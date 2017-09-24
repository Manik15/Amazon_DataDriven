package com.amazon_DDT;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtitity {
	
	
	public static void waitForElementToBeVisible(WebDriver driver, WebElement we) 
	{
		WebDriverWait wd = new WebDriverWait(driver, 10);
		wd.until(ExpectedConditions.visibilityOf(we));
	}
	
	public static void waitForElementToBeClickable(WebDriver driver, WebElement we) 
	{
		WebDriverWait wd = new WebDriverWait(driver, 10);
		wd.until(ExpectedConditions.elementToBeClickable(we));
	}
	
	public static void clickByJavaScriptExecutor(WebDriver driver1,WebElement element) 
	{
	JavascriptExecutor js = (JavascriptExecutor) driver1;
	js.executeScript("arguments[0].click();", element);

	}
	
	public static void windowHandle(WebDriver driver2)
	{
		Set<String> ids= driver2.getWindowHandles();
		Iterator<String>ITE=ids.iterator();
		
		String ParentID= ITE.next();
		 String ChildID= ITE.next();
		
		driver2.switchTo().window(ChildID);
		
	}
}
