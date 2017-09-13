package edu.asu.wpcarey.eoc.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

import edu.asu.wpcarey.eoc.dao.JobGrowthDAO;
import edu.asu.wpcarey.eoc.utils.EOCAppConstants;

public class JobGrowthService {

	private final JobGrowthDAO jobGrowthDAO;

	public JobGrowthService() {
		super();
		jobGrowthDAO = JobGrowthDAO.createInstance();
	}

	public static JobGrowthService createInstance() {
		return new JobGrowthService();
	}

	public String initiateJobGrowth(boolean initiateFlag, boolean metaDataFlag) {
		if (initiateFlag) {
			try {
				File f = new File(EOCAppConstants.JOB_GROWTH_UPDATE_FILE);
				if(f.isFile() && f.canRead()) {
				
					String line = StringUtils.EMPTY;
					if(metaDataFlag) {
						Process p = Runtime.getRuntime().exec(
								new String[] { "python", EOCAppConstants.JOB_GROWTH_MD_UPDATE_FILE + ".py" });
						BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
						while ((line = br.readLine()) != null) {
							System.out.println(line);
						}
					}
					Process p = Runtime.getRuntime().exec(
							new String[] { "python", EOCAppConstants.JOB_GROWTH_UPDATE_FILE + ".py" });
					BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
					while ((line = br.readLine()) != null) {
						System.out.println(line);
					}
		
					return "JG updated successfully.";
				} else {
					return "JG could not be updated : " + "Script file cannot be loaded";				
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "JG could not be updated : " + e.getMessage();
			}
		}
		return StringUtils.EMPTY;
	}

}
