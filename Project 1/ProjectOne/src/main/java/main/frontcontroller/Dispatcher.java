package main.frontcontroller;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*; //this is where "path" came from

import org.apache.log4j.Logger;

import main.controller.ReimbursementController;
import main.controller.UserController;
import main.dao.CustomConnectionFactory;

/**
 * Dispatcher itself is an instance of the dispatcher class we construct, but the controller pasth are static
 * handler is an interface that contain ONE method, which takes in two parameters.
 * That is why we can use lambda on it (argument-list) -> {body} 
 * Handlers:
 * Get - to retrieve a resource
 * Post - to create a resource
 * Put - update a resource, but it then replaces that resource with an updated one
 * Patch - is to partially update a resource
 * Delete - to delete a resource 
 * 
 * @author niki3
 *
 */
public class Dispatcher {
	private static final Logger loggy = Logger.getLogger(Dispatcher.class);
	///////////// CONSTRUCTOR
	/**
	 * creates a cinstructor to setup all the paths 
	 * @param app
	 */
	public Dispatcher(Javalin app) {
		setupAllPaths(app);
	}

	/**
	 * setupAllPaths method sets up paths for the usercontroller and 
	 * reimbursement controller
	 * 
	 * @param app
	 */
	public static void setupAllPaths(Javalin app) {
		setupUserControllerPaths(app);
		setUpReimbursementControllerPaths(app);
	}

	/**
	 * 
	 * @param app
	 */
	public static void setupUserControllerPaths(Javalin app) {
		app.routes(()->{
			path("/api/user", ()->{
				loggy.info("Added a GET request handler for the current path to the /api/user.");
				get(UserController::getAllUsers);
				path("/login", ()->{
					loggy.info("Added a POST request handler for the current path to the /api/user/login.");
					post(UserController::login);//endpoint: /api/user/login
				});
				path("/logout", ()->{
					loggy.info("Added a GET request handler for the current path to the /api/user/logout.");
					get(UserController::logout);//endpoint: /api/user/logout
				});
			});
		});
	}
	
	/**
	 * @param app
	 */
	public static void setUpReimbursementControllerPaths(Javalin app) {
		
		app.routes(()->{ //routes allows us to call the handlers
			path("/user/employee/tickets", ()->{ 
				loggy.info("Added a GET request handler for the current path to the /user/employee/tickets.");
				get(ReimbursementController::getUserTicket); //endpoint: /user/employee/tickets
				path("/create", ()->{
					loggy.info("Added a POST request handler for the current path to the /user/employee/tickets/create.");
					post(ReimbursementController::createTicket);//endpoint: /user/employee/tickets/create
				});	
			});
			path("/user/manager/tickets", ()->{
				loggy.info("Added a GET request handler for the current path to the /user/manager/tickets.");
				get(ReimbursementController::getAllTickets);//endpoint: /user/manager/tickets
				path("/update", ()->{
					loggy.info("Added a POST request handler for the current path to the /user/manager/tickets/update.");
					//put is usually when machine makes a change (server to server calls)
					post(ReimbursementController::updateTicket);//endpoint: /user/manager/tickets/update
				});
				
			});
			path("/user/whoami", ()->{
				loggy.info("Added a GET request handler for the current path to the whoAmI.");
				get(UserController::whoAmI);
			});
		});
	}
}