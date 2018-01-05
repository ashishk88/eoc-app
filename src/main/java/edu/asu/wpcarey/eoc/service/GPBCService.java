package edu.asu.wpcarey.eoc.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.asu.wpcarey.eoc.beans.PanelistSearchBean;
import edu.asu.wpcarey.eoc.beans.qualtrics.contact.Contacts;
import edu.asu.wpcarey.eoc.beans.qualtrics.mailinglist.Element;
import edu.asu.wpcarey.eoc.beans.qualtrics.mailinglist.MailingList;
import edu.asu.wpcarey.eoc.dao.DAOUtils;
import edu.asu.wpcarey.eoc.dao.GPBCDAO;
import edu.asu.wpcarey.eoc.ui.GPBCConstructionForecastsPanel;
import edu.asu.wpcarey.eoc.utils.EOCAppConstants;

public class GPBCService {

	public static GPBCService createInstance() {
		return new GPBCService();
	}

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	private Matcher matcher;

	private final GPBCDAO gpbcdao;
	
	private GPBCService() {
		gpbcdao = GPBCDAO.createInstance();
	}

	public String initiateEFUpdate() {
		try {
			File f = new File(EOCAppConstants.GPBC_UPDATE_FILE);
			if(f.isFile() && f.canRead()) {
			
				String line = StringUtils.EMPTY;
				Process p = Runtime.getRuntime().exec(
						new String[] { "python", EOCAppConstants.GPBC_UPDATE_FILE + ".py" });
				BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
	
				return "GPBC EF updated successfully.";
			} else {
				return "GPBC EF could not be updated : " + "Script file cannot be loaded";				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "GPBC EF could not be updated : " + e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
			return "GPBC EF could not be updated : " + e.getMessage();
		}
	}
	
	public String addUser(String firstName, String lastName, String email, String organization) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			return "Email address " + email + " is invalid";
		} else {
			return "User has been added.";
		}
	}

	public String saveData(GPBCConstructionForecastsPanel constructionForecastsPanel) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		try {
			if (GPBCConstructionForecastsPanel.getQuarter().equals("Q1")) {
				for(DAOUtils.GBPCConstructionType type : DAOUtils.GBPCConstructionType.values()) {
					int year = currentYear - 1;
					gpbcdao.truncateTable(type);
					for(int i=0; i < 3; i++) {
						String[][] data = constructionForecastsPanel.getData(type, year);
						gpbcdao.saveData(data, type, year);
						year++;
					}
				}
			} else {
				for(DAOUtils.GBPCConstructionType type : DAOUtils.GBPCConstructionType.values()) {
					int year = currentYear;
					gpbcdao.truncateTable(type);
					for(int i=0; i < 2; i++) {
						String[][] data = constructionForecastsPanel.getData(type, year);
						gpbcdao.saveData(data, type, year);
						year++;
					}
				}
			}
			return "Update Successful";
		} catch (Exception e) {
			e.printStackTrace();
			return "Update Failed : "+ e.getMessage();
		}
	}

	public PanelistSearchBean searchUser(String searchString) {
		String[] data = gpbcdao.searchUser(searchString);
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
				if(element.getName().equals("gpbc")) {
					mailingId = element.getId();
					break;
				}
			}
			
			if(mailingId != null) {
				response = DAOUtils.getQualtricsResponseString(EOCAppConstants.Qualtrics.GET_MAILING_LIST+"/"+ mailingId +"/contacts");
				Contacts contacts = mapper.readValue(response, Contacts.class);
				for(edu.asu.wpcarey.eoc.beans.qualtrics.contact.Element contact : contacts.getResult().getElements()) {
					if(contact.getEmail().equalsIgnoreCase(panelistSearchBean.getEmailAddress())) {
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
		System.out.println(response);
		response = gpbcdao.updateUser(panelistSearchBean);
		return response;
	}
}
