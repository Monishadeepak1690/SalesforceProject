package com.salesforces.cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC009_CancelServiceAppoinment {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		
		
		ChromeDriver driver=new ChromeDriver(options);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		
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
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Service ");
		

		
		
		//WebElement Service = driver.findElement(By.xpath("//p[text()='Service Appointments']"));
		//driver.executeScript("argument[0].click;",Service);
		
		 driver.findElement(By.xpath("//ul[contains(@class,'al-modal-list slds-grid')]//li[1]")).click();
	    //JavascriptExecutor js = (JavascriptExecutor)driver;
	    //js.executeScript("window.scrollBy(250,0)", "");

	
		
		//WebElement Service = driver.findElement(By.xpath("//p[text()='Service Appointments']"));
		//driver.executeScript("argument[0].click;",Service);
		
		 driver.findElement(By.xpath("(//span[text()='Recently Viewed'])[3]")).click();
		 
		 driver.findElement(By.xpath("(//span[text()='All Service Appointments'])[1]")).click();
		 //driver.findElement(By.xpath("//a[@title='Show 3 more actions']")).click();
		 driver.findElement(By.xpath("//tbody/tr/td[10]//a")).click();
		 driver.findElement(By.xpath("//a[@title='Cancel Service Appointment']")).click();
		 driver.findElement(By.xpath("//button[text()='Confirm Cancellation']")).click();
		 String text1="Canceled";
				WebElement text2= driver.findElement(By.xpath("(//a[text()='Canceled'])[2]"));
				String actual=text2.getText();
				Assert.assertEquals(text1,actual);
				System.out.println("Done");
				
				
		 
	
		 
		 
		 
	}

}
