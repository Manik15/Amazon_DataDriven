package com.excelDataPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelApiTest {

	public FileInputStream fis=null;
	public FileOutputStream fos=null;
	public XSSFWorkbook wBook=null;
	public XSSFSheet sheet= null;
	public XSSFRow row= null;
	public XSSFCell cell=null;
	String xFilePath;
	
	public ExcelApiTest(String xFilePath) throws IOException
	{
		this.xFilePath=xFilePath;
		fis= new FileInputStream(xFilePath);
		wBook= new XSSFWorkbook(fis);
		wBook.close();
	
	}
	
	public String getCellData(String sheetName, int rowNum, int colNum)
	{
		try 
		{
			sheet= wBook.getSheet(sheetName);
			row= sheet.getRow(rowNum);
			cell=row.getCell(colNum);
			
			if(cell.getCellTypeEnum()==CellType.STRING)
				return cell.getStringCellValue();
			else if(cell.getCellTypeEnum()==CellType.NUMERIC || cell.getCellTypeEnum()==CellType.FORMULA)
			{
				String cellValue= String.valueOf(cell.getNumericCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell))
				{
					//input the date format
					DateFormat df= new SimpleDateFormat("dd/mm/yy");
					//get the date value
					Date date= cell.getDateCellValue();
					cellValue= df.format(date);
				}
				return cellValue;
			}
			else if(cell.getCellTypeEnum()==CellType.BLANK)
				return " ";
			else
			{
				return String.valueOf(cell.getBooleanCellValue());
			}
			
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			return "row" + rowNum+" or column "+colNum +" does not exist  in Excel";
        }
	}

	public int getRowCount(String sheetName)
	{
		sheet= wBook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()+1;
		return rowCount;
	}

	public int getColCount(String sheetName)
	{
		sheet= wBook.getSheet(sheetName);
		row = sheet.getRow(0);
		int colCount= row.getLastCellNum();
		return colCount;
	}

	public boolean setCellData(String sheetName, int colName, int rowNum,String value)
	{
		try 
		{
			int col_Num = -1;
			sheet = wBook.getSheet(sheetName);
			//pointer to the header column
			row= sheet.getRow(0);
			
			//pointer to the editable column
			
			for(int i=0;i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(value))
				{
					col_Num=i;
				}
			}
			
			sheet.autoSizeColumn(col_Num);
			
			//write data to the specified rows
			row= sheet.getRow(rowNum-1); //cus if we give add data to 2 row, from excel point of its 1 row(starts from 0). So 2-1.
			if(row==null)
			{
				row=sheet.createRow(rowNum-1);
			}
			
			cell=row.getCell(col_Num);
			if(cell==null)
			{
				cell=row.createCell(col_Num);
			}
			
			cell.setCellValue(value);
			
			fos= new FileOutputStream(xFilePath);
			wBook.write(fos);
			fos.close();
			
		}
		
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return false;
	}

}
	
