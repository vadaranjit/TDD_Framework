package com.ds.utilities;

import java.io.File;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		String projectPath = System.getProperty("user.dir");
		//String path = projectPath+ "\\screenshots\\";
		String path = "D:\\GitProjects\\TddFramework\\screenshots";
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
	
	public WebElement getTableCellValue(WebElement cardTable,int rowIndex,int columnIndex) 
	{
//		int rowIndex = getRowCountFormTable(cardTable);
//		int columnIndex = getColumnCountFormTable(cardTable);
		WebElement cell = cardTable.findElement(By.xpath(".//tr[" + rowIndex + "]/td[" + columnIndex + "]"));
		return cell;
	}
	
	public int getRowCountFormTable(WebElement tableElement) {
        List<WebElement> rows = tableElement.findElements(By.xpath(".//tr"));
        return rows.size();
    }
	
	public int getColumnCountFormTable(WebElement tableElement) {
        // Assuming first row defines the column structure
        List<WebElement> columns = tableElement.findElements(By.xpath(".//tr[1]/td | .//tr[1]/th"));
        return columns.size();
    }
}
