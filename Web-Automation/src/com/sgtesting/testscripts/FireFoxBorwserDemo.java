package com.sgtesting.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class FireFoxBorwserDemo {
	public static WebDriver oBrowser=null;
	public static String path=null;
	public static void main(String[] args) {
		
		launchBrowser();
	//	navigate();

	}
	
	static void launchBrowser()
	{
		try
		{
			path=System.getProperty("user.dir");
			System.setProperty("webdriver.gecko.driver", path+"\\Library\\drivers\\geckodriver.exe");
			
			/*ProfilesIni profileini=new ProfilesIni();
			FirefoxProfile ffprofile=profileini.getProfile("AutomationProfile");
			FirefoxOptions options=new FirefoxOptions();
			options.setProfile(ffprofile);*/
			
			FirefoxProfile ffprofile=new FirefoxProfile();
			ffprofile.setPreference("browser.startup.homepage", "http://www.sgtestinginstitute.com");
			FirefoxOptions options=new FirefoxOptions();
			options.setProfile(ffprofile);
			
			oBrowser=new FirefoxDriver(options);
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
			Thread.sleep(4000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
