package com.brd.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.brd.qa.base.TestBase;
import com.sun.media.sound.InvalidFormatException;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIME_OUT=20;
	public static long IMPLICIT_WAIT=30;
	
public static String TESTDATA_SHEET_PATH="C:\\Users\\Matt\\eclipse-workspace\\BradyQaTest\\src\\main\\java\\com\\brd\\qa\\testdata\\TestDataSheet.xlsx";
	
	static XSSFWorkbook book;
	static XSSFSheet sheet;
	
	public static Object[][] getTestData(String sheetName){
		
		FileInputStream file=null;
		
		try {
			file= new FileInputStream(TESTDATA_SHEET_PATH);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		try {
				book= new XSSFWorkbook(file);
						
		}catch(InvalidFormatException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}	
		
		sheet = book.getSheet(sheetName);
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum();i++) {
			for(int k=0; k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]= sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
	
	
	
	}
	
	public static void takeScreenshotAtEndOfTest(String testMethodName) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(scrFile, new File("C:\\Users\\Matt\\eclipse-workspace\\BradyQaTest\\Screenshots\\"
		+testMethodName+"_"+System.currentTimeMillis()+".jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
			
	}

}
