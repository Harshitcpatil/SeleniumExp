package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleNestedFrame2 {
	public static void main(String[] args) {
		ChromeDriver ch = null;
		try {
			//1. Open browser and navigate the URL 
			//(file:///C:/temp/EveningBatch/HTML/Frames/MainPage.html)
			System.setProperty("webdriver.chrome.driver", ".\\Library\\drivers\\chromedriver.exe");
			ch = new ChromeDriver();
			ch.manage().window().maximize();
			ch.navigate().to("file:///C:/temp/EveningBatch/HTML/Frames/MainPage.html");
			Thread.sleep(2000);
			
			
			
			//2. Go to Page1 (frame) and enter the user name
			ch.switchTo().frame("page1");
			ch.findElement(By.id("frm1_un_id1")).sendKeys("aaaaaaaaaaaaaa");
			Thread.sleep(2000);
			
			
			
			//3. from page1 frame go to page2 frame & select all the check boxes
			ch.switchTo().frame("Page2");
			ch.findElement(By.id("chk_id1")).click();
			ch.findElement(By.id("chk_id2")).click();
			ch.findElement(By.id("chk_id3")).click();
			ch.findElement(By.id("chk_id4")).click();
			Thread.sleep(2000);
			
			
			//4. Go back to main page
			ch.switchTo().defaultContent();
			
			
			//5. Close the application
			ch.close();						
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			ch = null;
		}
	}
}
