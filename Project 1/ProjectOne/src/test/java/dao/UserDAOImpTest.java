package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
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
import org.postgresql.util.PSQLException;

import main.constants.UserType;
import main.dao.UserDAO;
import main.dao.UserDaoImp;
import main.model.User;

/**
 * Junit will be testing units of code in the UserDAOImp class that exists in the DAO layer
 * getUserByUsernameAndPassword(String username, String password),
 * getUserById(int id),
 * loginByUsernameAndPassword(String myUsername, String myPassword),
 * getUserFromDatabase(String username, String password)
 * 
 * @author nikita
 *
 */
public class UserDAOImpTest {

	UserDAO userDAO = null;

	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUpAndIntializeReimDAO() throws Exception {
		/*
		 * We would use before each to reset the initial conditions.
		 */
		System.out.println("--------------------before each--------------------");
		userDAO = new UserDaoImp();
	}

	//for this given user, should return manager. But we must put a correct expectation 
	/**
	 * @throws Exception
	 */
	@Test
	void whenUsernamePasswordEnteredShouldReturnUserFound() throws Exception {
		User userTest1 = userDAO.getUserFromDatabase("nikita", "password"); // Correct login credentials
		assertNotNull(userTest1); //object should not be null
		assertEquals("nikita", userTest1.getErsUsername()); //username 
		assertEquals(true, userTest1.getErsUsername().equalsIgnoreCase("nikita")); //True bc you cant compare string with booolean values
		assertTrue(userTest1.getErsUsername().equalsIgnoreCase("nikita")); //this will also be true. expected value is always true
		assertFalse(userTest1.getErsUsername().equalsIgnoreCase(""));// the expression inside of assertfalse is false
		//assertFalse(userTest1.getErsUsername().equalsIgnoreCase("nikita")); //since teh default expectation is false and the exprression is returning true the test is faiiling. 
		assertEquals(UserType.MANAGER, userTest1.getUserType(),"invalid value returned");
		
	}
	
	@Test
	void whenNoConnectionShouldThrowException() {
		Exception exception = assertThrows(Exception.class, () -> {
			userDAO.getUserFromDatabase(null, null); 
	    });		
	}

	/**
	 * @throws Exception
	 */
	@Test
	void whenUserNamePasswordEmptyShouldReturnNull() throws Exception {
		User userTest2 = userDAO.getUserFromDatabase("", ""); // User DNE
		assertNull(userTest2);
	}

	/**
	 * @throws Exception
	 */
	@Test
	void whenUsernamePasswordEnteredShouldReturnFalse() throws Exception {
		boolean test = userDAO.getUserByUsernameAndPassword("nikita", "nikita");
		assertFalse(test);
	}
	
	/**
	 * @throws Exception
	 */
	@Test
	void whenUsernamePasswordEnteredShouldReturnTrue() throws Exception {
		boolean test = userDAO.getUserByUsernameAndPassword("nikita", "password");
		assertTrue(test);
	}
	
	/**
	 * @throws Exception
	 */
	@Test
	void whenGettingUserByIdShouldReturnFalse() throws Exception {
		boolean test = userDAO.getUserById(0);
		assertFalse(test);
	}
	
	/**
	 * @throws Exception
	 */
	@Test
	void whenGettingUserByIdShouldReturnTrue() throws Exception {
		boolean test = userDAO.getUserById(3);
		assertTrue(test);
	}
	
	/**
	 * @throws Exception
	 */
	@Test
	void whenLoggingInWithUsernamePasswordShouldReturnTrue() throws Exception {
		boolean test = userDAO.loginByUsernameAndPassword("nikita", "password");
		assertTrue(test);
	}
	
	@Test
	void getUserByUsernameAndPasswordTest() throws Exception {
		User userTest3 = userDAO.getUserFromDatabase("nikita", "password"); // Correct login credentials
		assertNotNull(userTest3);
	}
	
	
	
	
}
