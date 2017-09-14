package edu.asu.wpcarey.eoc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

	public Object[][] getGBPCConstructionData(int year, DAOUtils.GBPCConstructionType type)  {
		List<List<Object>> dataList = new ArrayList<>();
		if (conn != null) {
			try {
				stmt = conn.createStatement();
				String query = "select * from " + type.getTablePrefix() + " where actuals=1 or year="+ String.valueOf(year);
				ResultSet rs = stmt.executeQuery(query);
				int rowcount = 0;
				if (rs.last()) {
					rowcount = rs.getRow();
					rs.beforeFirst();
				}
				if (rowcount != 0) {
					if (DAOUtils.GBPCConstructionType.INDUSTRIAL.getType().equals(type.getType())) {
						while (rs.next()) {
							final List<Object> columnDetails = new ArrayList<>();
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
							final List<Object> columnDetails = new ArrayList<>();
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
							final List<Object> columnDetails = new ArrayList<>();
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
							final List<Object> columnDetails = new ArrayList<>();
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
		
		Object[][] returnList = new Object[dataList.size()][];
		if(!dataList.isEmpty()) {
			int i = 0;
			for (List<Object> nestedList : dataList) {
				returnList[i++] = nestedList.toArray(new Object[nestedList.size()]);
			}
		}
		return returnList;
	}

}
