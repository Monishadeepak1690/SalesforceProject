package com.salesforces.cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_CreateOpportunity {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		//Launch Salesforce
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		//click on login
		driver.findElement(By.id("Login")).click();
		
		//2. Click on toggle menu button from the left corner
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		//3. Click view All and click Sales from App Launcher
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		
		WebElement opportunity=driver.findElement(By.xpath("(//span[@class='slds-truncate'])[3]")); 
		driver.executeScript("arguments[0].click();",opportunity);
		//Click on New
		driver.findElement(By.xpath("//div[text()='New']")).click();
		
		WebElement getName=driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input"));
		getName.sendKeys("Salesforce Automation by Monisha");
		String name=getName.getAttribute("value");
		
		//Select drop-down
		driver.findElement(By.xpath("(//div[@role='none'])[2]/button")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		//Click on Close Date
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//button[@name='today']")).click();
		//Click on Save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		//Click on Opportunity
		String actual=driver.findElement(By.xpath("//slot[@name='primaryField']//lightning-formatted-text")).getText();
		//Verify the name
		Assert.assertEquals(actual, name);
		System.out.println("Done !!");
		
		

	}

}
