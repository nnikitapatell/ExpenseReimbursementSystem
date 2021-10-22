package main.controller;

import org.apache.log4j.Logger;


import io.javalin.http.Context;
import main.constants.UserType;
import main.frontcontroller.FrontController;
import main.model.User;
import main.service.UserServiceImp;

public class UserController {
	// private static List<User> myAccounts = new ArrayList<>();
	private static UserServiceImp myUserServices = new UserServiceImp();
	private static final Logger loggy = Logger.getLogger(UserController.class);

	//////////////////////// HANDLER LOGIC: 
	/**
	 * @param context
	 * @throws Exception 
	 */
	public static void login(Context context) throws Exception {
//		System.out.println(context.fullUrl());//what is the difference between a get and post?

		String username = context.formParam("myUsername");
		String password = context.formParam("myPassword");
		loggy.info("User controller " + username + " logged in");
		//System.out.println("username: "+username+" "+"\t\tpassword: "+password);
		
		User validUser = myUserServices.getMyUserFromDatabase(username, password);
		if(null != validUser) {
			context.sessionAttribute("currentUser",validUser); 
			if (((User) context.sessionAttribute("currentUser")).getUserType() == UserType.EMPLOYEE) {																		
				loggy.info("Current user is a employee");
				//System.out.println("go to employee page");
				context.redirect("/html/employee.html");
			}else{		
				loggy.info("Current user is a manager");
			
				context.redirect("/html/manager.html");
			}
		}else {
			loggy.info("Redirected the invalid user.");
			context.redirect("/index.html");
		}
	}
	
	/**
	 * @param context
	 */
	public static void whoAmI(Context context) {
		if(null == context.sessionAttribute("currentUser")) {
			loggy.error("Current user session is invalid");
			context.json("INVAID_SESSION");
		}else {
			loggy.info("I am: " + ((User) context.sessionAttribute("currentUser")).getUserType());
		//	System.out.println("I am: " + ((User) context.sessionAttribute("currentUser")).getUserType());
			context.json(((User) context.sessionAttribute("currentUser")).getUserType());
		}
	}

	/**
	 * @param context
	 * @throws Exception 
	 */
	public static void getAllUsers(Context context) throws Exception {
		loggy.info("calling the service layer from controller to get user from database");
		context.json(myUserServices.getMyUserFromDatabase("username1", "pass1"));
	}
	
	/**
	 * @param context
	 */
	public static void logout(Context context) {
		loggy.info("The current user is null and the user is being redirected to the login page.");
		context.sessionAttribute("currentUser",null); //set the value to null to delete the obj that was stored in the session. The current user is not pointing to any object 
		context.redirect("/index.html"); // bc youre session is terminated you must login again
	}
}
