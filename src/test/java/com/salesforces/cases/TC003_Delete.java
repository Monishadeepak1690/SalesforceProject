package com.salesforces.cases;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_Delete {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		
		ChromeDriver driver=new ChromeDriver(options);
		
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
		
		//driver.executeScript("arguments[0].click();",opportunity1);
		String name="Salesforce Automation by Monisha";
		
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(name+Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//tbody/tr/td[8]//a")).click();
		
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		
		driver.findElement(By.xpath("//button[@title='Cancel Service Appointment']")).click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		
		
		
		
		
		
		
	}

}
