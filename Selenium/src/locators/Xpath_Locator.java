package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_Locator {
	public static void main(String[] args) {
		ChromeDriver ch = null;
		try {
			System.setProperty("webdriver.chrome.driver", ".\\Library\\drivers\\chromedriver.exe");
			ch = new ChromeDriver();
			ch.manage().window().maximize();
			ch.navigate().to("file:///C:/temp/EveningBatch/HTML/SampleWebPage.html");
			Thread.sleep(2000);
			
			//Identify the USerName & Password filed using absolute xpath
			ch.findElement(By.xpath("//a[@id='link_id1']")).click();
			
			Thread.sleep(2000);
			
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
