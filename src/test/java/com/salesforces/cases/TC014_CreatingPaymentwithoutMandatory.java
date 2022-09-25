package com.salesforces.cases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC014_CreatingPaymentwithoutMandatory {
@Test
	public void creatingPaymentwithoutMandatory() throws InterruptedException {

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
	
	//WebElement lightning = driver.findElement(By.xpath("class=\"switch-to-lightning\""));
	//driver.executeScript("arguments[0].click();",lightning);	
	
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
	
	WebElement Save = driver.findElement(By.xpath("//button[@title='Save']"));
	driver.executeScript("arguments[0].click();",Save);
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'These required fields must be completed: Amount, P')]")));
	String Text = driver.findElement(By.xpath("//li[contains(text(),'These required fields must be completed: Amount, P')]")).getText();
	System.out.println("Toast message is : " +Text);
	
}


}
