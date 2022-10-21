package com.mavenproject.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
	public static WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	By lnkCustomers_menu = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a");
	By lnkCustomers_menuitem = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
	
	By btnAddnew = By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	
	By txtEmail = By.xpath("//*[@id=\"Email\"]");
	By txtPassword = By.xpath("//*[@id=\"Password\"]");
	By txtFirstname = By.xpath("//*[@id=\"FirstName\"]");
	By txtLastname = By.xpath("//*[@id=\"LastName\"]");
	
	By rdMaleGender = By.id("Gender_Male");
	By rdFemaleGender = By.id("Gender_Female");
	
	By txtDob = By.xpath("//*[@id=\"DateOfBirth\"]");
	
	By txtCompanyname = By.xpath("//*[@id=\"Company\"]");
	
	By chkTax = By.xpath("//*[@id=\"IsTaxExempt\"]");
	
	By txtNewsletter = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div/div");
	
	By lstitemYourstorename = By.xpath("//*[@id=\"deb7610c-7625-4177-a58b-675792e36db6\"]");
	By lstitemTststore2 = By.xpath("//*[@id=\"SelectedNewsletterSubscriptionStoreIds_listbox\"]/li[2]");
	
	By txtcustomerRoles = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
	
	By lstitemAdministrators = By.xpath("//*[@id=\"26992197-aadf-4f66-ae88-2bbfe0df8e45\"]");
	By lstitemForumModerators = By.xpath("//*[@id=\"26992197-aadf-4f66-ae88-2bbfe0df8e45\"]");
	By lstitemGuests = By.xpath("//*[@id=\"26992197-aadf-4f66-ae88-2bbfe0df8e45\"]");
	By lstitemRegistered = By.xpath("//*[@id=\"26992197-aadf-4f66-ae88-2bbfe0df8e45\"]");
	By lstitemvendors = By.xpath("//*[@id=\"26992197-aadf-4f66-ae88-2bbfe0df8e45\"]");
	
	By drpmgrOfvendor = By.xpath("//*[@id=\"VendorId\"]");
	
	By chkActive = By.xpath("//*[@id=\"Active\"]");
	
	By txtComment = By.xpath("//*[@id=\"AdminComment\"]");
	
	By btnSave = By.xpath("/html/body/div[3]/div[1]/form/div[1]/div/button[1]");
	
	public void clickOnCustomerMenu() {
		ldriver.findElement(lnkCustomers_menu).click();
	}
	public void clickOnCustomerMenuItem() {
		ldriver.findElement(lnkCustomers_menuitem).click();
	}
	public void clickOnAddnew() {
		ldriver.findElement(btnAddnew).click();
	}
	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	public void setPassword(String pwd) {
		ldriver.findElement(txtPassword).sendKeys(pwd);
	}
	public void setFirstname(String fname) {
		ldriver.findElement(txtFirstname).sendKeys(fname);
	}
	public void setLastname(String lname) {
		ldriver.findElement(txtLastname).sendKeys(lname);
	}
	public void setGender(String gender) {
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdMaleGender).click();
		}
		else if(gender.equals("Female"))
		{
			ldriver.findElement(rdFemaleGender).click();
		}
		else
		{
			ldriver.findElement(rdMaleGender).click();//default
		}
	}
	public void setDob(String dob) {
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	public void setCompanyname(String cname) {
		ldriver.findElement(txtCompanyname).sendKeys(cname);
	}
	public void setTaxExempt() {
		ldriver.findElement(chkTax).click();
	}
	public void setNewsletter(String letter) {
		ldriver.findElement(txtNewsletter).click();
		WebElement list=null;
		switch(letter)
		{
		case "Your store name":
			list = ldriver.findElement(lstitemYourstorename);break;
		case "Test store 2":
			list = ldriver.findElement(lstitemTststore2);break;	
		}
		JavascriptExecutor  jsc = (JavascriptExecutor)ldriver;
		jsc.executeScript("arguments[0].click();", list);
	}
	public void setCustomerRoles(String role) {
		
		ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]")).click();
		ldriver.findElement(txtcustomerRoles).click();
		
		WebElement listitem;
		
		switch(role)
		{
		case "Administrators":
			listitem = ldriver.findElement(lstitemAdministrators);break;
		case "Forum Moderators":
			listitem = ldriver.findElement(lstitemForumModerators);break;
		case "Guests":
			listitem = ldriver.findElement(lstitemGuests);break;
		case "Registered":
			listitem = ldriver.findElement(lstitemRegistered);break;
		case "Vendors":
			listitem = ldriver.findElement(lstitemvendors);break;
		default:
			listitem = ldriver.findElement(lstitemGuests);
		}
		
		//listitem.click();//will not work
		
		JavascriptExecutor  js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listitem);
	}
	public void setManagerOfVendor(String value)
	{
		Select drp = new Select(ldriver.findElement(drpmgrOfvendor));
		drp.selectByVisibleText(value);
	}
	public void setActive() {
		ldriver.findElement(chkActive).click();
	}
	public void setComment(String cmt) {
		ldriver.findElement(txtComment).sendKeys(cmt);
	}
	public void clickOnSave()
	{
		ldriver.findElement(btnSave).click();
	}
}
