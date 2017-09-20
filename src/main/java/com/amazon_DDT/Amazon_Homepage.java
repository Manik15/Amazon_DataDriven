package com.amazon_DDT;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Amazon_Homepage {

	public WebDriver driver;
	
	public Amazon_Homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@data-nav-ref='nav_ya_signin']")
	WebElement hover;
	
	@FindBy(xpath="(//a[contains(@href,'amazon.in/ap/register')])[1]")
	WebElement createUser;
	
	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']/a/span[@class='nav-action-inner']")
	WebElement signIn;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement emailID;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement submit;
	
	
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
	
	
	
}

