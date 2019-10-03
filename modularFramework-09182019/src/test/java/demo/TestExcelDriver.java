package demo;

import org.testng.annotations.Test;

import comonLibs.utils.ExcelDriver;

public class TestExcelDriver {
	
	ExcelDriver excelDriver;
	
	String excelfilename;
	
	String sheetname;
	
	@Test
	public void verifyExcelDriver() throws Exception{
		
		excelfilename = System.getProperty("user.dir") + "/inputExcelsheets/InputTestData.xlsx";
		
		sheetname = "Test Data";
		
		excelDriver = new ExcelDriver();
		
		excelDriver.createWorkbook(excelfilename);
		
		excelDriver.openWorkbook(excelfilename);
		
		excelDriver.createSheet(sheetname);
		
		excelDriver.setCellData(sheetname, 1, 0, "Saurabh Dhingra");
		excelDriver.setCellData(sheetname, 1, 1, "Gaurav Yadav");
		excelDriver.setCellData(sheetname, 2, 0, "Mohan Sharma");
		excelDriver.setCellData(sheetname, 2, 1, "Saurabh Dhingra");
		
		excelDriver.saveFile();
		
		excelDriver.closeWorkbook();
		
	}

}
