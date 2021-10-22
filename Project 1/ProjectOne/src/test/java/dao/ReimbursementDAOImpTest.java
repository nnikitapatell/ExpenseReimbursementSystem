package dao;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
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

import main.dao.ReimbursementDAO;
import main.dao.ReimbursementDAOImp;
import main.model.Reimbursement;

public class ReimbursementDAOImpTest {

	ReimbursementDAO reimDAO = null;
	
	@BeforeEach
	void setUpAndIntializeReimDAO() throws Exception {
		/*
		 * We would use before each to reset the initial conditions.
		 */
		System.out.println("--------------------before each--------------------");
		reimDAO = new ReimbursementDAOImp();
	}
	
	@Test
	void getUserTicketsNotNullTest() {
		ArrayList<Reimbursement> reimTest1 = reimDAO.getUserTickets(2); 	
		assertNotNull(reimTest1);
	}
	
	@Test
	void getUserTicketsIsEmptyTest() {	
		ArrayList<Reimbursement> reimTest2 = reimDAO.getUserTickets(-50);	
		boolean emptyArrayList;
		emptyArrayList = reimTest2.size() == 0;
		assertTrue(emptyArrayList);
	}
	
	@Test
	void getAllTicketsNotNullTest() {
		ArrayList<Reimbursement> reimTest1 = reimDAO.getAllTickets(); 	
		assertNotNull(reimTest1);
	}
	
	@Test
	void getAllTicketsIsEmptyTest() {	
		ArrayList<Reimbursement> reimTest2 = reimDAO.getAllTickets();	
		boolean emptyArrayList;
		emptyArrayList = reimTest2.size() == 0;
		assertFalse(emptyArrayList);
	}
	
	@Test
	void whenAmountDescriptionAuthorTypeIdEnteredShouldReturnTrue() throws Exception {
		boolean test = reimDAO.createNewTicket(234, "hotel", 1 , 3);
		assertTrue(test);
	}
	
	@Test
	void whenReimIdStatusResolverAreEnteredShouldReturnTrue() throws Exception {
		boolean test = reimDAO.updateTicket(1,3 ,1 );
		assertTrue(test);
	}
	

}
