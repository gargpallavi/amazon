/**
 * 
 */
package com.amazon.executionEngine;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.commons.collections4.functors.ExceptionClosure;

import com.amazon.config.ActionKeywords;
import com.amazon.config.Constants;
import com.excel.utility.ExcelUtils;

/**
 * @author Minaxi
 *
 */
public class DriverScript {

	/**
	 * @param args
	 */
	public static Properties OR;
	public static Method method[];
	public static int iTestStep;
	public static int iTestLastStep;
	public static String testCaseID;
	public static String runMode;
	public static ActionKeywords akObj;
	public static String sActionKeyword;
	public static String sPageObject;
	
	public DriverScript()
	{
		akObj = new ActionKeywords();
		method = akObj.getClass().getMethods();
	}
	
		
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ExcelUtils.setExcelFile(Constants.TEST_DATA_PATH);
		DriverScript startEngine = new DriverScript();
		startEngine.execute_Test_Case();

	}

	private void execute_Test_Case() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int iTotalTestCases = ExcelUtils.getRowCount(Constants.SHEET_TESTCASES);
		for(int iTestCase = 1;iTestCase<=iTotalTestCases;iTestCase++)
		{
			testCaseID = ExcelUtils.getCellData(iTestCase, Constants.COL_TEST_CASE_ID, Constants.SHEET_TESTCASES);
			runMode = ExcelUtils.getCellData(iTestCase, Constants.COL_RUN_MODE, Constants.SHEET_TESTCASES);
			if(runMode.equals("Y"))
			{
				//iTestStep = ExcelUtils.getRowContains(testCaseID,Constants.COL_TEST_CASE_ID,Constants.SHEET_TESTSTEPS);
				iTestLastStep = ExcelUtils.getTestStepsCount(Constants.SHEET_TESTSTEPS, testCaseID);
				System.out.println(iTestLastStep);
				for(;iTestCase<=iTestLastStep;iTestCase++)
				{
					sActionKeyword = ExcelUtils.getCellData(iTestCase, Constants.COL_ActionKeyword, Constants.SHEET_TESTCASES);
					sPageObject = ExcelUtils.getCellData(iTestCase, Constants.COL_TEST_CASE_ID, Constants.SHEET_TESTCASES);
					execute_Acions();
				}
			}
		}
	}

	private void execute_Acions() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for(int i=0;i<method.length;i++)
		{
			System.out.println(method.length + "    "+ method[i]);
			if(method[i].getName().equals(sActionKeyword))
			{
				System.out.println("method[i] "+method[i]+" s "+sPageObject + "value of i is "+i);
				method[i].invoke(akObj, sPageObject);
				
			}
		}
		// TODO Auto-generated method stub
		
	}

}
