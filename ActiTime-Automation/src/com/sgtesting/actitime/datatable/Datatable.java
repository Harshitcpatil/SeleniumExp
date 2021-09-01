package com.sgtesting.actitime.datatable;

import java.io.FileInputStream;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datatable {
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
	public int rowCount(String fileName,String sheetName)
	{
		FileInputStream fin=null;
		Workbook wb=null;
		Sheet sh=null;
		int rc=0;
		try
		{
			fin=new FileInputStream(fileName);
			wb=new XSSFWorkbook(fin);
			sh=wb.getSheet(sheetName);
			if(sh==null)
			{
				return -1;
			}
			rc=sh.getPhysicalNumberOfRows();

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fin.close();
				wb.close();
				wb=null;
				sh=null;
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return rc-1;
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
	public String getCellData(String fileName,String sheetName,String columnName,int rownum)
	{
		FileInputStream fin=null;
		Workbook wb=null;
		Sheet sh=null;
		Row row=null;
		Cell cell=null;
		String strCellData=null;
		int colNum=0;
		try
		{
			fin=new FileInputStream(fileName);
			wb=new XSSFWorkbook(fin);
			sh=wb.getSheet(sheetName);
			if(sh==null)
			{
				strCellData=null;
			}
			row=sh.getRow(0);
			for(int c=0;c<row.getPhysicalNumberOfCells();c++)
			{
				cell=row.getCell(c);
				String colName=cell.getStringCellValue();
				if(columnName.trim().equalsIgnoreCase(colName.trim()))
				{
					colNum=c;
					break;
				}
			}
			row=sh.getRow(rownum-1);
			cell=row.getCell(colNum);
			if(cell==null||cell.getCellType()==CellType.BLANK)
			{
				strCellData="";
			}
			else if(cell.getCellType()==CellType.STRING)
			{
				strCellData=cell.getStringCellValue();
			}
			else if(cell.getCellType()==CellType.BOOLEAN)
			{
				strCellData=String.valueOf(cell.getBooleanCellValue());
			}
			else if(cell.getCellType()==CellType.FORMULA ||cell.getCellType()==CellType.NUMERIC)
			{
				if (DateUtil.isCellDateFormatted(cell))
				{
					double d=cell.getNumericCellValue();
					Calendar cal=Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					int month=cal.get(Calendar.MONTH)+1;
					int day=cal.get(Calendar.DAY_OF_MONTH);
					int year=cal.get(Calendar.YEAR);
					String sDate=month+"/"+day+"/"+year;
					strCellData=sDate;
				}
				else
				{
					strCellData=String.valueOf(cell.getNumericCellValue());
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fin.close();
				wb.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return strCellData;
	}
	/*public static void main(String[] args) {
		Datatable obj=new Datatable();
		String Filename="H:\\AUTOMATION\\WorkSpaceSelenium\\ActiTime-Automation\\Controller\\data_Controller.xlsx";
		int num=obj.rowCount(Filename, "Scenarios");
		System.out.println("# of Rows :"+num);
		
		String data=obj.getCellData(Filename, "Scenarios","Description",4);
		System.out.println(data);

	}*/

}
