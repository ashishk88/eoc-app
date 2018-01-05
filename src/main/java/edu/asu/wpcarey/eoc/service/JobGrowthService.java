package edu.asu.wpcarey.eoc.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;

import org.apache.commons.lang3.StringUtils;

import edu.asu.wpcarey.eoc.dao.JobGrowthDAO;
import edu.asu.wpcarey.eoc.ui.JobGrowthPanel;
import edu.asu.wpcarey.eoc.utils.EOCAppConstants;

public class JobGrowthService {


	public JobGrowthService() {
		super();
	}

	public static JobGrowthService createInstance() {
		return new JobGrowthService();
	}

}
