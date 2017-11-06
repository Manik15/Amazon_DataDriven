package com.amazon_DDT;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class Base_DDT {

	 public static WebDriver driver;
	 //public String baseURL="https://www.amazon.co.in";
	public static WebDriver initialize() throws IOException
	{
		Properties prop= new Properties();
		
		FileInputStream fis= new FileInputStream("data.properties");
		
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		String baseURL= prop.getProperty("baseURL");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
			driver= new ChromeDriver();
			driver.get(baseURL);
			
		}
		
		else if(browserName.equals("firefox"))
		{
			//firefox code
		}
		
		else if(browserName.equals("IE"))
		{
			//IE code
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;
	}
	
	@DataProvider
	public Object[][] getData() throws Exception
	{
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		
		//Size declaration is always the actual number
		//ReadExcel excelDP= new ReadExcel();
		
		
			Object[][] data= ReadExcel.testData("TestData.xlsx", "Sheet1");
			return data;
	
		
		
		
		
	}
}
