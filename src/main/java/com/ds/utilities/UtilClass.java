package com.ds.utilities;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.ds.testBase.TestBase;

public class UtilClass extends TestBase {
	
	public UtilClass()
	{
		PageFactory.initElements(driver, this);
	}

	//get url 
	
	public String getWebPageUrl()
	{
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public static void takeSS(String filename)
	{
		String path = "C:\\Users\\RANJIT\\eclipse-workspace\\DalalStreet17SeptFramework\\screenshots\\";
		try 
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File(path+filename+".png");
			FileHandler.copy(src, des);
		} 
		catch (IOException e) 
		{
			System.out.println("file path is not correct");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name = "LoginTestData")
	public String[][] getLoginData()
	{
		ExcelHandling excel_data1 =  new ExcelHandling();
		int r = excel_data1.getRowNumber("Login");
		int c = excel_data1.getCellNumber("Login", 1);
		
		String loginData[][] = new String[r][c];
		for(int i=1;i<=r;i++)
		{
			for(int j=0;j<c;j++)
			{
				loginData[i-1][j] = excel_data1.readData("Login", i, j);
			}
		}
		return loginData;
	}
}
