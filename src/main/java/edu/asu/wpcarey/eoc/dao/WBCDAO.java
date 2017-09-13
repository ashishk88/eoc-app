package edu.asu.wpcarey.eoc.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class WBCDAO {
	private final static Logger LOGGER = Logger.getLogger(WBCDAO.class.getName());

	private Connection conn;
	private Statement stmt;

	public WBCDAO() {
		super();
		try {
			Class.forName(DAOUtils.MYSQL_CONNECTOR);
			conn = DriverManager.getConnection(DAOUtils.WBC_DB_CONNECTION, DAOUtils.WBC_DB_USERNAME,
					DAOUtils.WBC_DB_PASSWORD);
			LOGGER.setLevel(Level.INFO);
		} catch (final SQLException e) {
			conn = null;
			e.printStackTrace();
		} catch (final ClassNotFoundException e) {
			conn = null;
			e.printStackTrace();
		}
	}

	public static WBCDAO createInstance() {
		return new WBCDAO();
	}

	private Client getClient() {
		final ClientConfig clientConfig = new DefaultClientConfig();
		final Client client = Client.create(clientConfig);
		return client;
	}

	public String getQualtricsResponse(final String URL, Map<String, String> params) {
		final Client client = getClient();
		String query = URL + "?";
		try {
			for (String key : params.keySet()) {
				query += key + "=" + URLEncoder.encode(params.get(key), "UTF-8") + "&";
			}
			query = query.substring(0, query.length() - 1);
			WebResource webResource = client.resource(query);
			final ClientResponse response = webResource.accept("text/html").get(ClientResponse.class);
			final String serverResponse = response.getEntity(String.class);
			return serverResponse;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return StringUtils.EMPTY;
	}

	public String addUser(String firstName, String lastName, String email, String organization, String state) {
		String status = StringUtils.EMPTY;
		if (conn != null) {
			try {
				stmt = conn.createStatement();
				String query = "select * from wbc_panelists where Email like '%" + email + "%'";
				LOGGER.info(query);
				ResultSet rs = stmt.executeQuery(query);
				int rowcount = 0;
				if (rs.last()) {
					rowcount = rs.getRow();
					rs.beforeFirst();
				}

				if (rowcount != 0) {
					return "User already exist.";
				} else {
					query = "INSERT INTO wbc_panelists (`FirstName`,`LastName`,`Email`,`Organization`,`arizona`,`california`,"
							+ "`colorado`, `idaho`, `montana`, `nevada`,`new_mexico`,`oregon`,`texas`,`utah`,`washington`,`wyoming`) VALUES"
							+ "('" + firstName + "', '" + lastName + "', '" + email.toLowerCase() + "', '"
							+ organization + "', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)";
					LOGGER.info(query);
					stmt.executeUpdate(query);

					query = "UPDATE wbc_panelists set " + state.toLowerCase() + " = 1 where FirstName = '" + firstName
							+ "' and LastName = '" + lastName + "' and Email = '" + email + "'";
					LOGGER.info(query);
					stmt.executeUpdate(query);

					query = "select * from wbc_deployment_table";
					rs = stmt.executeQuery(query);
					rs.next();
					final String table = rs.getString(1);

					query = "select * from " + table + " where States = '" + state + "' and Organization = '"
							+ organization + "'";
					LOGGER.info(query);
					rs = stmt.executeQuery(query);
					rowcount = 0;
					if (rs.last()) {
						rowcount = rs.getRow();
						rs.beforeFirst();
					}

					if (rowcount == 0) {
						query = "insert into " + table + " values ('" + state + "', '" + organization
								+ "', '0.0','0.0','0.0','0.0','0.0','0.0','0.0','0.0','0.0','0.0','0.0','0.0','0.0','0.0', '0000-00-00 00:00:00', 1)";
						LOGGER.info(query);
						stmt.executeUpdate(query);
					}
					return "User added in the system.";
				}
			} catch (Exception e) {
				return e.getMessage();
			}
		}
		return status;
	}

	public void performUpdateOperation() {
		try {
			stmt = conn.createStatement();
			String query = "select * from wbc_deployment_table";
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			final String table = rs.getString(1);

			final Calendar c = Calendar.getInstance();
			final int year = c.get(Calendar.YEAR);
			final int month = c.get(Calendar.MONTH) + 1;

			String newtable = DAOUtils.WBC_DEPLOYMENT_PREFIX + "_" + String.valueOf(month) + "_" + String.valueOf(year);

			query = "CREATE TABLE " + newtable + " LIKE " + table;
			stmt.executeUpdate(query);
			LOGGER.info(query);

			query = "insert into " + newtable + " select * from " + table;
			stmt.executeUpdate(query);
			LOGGER.info(query);

			query = "update " + newtable
					+ " set enabled = '0' where Organization in (select Organization from load_table_new)";
			stmt.executeUpdate(query);
			LOGGER.info(query);

			query = "delete from " + newtable + " where Organization = 'Last Month Consensus'";
			stmt.executeUpdate(query);
			LOGGER.info(query);

			query = "update " + newtable
					+ " set Organization = 'Last Month Consensus' where Organization = 'Consensus'";
			stmt.executeUpdate(query);
			LOGGER.info(query);

			query = "insert " + newtable
					+ "  (States, Organization, Q1A1, Q2A1_ggr, Q4A1, Q2A1, Q5A1, Q3A1, Q1A2, Q2A2_ggr, Q4A2, Q2A2, Q5A2, Q3A2, Q2A1_mfg, Q2A2_mfg, date, enabled)  select States, Organization, Q1A1, Q2A1_ggr, Q4A1, Q2A1, Q5A1, Q3A1, Q1A2, Q2A2_ggr, Q4A2, Q2A2, Q5A2, Q3A2, Q2A1_mfg, Q2A2_mfg, date, '1' from load_table_new";
			stmt.executeUpdate(query);
			LOGGER.info(query);

			query = "delete from " + newtable + " where enabled = '0'";
			stmt.executeUpdate(query);
			LOGGER.info(query);

			query = "insert into " + newtable
					+ " select States, 'Consensus', format(avg(Q1A1),1), format(avg(Q2A1_ggr),1), format(avg(Q4A1),1), format(avg(Q2A1),1), format(avg(Q5A1),1), format(avg(Q3A1),1), format(avg(Q1A2),1), format(avg(Q2A2_ggr),1), format(avg(Q4A2),1), format(avg(Q2A2),1), format(avg(Q5A2),1), format(avg(Q3A2),1), format(avg(Q2A1_mfg),1), format(avg(Q2A2_mfg),1), date, '1' from "
					+ newtable + "  where Organization != 'Last Month Consensus' group by States";
			stmt.executeUpdate(query);

			query = "update wbc_deployment_table set current_table = '" + newtable + "'";
			stmt.executeUpdate(query);
			LOGGER.info(query);
		} catch (Exception exp) {
		}
	}
}
