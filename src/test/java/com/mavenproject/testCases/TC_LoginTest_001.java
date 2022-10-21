package com.mavenproject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.mavenproject.pageObjects.LoginPage;
public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws InterruptedException, IOException
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
			captureScreen(driver,"LoginTest");
			logger.info("Login failed.....");//logger msg
			Assert.assertTrue(false);
		}
	}

}
