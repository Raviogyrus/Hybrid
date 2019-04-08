package ExcelUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.rowset.internal.Row;

public class ReadExcel {
	
	 WebDriver driver;
	 
	 	    WebDriverWait wait;
	 
	 	    HSSFWorkbook workbook;
	 
	 	    HSSFSheet sheet;
	 
	 	    HSSFCell cell;
	 	    
	 	   // Import excel sheet.
	 	 	 File src=new File("C:\\Users\\Ravindra Thakare RBT\\Desktop\\testDataNew.xlsx");
	
	 	   @BeforeTest
	 	  public void TestSetup()
	 	 {
	 	 	// Set the path of the Firefox driver.
	 	 	//System.setProperty("webdriver.gecko.driver", "C:\\Users\\geckodriver.exe");
	 	 	driver = new FirefoxDriver();
	 	 	
	 	 	// Enter url.
	 	 	driver.get("http://www.linkedin.com/");
	 	 	driver.manage().window().maximize();
	 	 	
	 	 	wait = new WebDriverWait(driver,30);
	 	 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 	 }	 	    
	 	    
	 	    
	 	   @Test
	 	  public void ReadData() throws IOException
	 	  {
	 	 	 // Load the file.
	 	 	 FileInputStream finput = new FileInputStream(src);
	 	 	 
	 	 	 // Load the workbook.
	 	 	workbook = new HSSFWorkbook(finput);
	 	 	 
	 	      // Load the sheet in which data is stored.
	 	 	 sheet= workbook.getSheetAt(0);

	 	 	 int rowCount = sheet.getLastRowNum();
	 	 	System.out.println("Total Rows => "+rowCount);
	 	 	 
	 	 	
	 	 	for(int i=0 ; i<rowCount; i++)
	 	 	{
	 	 		
	 	 		String Data0 = sheet.getRow(i).getCell(0).getStringCellValue();
	 	 		System.out.println("test data from exccel is => "+ Data0);
	 	 	}
	
	 	 	 
	 	 	/*
	 	 	
	 	 	 for(int i=1; i<=sheet.getLastRowNum(); i++)
	 	 	 {
	 	 		 // Import data for Email
	 	 		 cell = sheet.getRow(i).getCell(i);
	 	 		 cell.setCellType(Cell.CELL_TYPE_STRING);
	 	 		 driver.findElement(By.id("login-email")).sendKeys(cell.getStringCellValue());
	 	 		 
	 	 		 System.out.printf("Test first ");
	 	 		 
	 	 		 // Import data for password.
	 	 		 cell = sheet.getRow(i).getCell(2);
	 	 		 cell.setCellType(Cell.CELL_TYPE_STRING);
	 	 		 driver.findElement(By.id("login-password")).sendKeys(cell.getStringCellValue());
	 	 		   	
	 	 		 driver.findElement(By.id("login-email")).clear();
	 	 		 driver.findElement(By.id("login-password")).clear();
	 	 		 
	 	         }
	 	        
	 	   }
	 	   
	 	 
	 	   @Test
	 	   public void WriteData() throws IOException
	 	   {
	 		     
	 		 	 		  
	 			 // Write data in the excel.
	 		   FileOutputStream foutput=new FileOutputStream(src);
	 			
	 			// Specify the message needs to be written.
	 			String message = "Passed -ravio";
	 			
	 			// Create cell where data needs to be written.
	 			int i =1;
	 			for(i=1;sheet.getRow(i)!=null;i++)
	 			{
	 			sheet.getRow(i).createCell(3).setCellValue(message);
		 	 	 
	 			// Specify the file in which data needs to be written.
	 		    FileOutputStream fileOutput = new FileOutputStream(src);
		 	 	
	 		    // finally write content
			    workbook.write(fileOutput);
		 	 	 
			     // close the file
			    fileOutput.close();
			   
	 		  // driver.close();
	 		   
	 			}
	 	   }
	 	*/ 
	 	 	 	   
	 	  }   
	 	   @AfterMethod
	 	   public void teardown()
	 	   {
	 		   
	 		   driver.quit();
	 	   }

}
