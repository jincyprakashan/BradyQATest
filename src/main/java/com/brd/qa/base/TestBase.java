package com.brd.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.brd.qa.util.TestUtil;

public class TestBase{

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
			
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\Matt\\eclipse-workspace\\BradyQaTest\\src\\main\\java\\com\\brd\\qa\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
				
	}
	
	public static void Initialization() {
		String BrowserName=prop.getProperty("browser");
		
		if (BrowserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Chrome\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (BrowserName.equals("Internetexplorer")) {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else if(BrowserName.equals("Edge")) {
			System.setProperty("webdriver.edge.driver","MicrosoftWebdriver.exe");
			driver=new EdgeDriver();
		}
		else if(BrowserName.equals("FF")) {
			System.setProperty("webdriver.edge.driver","C:\\Selenium\\Firefox\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Browser value is not given");
		}
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
				
		}
	
	public void TearDown(){
		driver.close();
	}
	
}
