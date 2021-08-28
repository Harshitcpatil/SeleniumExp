package childWindows;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleChildWindow {
	public static void main(String[] args) {
		ChromeDriver ch = null;
		try {
			//Open the SampleWebPage.html
			System.setProperty("webdriver.chrome.driver", ".\\Library\\drivers\\chromedriver.exe");
			ch = new ChromeDriver();
			//A unique number to that browser. Bcoz selenium uses that unique to indentify the browser
			//next time
			ch.manage().window().maximize();
			ch.get("file:///C:/temp/EveningBatch/HTML/SampleWebPage.html");
			Thread.sleep(2000);
			
			
			//Read and store the parent window ID
			String sParent = ch.getWindowHandle();
			System.out.println(sParent);
			
			
			//Click on the 'SG Testing' link to get the child window
			ch.findElement(By.id("link_id1")).click();
			Thread.sleep(2000);
			
			
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
					
					System.out.println(ch.findElement(By.xpath("//h1")).getText());
					
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
