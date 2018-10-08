 /**
 * 
 */
package com.excel.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.amazon.config.Constants;

/**
 * @author Minaxi
 *
 */
public class ExcelUtils {
	private static XSSFSheet ExcelWorkSheet;
	private static XSSFWorkbook ExcelWorkBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	//this method is to set file path and to open excel file
	public static void setExcelFile(String path)
	{
		try {
			FileInputStream ExcelFile=new FileInputStream(path);
			ExcelWorkBook = new XSSFWorkbook(ExcelFile);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	//To read Test Data from excel cell
	public static String getCellData(int rowNum,int columnNum, String sheetName)
	{
		ExcelWorkSheet = ExcelWorkBook.getSheet(sheetName);
		Cell = ExcelWorkSheet.getRow(rowNum).getCell(columnNum);
		String cellData = Cell.getStringCellValue();
		return cellData;
	}
	//to find out total number of rows
	public static int getRowCount(String sheetName)
	{
		ExcelWorkSheet = ExcelWorkBook.getSheet(sheetName);
		int number = ExcelWorkSheet.getLastRowNum();
		return number;
	}
	/*this method is to get the row number of test case 
	and takes 3 arguments(testcasename, columnNumber nad sheetName)*/
	
	public static int getRowContains(String testCaseName, int colNumber, String sheetName)
	{
		int i;
		ExcelWorkSheet = ExcelWorkBook.getSheet(sheetName);
		int rowCount = ExcelUtils.getRowCount(sheetName);
		for(i=0;i<rowCount;i++)
		{
			if(ExcelUtils.getCellData(i, colNumber, sheetName).equalsIgnoreCase(testCaseName))
			{
				break;
			}
		}
		return i;
	}
	//this method is to get the count of the test steps
	public static int getTestStepsCount(String sheetName,String testCaseID)
	{
		System.out.println("sheet name is" +sheetName);
		for(int i=1;i<=ExcelUtils.getRowCount(sheetName);i++)
		{
			if(!testCaseID.equals(ExcelUtils.getCellData(i, Constants.COL_TEST_CASE_ID, sheetName)))
			{
				return i;
			}
		}
		ExcelWorkSheet = ExcelWorkBook.getSheet(sheetName);
		return ExcelWorkSheet.getLastRowNum()+1;
	}
}
