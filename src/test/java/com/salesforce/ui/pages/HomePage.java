package com.salesforce.ui.pages;




import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.JavascriptExecutor;

import com.salesforces.cases.ProjectSpecificMethodsSelBootCamp;

public class HomePage extends ProjectSpecificMethodsSelBootCamp  {
	 public HomePage (RemoteWebDriver driver) 
	  {
	  this.driver=driver; 
	  }	 
	
	
	

	  //PageFactory.initElements(driver,this); }
	 
	
	public HomePage clickAppLauncher() throws InterruptedException {

		//driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath(prop.getProperty("HomePage.clickAppLauncher.xpath"))).click();
		return this;
		
		
	}
	
	public HomePage clickOnViewAll() {
		//driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath(prop.getProperty("HomePage.clickOnViewAll.xpath"))).click();
		return this;
	}
	
	public HomePage searchAppLauncher() {
		//driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys(module);
		//driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
		
		driver.findElement(By.xpath(prop.getProperty("HomePage.searchAppLauncher.xpath"))).sendKeys("Sales");
		return this;
	}
	public HomePage clickOnSales() {
		//driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		driver.findElement(By.xpath(prop.getProperty("HomePage.clickOnSales.xpath"))).click();
		return this;
		
	}

	public AccountsPage clickOnAccountsTab()
	{
		WebElement accounts = driver.findElement(By.xpath(prop.getProperty("AccountsPage.clickOnAccountsTab.xpath")));
		driver.executeScript("arguments[0].click();",accounts);
	
		
		return new AccountsPage(driver);
	}





}