package com.salesforce.ui.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.ui.pages.Loginpage;
import com.salesforces.cases.ProjectSpecificMethodsSelBootCamp;

public class TC001_CreateAccount extends ProjectSpecificMethodsSelBootCamp{
	@BeforeTest
	public void setData() {
		 excelFileName = "TC001";
	}
	@Test(dataProvider="Dynamic_Data")
	public void createAccount(String username,String password,String Account,String Fax,String Website) throws InterruptedException {
		new Loginpage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton_Positive()
		.clickAppLaucher()
		.clickViewAll()
		.clickAccounts()
		.clickNew()
		.enterAccountName(Account)
		.enterAccountNumber()
		.enterFax(Fax)
		.enterWebsite(Website)
		.selectOwnership()
		.clicksave();
		
	
}
		
		
		
	}


