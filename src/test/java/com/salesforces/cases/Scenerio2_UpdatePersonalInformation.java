package com.salesforces.cases;

import java.security.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenerio2_UpdatePersonalInformation {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//1. Login to the application
		driver.get("http://automationpractice.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		 	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("MonishaB@example.com");
		 	driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Password123");
driver.findElement(By.xpath("//span[normalize-space()='Sign in']")).click();
Thread.sleep(5000);


driver.findElement(By.xpath("//a[@class='account']")).click();
driver.findElement(By.xpath("//a[@title='Information']")).click();
WebElement firstname = driver.findElement(By.xpath("//input[@id='firstname']"));
String Name=firstname.getText();
System.out.println(firstname.getText());
firstname.clear();
firstname.sendKeys("Monisha ",Keys.TAB);
driver.findElement(By.xpath("//input[@name='old_passwd']")).sendKeys("Password123");
driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("Password123");
driver.findElement(By.xpath("//input[@name='confirmation']")).sendKeys("Password123");
driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();





	}

}
