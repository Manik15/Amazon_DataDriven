package com.amazon_DDT;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Amazon_HomePage_CSS {

	
	public WebDriver driver;
	public Map<String, String>map;
	
	public Amazon_HomePage_CSS(WebDriver driver, Map<String, String>map)
	{
		
		this.driver= driver;
		this.map=map;
		PageFactory.initElements(driver, this);
			
	}
	
	public void selectLocation (String loc) throws InterruptedException
	{
		
		//WebElement we= driver.findElement(By.cssSelector(selector))
		
		List<WebElement> listOfCountries= driver.findElements(By.cssSelector("div[class='navFooterLine navFooterLinkLine navFooterPadItemLine ']>ul>li"));
		System.out.println(listOfCountries.size());
		System.out.println(loc);
		
		for(int i=0; i<listOfCountries.size();i++)
		{
			if(listOfCountries.get(i).getText().contains(loc))
			{
				
				System.out.println(listOfCountries.get(i).getText());
				
				WebElement we= listOfCountries.get(i);
				
				CommonUtitity.waitForElementToBeClickable(driver, we);
				CommonUtitity.clickByActionMethod(driver, we);
			
			}
			
		}
		
	}
	
	
	
	
	
}