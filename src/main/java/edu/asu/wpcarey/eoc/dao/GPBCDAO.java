package edu.asu.wpcarey.eoc.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class GPBCDAO {
	private final static Logger LOGGER = Logger.getLogger(GPBCDAO.class.getName());

	public static GPBCDAO createInstance() {
		return new GPBCDAO();
	}

	private Connection conn;
	private Statement stmt;

	private GPBCDAO() {
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

	public List<List<String>> getGBPCConstructionData(final DAOUtils.GBPCConstructionType type) throws Exception {
		final List<List<String>> dataList = new ArrayList<>();
		if (conn != null) {
			try {
				stmt = conn.createStatement();
				String query = "select CurrentTable from gdbc_contruction_tables where Id = '" + type.getType() + "'";
				ResultSet rs = stmt.executeQuery(query);
				int rowcount = 0;
				if (rs.last()) {
					rowcount = rs.getRow();
					rs.beforeFirst();
				}

				if (rowcount != 0) {
					rs.next();
					final String table = rs.getString(1);
					query = "select * from " + table;
					rs = stmt.executeQuery(query);
					rowcount = 0;
					if (rs.last()) {
						rowcount = rs.getRow();
						rs.beforeFirst();
					}
					if (rowcount != 0) {
						if (DAOUtils.GBPCConstructionType.INDUSTRY.getType().equals(type.getType())) {
							while (rs.next()) {
								final List<String> columnDetails = new ArrayList<>();
								columnDetails.add(String.valueOf(rs.getString(1)));
								columnDetails.add(rs.getString(2));
								columnDetails.add(rs.getString(3));
								columnDetails.add(rs.getString(4));
								columnDetails.add(rs.getString(5));
								columnDetails.add(rs.getString(6));
								columnDetails.add(rs.getString(7));
								dataList.add(columnDetails);
							}
						} else if (DAOUtils.GBPCConstructionType.OFFICE.getType().equals(type.getType())) {
							while (rs.next()) {
								final List<String> columnDetails = new ArrayList<>();
								columnDetails.add(String.valueOf(rs.getString(1)));
								columnDetails.add(rs.getString(2));
								columnDetails.add(rs.getString(3));
								columnDetails.add(rs.getString(4));
								columnDetails.add(rs.getString(5));
								columnDetails.add(rs.getString(6));
								columnDetails.add(rs.getString(7));
								dataList.add(columnDetails);
							}
						} else if (DAOUtils.GBPCConstructionType.RETAIL.getType().equals(type.getType())) {
							while (rs.next()) {
								final List<String> columnDetails = new ArrayList<>();
								columnDetails.add(String.valueOf(rs.getString(1)));
								columnDetails.add(rs.getString(2));
								columnDetails.add(rs.getString(3));
								columnDetails.add(rs.getString(4));
								columnDetails.add(rs.getString(5));
								columnDetails.add(rs.getString(6));
								columnDetails.add(rs.getString(7));
								dataList.add(columnDetails);
							}
						} else {
							while (rs.next()) {
								final List<String> columnDetails = new ArrayList<>();
								columnDetails.add(String.valueOf(rs.getString(1)));
								columnDetails.add(rs.getString(2));
								columnDetails.add(rs.getString(3));
								columnDetails.add(rs.getString(4));
								columnDetails.add(rs.getString(5));
								columnDetails.add(rs.getString(6));
								columnDetails.add(rs.getString(7));
								columnDetails.add(rs.getString(8));
								dataList.add(columnDetails);
							}
						}
					}
				}
			} catch (final Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		return dataList;
	}

	public void persistData(final List<List<String>> dataSet, final String type) {
		String query = "select CurrentTable from gdbc_contruction_tables where Id = '" + type + "'";
		try {
			LOGGER.info(query);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			final String table = rs.getString(1);

			final Calendar c = Calendar.getInstance();
			final int year = c.get(Calendar.YEAR);
			final int month = c.get(Calendar.MONTH) + 1;

			String newtable = DAOUtils.GBPCConstructionType.getTablePrefix(type) + "_" + String.valueOf(month) + "_"
					+ String.valueOf(year) + "_";

			try {
				query = "CREATE TABLE " + newtable + " LIKE " + table;
				stmt.executeUpdate(query);
				LOGGER.info(query);
			} catch (Exception ex) {
				query = "select CurrentTable from gdbc_contruction_tables where Id = '" + type + "'";
				rs = stmt.executeQuery(query);
				rs.next();
				newtable = rs.getString(1);

				if (newtable.charAt(newtable.length() - 1) == '_') {
					newtable = newtable + "1";
				} else {
					int index = newtable.lastIndexOf('_');
					newtable = newtable.substring(0, index) + Integer.parseInt(newtable.substring(index + 1)) + 1;
				}
				LOGGER.info(query);
				query = "CREATE TABLE " + newtable + " LIKE " + table;
				stmt.executeUpdate(query);
			}

			query = "update gdbc_contruction_tables set CurrentTable = '" + newtable + "' where Id = '" + type + "'";
			stmt.executeUpdate(query);
			LOGGER.info(query);
			int counter = 0;
			for (final List<String> data : dataSet) {

				counter = 1;
				query = "insert into " + newtable + " values (";
				for (final String value : data) {
					if (counter == 1) {
						query += value;
					} else if (counter > (data.size() - 2)) {
						query += ", " + value;
					} else {
						query += ", '" + value + "'";
					}
					counter++;
				}
				query += ")";
				LOGGER.info(query);
				// stmt.executeUpdate(query);
			}
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Client getClient() {
		final ClientConfig clientConfig = new DefaultClientConfig();
		final Client client = Client.create(clientConfig);
		return client;
	}

	public String getQualtricsResponse(String URL, Map<String, String> params) {
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

	public void saveAllHistoricalData(List<String> valuesList) {
		try {
			stmt = conn.createStatement();

			final Calendar c = Calendar.getInstance();
			final int year = c.get(Calendar.YEAR) - 1;
			try {
				String query = "CREATE TABLE gpbc_historical_" + String.valueOf(year) + " LIKE gpbc_historical";
				stmt.executeUpdate(query);
				LOGGER.info(query);

				query = "INSERT INTO gpbc_historical_" + String.valueOf(year) + " SELECT * FROM gpbc_historical";
				stmt.executeUpdate(query);
				LOGGER.info(query);

				query = "TRUNCATE gpbc_historical";
				stmt.executeUpdate(query);
				LOGGER.info(query);

				for (String value : valuesList) {
					query = "INSERT into  gpbc_historical_" + String.valueOf(year) + " VALUES " + value;
					stmt.executeUpdate(query);
					LOGGER.info(query);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
