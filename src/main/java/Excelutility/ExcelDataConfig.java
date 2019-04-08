package Excelutility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDataConfig {
	
	  HSSFWorkbook workbook;
		 
	    HSSFSheet sheet;

	    HSSFCell cell;
	    
	   
	
	public ExcelDataConfig(String excelpath)
	{
		try {
		 File src=new File("E:\\My Framework\\Hybrid\\TestData\\Testdata.xls");
	
		 FileInputStream finput = new FileInputStream(src);
 	 	 
 	 	
 	 workbook = new HSSFWorkbook(finput);
 	 	 
 	      // Load the sheet in which data is stored.

			System.out.println("excel data try loop ");
		
		
		}catch(Exception e)
		{
			System.out.println("This is exception in read excel ");
		}
	}

	
	public String getData(int sheetNumber, int row , int column)
	{
		sheet= workbook.getSheetAt(sheetNumber);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
