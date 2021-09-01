package com.sgtesting.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDemo {

	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		mouseActionsUsingClick();
		mouseActionsUsingDblClick();
		mouseActionsUsingContextClick();
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
			oBrowser.get("https://www.flipkart.com/");
			Thread.sleep(4000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void mouseActionsUsingClick()
	{
		try
		{
			Actions oMouse=new Actions(oBrowser);
			WebElement oEle=oBrowser.findElement(By.xpath("//button[text()='✕']"));
			oMouse.click(oEle).build().perform();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void mouseActionsUsingDblClick()
	{
		try
		{
			Actions oMouse=new Actions(oBrowser);
			WebElement oEle=oBrowser.findElement(By.xpath("//img[@alt='Grocery']"));
			oMouse.doubleClick(oEle).build().perform();
			Thread.sleep(3000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void mouseActionsUsingContextClick()
	{
		try
		{
			Actions oMouse=new Actions(oBrowser);
			WebElement oEle=oBrowser.findElement(By.xpath("//div[text()='Staples']"));
			oMouse.moveToElement(oEle).build().perform();
			Thread.sleep(2000);
			oMouse.contextClick(oEle).build().perform();
			Thread.sleep(3000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
