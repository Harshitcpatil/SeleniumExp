package myworkarea;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automationofactitime1 {

	public static void main(String[] args) {
		//
		ChromeDriver ch =null;
		try {
			System.setProperty("webdriver.chrome.driver","E:\\Selenium Automation\\Automation\\Selenium\\Library\\Driver\\chromedriver.exe");
	
		ch=new ChromeDriver();
		ch.manage().window().maximize();
		ch.get("http://localhost/login.do");
			if(ch.getTitle().equalsIgnoreCase("actiTIME - Login"))
				System.out.println("URL Loaded");
			
			
			else
				System.out.println("URL not Loaded");
			Thread.sleep(2000);
			
		ch.findElement(By.id("username")).sendKeys("admin");
		ch.findElement(By.name("pwd")).sendKeys("manager");
		ch.findElement(By.id("loginButton")).click();
		Thread.sleep(2000);
		
		String str=ch.findElement(By.xpath("//td[@class='pagetitle']")).getText();
		if(str.equalsIgnoreCase("Enter Time-Track"))
		System.out.println(" Login successfully");
		else
			System.out.println(" Login not successfully");
		
		ch.findElement(By.xpath("//td[@class='logoutCell']")).click();
		Thread.sleep(2000);
		
	if(ch.getTitle().equalsIgnoreCase("actiTIME - Login"))
		
		System.out.println("Log out successfully");
	else {
	
		System.out.println("Log out not successfully");
		Thread.sleep(2000);
	return;
		}
		ch.close();
		

		
		
		}
		
		catch(Exception e)
		{
			
		}
		

	}

}
