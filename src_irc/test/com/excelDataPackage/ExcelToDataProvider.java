package com.excelDataPackage;

import java.io.IOException;

public class ExcelToDataProvider {

	public Object[][] testData(String xFilePath, String sheetName) throws IOException
	{
		Object[][] excelData= null;
		ExcelApiTest eat= new ExcelApiTest(xFilePath);
		int rows = eat.getRowCount(sheetName);
		int cols= eat.getColCount(sheetName);
		
		for(int i=0;i<rows;i++)
		{
			for(int j=1;j<cols;j++)
			{
				excelData[i-1][j] = eat.getCellData(sheetName,i, j);
			}
		}
		return excelData;
	}
	
}
