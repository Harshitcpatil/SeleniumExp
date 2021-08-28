package scriptingOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScriptingOne {
	public static void main(String[] args) {
		ChromeDriver ch = null;
		try {
			//1. Open browser and navigate the URL.
			//Verify the login page has opened successful
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium Automation\\Automation\\Selenium\\Library\\Driver\\chromedriver.exe");
			ch = new ChromeDriver();
			ch.manage().window().maximize();
			ch.navigate().to("http://localhost/login.do");
			Thread.sleep(2000);
			
			if(ch.getTitle().equalsIgnoreCase("actiTIME - Login")) {
				System.out.println("The browser has opened and the URL is navigated successful");
			}else {
				System.out.println("Failed to open the browser and navigate to the URL");
				return;
			}
			
			
			//2. Enter the UN, PWD and click on Login button
			//Verify login is successful and Home page is displayed
			ch.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
			ch.findElement(By.name("pwd")).sendKeys("manager");
			ch.findElement(By.xpath("//a[@id='loginButton']")).click();
			Thread.sleep(2000);
			
			String strText = ch.findElement(By.xpath("//td[@class='pagetitle']")).getText();
			if(strText.equalsIgnoreCase("Enter Time-Track")) {
				System.out.println("Login to actiTime was successful");
				
				//Handle the shortcut window
				if(ch.findElements(By.xpath("//div[@style='display: block;']")).size() > 0)
				{
					ch.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
				}
			}else {
				System.out.println("Failed to login to actiTime application");
				return;
			}
			
			
			
			//3. go to user menu & click on add User button
			//Verify add User page should open
			ch.findElement(By.xpath("//div[text()='USERS']")).click();
			Thread.sleep(2000);
			ch.findElement(By.xpath("//div[text()='Add User']")).click();
			Thread.sleep(2000);
			
			if(ch.findElement(By.xpath("//span[text()='Add User']")).isDisplayed()) {
				System.out.println("The 'Add User' window has opened successful");
			}else {
				System.out.println("Failed to open the 'Add User' window");
				return;
			}
			
			
			
			//4. Enter all the required details for user creation & click on  CreateUser button
			//Verify the new user is created successful
			ch.findElement(By.xpath("//input[@name='firstName']")).sendKeys("auto");
			ch.findElement(By.xpath("//input[@name='lastName']")).sendKeys("user1");
			ch.findElement(By.xpath("//input[@name='email']")).sendKeys("auto.user1@sg.com");
			ch.findElement(By.xpath("//input[@name='username']")).sendKeys("autouser1");
			ch.findElement(By.xpath("//input[@name='password']")).sendKeys("Mercury");
			ch.findElement(By.xpath("//input[@name='passwordCopy']")).sendKeys("Mercury");
			ch.findElement(By.xpath("//span[text()='Create User']")).click();
			Thread.sleep(2000);
			
			if(ch.findElement(By.xpath("//span[text()='user1, auto']")).isDisplayed()) {
				System.out.println("The new user is created successful");
			}else {
				System.out.println("Failed to create the new user");
				return;
			}
			
			
			
			//5. Select the newly created user & modify the FN & LN & save it.
			//Verify the FN & LN got modified successful
			String userName = ch.findElement(By.xpath("//span[text()='user1, auto']")).getText();
			String name[] = userName.split(",");
			String InitialFN = name[1];
			String InitialLN = name[0];
			
			ch.findElement(By.xpath("//span[text()='user1, auto']")).click();
			Thread.sleep(2000);
			WebElement objFN = ch.findElement(By.xpath("//input[@name='firstName']"));
			objFN.clear();
			objFN.sendKeys("demo");
			WebElement objLN = ch.findElement(By.xpath("//input[@name='lastName']"));
			objLN.clear();
			objLN.sendKeys("user01");
			ch.findElement(By.xpath("//span[text()='Save Changes']")).click();
			Thread.sleep(2000);
			
			userName = ch.findElement(By.xpath("//span[text()='user01, demo']")).getText();
			name = userName.split(",");
			String LaterFN = name[1];
			String LaterLN = name[0];
			
			if((!InitialFN.equals(LaterFN) && !InitialLN.equals(LaterLN)) && (LaterFN.trim().equals("demo") && LaterLN.equals("user01")))
			{
				System.out.println("The use rinformation is updated successful");
			}else {
				System.out.println("Failed to update the user information");
				return;
			}
			
			
			
			//6. Select the user & delete it.
			//Verify user deleted successful
			ch.findElement(By.xpath("//span[text()='user01, demo']")).click();
			Thread.sleep(2000);
			ch.findElement(By.id("userDataLightBox_deleteBtn")).click();
			Thread.sleep(2000);
			ch.switchTo().alert().accept();
			Thread.sleep(2000);
			
			if(ch.findElements(By.xpath("//div[@class='name']/span[text()='user01, demo']")).size() > 0) {
				System.out.println("Failed to delete the user");
				return;
			}else {
				System.out.println("User have been deleted successful");
			}
			
			
			
			//7. Logout from actiTime
			//Verify logout is successful
			ch.findElement(By.xpath("//a[@id='logoutLink']")).click();
			Thread.sleep(2000);
			
			if(ch.findElement(By.id("headerContainer")).getText().equalsIgnoreCase("Please identify yourself"))
			{
				System.out.println("Logout from actiTime was successful");
			}else {
				System.out.println("Failed to logout from the actiTime application");
			}
						
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			//8. Close the browser
			ch.close();
			ch = null;
		}
	}
}
