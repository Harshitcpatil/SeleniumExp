package automation;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutomationofNukri {

	public static void main(String[] args) {
		// Automatin of nukri
		
		

	ChromeDriver ch= null;
		
		try
		
		{
			

			System.setProperty("webdriver.chrome.driver", "E:\\Selenium Automation\\Automation\\Selenium\\Library\\Driver\\chromedriver.exe"
					+ "");
			ch=new ChromeDriver();
			ch.manage().window().maximize();
			ch.get("https://www.naukri.com/");
			
			
			//Cofirm Nukri open or not
			
			
			if(ch.getTitle().equalsIgnoreCase("Jobs - Recruitment - Job Search -  Employment -Job Vacancies - Naukri.com"))
			{ 
				System.out.println("nukri opened successful");
			
			}
			else {
				System.out.println("Failed to open the nukri page");
				Thread.sleep(10000);
		
			}
			
			
			
			//Read Prent window
			String sParents = ch.getWindowHandle();
			System.out.println(sParents);
			// Read Child window
			
			Set<String>schild =ch.getWindowHandles();
			System.out.println(schild );
			
			for (String child:schild)
			{//Find the parent window id or filter te parent window id 
				if(!child.equals(sParents))
					
			//Switch to the child window with the help of child window ID
					
				{	ch.switchTo().window(child); 
					
				System.out.println(ch.getTitle());
			System.out.println(ch.getCurrentUrl());
			
			//close child window
			
			ch.close();
			Thread.sleep(2000);
				}	
			
			}
			
			
			ch.switchTo().window(sParents);
			Thread.sleep(2000);
			
			//Close the parent window
			ch.close();
			
		}
		catch(Exception e)
		{
		
		}
		finally 
		{
			ch=null;
		}
		}
}


