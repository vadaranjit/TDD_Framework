package com.ds.pageLayer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ds.utilities.UtilClass;

public class CartPage {

	UtilClass util_obj = new UtilClass();

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-striped']")
	private WebElement cardTable;

	public String getProductNameFromCart(String productName) {
		String value = null;
		int row = util_obj.getRowCountFormTable(cardTable);

		for (int i = 1; i <= row - 1; i++) {
			WebElement cellValue = util_obj.getTableCellValue(cardTable, i, 2);
			if (cellValue.getText().equals(productName)) {
				value = cellValue.getText();
				break;
			}
		}
		return value;
	}
}
