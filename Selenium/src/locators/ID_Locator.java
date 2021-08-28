package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ID_Locator {
	public static void main(String[] args) {
		ChromeDriver ch = null;
		try {
			System.setProperty("webdriver.chrome.driver", ".\\Library\\drivers\\chromedriver.exe");
			ch = new ChromeDriver();
			ch.manage().window().maximize();
			ch.navigate().to("file:///C:/temp/EveningBatch/HTML/SampleWebPage.html");
			Thread.sleep(2000);
			
			//Identify the USerName & Password filed using ID
			ch.findElement(By.id("frm1_un_id1")).sendKeys("userName");
			ch.findElement(By.id("frm1_pwd_id1")).sendKeys("password");
			
			Thread.sleep(2000);
			
			ch.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			ch = null;
		}
	}
}
