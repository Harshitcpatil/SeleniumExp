package childWindows;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaukriChildWindows {
	public static void main(String[] args) {
		ChromeDriver ch = null;
		try {
			//Open the SampleWebPage.html
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium Automation\\Automation\\Selenium\\Library\\Driver\\chromedriver.exe"
					+ "");
			ch = new ChromeDriver();
			//A unique number to that browser. Bcoz selenium uses that unique to indentify the browser
			//next time
			ch.manage().window().maximize();
			ch.get("https://www.naukri.com/");
			
			Thread.sleep(2000);
			
			
			//Read and store the parent window ID
			String sParent = ch.getWindowHandle();
			System.out.println(sParent);			
			
			//Read/Get the child window ID's
			Set<String> objChild = ch.getWindowHandles();
			System.out.println(objChild);
			
			for(String child : objChild)
			{
				//Filter out the parent window id
				if(!child.equals(sParent))
				{
					//Switch to the child window with the help of child window ID
					ch.switchTo().window(child);
					
					System.out.println(ch.getTitle());
					System.out.println(ch.getCurrentUrl());					
					Thread.sleep(2000);
					
					//Close the child window
					ch.close();
					Thread.sleep(2000);
				}
			}
			
			//SWitch back to parent window
			ch.switchTo().window(sParent);
			Thread.sleep(2000);
			
			//Close the parent window
			ch.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			ch = null;
		}
	}
}
