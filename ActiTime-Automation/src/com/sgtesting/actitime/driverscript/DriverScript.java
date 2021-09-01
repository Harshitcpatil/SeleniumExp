package com.sgtesting.actitime.driverscript;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;

import com.sgtesting.actitime.datatable.Datatable;
import com.sgtesting.actitime.tests.Initialize;

public class DriverScript {
	public static WebDriver oBrowser=null;
	public static String strPath=null;
	public static String strControllerFileName=null;
	public static Datatable datatable=null;
	public static String strTestScriptExcelFile=null;
	public static void main(String[] args) {
		
		try
		{
			strPath=System.getProperty("user.dir");
			System.out.println(strPath);
			strControllerFileName=strPath+"\\Controller\\data_Controller.xlsx";
			datatable=new Datatable();
			int rcControllerFile=datatable.rowCount(strControllerFileName, "Scenarios");
			System.out.println("# of Rows in Controller :"+rcControllerFile);
			for(int tcid=0;tcid<rcControllerFile;tcid++)
			{
				String testcaseid=datatable.getCellData(strControllerFileName, "Scenarios", "TestcaseID", tcid+2);
				String testcasename=datatable.getCellData(strControllerFileName, "Scenarios", "TestcaseName", tcid+2);
				String testcasedescription=datatable.getCellData(strControllerFileName, "Scenarios", "Description", tcid+2);
				String runstatus=datatable.getCellData(strControllerFileName, "Scenarios", "RunStatus", tcid+2);
				System.out.println("testcaseid  :"+testcaseid);
				System.out.println("testcasename  :"+testcasename);
				System.out.println("testcasedescription  :"+testcasedescription);
				System.out.println("runstatus  :"+runstatus);
				if(runstatus.equalsIgnoreCase("yes"))
				{
					oBrowser=Initialize.launchBrowser();
					
					Class driverParam[]=new Class[1];
					driverParam[0]=WebDriver.class;
					
					strTestScriptExcelFile=strPath+"\\TestScriptDataFiles\\"+testcasename+".xlsx";
					int rcTestScriptExcel=datatable.rowCount(strTestScriptExcelFile, testcaseid);
					for(int tsid=0;tsid<rcTestScriptExcel;tsid++)
					{
						String testscriptid=datatable.getCellData(strTestScriptExcelFile, testcaseid,"TestScriptID",tsid+2);
						String testdescription=datatable.getCellData(strTestScriptExcelFile, testcaseid,"Description",tsid+2);
						String testmethod=datatable.getCellData(strTestScriptExcelFile, testcaseid,"MethodName",tsid+2);
						String testpkgclassname=datatable.getCellData(strTestScriptExcelFile, testcaseid,"PackageClassName",tsid+2);
						System.out.println("testscriptid  :"+testscriptid);
						System.out.println("testdescription  :"+testdescription);
						System.out.println("testmethod  :"+testmethod);
						System.out.println("testpkgclassname  :"+testpkgclassname);
						
						Class classObject=Class.forName(testpkgclassname);
						Object obj=classObject.newInstance();
						
						Method method=obj.getClass().getMethod(testmethod, driverParam);
						method.invoke(obj, oBrowser);
					}
					System.out.println("++++++++++++++++++++++++++++++++++++");
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
