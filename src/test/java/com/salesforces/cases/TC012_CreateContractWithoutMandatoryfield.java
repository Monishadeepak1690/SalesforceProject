package com.salesforces.cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC012_CreateContractWithoutMandatoryfield {

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
		
		
		
WebElement test=driver.findElement(By.xpath("(//span[text()='Contracts']//following::lightning-icon)[1]"));
driver.executeScript("arguments[0].click();",test);


	WebElement Newcontract=driver.findElement(By.xpath("//span[text()='New Contract']"));
	driver.executeScript("arguments[0].click();",Newcontract);
	Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
		
		
driver.findElement(By.xpath("//div[@title='Monisha Unique']"));
driver.executeScript("arguments[0].click();",Newcontract);	
Thread.sleep(3000);

driver.findElement(By.xpath("(//div[@class='form-element']//input)[1]")).sendKeys("9/18/2022");

driver.findElement(By.xpath("//button[@title='Save']")).click();
Thread.sleep(3000);

WebElement test1 = driver.findElement(By.xpath("//li[text()='These required fields must be completed: Account Name, Contract Term (months)']"));
String actual=test1.getText();
System.out.println(actual);
String expected= "These required fields must be completed: Account Name, Contract Term (months)";
Assert.assertEquals(actual,expected);
System.err.println("done");


		
		
	}

}
