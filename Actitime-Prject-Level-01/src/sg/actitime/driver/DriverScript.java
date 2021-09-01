package sg.actitime.driver;

import sg.actitime.project01.Customers;
import sg.actitime.project01.HomePage;
import sg.actitime.project01.Initialize;
import sg.actitime.project01.LoginLogout;
import sg.actitime.project01.Projects;
import sg.actitime.project01.Tasks;
import sg.actitime.project01.Users;

public class DriverScript {

	public static void main(String[] args) {
		
		 //Create User Scenario
	    Initialize.launchBrowser();
		Initialize.navigate();
		LoginLogout.login();
		HomePage.minimizeFlyOutWindow();
		Users.createUser();
		Users.deleteUser();
		LoginLogout.logout();
		Initialize.closeApplication();
		
		//Create and Modify User Scenario
		Initialize.launchBrowser();
		Initialize.navigate();
		LoginLogout.login();
		HomePage.minimizeFlyOutWindow();
		Users.createUser();
		Users.modifyUser();
		Users.deleteUser();
		LoginLogout.logout();
		Initialize.closeApplication();
		
		//Create and Modify Coustomer Scenario
				Initialize.launchBrowser();
				Initialize.navigate();
				LoginLogout.login();
				HomePage.minimizeFlyOutWindow();
		        Customers.createCustomer();
		        Customers.modifyCustomer();
		        Customers.deleteCustomer();
				LoginLogout.logout();
				Initialize.closeApplication();
				

				//Create and Modify Project Scenario
						Initialize.launchBrowser();
						Initialize.navigate();
						LoginLogout.login();
						HomePage.minimizeFlyOutWindow();
				       Tasks.createTasks();
				       Tasks.modifyTasks();
				       Tasks.deleteTasks();
						LoginLogout.logout();
						Initialize.closeApplication();

	}

}
