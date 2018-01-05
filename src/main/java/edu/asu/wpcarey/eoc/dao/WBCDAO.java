package edu.asu.wpcarey.eoc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

import edu.asu.wpcarey.eoc.beans.PanelistSearchBean;
import edu.asu.wpcarey.eoc.utils.EOCAppConstants;

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
			stmt = conn.createStatement();
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

	public String addUser(String firstName, String lastName, String email, String organization, String state) {
		String status = StringUtils.EMPTY;
		if (conn != null) {
			try {
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

	public String[] searchUser(String searchString) {
		String[] rowData = new String[6];
		String query = "SELECT * FROM wbc.wbc_panelists where email like '%"+ searchString +"%';";
		ResultSet rs;
		try {
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				rowData[0] = String.valueOf(rs.getInt("id"));
				rowData[1] = rs.getString("FirstName");
				rowData[2] = rs.getString("LastName");
				rowData[3] = rs.getString("Email");
				rowData[4] = rs.getString("Organization");	
			}
		} catch (SQLException e) {
			e.printStackTrace();
			rowData[0] = "Error";
			rowData[1] = "Error";
			rowData[2] = "Error";
			rowData[3] = "Error";
			rowData[4] = "Error";
		}		
		return rowData;
	}

	public String updateUser(PanelistSearchBean panelistSearchBean) {
		try {
			String query = "update wbc_panelists set FirstName = '"+ panelistSearchBean.getFirstName() +"', LastName = '"+ panelistSearchBean.getLastName() +"'"
					+ ", Email = '"+ panelistSearchBean.getEmailAddress() +"', Organization = '"+ panelistSearchBean.getOrganization() +"', Name = '"+ panelistSearchBean.getLastName() + ", " + panelistSearchBean.getFirstName() +"' where id = "+ panelistSearchBean.getId();

			stmt.executeUpdate(query);
			for(String state : EOCAppConstants.EOC_STATES) {
				if(state.equals(panelistSearchBean.getState())) {
					if(state.equals("NewMexico")) {
						query = "update wbc_panelists set new_mexico=1 where id="+ panelistSearchBean.getId();
					} else {
						query = "update wbc_panelists set "+ state.toLowerCase() +"=1 where id="+ panelistSearchBean.getId();
					}
				} else {
					if(state.equals("NewMexico")) {
						query = "update wbc_panelists set new_mexico=0 where id="+ panelistSearchBean.getId();
					} else {
						query = "update wbc_panelists set "+ state.toLowerCase() +"=0 where id="+ panelistSearchBean.getId();
					}
				}
				stmt.executeUpdate(query);
			}
			return "Record successfully updated";
		} catch (SQLException e) {
			return "Record update failed : "+ e.getMessage();
		}
	}
}
