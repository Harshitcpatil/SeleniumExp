package com.sgtesting.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathDemo {

	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		staleEleemntExceptionDemo();
	}
	
	static void launchBrowser()
	{
		String path=null;
		try
		{
			path=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path+"\\Library\\drivers\\chromedriver.exe");
			System.out.println(path);
			oBrowser=new ChromeDriver();
			oBrowser.manage().window().maximize();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void navigate()
	{
		try
		{
			oBrowser.get("file:///H:/HTML/Sample.html");
			Thread.sleep(4000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	static void staleEleemntExceptionDemo()
	{
		try
		{
			List<WebElement> olinks=oBrowser.findElements(By.xpath("\\a[@href]"));
			System.out.println("# of links :"+olinks.size());
			for(int i=0;i<olinks.size();i++)
			{
				WebElement link=olinks.get(i);
				String text=link.getText();
				if(text.startsWith("Sele"))
				{
					link.click();
					
				}
			}
		//	oBrowser.navigate().back();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
