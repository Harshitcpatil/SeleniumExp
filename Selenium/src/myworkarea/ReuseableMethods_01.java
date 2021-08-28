package myworkarea;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReuseableMethods_01 {
	/****************************************
	 * Method Name		: luanchBrowser()
	 * Purpose			: It is used to launch the required browser viz., Chrome, Firefox & IE
	 * Author			: tester1
	 * Reviewer Name	:
	 * Modified By		:
	 * Modified Date	:
	 * Arguments		:
	 * ReturnType		:
	 * @return 
	 ****************************************/

public static WebDriver LanchBrowser(String browsername) {
	WebDriver wb=null;
	
	try {
		switch (browsername.toLowerCase())
		{
		case "chrome":
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Automation\\Automation\\Selenium\\Library\\Driver\\chromedriver.exe");
		wb=new ChromeDriver();
		case "firefox":
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium Automation\\Automation\\Selenium\\Library\\Driver\\geckodriver.exe");
			wb=new FirefoxDriver();
		}
			if(wb!=null)
			{
			System.out.println("The brower'"+browsername+"'open succesfully");
			wb.manage().window().maximize();
			return wb;
			}
			else
			{
				System.out.println("Invalid browser name '"+browsername+"' was specified.");
			return null;
			}
	}
	catch(Exception e)
	{
		System.out.println("Exception in 'luanchBrowser()' method. " + e);
		return null;
	}
	finally {
		wb=null;
	}
	}
/****************************************
 * Method Name		: navigateUrl()
 * Purpose			: It is used to navigate URL
 * Author			: tester1
 * Reviewer Name	:
 * Modified By		:
 * Modified Date	:
 * Arguments		:
 * ReturnType		:
 * @return 
 ****************************************/


public static boolean navigateURL(WebDriver wb,String Url) {

	try {
		wb.navigate().to(Url);
		if(wb.getTitle().equalsIgnoreCase("actiTIME - Login")){
			System.out.println("The URL was navigated successful");
			return true;
		}else {
			System.out.println("Failed to navigate the URL");
			return false;
		}
	}catch(Exception e)
	{
		System.out.println("Exception in 'navigateURL()' method. " + e);
		return false;
	}
}

			
		}


