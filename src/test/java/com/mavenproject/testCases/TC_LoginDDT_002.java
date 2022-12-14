package com.mavenproject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mavenproject.pageObjects.LoginPage;
import com.mavenproject.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass 
{
	@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd) throws IOException, InterruptedException
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("URL is opened.....");//logger msg
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		logger.info("Login clicked.....");//logger msg
		
		Thread.sleep(5000);
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			
			lp.clickLogout();
			Assert.assertTrue(true);
			logger.info("Login passed.....");//logger msg
		}
		else	
		{
			//captureScreen(driver,"LoginTest");
			logger.info("Login failed.....");//logger msg
			Assert.assertTrue(false);
		}
	}
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\mavenproject\\testData\\LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path,"Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1",1);
		
		String logindata[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path,"Sheet1",i,j);//1 0
			}
		}
		
		return logindata;
	}
}
