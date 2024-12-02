package com.ds.pageLayer;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//-------------- obj repo -----------------
	
	@FindBy(xpath="//input[@id='loginusername']")
	private WebElement email_txtbox;
	
	@FindBy(xpath="//input[@id='loginpassword']")
	private WebElement password_txtbox;
	
	@FindBy(xpath="//a[@id='login2']")
	private WebElement login_btn;
	
	@FindBy(xpath="(//button[@class='btn btn-primary'])[3]")
	private WebElement login_btn2;
	
	//------------ action methods -------------
	
	public void enterEmailAddress(String email)
	{
		email_txtbox.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		password_txtbox.sendKeys(password);
	}
	
	public void clickOnLoginButton()
	{
		login_btn.click();
	}
	
	public void clickOnLoginButton2()
	{
		login_btn2.click();
	}

}
