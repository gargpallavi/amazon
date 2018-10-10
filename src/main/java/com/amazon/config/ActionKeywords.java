/**
 * 
 */
package com.amazon.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testscripts.TC01;

/**
 * @author Minaxi
 *
 */
public class ActionKeywords {
	
	public static WebDriver driver;
	TC01 obj1= new TC01();
	public void TC01(String object)
	{
		obj1.openBrowser(object);
	
	}
	
	public void search(String object) throws InterruptedException
	{
		/*WebElement searchEle = driver.findElement(By.id("twotabsearchtextbox"));
		Thread.sleep(1000);
		searchEle.sendKeys("Shoes");
		//driver.quit();
		 */
		obj1.search(object);
	}

}
