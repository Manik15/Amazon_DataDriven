package com.amazon.practise;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.amazon_DDT.Amazon_Homepage;
import com.amazon_DDT.Base_DDT;
import com.amazon_DDT.CommonUtitity;

public class TestAddress extends Base_DDT {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.amazon.in/Noise-Grey-Knitted-Slouchy-Beanie/dp/B019SW9N3A/ref=sr_1_2?ie=UTF8&qid=1506239256&sr=8-2&keywords=Noise+Grey+Knitted+Slouchy+Beanie");
		driver.manage().window().maximize();
		
		String userName= "appumuv@gmail.com";
		String password= "Anushka19915";
		Map<String, String> map = null;
		Amazon_Homepage cu= new Amazon_Homepage(driver,map);
		cu.userSignIn(userName, password);
		//Amazon_Homepage.userSignIn(userName, password);
		driver.findElement(By.xpath("//div[@id='contextualIngressPtLabel_deliveryShortLine']")).click();
		Thread.sleep(5000);
		
		//clickAddress.click();
		List<WebElement> listofAddress = driver.findElements(By.xpath("//span[@class='a-text']"));
		
		System.out.println(listofAddress.size());
		
		Actions actions = new Actions(driver);
		
		
		for(int i=0;i<listofAddress.size();i++)
		{
			if(listofAddress.get(i).getText().contains("Qtr"))
			{
				System.out.println("Hi");
				System.out.println(i);
//				wait.until(ExpectedConditions.visibilityOf(listofItems.get(i)));
//				WebElement we= driver.findElement(By.xpath("//h2[text()='Noise Grey Knitted Slouchy Beanie']"));
//				CommonUtitity.clickByJavaScriptExecutor(driver, we);
				
				WebElement add= listofAddress.get(i);
				
				actions.moveToElement(add).doubleClick().build().perform();
				System.out.println(add);
				
				
				
				//add.click();
//				CommonUtitity.waitForElementToBeVisible(driver, add);
//				CommonUtitity.clickByJavaScriptExecutor(driver, add);
//				add.sendKeys(Keys.RETURN);
				//CommonUtitity.clickByJavaScriptExecutor(driver, add);
				//add.click();
				break;
				
			}
		}
		
		driver.findElement(By.xpath("(//input[@class='a-button-input' and @id='GLUXConfirmClose'])[1]")).click();
	}

}
