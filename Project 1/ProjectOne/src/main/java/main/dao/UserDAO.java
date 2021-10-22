package main.dao;

import main.model.User;


/**
 * @author Nikita
 * 
 * UserDAO interface is the data access object interface for CRUD operations
 * on the Users. It is a contract that is used to implement in various ways
 * using different methods of data storage and retrieval.
 *
 */
public interface UserDAO {
	
	/**
	 * getUserByUsernameAndPassword method retrieves user details based on the username and password.
     * The method returns boolean value if the username and password exist in the DB
     * 
	 * @param username
	 * @param password
	 * @return boolean value 
	 */
	public boolean getUserByUsernameAndPassword(String username, String password);
	
	/**
	 * loginByUsernameAndPassword method will check if the given credentials-username and password are in the database.
     * if the return value is true, then that means that the entered username and password are in the database.
     * if the return value is false, then the username and password are not in the database.
	 *  
	 * @param myUsername
	 * @param myPassword
	 * @return boolean value 
	 */
	public boolean loginByUsernameAndPassword(String myUsername, String myPassword);
	
	/**
	 * getUserFromDatabase method retrieves user details based on the username and password.
	 * 
	 * @param username
	 * @param password
	 * @return User
	 */
	public User getUserFromDatabase(String username, String password) throws Exception ;
	
	//public User getUserFromDatabase(String username, String password) throws Exception ;
	
	/**
	 * getUserById method will retireve the first and last name based off of the 
	 * user id.
	 * 
	 * @param id
	 * @return boolean value 
	 */
	public boolean getUserById(int id);
}
