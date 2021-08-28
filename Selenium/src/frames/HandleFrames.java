package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {
	public static void main(String[] args) {
		ChromeDriver ch = null;
		try {
			//1. Open browser and navigate to this URL 
			//(https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html)
			
			System.setProperty("webdriver.chrome.driver", 
					System.getProperty("user.dir")+"\\Library\\drivers\\chromedriver.exe");
			ch = new ChromeDriver();
			ch.manage().window().maximize();
			ch.navigate().to("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
			Thread.sleep(2000);
			
			
			//2. Switch to frame one using frame index
			// Note: in selenium the frame index starts from zero
			ch.switchTo().frame(0);
			
			
			//3. click on 'org.openqa.selenium' package link
			ch.findElement(By.linkText("org.openqa.selenium")).click();
			Thread.sleep(2000);
			
			
			//4. come back to main page
			ch.switchTo().defaultContent();
			
			
			
			//5. Switch to frame two using frame name
			ch.switchTo().frame("packageFrame");
			
			
			
			//6. click on 'WebDriver' link in the second frame
			ch.findElement(By.xpath("//span[text()='WebDriver']")).click();
			Thread.sleep(2000);
			
			
			//7. come back to main page
			ch.switchTo().defaultContent();
			
			
			
			//8. Switch to frame three using frame webelement
			//Notes: WebElement is a interface in selenium. The WebElement is returned by a 
			//method viz., .findElement() method.
			WebElement oFrame = ch.findElement(By.xpath("//iframe[@class='rightIframe']"));
			ch.switchTo().frame(oFrame);
			
			
			//9. read the header in the third frame
			String strHeader = ch.findElement(By.xpath("//h2")).getText();
			System.out.println(strHeader);
			
			if(strHeader.equalsIgnoreCase("Interface WebDriver")) {
				System.out.println("Header is correct");
			}else {
				System.out.println("Incorrect Header name");
			}
			
			
			
			//10. come back to main page
			ch.switchTo().defaultContent();
			
			
			
			//11. Close the main browser			
			ch.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			ch = null;
		}
	}
}