package com.automation.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchAndAddToCart {
	
	public SearchAndAddToCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CLASS_NAME,using="login")
	public WebElement signInLink;
	
	@FindBy(how=How.ID,using="email")
	public WebElement emailField;
	
	@FindBy(how=How.ID,using="passwd")
	public WebElement passwordField;
	
	@FindBy(how=How.ID,using="SubmitLogin")
	public WebElement submitLogin;
	
	@FindBy(how=How.ID,using="search_query_top")
	public WebElement searchInput;
	
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-default button-search']")
	public WebElement btnSearch;
	
	
	@FindBy(how=How.XPATH,using="//h5[@itemprop]/a[@title='Printed Chiffon Dress']")
	public WebElement dress;
	
	@FindBy(how=How.XPATH,using="//a[@class='btn btn-default button-plus product_quantity_up']")
	public WebElement quantityUp;
	
	@FindBy(how=How.ID,using="group_1")
	public WebElement sizeDD;
	
	@FindBy(how=How.ID,using="color_15")
	public WebElement colorGreen;
	
	@FindBy(how=How.XPATH,using="//button[@class='exclusive']")
	public WebElement btnAddToCart;
	
	@FindBy(how=How.XPATH,using="//span[@title='Close window']")
	public WebElement closePopup;
	
	@FindBy(how=How.XPATH,using="//a[@title='View my shopping cart']")
	public WebElement shoppingCart;
	
	@FindBy(how=How.XPATH,using="//p/a[@title='Proceed to checkout']")
	public WebElement btnProceed;
	
	@FindBy(how=How.XPATH,using="//textarea[@name='message']")
	public WebElement addComments;
	
	@FindBy(how=How.XPATH,using="//button[@name='processAddress']")
	public WebElement proceedAddress;
	
	@FindBy(how=How.ID,using="cgv")
	public WebElement agreeTerms;
	
	@FindBy(how=How.XPATH,using="//button[@name='processCarrier']")
	public WebElement proceedCarrier;
	
	@FindBy(how=How.XPATH,using="//a[@class='cheque']")
	public WebElement proceedByCheque;
	
	@FindBy(how=How.XPATH,using="//button[@class='button btn btn-default button-medium']")
	public WebElement confirmOrder;
	
	@FindBy(how=How.ID , using="layer_cart_product_attributes")
	public WebElement colorAndSize;
	
	@FindBy(how=How.ID , using="layer_cart_product_quantity")
	public WebElement qt;
	
	@FindBy(how=How.ID , using="layer_cart_product_price")
	public WebElement totalPrice;
	
	@FindBy(how=How.ID , using="layer_cart_product_title")
	public WebElement productName;
	
	@FindBy(how=How.XPATH , using="//div[@id='layer_cart']/div[@class='clearfix']")
	public WebElement popUp;
	
	@FindBy(css = "div#layer_cart h2")
	public WebElement cssSuccessMessageAddCart;
	
}
