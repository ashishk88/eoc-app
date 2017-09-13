package edu.asu.wpcarey.eoc.utils;

import java.util.HashMap;
import java.util.Map;

public class EOCAppConstants {

	public static final String WP_CAREY_EOC = "WP Carey EOC";
	public static final String WBC = "Western Blue Chip";
	public static final String WBC_ADD_PANEL = "Add Panel";
	public static final String WBC_UPDATE_PANEL = "Update Panel";
	public static final String WBC_LABEL_TEXT = "Use the button below to initiate the WBC update.";
	public static final String GPBC_LABEL_TEXT = "Use the button below to initiate the GPBC update.";
	public static final String WBC_BUTTON_TEXT = "Initiate WBC Update";
	public static final String MENU_ITEM_CLOSE = "Close";
	public static final String MENU_LINKS = "Links";
	public static final String MENU_ABOUT = "About";
	public static final String MENU_FILE = "File";
	public static final int SUCCESS = 0;
	public static final String MENU_ITEM_HELP = "Help";
	public static final String MENU_HELP_TEXT = "For any help contact : <a href=\"mailto:akuma119@asu.edu\">akuma119@asu.edu</a>";
	public static final String MENU_ITEM_LINKS = "Links";
	public static final String MENU_LINKS_TEXT = "Important links:\nDev Site: <a href=\"blogs.wpcarey.asu.edu/dev/economic-outlook\">blogs.wpcarey.asu.edu/dev/economic-outlook</a><br>"
			+ "Prod Site: <a href=\"research.wpcarey.asu.edu/economic-outlook\">research.wpcarey.asu.edu/economic-outlook</a><br>"
			+ "BLS site: <a href=\"download.bls.gov/pub/time.series/sm/\">download.bls.gov/pub/time.series/sm/</a>, "
			+ "<a href=\"http://www.bls.gov/schedule/2016/\">http://www.bls.gov/schedule/2016/</a><br>"
			+ "Qualtrics: <a href=\"https://www.qualtrics.com/\">https://www.qualtrics.com/</a>";

	public static final String BORDER_GPBC_TITLE = "Greater Phoenix Blue Chip";
	public static final String GPBC_BUTTON_CF = "Initiate GPBC CF update";
	public static final String GPBC_BUTTON_EF = "Initiate GPBC EF update";
	public static final String GPBC_BUTTON_CD = "Select Construction Data";
	public static final String GPBC_BUTTON_CDT = "GPBC Construction Data Template";
	public static final String GPBC_ALERT_CD = "Please select an excel sheet with the construction data.";
	public static final String GPBC_ALERT_FE = "The uploaded file is empty.";
	public static final String GPBC_ALERT_FP = "The GPBC Construction Forecast table data has been saved in database.";
	public static final String GPBC_ALERT_FI = "The uploaded file is invalid.";
	public static final String GPBC_ALERT_OF = "Do you want to overwrite the existing file?";
	public static final String EOC_APP_PASSWORD = "NO5/USAHB68358JgRKReRQ==";
	public static final String WBC_INITIATED = "The WBC update has been initiated.";

	// Qualtrics connection details
	public static class Qualtrics {

		public static Map<String, String> qualtricsWBCParam() {
			Map<String, String> params = new HashMap<>();
			params.put("Request", "getLegacyResponseData");
			params.put("User", "wpcareyseid@asu.edu");
			params.put("Token", "Eo9Cq2pIMlm9djm7obIjoIUNANYgxcG2fqM8QawD");
			params.put("SurveyID", "SV_0PrXQuBvQeRAaxv");
			params.put("Format", "CSV");
			params.put("Labels", "1");
			params.put("Version", "2.3");
			return params;
		}

		public static Map<String, String> qualtricsGPBCParam() {
			Map<String, String> params = new HashMap<>();
			params.put("Request", "getLegacyResponseData");
			params.put("User", "wpcareyseid@asu.edu");
			params.put("Token", "Eo9Cq2pIMlm9djm7obIjoIUNANYgxcG2fqM8QawD");
			params.put("SurveyID", "SV_0GSrDtYvoS62wvz");
			params.put("Format", "CSV");
			params.put("Labels", "1");
			params.put("Version", "2.3");
			return params;
		}
	}

	public static final String APP_DATE_FORMAT = "dd_MM_yyyy";
	public static final String APP_DATE_FORMAT_YEAR_ONLY = "_yyyy";
	public static final String USER_HOME = "user.home";
	public static final String DOCUMENTS = "Documents";
	public static final String EOC_APP = "EOC-APP";
	public static final String GPBC_ALERT_ED = "GPBC Economic forecast has been initiated.";
	public static final String GPBC_BUTTON_UHD = "Update GPBC Historical Data";
	public static final String[] EOC_STATES = new String[] { "Arizona", "California", "Colorado", "Idaho", "Montana",
			"Nevada", "NewMexico", "Oregon", "Texas", "Utah", "Washington", "Wyoming" };
	
	public static final String WBC_UPDATE_FILE = "P:\\SEID\\EOC_Program\\wbc\\wbc_update.py";
	public static final String GPBC_UPDATE_FILE = "P:\\SEID\\EOC_Program\\gpbc\\gpbc_update.py";	
	public static final String JOB_GROWTH_UPDATE_FILE = "P:\\SEID\\EOC_Program\\job_growth_python\\Job_Growth_Data_v5.py";
	public static final String JOB_GROWTH_MD_UPDATE_FILE = "P:\\SEID\\EOC_Program\\job_growth_python\\LoadMetaData.py";

}
