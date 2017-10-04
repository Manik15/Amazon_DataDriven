package com.amazon_DDT;



import java.awt.RenderingHints.Key;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Amazon_Homepage {

	public static WebDriver driver;
	
	public Amazon_Homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@data-nav-ref='nav_ya_signin']")
	static
	WebElement hover;
	
	@FindBy(xpath="(//a[contains(@href,'amazon.in/ap/register')])[1]")
	static
	WebElement createUser;
	
	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']/a/span[@class='nav-action-inner']")
	static
	WebElement signIn;
	
	@FindBy(xpath="//input[@type='email']")
	static
	WebElement emailID;
	
	@FindBy(xpath="//input[@type='password']")
	static
	WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	static
	WebElement submit;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	static
	WebElement searchItem;
	
	@FindBy(xpath="//div[@id='nav-xshop-container']")
	static
	WebElement visiblityOfItem;
	
	@FindBy(xpath="//div[@data-keyword='noise beanie cap for men']")
	static
	WebElement itemClickable;
	
	@FindBy(xpath="//input[@id='buy-now-button']")
	static
	WebElement buyNow;
	
	@FindBy(xpath="//select[@id='quantity']")
	static
	WebElement selectQuantity;
	
	@FindBy(xpath="//div[@id='contextualIngressPtLabel_deliveryShortLine']")
	static
	WebElement clickAddress;
	
	@FindBy(xpath="(//input[@class='a-button-input' and @id='GLUXConfirmClose'])[1]")
	static
	WebElement addClose;
	
	//selectAndSearchGenericItems
	
	
	@FindBy(xpath="//input[@name='low-price']")
	static
	WebElement lowPrice;
	
	@FindBy(xpath="//input[@name='high-price']")
	static
	WebElement highPrice;
	
