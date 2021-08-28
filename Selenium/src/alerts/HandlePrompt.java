package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlePrompt {
	public static void main(String[] args) {
		ChromeDriver ch = null;
		try {
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium Automation\\Automation\\Selenium\\Library\\Driver\\chromedriver.exe");
			ch = new ChromeDriver();
			ch.manage().window().maximize();
			ch.get("file:E:\\Selenium\\Selenium notes\\SampleWebPage.html");
			Thread.sleep(2000);
			
			//Click on 'promptBtn' to get the prompt alert
			ch.findElement(By.id("btn_id3")).click();
			Thread.sleep(2000);
			
			//Verify alert is displayed
			if(isAlertPresent(ch) == true)
			{
				//SWitch to alert
				Alert oAlert = ch.switchTo().alert();
				
				//REad the text from the prompt alert
				System.out.println(oAlert.getText());
				
				//Enter the input in the prompt
				oAlert.sendKeys("SG Testing Institute");
				Thread.sleep(2000);
				
				//oAlert.accept();
				oAlert.dismiss();
				Thread.sleep(2000);
				
				//Read the text displayed on the page
				
				String sText = ch.findElement(By.xpath("/html/body")).getText();
				System.out.println(sText);
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
