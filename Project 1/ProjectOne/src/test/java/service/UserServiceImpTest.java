package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.constants.UserType;
import main.model.Reimbursement;
import main.model.User;
import main.service.UserService;
import main.service.UserServiceImp;

public class UserServiceImpTest {
	UserService userServ = null;
	
	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUpAndIntializeReimDAO() throws Exception {
		/*
		 * We would use before each to reset the initial conditions.
		 */
		System.out.println("--------------------before each--------------------");
		userServ = new UserServiceImp();
	}
	
	@Test
	void whenUsernamePasswordEnteredShouldReturnTrue() throws Exception {
		boolean test = userServ.login("nikita", "password");
		assertTrue(test);
	}
	
	@Test
	void whenUsernamePasswordEnteredShouldReturnFalse() throws Exception {
		boolean test = userServ.login("nikita", "nikita");
		assertFalse(test);
	}
	
	@Test
	void whenUsingGetMyUserFromDatabaseItShouldReturnTrue() throws Exception {
		User test = userServ.getMyUserFromDatabase("nikita", "password");
		assertNotNull(test);
	}
	
//	@Test
//	void whenUsingGetMyUserFromDatabaseItShouldReturnFalse() throws Exception {
//	User test2 = userServ.getMyUserFromDatabase(null, null);	
//	}
}
