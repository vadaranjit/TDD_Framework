package com.ds.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ds.testBase.TestBase;

public class AddToCartTest extends TestBase {

	@Test()
	public void verifyProductAddedIntoCart() throws InterruptedException 
	{
		String expectedProduct = "Samsung galaxy s7";
		homePage_obj.clickOnPhonesCategories();
		homePage_obj.clickOnProduct();
		productPage_obj.clickOnAddToCardButton();
		Thread.sleep(1000);
		homePage_obj.clickOnCart();
		Thread.sleep(1000);
		String actualProduct = cartPage_obj.getProductNameFromCart("Samsung galaxy s7");
		Assert.assertEquals(actualProduct, expectedProduct);
	}
	
}