//	@FindBy(xpath="(//div[@id='leftNavContainer']/ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-base']/div[@class='a-row a-expander-container a-expander-extend-container'])[4]")
//	WebElement oS;
	
	@FindBy(xpath="//input[@value='Go' and @class='a-button-input']")
	static
	WebElement gO;
	
	String ChildID;
	
	
	/*public void createUser() throws InterruptedException
	{
		System.out.println("im here1");
		
//		CommonUtitity uWait= new CommonUtitity();
//		CommonUtitity.waitForElementToBeVisible(driver, hover);
//		Thread.sleep(5000);
		
		Actions A= new Actions(driver);
		A.moveToElement(hover).build().perform();
		
		System.out.println("im here");
		createUser.click();
	}*/
	
	
	
	public void userSignIn(String user,String pass)
	{
		Actions A= new Actions(driver);
		A.moveToElement(hover).build().perform();
		//driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']/a/span[@class='nav-action-inner']")).click();;
		signIn.click();
		//driver.findElement(By.xpath("//input[@type='email']")).sendKeys("appumuv@gmail.com");
		emailID.sendKeys(user);
		//driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Anushka19915");
		password.sendKeys(pass);
		//driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		submit.click();
	}
	
	public static void searchItems(String productName)
	{
		//Actions actions= new Actions(driver);
		searchItem.sendKeys(productName);
		searchItem.sendKeys(Keys.ENTER);
		
	}
	
	
	public void searchAndselectProduct(String productName ) throws InterruptedException
	{
		Actions actions= new Actions(driver);
//		searchItem.sendKeys(productName);
//		searchItem.sendKeys(Keys.ENTER);
//		WebDriverWait wd= new WebDriverWait(driver, 5);
//		wd.until(ExpectedConditions.visibilityOf(visiblityOfItem));
//		itemClickable.click();
		
		//Select item
		//int count= driver.findElements(By.tagName("h2")).size();
		java.util.List<WebElement> listofItems = driver.findElements(By.xpath("//h2[text()='"+productName+"']"));
		
		System.out.println(listofItems.size());
		//h2[text()='Noise Grey Knitted Slouchy Beanie winter woolen cap']
		WebDriverWait wait = new WebDriverWait(driver, 20); //Wait time of 20 seconds
		
		//listofItems.get(0).
		//System.out.println(listofItems);
		for(int i=0;i<listofItems.size();i++)
		{
			if(listofItems.get(i).getText().contains(productName))
			{
				System.out.println("Hola");
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(listofItems.get(i)));
				//WebElement we= driver.findElement(By.xpath("//h2[text()='Noise Grey Knitted Slouchy Beanie']"));
				//CommonUtitity.clickByJavaScriptExecutor(driver, we);
				
				WebElement addProduct= listofItems.get(i);
				
				actions.moveToElement(addProduct).click().build().perform();
				System.out.println(addProduct);
				break;
			}

			    
		}
		
	}
	
	public  void selectAndSearchGenericItems(String productName, String operatingSystem, String minPrice, String maxPrice, String num) throws InterruptedException
	{
		
		Amazon_Homepage.searchItems(productName);
		WebElement oS= driver.findElement(By.xpath("//span[text()='"+operatingSystem+"']"));
		
		oS.click();
		
		CommonUtitity.waitForElementToBeClickable(driver, lowPrice);
		lowPrice.sendKeys(minPrice);
		highPrice.sendKeys(maxPrice);
		
		gO.click();
		
		WebElement div=driver.findElement(By.xpath("//a[@class='a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal']"));
		
		CommonUtitity.waitForElementToBeClickable(driver, div);
		//Thread.sleep(5000);
		
		
		Actions A= new Actions(driver);
		A.moveToElement(div).click().build().perform();;
		//div.click();
		//CommonUtitity.clickByJavaScriptExecutor(driver, div);
		
		
		
		
		
		
		
	}
		
	
	
	public void selectQuantity(String quantity)
	{
	
		System.out.println(quantity);
		
		//switch to next window and buy to cart
		CommonUtitity.windowHandle(driver);
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		
		
		Select s = new Select(selectQuantity);
		
		
		s.selectByValue(quantity);
		
		
				
	}
	
	
	public void selectAddress(String address) throws InterruptedException
	{
		
		Thread.sleep(5000);
		
		
		System.out.println("HI");
		
		//WebElement click= driver.findElement(By.xpath("//div[@id='contextualIngressPtLabel_deliveryShortLine']"));
		CommonUtitity.waitForElementToBeVisible(driver, clickAddress);
		CommonUtitity.clickByJavaScriptExecutor(driver, clickAddress);
		//clickAddress.click();
		//driver.findElement(By.xpath("//div[@id='contextualIngressPtLabel_deliveryShortLine']")).click();
		Thread.sleep(5000);
		
		//clickAddress.click();
		List<WebElement> listofAddress = driver.findElements(By.xpath("//span[@class='a-text']"));
		
		System.out.println(listofAddress.size());
		
		Actions actions = new Actions(driver);
		
		
		for(int i=0;i<listofAddress.size();i++)
		{
			if(listofAddress.get(i).getText().contains(address))
			{
				System.out.println("Hi");
				System.out.println(i);
//				wait.until(ExpectedConditions.visibilityOf(listofItems.get(i)));
//				WebElement we= driver.findElement(By.xpath("//h2[text()='Noise Grey Knitted Slouchy Beanie']"));
//				CommonUtitity.clickByJavaScriptExecutor(driver, we);
				
				WebElement add= listofAddress.get(i);
				
				actions.moveToElement(add).doubleClick().build().perform();
				System.out.println(add);
				
				
				break;
				
			}
		}
		
		//WebElement con=driver.findElement(By.xpath("(//input[@class='a-button-input' and @id='GLUXConfirmClose'])[1]"));
		actions.moveToElement(addClose).click().build().perform();
		
		//CommonUtitity.waitForElementToBeVisible(driver, we);
		Thread.sleep(5000);
		
		//CommonUtitity.waitForElementToBeClickable(driver, buyNow);
		actions.moveToElement(buyNow).click().build().perform();
	
	}

	
}

