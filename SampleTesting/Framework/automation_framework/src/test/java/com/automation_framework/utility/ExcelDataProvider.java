package com.automation_framework.utility;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	
	//public ExcelDataProvider(){}
	//String sheetName="search";
	//String testCaseName="provodeexceldata";
	String src = "C:\\Users\\HP\\Documents\\Sample Testing\\Framework\\automation_framework\\TestData\\AppData.xlsx";
	XSSFWorkbook wb=null;
	XSSFSheet sheet=null;
	Map<String, String> TestData = new HashMap<String, String>();
	
	public ExcelDataProvider() {
		File file = new File(src);
		try {
			wb = new XSSFWorkbook(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public int getLastRowIndex() {
		return sheet.getLastRowNum();
	}
	
	public int getLastCellIndex(int rowIndex) {
		return sheet.getRow(rowIndex).getLastCellNum() - 1;
	}
	
	
	public Map<String, String> getExcelTestData(String sheetName, String testCaseName) throws Exception{
		int i;
		int lastCellIndex;
		
		sheet = wb.getSheet(sheetName);
		int lastRowIndex = getLastRowIndex();
		for(i=0; i<=lastRowIndex; i++){
			String testCase = sheet.getRow(i).getCell(0).getStringCellValue();
			if (testCase.equals(testCaseName)) {
				lastCellIndex = getLastCellIndex(i);
				for (int j = 0; j <= lastCellIndex; j++) {
					String key = sheet.getRow(i).getCell(j).getStringCellValue();
					String value = sheet.getRow(i+1).getCell(j).getStringCellValue();
					TestData.put(key, value);
				}
				break;
			}
		}
		
		System.out.println(TestData.get("SEARCH"));
		System.out.println(TestData.get("URL"));
		return TestData;
	}

}
