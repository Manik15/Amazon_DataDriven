package amazon_DDT_test;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.amazon_DDT.Amazon_Homepage;
import com.amazon_DDT.Base_DDT;
public class DDT_test extends Base_DDT
{

	
	@Test(dataProvider="getDataSign",dataProviderClass=Base_DDT.class)
	public void basePageNavigation(Map<String,String> map) throws IOException
	{
		//System.out.println(userName);
		driver=initialize();
		//driver.get(baseURL);
		driver.manage().window().maximize();
		
		Amazon_Homepage cu= new Amazon_Homepage(driver);
		//cu.createUser();
		
		String userName=map.get("userName");
		String password=map.get("password");
		
		System.out.println(userName+" > "+password);
		//System.out.println(User);
		cu.userSignIn(userName, password);
		
		
	}
	
	//@DataProvider
	
	/*public Object[][] getData()
	{
		Object[][] data= new Object[1][2];
		
		data[1][1]="appumuv@gmail.com";
		data[1][2]="Anushka19915";
		
		return data;
	}*/
	
	/*@DataProvider
	public Object[][] getData()
	{
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[1][2];
		//0th row
		data[0][0]="appumuv@gmail.com";
		data[0][1]="Anushka19915";
		//data[0][2]="Restrcited User";
		//1st row
		//data[1][0]="restricteduser@qw.com";
		//data[1][1]="456788";
		//data[1][2]= "Non restricted user";
		
		return data;	
	}*/
}
