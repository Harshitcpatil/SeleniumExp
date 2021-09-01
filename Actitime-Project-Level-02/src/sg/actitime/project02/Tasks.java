package sg.actitime.project02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Tasks  {
	
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
	public static void createTasks(WebDriver oBrowser)
	{
		try
		{   oBrowser.findElement(By.xpath("//*[@id=\"topnav\"]/tbody/tr[1]/td[3]/a")).click();
		    Thread.sleep(3000);
			oBrowser.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[1]/div[1]/div[3]/div/div[2]")).click();
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("/html/body/div[13]/div[1]")).click();
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("//*[@id=\"createTasksPopup_newCustomer\"]")).sendKeys("demo c1");
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("//*[@id=\"createTasksPopup_newProject\"]")).sendKeys("Q1");
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("//*[@id=\"createTasksPopup_createTasksTableContainer\"]/table/tbody/tr[1]/td[1]/input")).sendKeys("Q2");
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("//*[@id=\"createTasksPopup_commitBtn\"]/div/span")).click();
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
	public static void modifyTasks(WebDriver oBrowser)
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\"cpTreeBlock\"]/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div[3]")).click();
			Thread.sleep(3000);
			
			oBrowser.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[4]/div[2]/div[1]/div[1]/div[1]/div/div[1]/div[3]/div/div[1]")).click();
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("//div[text()='Archived']")).click();
			Alert oAlert=oBrowser.switchTo().alert();
			String content=oAlert.getText();
			System.out.println(content);
			oAlert.accept();
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
	public static void deleteTasks(WebDriver oBrowser)
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
