package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import main.model.User;

public class UserDaoImp implements UserDAO{
	 private static final Logger loggy = Logger.getLogger(UserDaoImp.class);
	
	@Override
	public boolean getUserByUsernameAndPassword(String username, String password) {
		User temp = null;
		try (Connection conn = CustomConnectionFactory.getConnection()) {

			String sql = "SELECT u.ERS_USERS_ID"
							+ "	FROM ERS_USERS u"
							+ "	WHERE u.ERS_USERNAME = ? AND u.ERS_PASSWORD = ?";
		
			PreparedStatement ps = conn.prepareStatement(sql);
			//pass in the username, password
			ps.setString(1, username); 
			ps.setString(2, password);
			
			
			ResultSet rs = ps.executeQuery(); // <----update not query. This line sends our statement to the DB
		
			if(rs.next()) {
				loggy.info("Successfully got user by username and password");
				return true;
			}else {
				loggy.error("Failed to get user by username and password");
				return false;
			}
			
		} catch (SQLException e) {
			//e.printStackTrace();
			loggy.error("Sorry, unable to get user by username and password from the DB", e);
			return false;
		}
	
	}

	@Override
	public boolean getUserById(int id) {
		User temp = null;
		try (Connection conn = CustomConnectionFactory.getConnection()) {

			String sql = "SELECT u.USER_FIRST_NAME, u.USER_LAST_NAME FROM ERS_USERS u "
							+ "	WHERE u.ERS_USERS_ID = ?";
		
			PreparedStatement ps = conn.prepareStatement(sql);
			//pass in the userid
			ps.setInt(1, id); 
			
			ResultSet rs = ps.executeQuery(); // <----update not query. This line sends our statement to the DB
			if(rs.next()) {
				loggy.info("Successfully got user by id");
				return true;
			}else {
				loggy.error("Failed to get user by id");
				return false;
			}
			
		} catch (SQLException e) {
			loggy.error("Sorry, unable to get user by id from the DB", e);
			//e.printStackTrace();
			return false;
		}
	
	}

	@Override
	public boolean loginByUsernameAndPassword(String myUsername, String myPassword) {
		User temp = null;
		if(myUsername == null && myPassword == null) {
			throw new RuntimeException("username and password cannot be null");
		}
		
		try (Connection conn = CustomConnectionFactory.getConnection()) {
			String sql = "SELECT u.ERS_USERS_ID FROM ERS_USERS u WHERE u.ERS_USERNAME= ? AND u.ERS_PASSWORD= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, myUsername); 
			ps.setString(2, myPassword);
			ResultSet rs = ps.executeQuery(); // <----update not query. This line sends our statement to the DB
			if (rs.next()) {
				loggy.info("Successfully logged in user by username and password");
				return true;
			}else {
				loggy.error("Failed to login user by username and password");
				return false;
			}
		} catch (SQLException e) {
			loggy.error("Sorry, unable to login user by username and password from the DB", e);
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public User getUserFromDatabase(String username, String password) throws Exception { //throws is also a keyword whihcis used in a method signature to indicate that his method may throw an exception 
		User temp = null;
		
		if(username == null && password == null) {
			throw new RuntimeException("username and password cannot be null"); //checked exception
		}
		
		try (Connection conn = CustomConnectionFactory.getConnection()) { 

			String sql = "SELECT u.ERS_USERS_ID, u.ERS_USERNAME, u.ERS_PASSWORD, u.USER_FIRST_NAME, u.USER_LAST_NAME, u.USER_EMAIL, u.USER_ROLE_ID "
					+ "	FROM ERS_USERS u WHERE u.ERS_USERNAME = ? AND u.ERS_PASSWORD = ?";
		
			PreparedStatement ps = conn.prepareStatement(sql);
			//pass in the username, password
			ps.setString(1, username); 
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery(); // <----update not query. This line sends our statement to the DB
			if(rs.next()) {
				temp = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			}
			loggy.info("Successfully got user from database" );
			
		}catch (Exception e) {
			loggy.error("Sorry, unable to get user from the DB by username and password", e);
			throw e;//throw is a key word which throws an exception mannually
			//e.printStackTrace();
		}
		return temp;
	}

//	@Override
//	public User getUserFromDatabase(String username, String password) {
		// TODO Auto-generated method stub
//		return null;
//	}


	
	

}
