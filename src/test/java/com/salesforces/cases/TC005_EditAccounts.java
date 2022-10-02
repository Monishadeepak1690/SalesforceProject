package com.salesforces.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005_EditAccounts extends ProjectSpecificMethodsSelBootCamp {
	@Test
	public void editAccount() throws InterruptedException {
		

		/*
		 * WebDriverManager.chromedriver().setup(); ChromeOptions options=new
		 * ChromeOptions(); options.addArguments("--disable-notifications");
		 * ChromeDriver driver=new ChromeDriver(options); JavascriptExecutor js =
		 * (JavascriptExecutor) driver;
		 * 
		 * //Launch Salesforce driver.get("https://login.salesforce.com/");
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 * 
		 * driver.findElement(By.id("username")).sendKeys(
		 * "hari.radhakrishnan@qeagle.com");
		 * driver.findElement(By.id("password")).sendKeys("India$321"); //click on login
		 * driver.findElement(By.id("Login")).click();
		 */
	
	//2. Click on toggle menu button from the left corner
	
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	
	//3. Click view All and click Sales from App Launcher
	
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
	driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
	
	
	//5. Click on Accounts tab 
	WebElement accounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
	driver.executeScript("arguments[0].click();",accounts);
	
	
	//6.Search for the Account Using the unique account name created by you
	driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("Monisha Unique"+Keys.ENTER);
	Thread.sleep(5000);
	
	//7. Click on the displayed Account Dropdown icon and select Edit
	//driver.findElement(By.xpath("//table[contains(@class,'slds-table forceRecordLayout')]")).click();
	
	
	
	
	driver.findElement(By.xpath("(//a[contains(@class,'slds-button slds-button--icon-x-small')])[1]")).click();
	driver.findElement(By.xpath("//a[@title='Edit']")).click();

	//driver.findElement(By.xpath("//label[text()='Phone']/following-sibling::div/input")).sendKeys("9952049027");
	//Thread.sleep(2000);


	driver.findElement(By.xpath("(//div[@role='none']//button)[2]")).click();
	WebElement type = driver.findElement(By.xpath("//span[@title='Technology Partner']"));
	driver.executeScript("arguments[0].click();", type);

	WebElement click_industry = driver.findElement(By.xpath("//label[text()='Industry']/following-sibling::div[1]//button"));
	driver.executeScript("arguments[0].click();", click_industry);
	WebElement industry = driver.findElement(By.xpath("//span[@title='Healthcare']"));
	driver.executeScript("arguments[0].click();", industry);

	//"arguments[0].value='"+ value +"';"
	String billingAddress = "101 Billing Address";
	WebElement billingStreet = driver.findElement(By.xpath("//label[text()='Billing Street']/following-sibling::div/textarea"));
	driver.executeScript("arguments[0].value='"+ billingAddress +"';", billingStreet);
	String shippingAddress = "201 Shipping Address";
	WebElement shippingStreet = driver.findElement(By.xpath("//label[text()='Shipping Street']/following-sibling::div/textarea"));
	driver.executeScript("arguments[0].value='"+ shippingAddress +"';", shippingStreet);

	Thread.sleep(3000);
	WebElement customerPriority = driver.findElement(By.xpath("//label[text()='Customer Priority']/following-sibling::div[1]//button"));
	driver.executeScript("arguments[0].click();", customerPriority);
	WebElement customerPriorityValue = driver.findElement(By.xpath("//span[@title='Low']"));
	driver.executeScript("arguments[0].click();", customerPriorityValue);

	Thread.sleep(3000);
	WebElement sla = driver.findElement(By.xpath("//label[text()='SLA']/following-sibling::div[1]//button"));
	driver.executeScript("arguments[0].click();", sla);
	WebElement slaValue = driver.findElement(By.xpath("//span[@title='Silver']"));
	driver.executeScript("arguments[0].click();", slaValue);

	Thread.sleep(3000);
	WebElement active = driver.findElement(By.xpath("//label[text()='Active']/following-sibling::div[1]//button"));
	driver.executeScript("arguments[0].click();", active);
	WebElement activeValue = driver.findElement(By.xpath("(//span[text()='No'])[2]"));
	driver.executeScript("arguments[0].click();", activeValue);

	Thread.sleep(3000);
	WebElement upsellOpty = driver.findElement(By.xpath("//label[text()='Upsell Opportunity']/following-sibling::div[1]//button"));
	driver.executeScript("arguments[0].click();", active);
	
	driver.findElement(By.xpath("(//span[text()='No'])[1]")).click();
	//driver.executeScript("arguments[0].click();", upsellOptyValue);
	Thread.sleep(3000);

	driver.findElement(By.xpath("//button[text()='Save']")).click();
	//label[text()='Upsell Opportunity']/following-sibling::div[1]//button

	driver.findElement(By.xpath("(//a[text()='Details'])[1]")).click();

	String actualText = driver.findElement(By.xpath("//span[text()='Type']/following::span[1]//lightning-formatted-text")).getText();

	Assert.assertEquals(actualText, "Technology Partner");

	driver.close();

	
	
	
	
	}
	
	
	
	
}
