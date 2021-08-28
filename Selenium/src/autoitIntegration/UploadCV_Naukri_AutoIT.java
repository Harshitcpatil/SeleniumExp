package autoitIntegration;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadCV_Naukri_AutoIT {
	public static void main(String[] args) {
		ChromeDriver ch = null;
		String filePath = null;
		try {
			//1. Open the browser and navigate to https://www.naukri.com/
			System.setProperty("webdriver.chrome.driver", ".\\Library\\drivers\\chromedriver.exe");
			ch = new ChromeDriver();
			ch.manage().window().maximize();
			ch.navigate().to("https://www.naukri.com/");
			Thread.sleep(4000);
			
			
			//2. Handle OR close the child windows if exist & verify child windows are closed.
			String sParent = ch.getWindowHandle();
			Set<String> objChild = ch.getWindowHandles();
			int initialCount = objChild.size();
			
			boolean blnFlag = false;
			if(objChild.size() > 1) {
				System.out.println("Child windows exist");
				blnFlag = true;
				for(String childWnd : objChild)
				{
					if(!childWnd.equals(sParent)) {
						ch.switchTo().window(childWnd);
						Thread.sleep(2000);
						ch.close();
					}
				}
			}else {
				System.out.println("No child window appeared");
			}
			
			if(blnFlag) {
				objChild = ch.getWindowHandles();
				int laterCount = objChild.size();
				
				if((initialCount - laterCount) == 1) {
					System.out.println("Closed all the child windows except main window");
				}
			}
			
			ch.switchTo().window(sParent);
			
			
			//3. Click on "Upload CV" button. This will open the upload window.
			ch.findElement(By.xpath("//label[@id='wdgt-file-upload']")).click();
			Thread.sleep(3000);
			
			
			//4. Write autoIT script to handle the naukri upload window.
			filePath = "C:\\temp\\EveningBatch\\AutoITScripts\\UploadCV_Chrome.exe";
			Runtime.getRuntime().exec(filePath);
			
			Thread.sleep(10000);
			
			
			//5. Verify The upload confirmation message is displayed successful
			String strMessage = ch.findElement(By.xpath("//span[@class='upload-cv-success-msg']")).getText();
			System.out.println(strMessage);
			
			if(strMessage.contains("uploaded Successfully")) System.out.println("The CV uploaded successful");
			else System.out.println("Failed to upload the CV in naukri");
			
			ch.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			ch = null;
		}
	}
}
