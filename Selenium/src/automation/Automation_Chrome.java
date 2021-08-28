package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automation_Chrome {
	public static void main(String[] args) {
		ChromeDriver chrome = null;
		try {
			//Open the browser and enter the actiTime URL
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium Automation\\Automation\\Selenium\\Library\\Driver\\chromedriver.exe"
					+ "");
			
			//Open the chrome browser
			chrome = new ChromeDriver();
			
			//Maximize the chrome browser
			chrome.manage().window().maximize();
			
			//Enter the actiTime URL
			chrome.get("http://localhost/login.do");


			
			
			//Browser should open and load the URL successful
			if(chrome.getTitle().equalsIgnoreCase("actiTIME - Login"))
			{
				System.out.println("The URL navigated & actiTime login page has opened successful");
			}
			else {
				System.out.println("Failed to open the actiTime login page");
				return;
			}
			
			
			
			//Enter Username & password and click on Login button
			chrome.findElement(By.id("username")).sendKeys("admin");
			chrome.findElement(By.name("pwd")).sendKeys("manager");
			chrome.findElement(By.id("loginButton")).click();
			Thread.sleep(2000);
			
			
			
			//Verify login is successful
			String strText = chrome.findElement(By.xpath("//td[@class='pagetitle']")).getText();
			if(strText.equalsIgnoreCase("Enter Time-Track")) {
				System.out.println("The login to actiTime was successful");
			}else {
				System.out.println("Failed to login to actiTime");
				return;
			}
			
			
			//close OR handle the shortcut	window
			if(chrome.findElement(By.id("gettingStartedShortcutsMenuWrapper")).isDisplayed()) {
				chrome.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
			}
			Thread.sleep(2000);
			
			
			//Logout from actiTime	
			chrome.findElement(By.id("logoutLink")).click();
			Thread.sleep(2000);
			
			//VErify logout is successful
			strText = chrome.findElement(By.id("headerContainer")).getText();
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
			chrome.close();
			chrome = null;
		}
	}
}
