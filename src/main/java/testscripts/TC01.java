/**
 * 
 */
package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.config.Constants;
import com.excel.utility.ExcelUtils;

/**
 * @author Minaxi
 *
 */
public class TC01 {
	public static WebDriver driver;
	private String sTestCaseName;

	@Test
	public void openBrowser(String object)
	{
		System.out.println("inside open browser");
		System.setProperty("webdriver.chrome.driver", "D:\\StudyMaterial\\DevOps\\Slelenium\\Data_Driven_Framework\\amazon\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(Constants.URL);
	}
	@Test(dataProvider = "getTestData")
	public void search(String search)
	{
		System.out.println("inside search");
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys(search);
	}
	 @DataProvider
	 public String getTestData() throws Exception{
		    // Setting up the Test Data Excel file
	ExcelUtils.setExcelFile("D:\\StudyMaterial\\DevOps\\Slelenium\\Data_Driven_Framework\\amazon\\src\\test\\resources\\DataEngine.xlsx");
	System.out.println("inside data provider");
	String testObjArray = ExcelUtils.getCellData(1, 1, "Sheet1");
	System.out.println("value returned "+testObjArray);
	return testObjArray;

	 }
}
