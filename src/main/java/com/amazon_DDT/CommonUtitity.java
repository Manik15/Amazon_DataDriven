package com.amazon_DDT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtitity {
	public static void waitForElementToBeVisible(WebDriver driver, WebElement we) {
		WebDriverWait wd = new WebDriverWait(driver, 10);
		wd.until(ExpectedConditions.visibilityOf(we));
	}
}
