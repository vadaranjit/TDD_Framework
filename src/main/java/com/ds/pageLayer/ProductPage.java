package com.ds.pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='col-sm-12 col-md-6 col-lg-6']") 
	private WebElement addToCartButton;
	
	public void clickOnAddToCardButton() {
		addToCartButton.click();
	}
}
