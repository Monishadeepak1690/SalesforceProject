package com.salesforces.cases;


import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;
public class TC004_CreateAccount extends ProjectSpecificMethodsSelBootCamp {

	
	
	//login ,paassword,account ,fax,Website
	
	
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
		@BeforeTest
		public void setData() {
			 excelFileName = "TC001";
		}
		
		@Test(dataProvider="Dynamic_Data")
		public void createAccount(String username,String password,String Account,String Fax,String Website) throws InterruptedException {
		Thread.sleep(3000);
			
			 driver.findElement(By.id("username")).sendKeys(username);
					  driver.findElement(By.id("password")).sendKeys(password); //click on login
					 driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		
		//3. Click view All and click Sales from App Launcher
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		
		
		//4. Click on Accounts tab 
		WebElement accounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();",accounts);
		
		//5. Click on New button
		driver.findElement(By.xpath("//div[text()='New']")).click();
		
		//6. Enter 'your name' as account name
		//String Expected="Monisha Unique";
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Monisha Unique");
		//js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("//input[@name='AccountNumber']")).sendKeys(Account);
		driver.findElement(By.xpath("//input[@name='Fax']")).sendKeys(Fax);
		driver.findElement(By.xpath("//input[@name='Website']")).sendKeys(Website);
		
		
		//7. Select Ownership as Public   
		WebElement Ownership = driver.findElement(By.xpath("(//button[@data-value='--None--'])[3]"));
		driver.executeScript("arguments[0].click();",Ownership);
		
		
		//WebElement ownership = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]"));
		//int y=driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]")).getLocation().getY();
		//driver.executeScript("arguments[0].scrollIntoView();",ownership);
		
		//Action builder=new Action(driver);
		//builder.SendKeys(Keys.PAGE_DOWN).build().perform();
		//8. Click save and verify Account name 
		   
		driver.findElement(By.xpath("//span[@title='Public']")).click();
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		//Arvind Xpath :driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds-input_faux')])[3]")).click(); driver.findElement(By.xpath("//span[@title='Public']")).click();
		
		
		
	Thread.sleep(2000);
	/*
	 * String Actual = driver.findElement(By.
	 * xpath("//div[@class='slds-theme--success slds-notify--toast slds-notify slds-notify--toast forceToastMessage']"
	 * )).getText(); Assert.assertEquals(Actual,Expected);
	 * System.out.println("Done");
	 */


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}

}
