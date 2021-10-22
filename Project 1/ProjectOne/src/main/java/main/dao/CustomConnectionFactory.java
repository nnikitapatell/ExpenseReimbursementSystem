package main.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * A helper class that contains just static methods. It is stateless and cannot be instantiated.
 * The method(s) will be reused across the application.
 * @author nikita
 *
 */
public class CustomConnectionFactory {
	private static final Logger loggy = Logger.getLogger(CustomConnectionFactory.class);
	
	
	//CONNECT TO THE DATABASE BY USING URL, USERNAME, PASSWORD
	private static final String url = "jdbc:postgresql://34.83.20.81/expenseReimbursementSystem";
	private static final String username = "postgres";
	private static final String password = "Bh@gat_123";
	
	/**
	 * Driver manager is a service used for managing a set of JDBC drivers.
	 * It will attempt to establish a connect to the database by using the given 
	 * database URL, username, and password.
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		loggy.info("Connection established to connect to the Database.");
		return DriverManager.getConnection(url, username, password);
	} 
}
