package main.dao;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import main.model.Reimbursement;
import main.model.User;

/**
 * @author Nikita
 * 
 * ReimbursementDAO interface is the data access object interface for CRUD Operations
 * on Reimbursements. It is a contract that is used to implement in various ways
 * using different methods of data storage and retrieval.
 *
 */
public interface ReimbursementDAO{
	
		
	
		/**
		 * getUserTickets will return a arraylist of tickets taht belong to a user 
		 *  
		 * @param id
		 * @return
		 */
		public ArrayList<Reimbursement> getUserTickets(int id);
		
		/**
		 * createNewTicket will retunr a boolean value depending of the success of the
		 * creation of the ticket.
		 * 
		 * @param reimAmount
		 * @param reimDescription
		 * @param reimAuthor
		 * @param reimTypeId
		 * @return
		 */
		public boolean createNewTicket(int reimAmount, String reimDescription, int reimAuthor, 
				int reimTypeId);
		
		/**
		 * return an arraylist of reimebursement ticket that the manager has access to 
		 * @return
		 */
		public ArrayList<Reimbursement> getAllTickets();
	
		/**
		 * updates the ticket that the manager requests to update through form
		 * that conists of reimid, status id adn resolver id
		 * 
		 * @param reimbId
		 * @param reimbStatusId
		 * @param reimbResolver
		 * @return
		 */
		public boolean updateTicket(int reimbId, int reimbStatusId, int reimbResolver);
		
}

