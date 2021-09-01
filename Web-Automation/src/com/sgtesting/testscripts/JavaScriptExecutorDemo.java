package com.sgtesting.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {

	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		displayTitle();
		getURL();
		displayLinksCount();
 // 	enterTextInTextField();
 //		enterTextInTextField1();
 //		clickOnButton1();
 //		clickOnButton2();
//		clickOnCheckBox1();
//		clickOnCheckBox2();
//		clickOnRadioButton1();
//		clickOnRadioButton2();
		selectItemFromDropDown();
	}
	
	static void launchBrowser()
	{
		String path=null;
		try
		{
			path=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path+"\\Library\\drivers\\chromedriver.exe");
			System.out.println(path);
			oBrowser=new ChromeDriver();
			oBrowser.manage().window().maximize();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void navigate()
	{
		try
		{
			oBrowser.get("file:///H:/HTML/Sample.html");
			Thread.sleep(4000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void displayTitle()
	{
		JavascriptExecutor js= (JavascriptExecutor) oBrowser;
		String title=(String) js.executeScript("var kk=document.title; return kk;");
		System.out.println("the Title of Application :"+title);
	}
	
	static void getURL()
	{
		JavascriptExecutor js= (JavascriptExecutor) oBrowser;
		String url=(String) js.executeScript("var kk=document.URL; return kk;");
		System.out.println("The url of Application :"+url);
	}
	
	static void displayLinksCount()
	{
		JavascriptExecutor js= (JavascriptExecutor) oBrowser;
		long linkscount=(long) js.executeScript("var lc=document.getElementsByTagName('A'); return lc.length;");
		System.out.println("Links Count :"+linkscount);
	}
	
	static void enterTextInTextField()
	{
		JavascriptExecutor js= (JavascriptExecutor) oBrowser;
		js.executeScript("document.getElementById('pwd1pass1word1').value='DemoUser123'");
	}
	
	static void enterTextInTextField1()
	{
		WebElement oEle=oBrowser.findElement(By.id("pwd1pass1word1"));
		JavascriptExecutor js= (JavascriptExecutor) oBrowser;
		js.executeScript("arguments[0].value='DemoUser123'",oEle);
	}
	
	static void clickOnButton1()
	{
		JavascriptExecutor js= (JavascriptExecutor) oBrowser;
		js.executeScript("document.getElementById('btn1submit1button1').click();");
	}

	static void clickOnButton2()
	{
		WebElement oEle=oBrowser.findElement(By.name("submit1btn1"));
		JavascriptExecutor js= (JavascriptExecutor) oBrowser;
		js.executeScript("arguments[0].click();",oEle);
	}
	
	static void clickOnCheckBox1()
	{
		JavascriptExecutor js= (JavascriptExecutor) oBrowser;
		js.executeScript("document.getElementById('chk1windows').click();");
	}
	
	static void clickOnCheckBox2()
	{
		WebElement oEle=oBrowser.findElement(By.name("windows"));
		JavascriptExecutor js= (JavascriptExecutor) oBrowser;
		js.executeScript("arguments[0].click();",oEle);
	}
	
	static void clickOnRadioButton1()
	{
		JavascriptExecutor js= (JavascriptExecutor) oBrowser;
		js.executeScript("document.getElementById('rad2firefox').click();");
	}
	
	static void clickOnRadioButton2()
	{
		WebElement oEle=oBrowser.findElement(By.xpath("//input[@name='firefox']"));
		JavascriptExecutor js= (JavascriptExecutor) oBrowser;
		js.executeScript("arguments[0].click();",oEle);
	}
	
	static void selectItemFromDropDown()
	{
		JavascriptExecutor js= (JavascriptExecutor) oBrowser;
		String str="var kk=document.getElementById('tools');";
		str+="for(var i=0;i<kk.length;i++)  {";
		str+="if(kk.options[i].text='Selenium WebDriver'){";
		str+="kk.options[i].selected='1';";
		str+="}";
		str+="}";
		
		js.executeScript(str);
	}
}
