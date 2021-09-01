package sg.actitime.project02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Projects extends Initialize {
	
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
	public static void createProject(WebDriver oBrowser)
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\"topnav\"]/tbody/tr[1]/td[3]/a")).click();
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("//*[@id=\"cpTreeBlock\"]/div[2]/div[1]/div[2]/div/div[2]")).click();
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("/html/body/div[14]/div[2]")).click();
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("//*[@id=\"projectPopup_projectNameField\"]")).sendKeys("demo c1");
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("//*[@id=\"projectPopup_newCustomerNameField\"]")).sendKeys("Harshit");
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("//*[@id=\"projectPopup_commitBtn\"]/div/span")).click();
			Thread.sleep(3000);
			
			Thread.sleep(3000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param args
	 * Created By:
	 * Created Date:
	 * Modified By:
	 * Reviewed By:
	 * 
	 * Return Value:
	 * Parameters:
	 * Description:
	 */
	public static void modifyProject(WebDriver oBrowser)
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\"cpTreeBlock\"]/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div[3]")).click();
			Thread.sleep(3000);
			
			oBrowser.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[4]/div[2]/div[1]/div[1]/div[1]/div/div[1]/div[3]/div/div[1]")).click();
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("//div[text()='Archived']")).click();
			Thread.sleep(3000);
			
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
	public static void deleteProject(WebDriver oBrowser)
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[4]/div[1]/div[2]/div[3]/div/div/div[2]")).click();
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[4]/div[4]/div/div[3]/div")).click();
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("//*[@id=\"projectPanel_deleteConfirm_submitTitle\"]")).click();
			Thread.sleep(3000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
