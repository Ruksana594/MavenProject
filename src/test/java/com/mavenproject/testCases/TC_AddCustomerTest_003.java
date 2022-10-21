package com.mavenproject.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mavenproject.pageObjects.AddCustomerPage;
import com.mavenproject.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	@Test
	public void addNewCustomer() throws IOException
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("URL is opened.....");//logger msg
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		logger.info("Login clicked.....");//logger msg
		
		logger.info("providing customer details.....");
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickOnCustomerMenu();
		addcust.clickOnCustomerMenuItem();
		addcust.clickOnAddnew();
		
		String email = randomestring() + "@gmail.com";
		addcust.setEmail(email);
		
		addcust.setPassword("test1234");
		
		addcust.setFirstname("Alex");
		
		addcust.setLastname("John");
		
		addcust.setGender("Male");
		
		addcust.setDob("10/7/1993");//format: mm/d/yyyy
		
		addcust.setComment("THIS IS FOR TESTING........");
		
		addcust.setManagerOfVendor("Vendor 2");
		
		addcust.setActive();
		
		addcust.setCompanyname("EPAM");
		
		addcust.setTaxExempt();
		
		addcust.clickOnSave();
		
		//addcust.setCustomerRoles("Guests");
		
		//addcust.setNewsletter("Test store 2");
		

		logger.info("validation started....");
				
		//String msg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		
		String msg = driver.findElement(By.tagName("body")).getText();
			
		
		if(msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
				
	}
}