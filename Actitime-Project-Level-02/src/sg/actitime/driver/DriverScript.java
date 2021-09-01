package sg.actitime.driver;

import org.openqa.selenium.WebDriver;

import sg.actitime.project02.Customers;
import sg.actitime.project02.HomePage;
import sg.actitime.project02.Initialize;
import sg.actitime.project02.LoginLogout;
import sg.actitime.project02.Projects;
import sg.actitime.project02.Tasks;
import sg.actitime.project02.Users;

public class DriverScript {

	public static void main(String[] args) {
		WebDriver oBrowser=null;
		//Create User Scenario
		oBrowser=Initialize.launchBrowser();
		Initialize.navigate(oBrowser);
		LoginLogout.login(oBrowser);
		HomePage.minimizeFlyOutWindow(oBrowser);
		Users.createUser(oBrowser);
		Users.deleteUser(oBrowser);
		LoginLogout.logout(oBrowser);
		Initialize.closeApplication(oBrowser);
		
		//Create and Modify User Scenario
		oBrowser=Initialize.launchBrowser();
		Initialize.navigate(oBrowser);
		LoginLogout.login(oBrowser);
		HomePage.minimizeFlyOutWindow(oBrowser);
		Users.createUser(oBrowser);
		Users.modifyUser(oBrowser);
		Users.deleteUser(oBrowser);
		LoginLogout.logout(oBrowser);
		Initialize.closeApplication(oBrowser);
		
		//Create and Modify Coustomer Scenario
		oBrowser=Initialize.launchBrowser();
		Initialize.navigate(oBrowser);
		LoginLogout.login(oBrowser);
		HomePage.minimizeFlyOutWindow(oBrowser);
		Customers.createCustomer(oBrowser);
		System.out.println("createCustomer browser");
	    Customers.modifyCustomer(oBrowser);
	    Customers.deleteCustomer(oBrowser);
		LoginLogout.logout(oBrowser);
		Initialize.closeApplication(oBrowser);
		
		//Create and Modify Project Scenario
		oBrowser=Initialize.launchBrowser();
		Initialize.navigate(oBrowser);
		LoginLogout.login(oBrowser);
		HomePage.minimizeFlyOutWindow(oBrowser);
		Projects.createProject(oBrowser);
        Projects.modifyProject(oBrowser);
        Projects.deleteProject(oBrowser);
		LoginLogout.logout(oBrowser);
		Initialize.closeApplication(oBrowser);
		
		//Create and Modify Project Scenario
				oBrowser=Initialize.launchBrowser();
				Initialize.navigate(oBrowser);
				LoginLogout.login(oBrowser);
				HomePage.minimizeFlyOutWindow(oBrowser);
				Tasks.createTasks(oBrowser);
				Tasks.modifyTasks(oBrowser);
				Tasks.deleteTasks(oBrowser);
				LoginLogout.logout(oBrowser);
				Initialize.closeApplication(oBrowser);
				
		
	}

}
