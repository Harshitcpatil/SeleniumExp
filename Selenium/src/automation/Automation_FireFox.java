package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Automation_FireFox {
	public static void main(String[] args) {
		FirefoxDriver ff = null;
		try {
			//Open the browser and enter the actiTime URL
			System.setProperty("webdriver.gecko.driver", "C:\\temp\\EveningBatch\\Evening_Workspace\\CoreJava_Project\\Library\\drivers\\geckodriver.exe");
			
			//Open the chrome browser
			ff = new FirefoxDriver();
			
			//Maximize the chrome browser
			ff.manage().window().maximize();
			
			//Enter the actiTime URL
			ff.get("http://localhost/login.do");
			Thread.sleep(2000);
			
			
			//Browser should open and load the URL successful
			if(ff.getTitle().equalsIgnoreCase("actiTIME - Login")) {
				System.out.println("The URL navigated & actiTime login page has opened successful");
			}else {
				System.out.println("Failed to open the actiTime login page");
				return;
			}
			
			
			
			//Enter Username & password and click on Login button
			ff.findElement(By.id("username")).sendKeys("admin");
			ff.findElement(By.name("pwd")).sendKeys("manager");
			ff.findElement(By.id("loginButton")).click();
			Thread.sleep(2000);
			
			
			//Verify login is successful
			String strText = ff.findElement(By.xpath("//td[@class='pagetitle']")).getText();
			if(strText.equalsIgnoreCase("Enter Time-Track")) {
				System.out.println("The login to actiTime was successful");
			}else {
				System.out.println("Failed to login to actiTime");
				return;
			}
			
			
			//close OR handle the shortcut	window
			if(ff.findElement(By.id("gettingStartedShortcutsMenuWrapper")).isDisplayed()) {
				ff.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
			}
			Thread.sleep(2000);
			
			
			//Logout from actiTime	
			ff.findElement(By.id("logoutLink")).click();
			Thread.sleep(2000);
			
			//VErify logout is successful
			strText = ff.findElement(By.id("headerContainer")).getText();
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
			ff.close();
			ff = null;
		}
	}
}
