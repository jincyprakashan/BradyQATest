package com.brd.qa.pages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.brd.qa.base.TestBase;


public class HomePage extends TestBase {
	//Page Factory - Object Repository
	
			@FindBy (xpath ="//button[@class='tv-header__user-menu-button tv-header__user-menu-button--anonymous js-header-user-menu-button']")
			WebElement SignIn;
			
			@FindBy (xpath ="//span[contains(text(),'Sign in')]")
			WebElement SignInLink;
			
			@FindBy (xpath ="//span[contains(text(),'Accept all')]")
			WebElement AcceptCookies;
		
			//Initializing the page objects
				public HomePage() {
					PageFactory.initElements(driver,this);
				}
				
				//Actions
				public SignInPage ValidateSignInLink() throws InterruptedException {
					SignIn.click();
					Thread.sleep(3000);
					SignInLink.click();
					return new SignInPage();
				}
				
				public void AcceptAllCookies(){
				 try{
						AcceptCookies.click();
					}catch(NoSuchElementException e) {
						e.printStackTrace();
					}
									
				}
				
				public void SelectTab(String Tab) {
					driver.findElement(By.linkText(Tab)).click();
					System.out.println(Tab+" tab is selected");
														
				}
				
				public String GetPageTitle() {
					String Pagetitle=driver.getTitle();
					return Pagetitle;
										
				}

}
