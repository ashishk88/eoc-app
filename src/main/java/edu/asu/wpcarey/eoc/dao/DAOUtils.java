package edu.asu.wpcarey.eoc.dao;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class DAOUtils {

	public enum GBPCConstructionType {
		RETAIL("retail", "gpbc_retail"), OFFICE("office", "gpbc_office"), INDUSTRIAL("industrial",
				"gpbc_industrial"), RESIDENTIAL("residential", "gpbc_residential");

		private final String type;

		private final String tablePrefix;

		private GBPCConstructionType(final String type, final String tablePrefix) {
			this.type = type;
			this.tablePrefix = tablePrefix;
		}

		public String getType() {
			return type;
		}

		public String getTablePrefix() {
			return tablePrefix;
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
	
	public static String getQualtricsResponseString(String URL) {
		Client client = Client.create();
		WebResource webResource =client.resource(URL);
		ClientResponse response = null;
		response = webResource.header("Content-Type", "application/json;charset=UTF-8")
		    .header("X-API-TOKEN", "Eo9Cq2pIMlm9djm7obIjoIUNANYgxcG2fqM8QawD")
		    .get(ClientResponse.class);
		return response.getEntity(String.class);
	}
	
	public static String updateUser(String url, String firstName, String lastName, String email, String org) {
		Client client = Client.create();
		WebResource webResource =client.resource(url);
		
		String data = "{\"firstName\": \""+ firstName +"\", \"lastName\":\""+ lastName +"\", \"email\":\""+ email +"\"}";
        ClientResponse response = webResource.header("Content-Type", "application/json;charset=UTF-8")
    		    .header("X-API-TOKEN", "Eo9Cq2pIMlm9djm7obIjoIUNANYgxcG2fqM8QawD")
    		    .put(ClientResponse.class, data);
        return response.toString();
	}
}
