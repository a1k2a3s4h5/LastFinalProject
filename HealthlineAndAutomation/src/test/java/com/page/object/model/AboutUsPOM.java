package com.page.object.model;

import org.openqa.selenium.WebDriver;

import com.automation.locators.AboutUsLocators;

public class AboutUsPOM {
	AboutUsLocators aboutUs;
	WebDriver driver;
	public AboutUsPOM(WebDriver driver) {	
		this.driver=driver;
		aboutUs=new AboutUsLocators(driver);
	}
	
	public void clickAboutUs() {
		aboutUs.aboutUsLink.click();
	}
}
