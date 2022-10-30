package com.salesforces.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
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

		@BeforeTest
		public void setData() {
			 excelFileName = "TC002_EditAccount";
		}

		/*
		  WebDriverManager.chromedriver().setup(); ChromeOptions options=new
		  ChromeOptions(); options.addArguments("--disable-notifications");
		  ChromeDriver driver=new ChromeDriver(options); JavascriptExecutor js =
		  (JavascriptExecutor) driver;
		  
		  //Launch Salesforce driver.get("https://login.salesforce.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);*/
		  
		
		 
	
	//2. Click on toggle menu button from the left corner
	@Test(dataProvider="Dynamic_Data")
	public void editAccount(String username,String password,String accountname,String phonenumber,String address ) throws InterruptedException {
		  driver.findElement(By.id("username")).sendKeys(username);
		  driver.findElement(By.id("password")).sendKeys(password); //click on login
		  driver.findElement(By.id("Login")).click();
	
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	
	//3. Click view All and click Sales from App Launcher
	
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
	driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
	
	
	//5. Click on Accounts tab 
	WebElement accounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
	driver.executeScript("arguments[0].click();",accounts);
	
	
	//6.Search for the Account Using the unique account name created by you
	driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys( accountname +Keys.ENTER);
	Thread.sleep(5000);
	
	//7. Click on the displayed Account Dropdown icon and select Edit
	//driver.findElement(By.xpath("//table[contains(@class,'slds-table forceRecordLayout')]")).click();
	
	
	Thread.sleep(3000);
	  driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a")).click(); 
	  //Click on Edit button 
	  driver.findElement(By.xpath("//a[@title='Edit']")).click();
	  Thread.sleep(2000); 
	  //Edit Phone number 
	  WebElement ele_phone=driver.findElement(By.xpath("//input[@name='Phone']"));
	  ele_phone.clear(); 
	  Thread.sleep(2000); 
	  ele_phone.sendKeys(phonenumber); 
	   	
	//driver.findElement(By.xpath("//label[text()='Phone']/following-sibling::div/input")).sendKeys("9952049027");
	//Thread.sleep(2000);
	//Click and Edit Type 
	  driver.findElement(By.xpath("//label[text()='Type']//parent::lightning-combobox//child::button")).click(); 
	  //Select Type
	  driver.findElement(By.xpath("//span[@title='Technology Partner']")).click();
	//Click and Edit Type 
	  WebElement click_industry = driver.findElement(By.xpath("//label[text()='Industry']/following-sibling::div[1]//button"));
	driver.executeScript("arguments[0].click();", click_industry);
	WebElement industry = driver.findElement(By.xpath("//span[@title='Healthcare']"));
	driver.executeScript("arguments[0].click();", industry);

	//"arguments[0].value='"+ value +"';"
	WebElement billing=driver.findElement(By.xpath("//label[text()='Billing Street']//following-sibling::div//textarea"));
	  driver.executeScript("arguments[0].value='"+address+"';", billing); 
	  //Enter Shipping address 
	  driver.findElement(By.xpath("//label[text()='Shipping Street']//parent::lightning-textarea//child::textarea")).sendKeys("Shipping address"); 
	  //Click on Customer Priority
	  WebElement cust_priority=driver.findElement(By.xpath("//label[text()='Customer Priority']//parent::lightning-combobox//child::span")); 
	  driver.executeScript("arguments[0].click();", cust_priority); 
	  //Select Low 
	  driver.findElement(By.xpath("//span[@title='Low']")).click(); 
	  //Click on SLA 
	  driver.findElement(By.xpath("//label[text()='SLA']//parent::lightning-combobox//descendant::button")).click(); 
	  //Select Silver
	  driver.findElement(By.xpath("//span[@title='Silver']")).click(); 
	  //Click on Active 
	  driver.findElement(By.xpath("//label[text()='Active']//parent::lightning-combobox//child::span")).click();
	  //Select No 
	  driver.findElement(By.xpath("//span[@title='No']")).click();
	  //Click on Upsell Opportunity 
	  driver.findElement(By.xpath("//label[text()='Upsell Opportunity']//parent::lightning-combobox//child::button")).click(); 
	  //Select No
	  driver.findElement(By.xpath("//span[@title='No']")).click(); //Click on Save
	  driver.findElement(By.xpath("//button[text()='Save']")).click(); 
	  Thread.sleep(3000); 
		/*
		 * String phone_num=driver.findElement(By.xpath(
		 * "//tbody//tr[1]//td[4]//span[@dir='ltr']")).getText();
		 * output=driver.findElement(By.xpath("//tbody//tr[1]//td[4]//span[@dir='ltr']")
		 * ).getText(); System.out.println("In Edit Class: "+output);
		 * validationInput=phone;
		 * 
		 * Assert.assertEquals(phone_num, phone);
		 */
}
}