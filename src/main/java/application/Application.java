package main.java.application;

import main.java.controller.EntryController;
import main.java.controller.PriorityPaymentController;
import main.java.util.Path;
import static spark.Spark.*;



public class Application {
	
	public static void main(String[] args) {
		
		//load static files
		staticFiles.location("/public");
		//set up the routes
		get(Path.Web.TEST_PAGE,EntryController.testPage);
		get(Path.Web.INDEX_PAGE, EntryController.indexPage);
		get(Path.Web.PRIORITY_PAYMENT_PAGE,PriorityPaymentController.priorityPaymentPage);
		
	}


}
