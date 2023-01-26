package com.brd.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.brd.qa.base.TestBase;
import com.brd.qa.pages.SignInPage;
import com.brd.qa.util.CustomListener;
import com.brd.qa.util.TestUtil;

import com.brd.qa.pages.HomePage;
import com.brd.qa.pages.Search;

@Listeners(CustomListener.class)
public class HomePageTest extends BaseTest{
	
	public HomePageTest() {
		super();
	}
	
	@Test(dataProvider="getTestData")
	public void KeywordSearchTest(String Username,String Password,String Tab,String SearchText) throws InterruptedException {
		Thread.sleep(2000);
		HomePage.AcceptAllCookies();
		HomePage.ValidateSignInLink();
		Thread.sleep(2000);
		SignInPage.ValidateSignInfunction(Username,Password);
		Thread.sleep(2000);
		HomePage.SelectTab(Tab);
		Thread.sleep(2000);
		Search.SearchFunction(SearchText);
		String title=HomePage.GetPageTitle();
		//System.out.println(title);
		Assert.assertEquals(title, "GBP JPY Chart – Pound to Yen Rate — TradingView");
		System.out.println("Page is verified. Page title is " +title);
		}
	
	
}
