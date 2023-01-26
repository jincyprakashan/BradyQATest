package com.brd.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.brd.qa.base.TestBase;

public class SignInPage extends TestBase {
	//Page Factory - Object Repository
	
		@FindBy (xpath ="//span[@class='tv-signin-dialog__social tv-signin-dialog__toggle-email js-show-email']")
		WebElement Email;
		
		@FindBy (xpath ="//input[@name='username']")
		WebElement Username;
		
		@FindBy (xpath ="//input[@name='password']")
		WebElement Password;
		
		@FindBy (xpath ="//span[@class='tv-button__loader']")
		WebElement SignInBtn;
		
		//Initializing the page objects
			public SignInPage() {
				PageFactory.initElements(driver, this);
			}
			
			public HomePage ValidateSignInfunction(String username,String password) throws InterruptedException {
				Email.click();
				Username.sendKeys(username);
				Password.sendKeys(password);
				SignInBtn.click();
				return new HomePage();
				
			}
		
			
}
