package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Name_Locator {
	public static void main(String[] args) {
		ChromeDriver ch = null;
		try {
			System.setProperty("webdriver.chrome.driver", ".\\Library\\drivers\\chromedriver.exe");
			ch = new ChromeDriver();
			ch.manage().window().maximize();
			ch.navigate().to("file:///C:/temp/EveningBatch/HTML/SampleWebPage.html");
			Thread.sleep(2000);
			
			//Identify the USerName & Password filed using name
			ch.findElement(By.name("frm1_un_name1")).sendKeys("userName");
			ch.findElement(By.name("frm1_pwd_name1")).sendKeys("password");
			
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
