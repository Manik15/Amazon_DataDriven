package com.amazon_DDT_test;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.amazon.constants.CommonConstants;
import com.amazon_DDT.Amazon_Homepage;
import com.amazon_DDT.Base_DDT;
public class DDT_test extends Base_DDT
{

	
	@Test(dataProvider="getData",dataProviderClass=Base_DDT.class)
	public void basePageNavigation(Map<String,String> map) throws IOException, InterruptedException
	{
		System.out.println(map);
		driver=initialize();
		//driver.get(url);
		driver.manage().window().maximize();
		
//		String userName=map.get(CommonConstants.USERNAME);
//		String password=map.get("Password");
//		String prodName=map.get("Product");
//		String deliveryAddress= map.get("location");
//		String quantityOfProd=map.get("Quantity").replaceAll("[-+.^:,0]","");
//		
//		
//		String operatingSystem=map.get("Os");
//		String minPrice=map.get("Min Price");
//		String maxPrice=map.get("Max Price");
//		String num=map.get("num").replaceAll("[-+.^:,0]","");
		
		
		
		
		Amazon_Homepage aH= new Amazon_Homepage(driver,map);
		//cus driver has to go the constructor
		
//		aH.userSignIn(userName,password);
//		aH.searchAndselectProduct(prodName);
//		aH.selectQuantity(quantityOfProd);
//		
//		aH.selectAddress(deliveryAddress);
		
		aH.selectAndSearchGenericItems();
		
		
	}
}
