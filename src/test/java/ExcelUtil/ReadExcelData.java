package ExcelUtil;

import org.openqa.selenium.TakesScreenshot;


import Excelutility.ExcelDataConfig;


public class ReadExcelData {
	
	
	public void RunExcel() {
	ExcelDataConfig excel = new ExcelDataConfig("E:\\My Framework\\Hybrid\\TestData\\Testdata.xls");
	System.out.println(excel.getData(0, 0, 1));
	
	}

}
