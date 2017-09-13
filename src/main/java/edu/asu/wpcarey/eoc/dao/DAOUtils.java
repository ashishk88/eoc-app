package edu.asu.wpcarey.eoc.dao;

import org.apache.commons.lang3.StringUtils;

public class DAOUtils {

	public enum GBPCConstructionType {
		RETAIL("retail", "gpbc_retail"), OFFICE("office", "gpbc_office"), INDUSTRY("industrial",
				"gpbc_industrial"), RESIDENTIAL("residential", "gpbc_residential");
		public static String getTablePrefix(final String value) {
			for (final GBPCConstructionType constructionType : GBPCConstructionType.values()) {
				if (constructionType.type.equals(value.toLowerCase())) {
					return constructionType.tablePrefix;
				}
			}
			return StringUtils.EMPTY;
		}

		public static String parseString(final String value) {
			for (final GBPCConstructionType constructionType : GBPCConstructionType.values()) {
				if (constructionType.type.equals(value.toLowerCase())) {
					return constructionType.type;
				}
			}
			return StringUtils.EMPTY;
		}

		private final String type;

		private final String tablePrefix;

		private GBPCConstructionType(final String type, final String tablePrefix) {
			this.type = type;
			this.tablePrefix = tablePrefix;
		}

		public String getType() {
			return type;
		}

	}

	static final String MYSQL_CONNECTOR = "com.mysql.jdbc.Driver";

	static final String WBC_DB_CONNECTION = "jdbc:mysql://wbc.cotzely14ram.us-west-2.rds.amazonaws.com/wbc";
	// Database credentials
	static final String WBC_DB_USERNAME = "wbc_master";

	static final String WBC_DB_PASSWORD = "wbcpassword";

	static final String WBC_DEPLOYMENT_PREFIX = " wbc_deployment";

	static final String JG_DB_CONNECTION = "jdbc:mysql://job-growth.cotzely14ram.us-west-2.rds.amazonaws.com/job_growth";
	// Database credentials
	static final String JG_DB_USERNAME = "job_growthmaster";

	static final String JG_DB_PASSWORD = "jobgrowthpass";
}