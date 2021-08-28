package robotClass;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadCV_RobotClass {
	public static void main(String[] args) {
		ChromeDriver ch = null;
		Robot robot = null;
		try {
			System.setProperty("webdriver.chrome.driver", ".\\Library\\drivers\\chromedriver.exe");
			ch = new ChromeDriver();
			ch.manage().window().maximize();
			ch.navigate().to("https://www.naukri.com/");
			Thread.sleep(2000);
			
			//Click on the 'Upload CV' button
			ch.findElement(By.xpath("//label[@id='wdgt-file-upload']")).click();
			Thread.sleep(4000);
			
			
			//Use robot class to handle the upload window
			robot = new Robot();
			
			
			//Create a file path which has to be copied & copy the file path to ClipBoard Object
			StringSelection path = new StringSelection("C:\\temp\\EveningBatch\\My_CV.docx");
			Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
			clip.setContents(path, null);
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
			Thread.sleep(2000);
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			Thread.sleep(10000);
			
			String strText = ch.findElement(By.xpath("//span[@class='upload-cv-success-msg']")).getText();
			
			if(strText.contains("uploaded Successfully")) System.out.println("CV uploaded successful");
			else System.out.println("Failed to upload the CV");
			Thread.sleep(2000);
			
			ch.quit();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			ch = null;
			robot = null;
		}
	}
}
