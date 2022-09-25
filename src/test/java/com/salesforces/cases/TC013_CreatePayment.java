package com.salesforces.cases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC013_CreatePayment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
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
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("payment");
		//driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		
		
		WebElement payment= driver.findElement(By.xpath("//a[@data-label='Payments']"));
		driver.executeScript("arguments[0].click();",payment);	
		
		WebElement New = driver.findElement(By.xpath("//a[@title='New'][@class='forceActionLink']"));
		driver.executeScript("arguments[0].click();",New);	
		
	
		
		
		
		
		
		WebElement status = driver.findElement(By.xpath("(//a[@class='select'])[1]"));
		driver.executeScript("arguments[0].click();",status);
		driver.findElement(By.xpath("//a[@title='Processed']")).click();
		
	
	
		
		WebElement Type = driver.findElement(By.xpath("(//a[@class='select'])[2]"));
		driver.executeScript("arguments[0].click();",Type);
		driver.findElement(By.xpath("//a[@title='Capture']")).click();
		
		
		
		driver.findElement(By.xpath("//input[@class='input uiInputSmartNumber']")).sendKeys("850");
		
		
		
		WebElement processing = driver.findElement(By.xpath("(//div[@class='uiPopupTrigger']//a)[3]"));
		driver.executeScript("arguments[0].click();",processing);
		
		driver.findElement(By.xpath("//a[@title='External']")).click();
		
		
		
		driver.findElement(By.xpath("//button[@title='Save']")).click();//a[@title='External']

		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toast')]")));
		String toastText = driver.findElement(By.xpath("//span[contains(@class,'toast')]")).getText();
		System.out.println("Toast message is : " + toastText);
		
		
		
		
		
		
		
		
		
		


		
		
		
		
		
		
		
		
		
		
	
		
		

	}

}
