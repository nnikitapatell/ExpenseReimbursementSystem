package main.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import main.model.Reimbursement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ReimbursementDAOImp implements ReimbursementDAO{
	 private static final Logger loggy = Logger.getLogger(ReimbursementDAO.class);

	@Override
	public ArrayList<Reimbursement> getUserTickets(int id) {

		ArrayList<Reimbursement> myReimbs = new ArrayList<Reimbursement>();
		try (Connection conn = CustomConnectionFactory.getConnection()) {

			String sql = "SELECT REIM_ID ,REIM_AMOUNT, REIM_SUBMITTED, REIM_RESOLVED, REIM_DESCRIPTION, "
					+ "	REIM_AUTHOR, REIM_RESOLVER, REIM_STATUS_ID, REIM_TYPE_ID "
					+ "	FROM ERS_REIMBURSEMENT er where er.REIM_AUTHOR = ?";
					
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery(); // <----update not query. This line sends our statement to the DB
			//Moves the cursor forward one row from its current position. Cursor is initially positioned before the first row;
			//the first call to the method makes the first row the current row; the second call makes the second row 
			//the current row, and so on.
			while(rs.next()) {
				//adds a new reimbursement to the arraylist
				myReimbs.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
			}
			loggy.info("Number of tickets returned: " + myReimbs.size());
			
			return myReimbs;
		} catch (SQLException e) {
			//e.printStackTrace();
			loggy.error("Sorry, unable to get user tickets from the DB", e);
			return null;
		}
	}

	@Override
	public boolean createNewTicket(int reimAmount, String reimDescription, int reimAuthor, 
			int reimTypeId) {
		
		try(Connection conn = CustomConnectionFactory.getConnection()){
			String sql = "INSERT INTO ERS_REIMBURSEMENT (REIM_AMOUNT, REIM_DESCRIPTION, REIM_AUTHOR, REIM_TYPE_ID) "
					+ "	VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, reimAmount);
			ps.setString(2, reimDescription);
			ps.setInt(3, reimAuthor);
			ps.setInt(4, reimTypeId);
			ps.executeUpdate();
			loggy.info("Successfully created new ticket for " + reimAuthor );
		}
		catch(SQLException e){
			//e.printStackTrace();
			loggy.error("Sorry, unable to create ticket in the DB", e);
			return false;
		}
		return true;
	}


	@Override
	public ArrayList<Reimbursement> getAllTickets() {
		ArrayList<Reimbursement> allReimbs = new ArrayList<Reimbursement>();
		try (Connection conn = CustomConnectionFactory.getConnection()) {

			String sql = "SELECT er.REIM_ID, er.REIM_AMOUNT, er.REIM_SUBMITTED, er.REIM_RESOLVED, er.REIM_DESCRIPTION, \r\n"
					+ "concat (author.user_first_name , ' ', author.user_last_name) author, \r\n"
					+ "concat (resolver.user_first_name,' ',resolver.user_last_name) resolver, ers.REIM_STATUS, ert.REIM_TYPE\r\n"
					+ "FROM ERS_REIMBURSEMENT er \r\n"
					+ "LEFT JOIN ERS_USERS author ON er.REIM_AUTHOR = author.ERS_USERS_ID \r\n"
					+ "LEFT JOIN ERS_USERS resolver ON er.REIM_RESOLVER = resolver.ERS_USERS_ID \r\n"
					+ "JOIN ERS_REIMBURSEMENT_STATUS ers ON er.REIM_STATUS_ID = ers.REIM_STATUS_ID\r\n"
					+ "JOIN ERS_REIMBURSEMENT_TYPE ert ON ert.REIM_TYPE_ID = er.REIM_TYPE_ID ORDER BY er.REIM_ID";
		
			PreparedStatement ps = conn.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery(); // <----update not query. This line sends our statement to the DB
			while(rs.next()) {
				allReimbs.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
				
			}
			loggy.info("Successfully got all tickets." );
			return allReimbs;
			
		} catch (SQLException e) {
			//e.printStackTrace();
			loggy.error("Sorry, unable to get all tickets from the DB", e);
			return null;
		}
	
	}

	@Override
	public boolean updateTicket(int reimId, int reimStatusId, int reimResolver) {
		try (Connection conn = CustomConnectionFactory.getConnection()) {
			System.out.println("I made it to dao update ticket");
			String sql = "UPDATE ERS_REIMBURSEMENT SET REIM_RESOLVED = now() , REIM_STATUS_ID = ?, REIM_RESOLVER = ? WHERE REIM_ID = ?";
		
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(3, reimId); 
			ps.setInt(1, reimStatusId); 
			ps.setInt(2, reimResolver); 
			ps.executeUpdate();
			
			loggy.info("Successfully updated ticket: " + reimId);
			
		} catch (SQLException e) {
			//e.printStackTrace();
			 loggy.error("Sorry, unable to update the DB", e);
			return false;
		}
		return true;
	}









	
	
	

	
	
	
	
	
}
