package edu.asu.wpcarey.eoc.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.asu.wpcarey.eoc.beans.PanelistSearchBean;
import edu.asu.wpcarey.eoc.beans.qualtrics.contact.Contacts;
import edu.asu.wpcarey.eoc.beans.qualtrics.mailinglist.Element;
import edu.asu.wpcarey.eoc.beans.qualtrics.mailinglist.MailingList;
import edu.asu.wpcarey.eoc.dao.DAOUtils;
import edu.asu.wpcarey.eoc.dao.WBCDAO;
import edu.asu.wpcarey.eoc.utils.EOCAppConstants;

public class WBCService {

	private WBCDAO wbcdao;
	private Pattern pattern;
	private Matcher matcher;

	public static WBCService createInstance() {
		WBCService wBService = new WBCService();
		wBService.wbcdao = WBCDAO.createInstance();
		return wBService;
	}

	public String initiateUpdate() {
		try {
			File f = new File(EOCAppConstants.WBC_UPDATE_FILE);
			if(f.isFile() && f.canRead()) {
			
				String line = StringUtils.EMPTY;
				Process p = Runtime.getRuntime().exec(
						new String[] { "python", EOCAppConstants.WBC_UPDATE_FILE + ".py" });
				BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
	
				return "WBC updated successfully.";
			} else {
				return "WBC could not be updated : " + "Script file cannot be loaded";				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "WBC could not be updated : " + e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
			return "WBC could not be updated : " + e.getMessage();
		}
	}

	public String addUser(String firstName, String lastName, String email, String organization, String state) {
		pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			return "Email address " + email + " is invalid";
		} else {
			return wbcdao.addUser(firstName, lastName, email, organization, state);
		}
	}

	public PanelistSearchBean searchUser(String searchString) {
		String[] data = wbcdao.searchUser(searchString);
		PanelistSearchBean panelistSearchBean = new PanelistSearchBean(data);
		if(!( panelistSearchBean.getEmailAddress() == null && panelistSearchBean.getEmailAddress().equals(StringUtils.EMPTY))) {
			getAndUpdateDetailsFromQualtrics(panelistSearchBean);
		}
		return panelistSearchBean;
	}

	private void getAndUpdateDetailsFromQualtrics(PanelistSearchBean panelistSearchBean) {
		String response = DAOUtils.getQualtricsResponseString(EOCAppConstants.Qualtrics.GET_MAILING_LIST);
		ObjectMapper mapper = new ObjectMapper();
		String mailingId = null;
		try {
			MailingList mailingList = mapper.readValue(response, MailingList.class);
			for(Element element : mailingList.getResult().getElements()) {
				if(element.getName().equals("wbc_new")) {
					mailingId = element.getId();
					break;
				}
			}
			
			if(mailingId != null) {
				response = DAOUtils.getQualtricsResponseString(EOCAppConstants.Qualtrics.GET_MAILING_LIST+"/"+ mailingId +"/contacts");
				Contacts contacts = mapper.readValue(response, Contacts.class);
				for(edu.asu.wpcarey.eoc.beans.qualtrics.contact.Element contact : contacts.getResult().getElements()) {
					if(contact.getEmail().equals(panelistSearchBean.getEmailAddress())) {
						panelistSearchBean.setMailingId(mailingId);
						panelistSearchBean.setContactId(contact.getId());
						break;
					}
				}
			} else {
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String updateUser(PanelistSearchBean panelistSearchBean) {
		String url = EOCAppConstants.Qualtrics.GET_MAILING_LIST+"/"+ panelistSearchBean.getMailingId() + "/contacts/" + panelistSearchBean.getContactId();
		ObjectMapper mapper = new ObjectMapper();
		String response = DAOUtils.updateUser(url, panelistSearchBean.getFirstName(), panelistSearchBean.getLastName(), panelistSearchBean.getEmailAddress(), panelistSearchBean.getOrganization());
		response = wbcdao.updateUser(panelistSearchBean);
		return response;
	}
}
