package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlert {
	public static void main(String[] args) {
		ChromeDriver ch = null;
		try {
			System.setProperty("webdriver.chrome.driver", ".\\Library\\drivers\\chromedriver.exe");
			ch = new ChromeDriver();
			ch.manage().window().maximize();
			ch.get("file:///C:/temp/EveningBatch/HTML/Alerts%20Page/SampleAlertsDemo.html");
			Thread.sleep(2000);
			
			//Click on 'alertBtn' to get the alert
			ch.findElement(By.id("btn_id1")).click();
			Thread.sleep(2000);
			
			//Verify alert is displayed
			if(isAlertPresent(ch) == true)
			{
				//SWitch to alert
				Alert oAlert = ch.switchTo().alert();
				
				//REad the text from the alert
				System.out.println(oAlert.getText());
				
				//Click on OK button
				oAlert.accept();
			}
			else {
				System.out.println("Alert doesnot exist");
			}
			
			Thread.sleep(5000);
			
			ch.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			ch = null;
		}
	}
	
	
	
	//Write a method to check that the alert is exist or not?
	public static boolean isAlertPresent(WebDriver oDriver)
	{
		try {
			oDriver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException obj)
		{
			return false;
		}
	}
}
