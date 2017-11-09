package com.irc.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass_IRC {

	public static WebDriver driver;
	
	public static WebDriver intialize() throws IOException
	{
		System.out.println("1");
		Properties prop= new Properties();
		
		FileInputStream fis= new FileInputStream("datairc.properties");
		prop.load(fis);
		
		String baseurl= prop.getProperty("baseURL");
		
		
		String browserName= prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equals("chrome"))
		{
			System.setProperty("Webdriver.chrome.driver", "chromedriver");
			driver= new ChromeDriver();
			driver.get(baseurl);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
	}
	
	
	
	
}
