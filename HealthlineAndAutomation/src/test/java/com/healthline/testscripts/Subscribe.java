package com.healthline.testscripts;

/**
 * Aim:Verify the subscribe functionality
 * Author: Group Q
 * Created on:6/03/2021
 * Modified on: 31/03/2021
 */
import org.testng.annotations.Test;

import utils.VisibilityOfElement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class Subscribe {

	public WebDriver driver;
	public boolean visibleFlag=false;
	utils.SetupEnvironment setup=new utils.SetupEnvironment();
	public com.page.object.model.SubscribePOM subscribe;
	
	@DataProvider(name="validEmail")
	public Object[][] validEmailAddress(){
		return new Object[][] {{"test@gmail.com"}};
	}
	
	@DataProvider(name="invalidEmail")
	public Object[][] invalidEmailAddress(){
		return new Object[][] {{"test.com"}};
	}
	
	
	@Parameters({"browserName","url"})
	@BeforeMethod
	public void beforeMethod(String browserName,String url) {
		driver = setup.driverReturn(browserName,url);
		subscribe=new com.page.object.model.SubscribePOM(driver);
		System.out.println("I am in akash master");
	}

	@Test(dataProvider="validEmail",priority=1,description="To verify subscribe functionality wuth valid email address.")
	public void subscribeFunctionalityWithValidEmail(String email) {
		subscribe.workingOfSubscriber(email);
		visibleFlag=VisibilityOfElement.isElementVisible(By.xpath("//h2[text()='Thanks for subscribing']"), driver);
		Assert.assertEquals(visibleFlag, true,"Subscribe is not working.");
	}

	@Test(dataProvider="invalidEmail",priority=2,description="To verify subscribe functionality with invalid email address.")
	public void subscribeFunctionalityWithInvalidEmail(String email) {
		subscribe.workingOfSubscriber(email);
		visibleFlag=VisibilityOfElement.isElementVisible(By.xpath("//h2[text()='Thanks for subscribing']"), driver);
		Assert.assertEquals(visibleFlag, true,"Subscribe is not working.");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Closing Browser");
		driver.quit();
	}

}
