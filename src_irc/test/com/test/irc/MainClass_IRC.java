package com.test.irc;

import java.io.IOException;


import org.testng.annotations.Test;

import com.irc.main.BaseClass_IRC;

public class MainClass_IRC extends BaseClass_IRC{

	@Test
	public void basePageNavigate() throws IOException
	{
		System.out.println("Hello");
		driver=intialize();
		driver.manage().window().maximize();
	}
}
