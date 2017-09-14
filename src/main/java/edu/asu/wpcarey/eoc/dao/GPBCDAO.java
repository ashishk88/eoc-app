package edu.asu.wpcarey.eoc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.PreparedStatement;

import edu.asu.wpcarey.eoc.dao.DAOUtils.GBPCConstructionType;

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

	public String[][] getGBPCConstructionData(int year, DAOUtils.GBPCConstructionType type) {
		List<List<String>> dataList = new ArrayList<>();
		if (conn != null) {
			try {
				String query = "select * from " + type.getTablePrefix() + " where year=" + String.valueOf(year);
				ResultSet rs = stmt.executeQuery(query);
				int rowcount = 0;
				if (rs.last()) {
					rowcount = rs.getRow();
					rs.beforeFirst();
				}
				if (rowcount != 0) {
					if (DAOUtils.GBPCConstructionType.INDUSTRIAL.getType().equals(type.getType())) {
						while (rs.next()) {
							final List<String> columnDetails = new ArrayList<>();
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
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}

		String[][] returnList = new String[dataList.size()][];
		if (!dataList.isEmpty()) {
			int i = 0;
			for (List<String> nestedList : dataList) {
				returnList[i++] = nestedList.toArray(new String[nestedList.size()]);
			}
		}
		return returnList;
	}

	public void truncateTable(GBPCConstructionType type) {
		String table = type.getTablePrefix();
		try {
			stmt.executeUpdate("TRUNCATE " + table);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void saveData(String[][] data, GBPCConstructionType type, int year) throws SQLException {
		String table = type.getTablePrefix();
		java.sql.PreparedStatement preparedStatement = null;

		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);

		if (type.equals(DAOUtils.GBPCConstructionType.RESIDENTIAL)) {
			try {

				String query = "INSERT INTO " + table
						+ " (`year`, `organization`, `Q1`, `Q2`, `Q3`, `Q4`, `enabled`, `actuals`, `month`,`year_published`) "
						+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
				preparedStatement = conn.prepareStatement(query);

				for (String[] row : data) {
					preparedStatement.setInt(1, year);
					preparedStatement.setString(2, row[0]);
					preparedStatement.setString(3, row[1]);
					preparedStatement.setString(4, row[2]);
					preparedStatement.setString(5, row[3]);
					preparedStatement.setString(6, row[4]);
					preparedStatement.setInt(7, Integer.parseInt(row[5]));
					preparedStatement.setInt(8, Integer.parseInt(row[6]));
					preparedStatement.setInt(9, currentMonth);
					preparedStatement.setInt(10, currentYear);
					preparedStatement.executeUpdate();
				}
			} catch (SQLException e) {
				throw e;
			}
		} else {
			try {

				String query = "INSERT INTO " + table
						+ " (`year`, `organization`, `Q1`, `Q2`, `Q3`, `enabled`, `actuals`, `month`,`year_published`) "
						+ "VALUES (?,?,?,?,?,?,?,?,?)";
				preparedStatement = conn.prepareStatement(query);

				for (String[] row : data) {
					preparedStatement.setInt(1, year);
					preparedStatement.setString(2, row[0]);
					preparedStatement.setString(3, row[1]);
					preparedStatement.setString(4, row[2]);
					preparedStatement.setString(5, row[3]);
					preparedStatement.setInt(7, Integer.parseInt(row[4]));
					preparedStatement.setInt(8, Integer.parseInt(row[5]));
					preparedStatement.setInt(8, currentMonth);
					preparedStatement.setInt(9, currentYear);
					preparedStatement.executeUpdate();
				}
			} catch (SQLException e) {
				throw e;
			}
		}
	}

}
