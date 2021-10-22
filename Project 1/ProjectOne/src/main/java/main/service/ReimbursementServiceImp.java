package main.service;

import java.util.HashMap;


import java.util.List;

import org.apache.log4j.Logger;

import main.controller.UserController;
import main.dao.ReimbursementDAO;
import main.dao.ReimbursementDAOImp;
import main.model.Reimbursement;

public class ReimbursementServiceImp implements ReimbursementService{

	private ReimbursementDAO myDao = new ReimbursementDAOImp();
	private static final Logger loggy = Logger.getLogger(ReimbursementServiceImp.class);

	@Override
	public boolean createNewTicket(int reimAmount, String reimDescription, int reimAuthor, 
			int reimTypeId) {
		if (myDao.createNewTicket(reimAmount, reimDescription, reimAuthor, 
				reimTypeId)) {
			loggy.info("ReimbursementServiceImp called the dao to create ticket");
			return true;
			
		} else {
			loggy.info("ReimbursementServiceImp was NOT able to call the dao to create ticket");
			return false;
		}
	}

	@Override
	public HashMap<Integer,Reimbursement> getUserTickets(int id) {
		List<Reimbursement> temp = myDao.getUserTickets(id); //store usertickets under the id given to a local list
		HashMap<Integer,Reimbursement> storeReimbursement = new HashMap<Integer, Reimbursement>(); //for each reimbursement stored in the local list store it in a key value pair with the id 
		if(temp == null) {//check if array list is null
			loggy.info("Local reimbursement list is null");
			return null;
		}else {
			loggy.info("Local reimbursement list has : " + temp.size() + " tickets");
			//for each reimbursemeent, it stores the element in temp  
			for(Reimbursement r:temp) { 
				//put the <id, reimburseemnt into the stroeReimbursement HashMap
				storeReimbursement.put(r.getReimId(), r);
			}
			loggy.info("ReimbursementServiceImp stored usertickets in hash map < id, riem >: " + storeReimbursement.size());
			//return the hashmap
			return storeReimbursement;
		}
	}

	@Override
	public HashMap<Integer,Reimbursement> getAllTickets() {
		List<Reimbursement> temp = myDao.getAllTickets(); //local list that will store reimbursemens
		HashMap<Integer,Reimbursement> storeReimbursement = new HashMap<Integer, Reimbursement>();
		if(temp == null) { //check if array list is null
			loggy.info("Local reimbursement list is null");
			return null;
			
		}else {
			loggy.info("Local reimbursement list has : " + temp.size() + " tickets");
			for(Reimbursement r:temp) {//for each reimbursemeent, it stores the element in temp 
				//put the <id, reimburseemnt into the stroeReimbursement HashMap
				storeReimbursement.put(r.getReimId(), r);
			}
			loggy.info("ReimbursementServiceImp stored all tickets in hash map < id, riem >: " +  + storeReimbursement.size());
			return storeReimbursement;//return the hashmap
		}
	}

	@Override
	public boolean updateTicket(int reimId, int reimStatus, int reimResolver) {
		System.out.println("I made it to update ticket service layer.");
		if(myDao.updateTicket(reimId, reimStatus, reimResolver)) { //check if reimbursement is updated
			loggy.info("ReimbursementServiceImp was able to update ticket");
			return true;
		}else {
			loggy.info("ReimbursementServiceImp was unable to update ticket");
			return false;
		}
	}




	

}
