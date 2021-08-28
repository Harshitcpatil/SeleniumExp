package scriptingTwo;

import org.openqa.selenium.WebDriver;

public class ScriptingTwo extends ReusebleMethods{
	public static void main(String[] args) {
		WebDriver oBrowser = null;
		String strStatus = null;
		String userName = null;
		try {
			oBrowser = luanchBrowser("Chrome");
			strStatus+= navigateURL(oBrowser, "http://localhost/login.do");
			strStatus+= loginToApp(oBrowser, "admin", "manager");
			userName = createUser(oBrowser);
			userName = modifyUser(oBrowser, userName, "test", "account1");
			strStatus+= deleteUser(oBrowser, userName);
			strStatus+= logoutFromApp(oBrowser);
			strStatus+= closeBrowser(oBrowser);
			
			if(strStatus.contains("false")) {
				System.out.println("The test script was failed");
			}else {
				System.out.println("The test script was passed");
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
