package framework;


import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelToDataProvider {

    public static HSSFWorkbook workbook;
    public static HSSFSheet worksheet;
    public static DataFormatter formatter= new DataFormatter();
    public static String file_location = System.getProperty("user.dir")+"/Desktop";
    static String SheetName= "Sheet1";
    public  String Res;
   // Write obj1=new Write();
    public int DataSet=-1;

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
	//*******************************REading from excel ******************************//
	@Test //Test method
	(dataProvider="ReadVariant",priority=1) //It get values from ReadVariant function method
	 
	//Here my all parameters from excel sheet are mentioned.
	public void AddVariants(String NAME, String DESCRIPTION, String WEIGHT, String PRICE, String MODEL, String RS) throws IOException
	{
	//Data will set in Excel sheet once one parameter will get from excel sheet to Respective locator position.
	
		DataSet++;
	System.out.println("NAme of product available are:" +NAME);
	System.out.println("Weight for products are:" +DESCRIPTION);
	System.out.println("Volume of product are:" +WEIGHT);
	System.out.println("Description quotation are:" +PRICE);
	System.out.println("Description picklings are:" +MODEL);
	 
	}
	
	//*************************************Write in result column *****************************//
//Check other classs - Write.java


}
     
    
