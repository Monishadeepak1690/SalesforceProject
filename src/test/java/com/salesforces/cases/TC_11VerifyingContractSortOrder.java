package com.salesforces.cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_11VerifyingContractSortOrder {


		public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

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
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Contract");
		Thread.sleep(3000);
		
		WebElement contract=driver.findElement(By.xpath("//a[@data-label='Contracts']"));
		driver.executeScript("arguments[0].click();",contract);	
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//th[@title='Contract Number']//lightning-primitive-icon")).click();
		WebElement arrow = driver.findElement(By.xpath("//span[@title='Contract Number']"));
		Actions action=new Actions(driver);
		action.moveToElement(arrow).perform();
		arrow.click();
	
		
		
	}

}
