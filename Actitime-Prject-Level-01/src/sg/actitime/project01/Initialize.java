package sg.actitime.project01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Initialize {
	public static WebDriver oBrowser=null;
	/**
	 * @param args
	 * Created By:
	 * Created Date:
	 * Modified By:
	 * Reviewed By:
	 * Return Value:
	 * Parameters:
	 * Description:
	 */
	public static void launchBrowser()
	{
		String path=null;
		try
		{
			path=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", "E:\\CurrentWorkSpace\\SeleniumExp\\Actitime-Prject-Level-01\\Library\\Driver\\chromedriver.exe");
			System.out.println(path);
			oBrowser=new ChromeDriver();
			oBrowser.manage().window().maximize();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 * Created By:
	 * Created Date:
	 * Modified By:
	 * Reviewed By:
	 * Return Value:
	 * Parameters:
	 * Description:
	 */
	public static void navigate()
	{
		try
		{
			oBrowser.navigate().to("http://localhost/login.do");
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 * Created By:
	 * Created Date:
	 * Modified By:
	 * Reviewed By:
	 * Return Value:
	 * Parameters:
	 * Description:
	 */
	public static void closeApplication()
	{
		try
		{
			oBrowser.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
