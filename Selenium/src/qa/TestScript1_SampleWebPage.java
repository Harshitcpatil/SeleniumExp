package qa;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript1_SampleWebPage {
	public static void main(String[] args) {
		ChromeDriver ch = null;
		try {
			//1. Open sample web application
			System.setProperty("webdriver.chrome.driver", ".\\Library\\drivers\\chromedriver.exe");
			ch = new ChromeDriver();
			ch.manage().window().maximize();
			ch.get("file:///C:/temp/EveningBatch/HTML/SampleWebPage.html");
			Thread.sleep(2000);
			
			
			//2. Click on 'SG Testing' link
			ch.findElement(By.id("link_id1")).click();
			Thread.sleep(2000);
			
			
			//3. SG Testing website opens in a new window. You need to swit to child window
			String sParent = ch.getWindowHandle();
			Set<String> objChild = ch.getWindowHandles();
			
			Object arr[] = objChild.toArray();
			ch.switchTo().window(arr[1].toString());
			System.out.println(ch.getCurrentUrl());
			
			//4. Read the upcoming batch details
			String sUpcomingBatch = ch.findElement(By.xpath("//div[@data-bind='html: updatebatch']")).getText();
			System.out.println(sUpcomingBatch);
			
			
			//5. 5. Close the SG testing window & come back to parent window
			ch.close();
			Thread.sleep(2000);
			ch.switchTo().window(sParent);
			
			
			
			//6. Click on 'Google India' link. It also opens in new window
			ch.findElement(By.id("link_id2")).click();
			Thread.sleep(2000);
			
			
			//7. Switch to google india child window
			objChild.clear();
			objChild = ch.getWindowHandles();
			arr = objChild.toArray();
			ch.switchTo().window(arr[1].toString());
			
			
			//8. Search for 'SG Testing Institute' and find out how many results were found
			ch.findElement(By.name("q")).sendKeys("SG Testing Institute");
			Thread.sleep(2000);
			ch.findElement(By.name("btnK")).click();
			Thread.sleep(2000);
			
			System.out.println(ch.findElement(By.id("result-stats")).getText());
			

			//9. close the google india child browser & switch to parent window
			ch.close();
			Thread.sleep(2000);
			
			
			//10. SWitch back to Main (Sample web application)
			ch.switchTo().window(sParent);
			
			
			//11. Close it
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
