package edu.asu.wpcarey.eoc.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import edu.asu.wpcarey.eoc.dao.WBCDAO;
import edu.asu.wpcarey.eoc.utils.EOCAppConstants;

public class WBCService {

	private WBCDAO wbcdao;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
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
}
