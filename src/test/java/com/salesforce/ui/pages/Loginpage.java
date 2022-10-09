package com.salesforce.ui.pages;

import org.openqa.selenium.By;

import com.salesforces.cases.ProjectSpecificMethodsSelBootCamp;

public class Loginpage extends ProjectSpecificMethodsSelBootCamp {
public Loginpage enterUsername(String username)
{
	
	driver.findElement(By.id("username")).sendKeys(username);
	return this;
}
public Loginpage enterPassword(String password)
{
	  driver.findElement(By.id("password")).sendKeys(password);
	return this; 
		 
}

public Homepage clickLoginButton_Positive()

{
	driver.findElement(By.id("Login")).click();	
	return new Homepage();
	
}

public Loginpage clickLoginButton_Negative()

{
	driver.findElement(By.id("Login")).click();	
	return this;
	
}

}
