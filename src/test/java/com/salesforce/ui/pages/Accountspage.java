package com.salesforce.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.salesforces.cases.ProjectSpecificMethodsSelBootCamp;

public class Accountspage extends ProjectSpecificMethodsSelBootCamp {
	public Accountspage clickNew()
	{
		driver.findElement(By.xpath("//div[text()='New']")).click();
		return this;
	}
	public Accountspage enterAccountName(String Account)
	
	{
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(Account);
		return this;
	}
	public Accountspage enterAccountNumber()
	{
		driver.findElement(By.xpath("//input[@name='AccountNumber']")).sendKeys("3165");
		return this;
	}
	public Accountspage enterFax(String Fax)
	{
		driver.findElement(By.xpath("//input[@name='Fax']")).sendKeys(Fax);
		return this;
	}
	public Accountspage enterWebsite(String Website)
	{
		driver.findElement(By.xpath("//input[@name='Website']")).sendKeys(Website);
		return this;
	
	}
	public Accountspage selectOwnership()
	{
		WebElement Ownership = driver.findElement(By.xpath("(//button[@data-value='--None--'])[3]"));
		driver.executeScript("arguments[0].click();",Ownership);
		driver.findElement(By.xpath("//span[@title='Public']")).click();
		return this;
	}
	public Accountspage clicksave()
	{
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		return this;
	}
	
	}
