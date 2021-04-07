package com.automation.testscripts;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.page.object.model.SearchPOM;

import utils.Logger;
import utils.VisibilityOfElement;

public class SearchItems {

	utils.SetupEnvironment setup = new utils.SetupEnvironment();
	SearchPOM search;
	public WebDriver driver;
	public boolean visibleFlag = false;

	@DataProvider(name = "inValidSearch")
	public Object[] inValidSearch() {
		return new Object[] { "Hii", "how are u", "kese ho" };
	}

	@DataProvider(name = "validSearch")
	public Object[] validSearch() {
		return new Object[] { "Top", "Dress" };
	}

	@Parameters({ "browserName", "url" })
	@BeforeMethod
	public void beforeMethod(@Optional String browserName, String url) {
		driver = setup.driverReturn(browserName, url);
		search = new com.page.object.model.SearchPOM(driver);
	}

	@Test(dataProvider = "validSearch", priority = 2, description = "To verify the search functionality.")
	public void validSearchItems(String searchData) {
		search.sendSearchText(searchData);
		visibleFlag = VisibilityOfElement
				.isElementVisible(By.xpath("//p[contains(text(),'No results were found for your search')]"), driver);
		Assert.assertEquals(visibleFlag, false, "For valid search it should not provide correct pages.");
		Logger.print("Item or items succesfully display on DOM.");
	}

	@Test(dataProvider = "inValidSearch", priority = 1, description = "To verify the search functionality.")
	public void inValidSearchItems(String searchData) {
		search.sendSearchText(searchData);
		visibleFlag = VisibilityOfElement
				.isElementVisible(By.xpath("//p[contains(text(),'No results were found for your search')]"), driver);

		Assert.assertEquals(visibleFlag, true, "Not accepeted messege was found.");
		Logger.print("For \"" + searchData + "\" it will display no result found. ");

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Closing Browsr");
		driver.quit();
	}
}
