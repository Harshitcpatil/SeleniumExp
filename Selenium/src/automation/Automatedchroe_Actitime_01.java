package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;




public class Automatedchroe_Actitime_01 {

	public static void main(String[] args) {
		ChromeDriver ch = null;
	try {
System.setProperty("webdriver.chrome.driver", "E:\\Selenium Automation\\Automation\\Selenium\\Library\\Driver\\chromedriver.exe"
		+ "");

	ch = new ChromeDriver();
	ch.manage().window().maximize();
	ch.get("http://localhost/login.do");
	Thread.sleep(2000);
	
	if(ch.getTitle().equalsIgnoreCase("actiTIME - Login"))
	
	{
		System.out.println("The URL navigated & actiTime login page has opened successful");
	}
	
	else {
		System.out.println("Url not loaded");
		return;
		
		
	}
	
		
	
	ch.findElement(By.id("username")).sendKeys("admin");
	
	ch.findElement(By.name("pwd")).sendKeys("manager");
	ch.findElement(By.id("loginButton")).click();	
	Thread.sleep(2000);
	
	String str=ch.findElement(By.xpath("//td[@Class='pagetitle']")).getText();
	if(str.equalsIgnoreCase("Enter Time-Track"))
	{System.out.println("The login to actiTime was successful");}
	else
	{System.out.println("not login to actiTime");
return;	}
	if(ch.findElement(By.id("gettingStartedShortcutsMenuWrapper")).isDisplayed());
	{
	ch.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
	
	}
	Thread.sleep(2000);
	
	ch.findElement(By.id("logoutLink")).click();
	
	}
	

	catch (Exception e) {
		
	
		
	}
	

	
	finally
	{
		ch = null;
	}
	
	}
}
