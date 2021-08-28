package scriptingTwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReusebleMethods {
	/****************************************
	 * Method Name		: luanchBrowser()
	 * Purpose			: It is used to launch the required browser viz., Chrome, Firefox & IE
	 * Author			: tester1
	 * Reviewer Name	:
	 * Modified By		:
	 * Modified Date	:
	 * Arguments		:
	 * ReturnType		:
	 ****************************************/
	public static WebDriver luanchBrowser(String browserName)
	{
		WebDriver oDriver = null;
		try {
			switch(browserName.toLowerCase())
			{
				case "chrome":
					System.setProperty("webdriver.chrome.driver", ".\\Library\\drivers\\chromedriver.exe");
					oDriver = new ChromeDriver();
					break;
				case "firefox":
					System.setProperty("webdriver.gecko.driver", ".\\Library\\drivers\\geckodriver.exe");
					oDriver = new FirefoxDriver();
					break;
				case "ie":
					System.setProperty("webdriver.ie.driver", ".\\Library\\drivers\\IEDriverServer.exe");
					oDriver = new InternetExplorerDriver();
					break;
				default:
					System.out.println("Invalid browser name '"+browserName+"' was specified.");
			}
			
			if(oDriver != null) {
				System.out.println("The browser '"+browserName+"' has launched successful");
				oDriver.manage().window().maximize();
				return oDriver;
			}else {
				System.out.println("Failed to launch the '"+browserName+"' browser");
				return null;
			}
		}catch(Exception e)
		{
			System.out.println("Exception in 'luanchBrowser()' method. " + e);
			return null;
		}
		finally
		{
			oDriver = null;
		}
	}
	
	
	
	
	/****************************************
	 * Method Name		: navigateURL()
	 * Purpose			: It is used to navigate the URL
	 * Author			: tester1
	 * Reviewer Name	:
	 * Modified By		:
	 * Modified Date	:
	 * Arguments		:
	 * ReturnType		:
	 ****************************************/
	public static boolean navigateURL(WebDriver oDriver, String URL)
	{
		try {
			oDriver.navigate().to(URL);
			Thread.sleep(2000);
			
			if(oDriver.getTitle().equalsIgnoreCase("actiTIME - Login")) {
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
	
	
	
	
	/****************************************
	 * Method Name		: loginToApp()
	 * Purpose			: It is used to login to the actiTime application
	 * Author			: tester1
	 * Reviewer Name	: lead1
	 * Modified By		: tester2
	 * Modified Date	:
	 * Arguments		: WebDriver oDriver, String userName, String password
	 * ReturnType		: boolean
	 ****************************************/
	public static boolean loginToApp(WebDriver oDriver, String userName, String password)
	{
		try {
			oDriver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
			oDriver.findElement(By.name("pwd")).sendKeys(password);
			oDriver.findElement(By.xpath("//a[@id='loginButton']")).click();
			Thread.sleep(2000);
			
			String strText = oDriver.findElement(By.xpath("//td[@class='pagetitle']")).getText();
			if(strText.equalsIgnoreCase("Enter Time-Track")) {
				//Handle the shortcut window
				if(oDriver.findElements(By.xpath("//div[@style='display: block;']")).size() > 0)
				{
					oDriver.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
				}
				
				System.out.println("Login to actiTime was successful");
				return true;
			}else {
				System.out.println("Failed to login to actiTime application");
				return false;
			}
		}catch(Exception e)
		{
			System.out.println("Exception in 'loginToApp()' method. " + e);
			return false;
		}
	}
	
	
	
	
	/****************************************
	 * Method Name		: createUser()
	 * Purpose			: It is used to create the new user in actiTime application
	 * Author			: tester1
	 * Reviewer Name	: lead1
	 * Modified By		: tester2
	 * Modified Date	:
	 * Arguments		: WebDriver oDriver
	 * ReturnType		: String
	 ****************************************/
	public static String createUser(WebDriver oDriver)
	{
		String userName = null;
		try {
			oDriver.findElement(By.xpath("//div[text()='USERS']")).click();
			Thread.sleep(2000);
			oDriver.findElement(By.xpath("//div[text()='Add User']")).click();
			Thread.sleep(2000);
			
			if(oDriver.findElement(By.xpath("//span[text()='Add User']")).isDisplayed()) {
				System.out.println("The 'Add User' window has opened successful");
			}else {
				System.out.println("Failed to open the 'Add User' window");
				return null;
			}

			oDriver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("auto");
			oDriver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("user1");
			oDriver.findElement(By.xpath("//input[@name='email']")).sendKeys("auto.user1@sg.com");
			oDriver.findElement(By.xpath("//input[@name='username']")).sendKeys("autouser1");
			oDriver.findElement(By.xpath("//input[@name='password']")).sendKeys("Mercury");
			oDriver.findElement(By.xpath("//input[@name='passwordCopy']")).sendKeys("Mercury");
			oDriver.findElement(By.xpath("//span[text()='Create User']")).click();
			Thread.sleep(2000);
			
			userName = "user1, auto";
			if(oDriver.findElement(By.xpath("//span[text()='"+userName+"']")).isDisplayed()) {
				System.out.println("The new user is created successful");
				return userName;
			}else {
				System.out.println("Failed to create the new user");
				return null;
			}
		}catch(Exception e)
		{
			System.out.println("Exception in 'createUser()' method. " + e);
			return null;
		}
	}
	
	
	
	
	/****************************************
	 * Method Name		: modifyUser()
	 * Purpose			: It is used to modify the specific user in actiTime application
	 * Author			: tester1
	 * Reviewer Name	: lead1
	 * Modified By		: tester2
	 * Modified Date	:
	 * Arguments		: WebDriver oDriver, String existingUserName, String newFN, String newLN
	 * ReturnType		: String
	 ****************************************/
	public static String modifyUser(WebDriver oDriver, String existingUserName, String newFN, String newLN)
	{
		String userName = null;
		try {
			String name[] = existingUserName.split(",");
			String InitialFN = name[1];
			String InitialLN = name[0];
			
			oDriver.findElement(By.xpath("//span[text()='"+existingUserName+"']")).click();
			Thread.sleep(2000);
			WebElement objFN = oDriver.findElement(By.xpath("//input[@name='firstName']"));
			objFN.clear();
			objFN.sendKeys(newFN);
			WebElement objLN = oDriver.findElement(By.xpath("//input[@name='lastName']"));
			objLN.clear();
			objLN.sendKeys(newLN);
			oDriver.findElement(By.xpath("//span[text()='Save Changes']")).click();
			Thread.sleep(2000);
			
			userName = newLN+", "+newFN;
			name = userName.split(",");
			String LaterFN = name[1].trim();
			String LaterLN = name[0];
			
			if((!InitialFN.equals(LaterFN) && !InitialLN.equals(LaterLN)) && (LaterFN.trim().equals(newFN) && LaterLN.equals(newLN)))
			{
				System.out.println("The use rinformation is updated successful");
				return userName;
			}else {
				System.out.println("Failed to update the user information");
				return null;
			}
		}catch(Exception e)
		{
			System.out.println("Exception in 'modifyUser()' method. " + e);
			return null;
		}
	}
	
	
	
	
	/****************************************
	 * Method Name		: deleteUser()
	 * Purpose			: It is used to delete the specific user in actiTime application
	 * Author			: tester1
	 * Reviewer Name	: lead1
	 * Modified By		: tester2
	 * Modified Date	:
	 * Arguments		: WebDriver oDriver, String userToDelete
	 * ReturnType		: boolean
	 ****************************************/
	public static boolean deleteUser(WebDriver oDriver, String userToDelete)
	{
		try {
			oDriver.findElement(By.xpath("//span[text()='"+userToDelete+"']")).click();
			Thread.sleep(2000);
			oDriver.findElement(By.id("userDataLightBox_deleteBtn")).click();
			Thread.sleep(2000);
			oDriver.switchTo().alert().accept();
			Thread.sleep(2000);
			
			if(oDriver.findElements(By.xpath("//div[@class='name']/span[text()='"+userToDelete+"']")).size() > 0) {
				System.out.println("Failed to delete the user");
				return false;
			}else {
				System.out.println("User have been deleted successful");
				return true;
			}
		}catch(Exception e)
		{
			System.out.println("Exception in 'deleteUser()' method. " + e);
			return false;
		}
	}
	
	
	
	
	/****************************************
	 * Method Name		: logoutFromApp()
	 * Purpose			: It is used to logout from the actiTime application
	 * Author			: tester1
	 * Reviewer Name	: lead1
	 * Modified By		: tester2
	 * Modified Date	:
	 * Arguments		: WebDriver oDriver, String userToDelete
	 * ReturnType		: boolean
	 ****************************************/
	public static boolean logoutFromApp(WebDriver oDriver)
	{
		try {
			oDriver.findElement(By.xpath("//a[@id='logoutLink']")).click();
			Thread.sleep(2000);
			
			if(oDriver.findElement(By.id("headerContainer")).getText().equalsIgnoreCase("Please identify yourself"))
			{
				System.out.println("Logout from actiTime was successful");
				return true;
			}else {
				System.out.println("Failed to logout from the actiTime application");
				return false;
			}
		}catch(Exception e)
		{
			System.out.println("Exception in 'logoutFromApp()' method. " + e);
			return false;
		}
	}
	
	
	
	/****************************************
	 * Method Name		: closeBrowser()
	 * Purpose			: It is used to close the browser
	 * Author			: tester1
	 * Reviewer Name	: lead1
	 * Modified By		: tester2
	 * Modified Date	:
	 * Arguments		: WebDriver oDriver
	 * ReturnType		: boolean
	 ****************************************/
	public static boolean closeBrowser(WebDriver oDriver)
	{
		try {
			oDriver.close();
			oDriver = null;
			return true;
		}catch(Exception e)
		{
			System.out.println("Exception in 'closeBrowser()' method. " + e);
			return false;
		}
	}
}
