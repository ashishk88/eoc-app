package edu.asu.wpcarey.eoc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JobGrowthDAO {

	public static JobGrowthDAO createInstance() {
		return new JobGrowthDAO();
	}
		
	private final static Logger LOGGER = Logger.getLogger(JobGrowthDAO.class.getName());

	private Connection conn;
	private Statement stmt;

	public JobGrowthDAO() {
		super();
		try {
			Class.forName(DAOUtils.MYSQL_CONNECTOR);
			conn = DriverManager.getConnection(DAOUtils.JG_DB_CONNECTION, DAOUtils.JG_DB_USERNAME,
					DAOUtils.JG_DB_PASSWORD);
			LOGGER.setLevel(Level.INFO);
		} catch (final SQLException e) {
			conn = null;
			e.printStackTrace();
		} catch (final ClassNotFoundException e) {
			conn = null;
			e.printStackTrace();
		}
	}

}
