package service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.service.ReimbursementServiceImp;
import main.model.Reimbursement;
import main.service.ReimbursementService;




/**
 * Junit is a testing frame work used to test units of code. It is often used during test driven development
 * to make our program more efficent. It is also automic testing in the sense that you can write your ocde in a
 * class and it will run all the tests written in the class
 * 
 * test: tells us its a test method
 * beforeeach: used to tell junit to run the test before each test method
 * aftereach: used to tell junit to run the test after each method
 * displayname: used to print the name of the test that is being run
 * 
 * @author Nikita Patel
 *
 */
public class ReimbursementServiceImpTest {

	ReimbursementService reimServ = null;
	
	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUpAndIntializeReimDAO() throws Exception {
		/*
		 * We would use before each to reset the initial conditions.
		 */
		System.out.println("--------------------before each--------------------");
		reimServ = new ReimbursementServiceImp();
	}
	
	@Test
	void geUserTicketsNotNullTest() {
		HashMap<Integer,Reimbursement> storeReimbursementTest = reimServ.getUserTickets(2);
		assertNotNull(storeReimbursementTest);
	}
	
	@Test
	void getUserTicketsIsEmptyTest() {	
		HashMap<Integer,Reimbursement> storeReimbursementTest = reimServ.getUserTickets(-50);
		boolean emptyStoreReimbursement;
		emptyStoreReimbursement = storeReimbursementTest.size() == 0;
		assertTrue(emptyStoreReimbursement);
	}
	
	@Test
	void getAllTicketsNotNullTest() {
		HashMap<Integer,Reimbursement> storeReimbursementTest = reimServ.getAllTickets();
		assertNotNull(storeReimbursementTest);
	}
	
	@Test
	void getAllTicketsIsEmptyTest() {	
		HashMap<Integer,Reimbursement> storeReimbursementTest = reimServ.getAllTickets();
		boolean emptyStoreReimbursement;
		emptyStoreReimbursement = storeReimbursementTest.size() == 0;
		assertTrue(emptyStoreReimbursement);
	}
}
