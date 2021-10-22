package main.service;

import java.util.HashMap;
import java.util.List;

import main.model.Reimbursement;

/**
 * @author Nikita The ReimbursementService class contains the business logic for
 *         performing operations on the reimbursements
 *
 */
public interface ReimbursementService {
	
	

	/**
	 * @param reimbAmount
	 * @param reimbDescription
	 * @param reimbAuthor
	 * @param reimbTypeId
	 * @return
	 */
	public boolean createNewTicket(int reimbAmount, String reimbDescription, int reimbAuthor, 
			int reimbTypeId);

	/**
	 * @param reimId
	 * @param reimStatus
	 * @param reimResolver
	 * @return
	 */
	boolean updateTicket(int reimId, int reimStatus, int reimResolver);

	/**
	 * @return
	 */
	public HashMap<Integer,Reimbursement> getAllTickets();

	/**
	 * @param id
	 * @return
	 */
	public HashMap<Integer,Reimbursement> getUserTickets(int id);
	
}
