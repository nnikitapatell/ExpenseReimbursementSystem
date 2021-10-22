package main.service;

import org.apache.log4j.Logger;

import main.constants.UserType;
import main.controller.UserController;
import main.dao.CustomConnectionFactory;
import main.dao.UserDaoImp;
import main.model.User;

public class UserServiceImp implements UserService {
	
	
    private UserDaoImp userDao = new UserDaoImp();
    private User myUser; //object that we are using, local copy
    private static final Logger loggy = Logger.getLogger(UserServiceImp.class);
   
    public boolean login(String username, String password) {
    	if(userDao.loginByUsernameAndPassword(username, password)){
    		loggy.info("The DB has been calle to login user");
        	return true;
        }else {
        	loggy.info("Sorry, unable to call the DB to login user");
        	return false;
        }
    }

    @Override
    public User getMyUserFromDatabase(String username, String password) throws Exception {
        User aUser = userDao.getUserFromDatabase(username, password);
        if (aUser == null) {
        	loggy.info("temp user is null");
            return null;
        } else {
            myUser = aUser;
        }
        loggy.info("Retrived a user");
        return myUser;
    }
    
    

}
