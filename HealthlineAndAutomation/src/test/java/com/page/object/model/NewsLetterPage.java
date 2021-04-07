package com.page.object.model;

import org.openqa.selenium.WebDriver;

import com.automation.locators.NewsletterLocators;

import utils.Logger;


public class NewsLetterPage {
	public NewsletterLocators newsLetter;
	public WebDriver driver;
	
	public NewsLetterPage(WebDriver driver) {	
		this.driver=driver;
		newsLetter=new NewsletterLocators(driver);
	}
	
	public void newsLetter(String email) {
		
		newsLetter.emailAddress.click();
		newsLetter.emailAddress.clear();
		newsLetter.emailAddress.sendKeys(email);
		Logger.print("Send email: "+email);
		newsLetter.btnSubmit.click();
	}

}
