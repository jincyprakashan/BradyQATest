package com.brd.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.brd.qa.base.TestBase;
import com.brd.qa.pages.HomePage;
import com.brd.qa.pages.Search;
import com.brd.qa.pages.SignInPage;
import com.brd.qa.util.TestUtil;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest extends TestBase{
	SignInPage SignInPage;
	HomePage HomePage;
	Search Search;
	String sheetName="Sheet1";
	
	public ExtentReports extent;
	public ExtentTest extentTest;

	@BeforeMethod
	public void SetUp(){
		
		Initialization();
		SignInPage= new SignInPage();
		HomePage= new HomePage();
		Search=new Search();
					
	}
	
	@AfterMethod
	public void BrowserClose() {
		TearDown();
	}
	
	@DataProvider
	public Object[][] getTestData(){
		
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	

}
