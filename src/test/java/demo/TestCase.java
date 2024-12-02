package demo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ds.testBase.TestBase;
import com.ds.utilities.ExcelHandling;

public class TestCase extends TestBase{

	@Test(dataProvider = "LoginTestData")
	public void verifyLoginWithCorrectCred(String sr_no, String email,String password) throws InterruptedException
	{
		String expected_output = "https://www.apps.dalalstreet.ai/dashboard";
		
		login_obj.enterEmailAddress(email);
		login_obj.enterPassword(password);
		login_obj.clickOnLoginButton();
		Thread.sleep(5000);
		String actual_output = util_obj.getWebPageUrl();
		
		int row_num = Integer.parseInt(sr_no);
		
		if(actual_output.equals(expected_output))
		{
			excel_data.writeData("Login", row_num, 3, "Passed");
		}
		else
		{
			excel_data.writeData("Login", row_num, 3, "Failed");
		}
		
		Assert.assertEquals(actual_output, expected_output);
		
		
//		TestCase c = new TestCase();
//		c.getLoginData();
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
