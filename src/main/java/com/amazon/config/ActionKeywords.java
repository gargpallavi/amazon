/**
 * 
 */
package com.amazon.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

/**
 * @author Minaxi
 *
 */
public class ActionKeywords {
	public static WebDriver driver;
	/*@FindBy(id="twotabsearchtextbox")
	WebElement searchEle;*/
	public static void openBrowser(String object)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\StudyMaterial\\DevOps\\Slelenium\\Data_Driven_Framework\\amazon\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(Constants.URL);
		driver.quit();
	}
	
	/*public void search()
	{
		WebElement searchEle = driver.findElement(By.id("twotabsearchtextbox"));
		searchEle.sendKeys("Shoes");
	}*/

}
