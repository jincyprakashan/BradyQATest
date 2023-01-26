package com.brd.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.brd.qa.base.TestBase;

public class Search extends TestBase {
	
	@FindBy (xpath ="//button[@class='tv-header-search-container tv-header-search-container__button tv-header-search-container__button--full js-header-search-button']")
	WebElement SearchBtn;
	
	@FindBy (xpath ="//input[@name='query']")
	WebElement Search;
	
	//Initializing the page objects
	public Search() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void SearchFunction(String searchtext) throws InterruptedException {
		SearchBtn.click();
		Search.clear();
		Search.sendKeys(searchtext);
		WebElement WE=driver.findElement(By.xpath("//span[@class='tv-circle-logo tv-circle-logo--xsmall']"));
		Actions action=new Actions(driver);
		action.moveToElement(WE).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@name='search-type' and @value='symbols']")).click();
		Thread.sleep(2000);
		}
}
