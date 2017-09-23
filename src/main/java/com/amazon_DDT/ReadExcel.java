package com.amazon_DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class ReadExcel {
	public static FileInputStream excelFile=null;
	public static XSSFWorkbook WB=null;
	public static XSSFSheet excelSheet= null;
	public static XSSFCell cell=null;
	public static XSSFRow row=null;
	public static MissingCellPolicy Row;
	public static XSSFRow row1=null;
	String Path;
	
	
	
	public ReadExcel( String Path) throws IOException
	{
		this.Path= Path;
		excelFile= new FileInputStream(Path);
		WB= new XSSFWorkbook(excelFile);
		
		excelFile.close();
	}
  public static Object[][] testData(String Path, String SheetName) throws Exception
  {
	  try {
		  
		  excelSheet = WB.getSheet(SheetName);
		  System.out.println(Path);
		  Object[][] excelData=null;
		  ReadExcel RE= new ReadExcel(Path);
		  int rowNUM= RE.getRowCount(SheetName);
		  int colNUM= RE.getColumnCount(SheetName);
		  ArrayList<String> colNames=null;
		  
		  System.out.println(rowNUM);
		  System.out.println(colNUM);
		  //colNames= getcolNames(SheetName);
		  
		 // key=column header
		  
		  Map<String, Object> map=null;
		  excelData= new Object[rowNUM-1][colNUM];
		  for(int i=1;i<rowNUM;i++)
		  {
			row1= excelSheet.getRow(i);
		  	map=new HashMap<String, Object>(rowNUM); // row 
		  	for (int j=0;j<colNUM;j++)
		  	{
		  		
		  //map.put(cellValue(0,j),cellvaule(i,j) //1st Iteration username>appuv,pass>anus,pro>a
		  // 2nd Iteration   username>123,pass>abc,pro>b
			//map.put(ReadExcel.getCellData(SheetName, j,0), ReadExcel.getCellData(SheetName, j,i));
			map.put(colNUM., value)
			
			System.out.println(map);
			excelData[i-1][j]=map;
			  
		  	}
		  }
		  
		  
		  return excelData;
		  
		  
		  
		  
		  
//		  excelData= new Object[rowNUM-1][colNUM];
//		  
//		  for(int i=1; i<rowNUM;i++)
//		  {
//			  for(int j=0;j<colNUM;j++)
//			  {
//				  excelData[i-1][j]= ReadExcel.getCellData(SheetName, j, i);
//			  }
//		  }
	  
		 // return excelData;
	  }
	  catch(Exception e)
	  {
		  throw(e);
	  }
	 
	
  }
  
  private static ArrayList<String> getcolNames(String sheetName) {
	// TODO Auto-generated method stub
	  excelSheet = WB.getSheet(sheetName);
      row = excelSheet.getRow(0);
      ArrayList<String> columnNames=null;
      
//      cell.getSheet().getRow(0).getCell(currentcellIndex)
//      .getRichStringCellValue().toString()
      
    	  for(int j=0;j<ReadExcel.getColumnCount(sheetName);j++)
    	  {
    		  XSSFCell columncell = row.getCell(j);
    		  columnNames= columncell.
    	  }
      
      //columnNames= row.getCell(0).getRichStringCellValue().toString().to;
	  
	return columnNames;
}
public int getRowCount(String sheetName) {
	
	  System.out.println(WB);
	  excelSheet= WB.getSheet(sheetName);
	  System.out.println(excelSheet);
	  int rowCount= excelSheet.getLastRowNum()+1;
	return rowCount;
}
public static int getColumnCount(String sheetName)
  {
      excelSheet = WB.getSheet(sheetName);
      row = excelSheet.getRow(0);
      int colCount = row.getLastCellNum();
      return colCount;
  }
	
//  public static XSSFSheet getSheetdetails(String sheetName)
//  {
//	  excelSheet=WB.getSheet(sheetName);
//	  return excelSheet;
//  }

  public static String getCellData(String sheetName,int colNum,int rowNum)
  {
      try
      {
          excelSheet = WB.getSheet(sheetName);
          row = excelSheet.getRow(rowNum);
          cell = row.getCell(colNum);
          
          if(cell.getCellTypeEnum() == CellType.STRING)
              return cell.getStringCellValue();
          
          //map.put(ReadExcel.getCellData(SheetName,0,j), ReadExcel.getCellData(SheetName, i, j));
          else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.STRING)
          {
              String cellValue  = String.valueOf(cell.getNumericCellValue());
              if (HSSFDateUtil.isCellDateFormatted(cell))
              {
                  DateFormat df = new SimpleDateFormat("dd/MM/yy");
                  Date date = cell.getDateCellValue();
                  cellValue = df.format(date);
              }
              return cellValue;
          }
          
          else if(cell.getCellTypeEnum() == CellType.BLANK)
              return "";
          else
          {
              return String.valueOf(cell.getBooleanCellValue());
          }
          
      }
      
      catch(Exception e)
      {
    	  return "row "+rowNum+" or column "+colNum +" does not exist  in Excel";
      }
  }
  
  public static void setCellData(String Result,int rowNum, int colNum)
  {
	  try {
		row= excelSheet.getRow(rowNum);
		  cell= row.getCell(colNum, Row.RETURN_BLANK_AS_NULL);
		  
		  if(cell==null)
		  {
			  cell=row.createCell(colNum);
			  cell.setCellValue(Result);
		  }
		  
		  else
		  {
			  cell.setCellValue(Result);
		  }
		  
		  FileOutputStream fileOut= new FileOutputStream(Constant_details.path + Constant_details.excelName);
		  WB.write(fileOut);
		  fileOut.flush();
		  fileOut.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
}
