package framework;
 
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.ExcelToDataProvider;

public class Write 
    {
    public static HSSFWorkbook workbook;
    public static HSSFSheet worksheet;
    public static DataFormatter formatter= new DataFormatter();
    public static String file_location = System.getProperty("user.dir")+"/Desktop";
    static String SheetName= "Sheet1";
    public String ColName="RESULT";
    public int col_num;

    @DataProvider
    public static Object[][] ReadVariant() throws IOException
    {
    FileInputStream fileInputStream= new FileInputStream("C:\\Users\\Ravindra Thakare RBT\\Desktop\\TestDataNew.xls"); //Excel sheet file location get mentioned here
        workbook = new HSSFWorkbook (fileInputStream); //get my workbook 
        worksheet=workbook.getSheet(SheetName);// get my sheet from workbook
        HSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0   
     
        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
        int ColNum= Row.getLastCellNum(); // get last ColNum 
         
        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
         
            for(int i=0; i<RowNum-1; i++) //Loop work for Rows
            {  
                HSSFRow row= worksheet.getRow(i+1);
                 
                for (int j=0; j<ColNum; j++) //Loop work for colNum
                {
                    if(row==null)
                        Data[i][j]= "";
                    else
                    {
                        HSSFCell cell= row.getCell(j);
                        if(cell==null)
                            Data[i][j]= ""; //if it get Null value it pass no data 
                        else
                        {
                            String value=formatter.formatCellValue(cell);
                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                        }
                    }
                    
                    }
            }
 
        return Data;
        
    }
    
	@Test 
	(dataProvider="ReadVariant")	
public void WriteResult(String NAME, String DESCRIPTION, String WEIGHT, String PRICE, String MODEL, String RS,int DR) throws IOException
{

	 System.out.println("This is Wriiiiiiiiiite method 5245545435543");
	//FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Ravindra Thakare RBT\\Desktop\\TestData.xls"));
    FileInputStream file_input_stream= new FileInputStream("C:\\Users\\Ravindra Thakare RBT\\Desktop\\TestDataNew.xls");
    workbook=new HSSFWorkbook(file_input_stream);
    worksheet=workbook.getSheet(ExcelToDataProvider.SheetName);
    HSSFRow Row=worksheet.getRow(0);

    int sheetIndex=workbook.getSheetIndex(ExcelToDataProvider.SheetName);
    DataFormatter formatter = new DataFormatter();
    if(sheetIndex==-1)
    {
        System.out.println("No such sheet in file exists");
    } else      {
        col_num=-1;
            for(int i=0;i<Row.getLastCellNum();i++)
            {
                HSSFCell cols=Row.getCell(i);
                String colsval=formatter.formatCellValue(cols);
                if(colsval.trim().equalsIgnoreCase(ColName.trim()))
                {
                    col_num=i;
                    break;
                }
            }
//          
            Row= worksheet.getRow(DR);
            try
                {
                //get my Row which is equal to Data  Result and that colNum
                    HSSFCell cell=worksheet.getRow(DR).getCell(col_num);
                    // if no cell found then it create cell
                    if(cell==null) {
                        cell=Row.createCell(col_num);                           
                    }
                    //Set Result is pass in that cell number
                    cell.setCellValue(RS);
                                     
                     
                }
            catch (Exception e) //add exception in result colummn in failed 
            
            {
                System.out.println(e.getMessage()); 
                HSSFCell cell=worksheet.getRow(DR).getCell(col_num);
                // if no cell found then it create cell
                if(cell==null) {
                    cell=Row.createCell(col_num);                           
                }
                //Set Result is pass in that cell number
                cell.setCellValue(e.getMessage());
            } 

    }
        FileOutputStream file_output_stream=new FileOutputStream("C:\\Users\\Ravindra Thakare RBT\\Desktop\\TestDataNew.xls");
        workbook.write(file_output_stream);
        file_output_stream.close();
        if(col_num==-1) {
            System.out.println("Column you are searching for does not exist");
        }
}

}