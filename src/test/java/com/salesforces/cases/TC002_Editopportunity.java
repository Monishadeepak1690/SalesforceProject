package com.salesforces.cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_Editopportunity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		
		ChromeDriver driver=new ChromeDriver(options);
		
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement elementUsername=driver.findElement(By.id("username"));
		elementUsername.sendKeys("hari.radhakrishnan@qeagle.com");
		WebElement elementPassword=driver.findElement(By.id("password"));
		elementPassword.sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("sales");
		driver.findElement(By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']")).click();
		
		WebElement opportunity=driver.findElement(By.xpath("(//span[@class='slds-truncate'])[3]"));
		driver.executeScript("arguments[0].click();",opportunity);		
		

		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Salesforce Automation by Monisha"+Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//tbody/tr/td[8]//a")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
	
		WebElement closeDate=driver.findElement(By.xpath("//input[@name='CloseDate']"));
		driver.executeScript("arguments[0].click();",closeDate);
		
		WebElement date = driver.findElement(By.xpath("//label[text()='Close Date']/following-sibling::div[1]/input"));
		date.clear();
		date.sendKeys("9/17/2022");

		driver.findElement(By.xpath("//button[text()='Save']")).click();

		driver.findElement(By.xpath("(//span[@class='toastMessage slds-text-heading--small forceActionsText']")).click();

		String actualText = driver.findElement(By.xpath("(//span[text()='Close Date'])[2]/following::span[1]//lightning-formatted-text")).getText();

		Assert.assertEquals(actualText, "9/11/2022");

		
	}

}
