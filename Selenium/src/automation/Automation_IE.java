package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Automation_IE {
	public static void main(String[] args) {
		InternetExplorerDriver ie = null;
		try {
			//Open the browser and enter the actiTime URL
			System.setProperty("webdriver.ie.driver", "C:\\temp\\EveningBatch\\Evening_Workspace\\CoreJava_Project\\Library\\drivers\\iEDriverServer.exe");
			
			//Open the chrome browser
			ie = new InternetExplorerDriver();
			
			//Maximize the chrome browser
			ie.manage().window().maximize();
			
			//Enter the actiTime URL
			ie.get("http://localhost/login.do");
			Thread.sleep(2000);
			
			
			//Browser should open and load the URL successful
			if(ie.getTitle().equalsIgnoreCase("actiTIME - Login")) {
				System.out.println("The URL navigated & actiTime login page has opened successful");
			}else {
				System.out.println("Failed to open the actiTime login page");
				return;
			}
			
			
			
			//Enter Username & password and click on Login button
			ie.findElement(By.id("username")).sendKeys("admin");
			ie.findElement(By.name("pwd")).sendKeys("manager");
			ie.findElement(By.id("loginButton")).click();
			Thread.sleep(2000);
			
			
			//Verify login is successful
			String strText = ie.findElement(By.xpath("//td[@class='pagetitle']")).getText();
			if(strText.equalsIgnoreCase("Enter Time-Track")) {
				System.out.println("The login to actiTime was successful");
			}else {
				System.out.println("Failed to login to actiTime");
				return;
			}
			
			
			//close OR handle the shortcut	window
			/*if(ie.findElement(By.xpath("//div[@style='display: block;']")).isDisplayed()) {
				ie.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
			}
			Thread.sleep(2000);*/
			
			
			//Logout from actiTime	
			ie.findElement(By.id("logoutLink")).click();
			Thread.sleep(2000);
			
			//VErify logout is successful
			strText = ie.findElement(By.id("headerContainer")).getText();
			if(strText.equalsIgnoreCase("Please identify yourself")) {
				System.out.println("Logout from the actiTime is successful");
			}else {
				System.out.println("Failed to logout from the actiTime");
				return;
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Close the browser
			ie.close();
			ie = null;
		}
	}
}
