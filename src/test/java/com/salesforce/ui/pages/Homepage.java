package com.salesforce.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.salesforces.cases.ProjectSpecificMethodsSelBootCamp;

public class Homepage extends ProjectSpecificMethodsSelBootCamp  {
	public Homepage clickAppLaucher()
	{
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		return this;
	}
	public Homepage clickViewAll()
	{
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		return this;
	}
	public Accountspage clickAccounts()
	{
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		
		WebElement accounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();",accounts);
		return new Accountspage();
	}

}
