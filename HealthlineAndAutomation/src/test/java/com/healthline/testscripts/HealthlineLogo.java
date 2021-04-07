package com.healthline.testscripts;

import org.testng.annotations.Test;

import utils.VisibilityOfElement;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HealthlineLogo {
	public WebDriver driver;
	public boolean visibleFlag=false;
	utils.SetupEnvironment setup=new utils.SetupEnvironment();
	public com.page.object.model.HealthlineLogoPOM healthlineLogo;
	
	@Parameters({"browserName","url"})
	@BeforeMethod
	public void beforeMethod(String browserName,String url) {
		driver = setup.driverReturn(browserName,url);
		healthlineLogo=new com.page.object.model.HealthlineLogoPOM(driver);
	}

	@Test(description="To verify healthline logo functionality.")
	public void clickFunctionalityOfHealthlineLogo() {
		healthlineLogo.workOfHealthlineLogo();
		visibleFlag = VisibilityOfElement.isElementVisible(healthlineLogo.getHomepage(), driver);
		Assert.assertEquals(visibleFlag,true,"Refresh not worked.");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Closing Browsr");
		driver.quit();
	}

}
