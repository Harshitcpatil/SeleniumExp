package com.sgtesting.testscripts;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitDemo {

	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		login();
		
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
			oBrowser.get("http://localhost/login.do");
			Wait<WebDriver> wait=new FluentWait<WebDriver>(oBrowser)
					.withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(NoSuchElementException.class,TimeoutException.class);
			
			wait.until(new Function<WebDriver,WebElement>(){
				public WebElement apply(WebDriver oBrowser)
				{
					return oBrowser.findElement(By.id("username"));
				}
			});
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void login()
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys("admin");	
			oBrowser.findElement(By.name("pwd")).sendKeys("manager");	
			oBrowser.findElement(By.xpath("//div[text()='Login ']")).click();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
