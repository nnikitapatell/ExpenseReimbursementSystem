package main.frontcontroller;

import main.constants.UserType;

import main.model.User;

import org.apache.log4j.Logger;

import io.javalin.Javalin;
import io.javalin.http.Context;
//import io.javalin.http.UnauthorizedResponse;

public class FrontController {
	private static final Logger loggy = Logger.getLogger(FrontController.class);
	Javalin app;
	Dispatcher dispatcher;

	///////////// CONSTRUCTOR
	/**
	 * 
	 * @param app
	 */
	public FrontController(Javalin app) {
		this.app = app; // configuration
		app.before("/api/*", FrontController::checkAllRequests); // checking if
		// requests exist
		// app.before("/*", FrontController::checkAllRequests);
		loggy.info("Checked if the requests exist");
		this.dispatcher = new Dispatcher(app);
	}

	/////////////// MIDDLEWARE LOGIC
	/*
	 * THIS is where you'd check to see if they are logged in, via checking their
	 * current session object and you'll see what role they are logged in as.
	 * 
	 * For example, employees shouldn't be able to trigger admin functionality just
	 * because they hard coded the admin url into their browser.
	 */
	/**
	 * @param context
	 */
	public static void checkAllRequests(Context context) {
		// System.out.println("In front controller! " + context.path());
		loggy.info("In front controller!  " + context.path());
		// check to see if the the current user session attribute is null and is the
		// path /index.html
		if (context.sessionAttribute("currentUser") == null && context.path().equals("/index.html")) {
			loggy.info("Current user is null and pat is " + context.path());
			// System.out.println("True");
			return;
		}
		if (context.path().equals("/api/user")) {
			// System.out.println(context.path() );
			loggy.info(context.path());
			return;
		}
	}
}
