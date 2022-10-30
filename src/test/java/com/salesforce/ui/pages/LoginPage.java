package com.salesforce.ui.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.salesforces.cases.ProjectSpecificMethodsSelBootCamp;

public class LoginPage extends ProjectSpecificMethodsSelBootCamp {
	
	  public LoginPage(RemoteWebDriver driver) 
	  {
	  this.driver=driver; 
	  }	 
	
	
	
	public LoginPage enterUserName(String username) {
		
		//WebElement elementUsername=driver.findElement(By.id("username"));
		//  elementUsername.sendKeys("hari.radhakrishnan@qeagle.com");
		//driver.findElement(By.id(prop.getProperty("LoginPage.id"))).sendKeys(username);
		driver.findElement(By.id(prop.getProperty("LoginPage.username.id"))).sendKeys(username);
		
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		//WebElement elementPassword=driver.findElement(By.id("password"));
		  //elementPassword.sendKeys("India$4321");
		//driver.findElement(By.id(prop.getProperty("LoginPage.password.id"))).sendKeys(password);
		driver.findElement(By.id(prop.getProperty("LoginPage.password.id"))).sendKeys(password);
		return this;
	}
	
	public HomePage clickLogin() throws InterruptedException {
		  driver.findElement(By.xpath("//input[@type='submit']")).click();
		  Thread.sleep(2000);
		//driver.findElement(By.id(prop.getProperty("LoginPage.LoginButton.id"))).click();
		return new HomePage(driver);
	}



}