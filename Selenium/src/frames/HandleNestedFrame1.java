package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleNestedFrame1 {
	public static void main(String[] args) {
		ChromeDriver ch = null;
		try {
			//1. Open browser and navigate the URL 
			//(file:///C:/temp/EveningBatch/HTML/Frames/MainPage.html)
			
			System.setProperty("webdriver.chrome.driver", 
					System.getProperty("user.dir")+"\\Library\\drivers\\chromedriver.exe");
			ch = new ChromeDriver();
			ch.manage().window().maximize();
			ch.navigate().to("file:///C:/temp/EveningBatch/HTML/Frames/MainPage.html");
			Thread.sleep(2000);
			
			
			//2. Go to Page2 (frame) and check the 'Selenium IDE' check box
			ch.switchTo().frame("page1").switchTo().frame("Page2");
			ch.findElement(By.id("chk_id1")).click();
			Thread.sleep(2000);
			
			
			//3. Come back to Page1 (Frame) & enter the UN & PWD
			ch.switchTo().parentFrame();
			ch.findElement(By.id("frm1_un_id1")).sendKeys("userName");
			ch.findElement(By.id("frm1_pwd_id1")).sendKeys("Password");
			Thread.sleep(2000);
			
			
			//4. Go back to main page
			ch.switchTo().defaultContent();
			
			
			//5. Close the application
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
