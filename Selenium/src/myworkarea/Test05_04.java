package myworkarea;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test05_04 {

	public static void main(String[] args) {
		ChromeDriver ch = null;
		try {
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium Automation\\Automation\\Selenium\\Library\\Driver\\chromedriver.exe");
			ch = new ChromeDriver();
			ch.manage().window().maximize();
			ch.get("file:E:\\Selenium\\Selenium notes\\SampleWebPage.html");
			Thread.sleep(2000);
			
			ch.findElement(By.id("link_id1")).click();
			Thread.sleep(4000);
			ch.findElement(By.id("link_id2")).click();
			Thread.sleep(4000);
			ch.findElement(By.id("link_id3")).click();
			Thread.sleep(4000);
			ch.findElement(By.id("link_id4"));
			
			Thread.sleep(4000);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			ch = null;
		}
	}	

	}

