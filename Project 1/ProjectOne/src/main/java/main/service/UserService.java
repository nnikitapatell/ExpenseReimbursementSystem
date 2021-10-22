package main.service;


import main.model.User;

/**
 * @author Nikita
 * The UserService class contains the business logic for performing operations 
 * on the users
 *
 */
public interface UserService {

	    /**
	     * Authenticates the username and password and returns the User object for that user
	     *
	     * @param username
	     * @param password
	     * @return the User who is currently logged in
	     */
	    public boolean login(String username, String password);

	    /**
	     * Retrieves the user from the database using their username and password
	     * 
	     * @param username
	     * @param password
	     * @return
	     * @throws Exception 
	     */
	    public User getMyUserFromDatabase(String username, String password) throws Exception;

	}
	
