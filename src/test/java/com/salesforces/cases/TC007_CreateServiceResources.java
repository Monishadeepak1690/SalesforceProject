package com.salesforces.cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC007_CreateServiceResources {

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
		Thread.sleep(3000);
		
		//3. Click view All and click Sales from App Launcher
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Service");
		driver.findElement(By.xpath("//a[@data-label='Service Resources']//span//mark[contains(text(),'Service')]")).click();
		driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']//span[1]")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		
		
driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();

		
		driver.findElement(By.xpath("//input[@class=' input']")).clear();
		String ActualValue ="Monisha Baskaran";
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys(ActualValue);
		
		
		
		
//driver.findElement(By.xpath("//input[@id='4497:0']")).clear();
//driver.findElement(By.xpath("(//span[text()='Name'])[1]")).sendKeys("Monisha Baskaran");
		//driver.executeScript("arguments[0].click();",findElement);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='Save']")).click();
WebElement actual=driver.findElement(By.xpath("//span[text()='Service Resource']"));
String value=actual.getText();
System.out.println(value);
Assert.assertEquals(ActualValue,value);

System.out.println("Done");


		
		
		
		
	}

}
