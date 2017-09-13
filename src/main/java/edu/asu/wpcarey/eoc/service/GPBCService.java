package edu.asu.wpcarey.eoc.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import edu.asu.wpcarey.eoc.dao.GPBCDAO;
import edu.asu.wpcarey.eoc.utils.EOCAppConstants;

public class GPBCService {

	public static GPBCService createInstance() {
		return new GPBCService();
	}

	private String type;
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
}
