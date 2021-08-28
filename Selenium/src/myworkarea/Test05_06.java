package myworkarea;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test05_06 {

public static void main(String[] args) {
			ChromeDriver chrome = null;
			try {

				System.setProperty("webdriver.chrome.driver", "E:\\Selenium Automation\\Automation\\Selenium\\Library\\Driver\\chromedriver.exe"
						+ "");
				
				chrome = new ChromeDriver();
				
	
				chrome.manage().window().maximize();
				
		
				chrome.get("https://www.redbus.com");
				Thread.sleep(10000);
				

				
				
			
				if(chrome.getTitle().equalsIgnoreCase("Book bus tickets online with redBus!"))
				{
					System.out.println("The URL  opened successful");
					Thread.sleep(2000);
					
				}
				else {
					System.out.println("Failed to The URL  opened successful");
					return;
				}
				chrome.findElement(By.id("src")).sendKeys("Shivamogga");
			      chrome.findElement(By.id("src")).click();
				Thread.sleep(1000);
				chrome.findElement(By.id("dest")).sendKeys("Bangalore");
				  chrome.findElement(By.id("dest")).click();
				Thread.sleep(1000);
				 chrome.findElement(By.xpath("//label[@for='onward_cal']")).sendKeys("26-Jul-2021");
				
				chrome.findElement(By.id("search_btn")).click();
				Thread.sleep(1000);

				String strText=	chrome.findElement(By.xpath("//div[@class='fr-strts-frm']")).getText();
				if(strText.contentEquals("Fare Starts from INR 399")) 
				System.out.println("search result found");	
				else System.out.println("search result not found");
				return;
				
				
			}
				
				
			catch(Exception e)
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
	