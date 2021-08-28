package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagName_Locator {
	public static void main(String[] args) {
		ChromeDriver ch = null;
		try {
			System.setProperty("webdriver.chrome.driver", ".\\Library\\drivers\\chromedriver.exe");
			ch = new ChromeDriver();
			ch.manage().window().maximize();
			ch.navigate().to("file:///C:/temp/EveningBatch/HTML/SampleWebPage.html");
			Thread.sleep(2000);
			
			//Identify the USerName filed using tagName
			ch.findElement(By.tagName("input")).sendKeys("userName");
			
			
			//Click on the first check link
			ch.findElement(By.tagName("a")).click();
			Thread.sleep(3000);
			
			ch.quit();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			ch = null;
		}
	}
}
