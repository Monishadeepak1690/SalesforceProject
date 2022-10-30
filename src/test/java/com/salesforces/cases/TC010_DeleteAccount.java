package com.salesforces.cases;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
	
public class TC010_DeleteAccount extends ProjectSpecificMethodsSelBootCamp {
	@Test

	@BeforeTest
	public void setData() {
		 excelFileName = "TC003_DeleteAccount";
	}

	

//2. Click on toggle menu button from the left corner
@Test(dataProvider="Dynamic_Data")
public void editAccount(String username,String password,String input ) throws InterruptedException {
	

	
	  driver.findElement(By.id("username")).sendKeys(username);
	  driver.findElement(By.id("password")).sendKeys(password); //click on login
	  driver.findElement(By.id("Login")).click();
	  
driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		driver.executeScript("arguments[0].click();", viewAll);

		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		WebElement account = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", account);

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(input, Keys.ENTER);

		Thread.sleep(3000);

		WebElement accountName = driver.findElement(By.xpath("(//a[text()='Monisha'])[1]"));
		driver.executeScript("arguments[0].click();", accountName);

		//driver.findElement(By.xpath("//button[text()='New Note']/ancestor::li/following-sibling::li//button")).click();
		driver.findElement(By.xpath("(//tbody/tr/td[6]//a)[1]")).click();
		//driver.findElement(By.xpath("//button[text()='New Note']/ancestor::li/following-sibling::li//div//span[text()='Delete']")).click();//a[@title='Delete'].click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		//Confirm Delete
		WebElement confirmation=driver.findElement(By.xpath("//h2[text()='Delete Account']/following::span[text()='Delete']"));
		driver.executeScript("arguments[0].click();", confirmation);
		Thread.sleep(4000);
		//Final Validation
		driver.navigate().refresh();
		//Search and select account
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(input);
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		boolean display=driver.findElement(By.xpath("//span[text()='No items to display.']")).isDisplayed();
		System.out.println("Display: "+display);
		Assert.assertEquals(display, true);
		System.out.println("Done !!");
		}

		


}
