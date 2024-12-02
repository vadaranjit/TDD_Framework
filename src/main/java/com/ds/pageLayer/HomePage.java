package com.ds.pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='list-group']/a[text()='Phones']")
	private WebElement categoriesPhones;
	
	@FindBy(xpath="//h4[@class='card-title']")
	private WebElement clickProductButton;
	
	@FindBy(xpath="//li[@class='nav-item']/a[text()='Cart']")
	private WebElement clickCartButton;

	public void clickOnPhonesCategories() 
	{
		categoriesPhones.click();
	}
	
	public void clickOnProduct() 
	{
		clickProductButton.click();
	}
	public void clickOnCart() 
	{
		clickCartButton.click();
	}
}
