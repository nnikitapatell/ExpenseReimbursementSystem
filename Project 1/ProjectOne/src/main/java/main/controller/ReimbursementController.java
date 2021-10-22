package main.controller;

import org.apache.log4j.Logger;

import io.javalin.http.Context;
import main.model.User;
import main.service.ReimbursementService;
import main.service.ReimbursementServiceImp;

/**
 * @author nikita patel
 *
 */
public class ReimbursementController {

//	private static List<Reimbursement> myReimbursements = new ArrayList<>();
	private static ReimbursementService myReimServices = new ReimbursementServiceImp();
	private static final Logger loggy = Logger.getLogger(ReimbursementController.class);

	//////////////////////// HANDLER LOGIC

	/**
	 * The context object provides you with everything you need to handle
	 * a http request.
	 * It contains the underlying servlet-request and servlet-response, and a bunch of getters and setters.
	 * Javalin has 3 main handler type: before handler, endpoint handler, and after-handler
	 * @return void
	 * @param context
	 */
	public static void getAllTickets(Context context) {
		//use the context.json to set the response which will be returned to the user.
		loggy.info("The getAllTickets method is being called from the controller.");
		context.json(myReimServices.getAllTickets());
	}

	/**
	 * gets the tickets for current logged in user
	 * @param context
	 */
	public static void getUserTicket(Context context) { 
		//context.sessionAttribute will get a session attribute
		loggy.info("The getUserTickets method is being called from the controller.");
		int reimAuthor = ((User) context.sessionAttribute("currentUser")).getErsUsersID();
		//use the context.json to set the response which will be returned to the user.
		context.json(myReimServices.getUserTickets(reimAuthor));
	}

	/**
	 * creates ticket by getting values submitted by the current user 
	 * the ticket is stored under the current user
	 * the values of amount and description are obtained by input from the form.
	 * 
	 * @param context
	 */
	public static void createTicket(Context context) {
		int reimAmount = Integer.parseInt(context.formParam("reimAmount"));//form parameter by name, as string but then its parsed to an int value 
		//get the current user id usign model layer User class
		int reimAuthor = ((User) context.sessionAttribute("currentUser")).getErsUsersID();
		//form parameter by name, as string
		String description = context.formParam("reimDesc");
		//int statusId = Integer.parseInt(context.pathParam("statusId"));
		int reimType = Integer.parseInt(context.formParam("reimType"));
		//check if the a new ticket was created
		if (myReimServices.createNewTicket(reimAmount, description, reimAuthor, reimType)) {
			//true - then redirect to employee page to see the updated tabel
			loggy.info("Successfully created a new ticket and the user is being redirected back to the employee page to see the new ticket added");
			context.redirect("/html/employee.html");
		}
	}

	/**
	 * updates the ticket by getting input from the form.
	 * 
	 * @param context
	 */
	public static void updateTicket(Context context) {
		int reimId = Integer.parseInt(context.formParam("reimId")); //form parameter by name, as string, but then its parsed to an int value 
		int reimStatusId = Integer.parseInt(context.formParam("reimStatusId")); //form parameter by name, as string, but then its parsed to an int value 
		int userId = ((User)context.sessionAttribute("currentUser")).getErsUsersID(); //get the current user id usign model layer User class

		//check if the ticket was updated
		if (myReimServices.updateTicket(reimId, reimStatusId, userId)) {
			//redirect the user to the manager page to see update
			context.redirect("/html/manager.html");
			loggy.info("The ticket has a been updated: " + myReimServices.updateTicket(reimId, reimStatusId, userId));
			//System.out.println(myReimServices.updateTicket(reimId, reimStatusId, userId));
			//System.out.println("The ticket has been updated.");
		}
	}
}
