package com.salesforces.cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenerio1_OrderTShirt {

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
		driver.findElement(By.xpath("(//a[@title='T-shirts'])[2]")).click();
		
		
		WebElement tshirt = driver.findElement(By.xpath("(//a[@title='Faded Short Sleeve T-shirts'])[2]"));
		
		Actions action=new Actions(driver);
		action.moveToElement(tshirt).click().perform();
		
		driver.findElement(By.xpath("//span[text()='Add to cart']")).click();
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
		
		WebElement product = driver.findElement(By.xpath("//p[@class='product-name']"));
		String ProductName=product.getText();
		System.out.println(ProductName);
		
		
		driver.findElement(By.xpath("(//a[@title='Proceed to checkout'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
		driver.findElement(By.xpath("//input[@id='cgv']")).click();
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		driver.findElement(By.xpath("//a[@class='bankwire']")).click();
		driver.findElement(By.xpath("//span[text()='I confirm my order']")).click();
		
		
		//WebElement sku = driver.findElement(By.xpath("(//p[@class='product-name']//following::small)[1]"));
		//String demo=sku.getText();
		
		//WebElement Size = driver.findElement(By.xpath("(//p[@class='product-name']//following::small)[2]"));
		//String Color=sku.getText();
		
		driver.findElement(By.xpath("//a[@class='account']")).click();
		
		driver.findElement(By.xpath("//a[@title='Orders']")).click();
		driver.findElement(By.xpath("//tr[contains(@class,'first_item')]//span[contains(text(),'Details')]")).click();
		
		driver.findElement(By.xpath("//label[contains(text(),'Faded Short Sleeve T-shirts - Color : Orange, Size')]")).click();
		WebElement order = driver.findElement(By.xpath("//div[@id='order-detail-content']/table[1]/tbody[1]/tr[1]/td[2]"));
		String producterorder=order.getText();
		System.out.println(producterorder);
		
		Assert.assertEquals(ProductName,producterorder );
		System.out.println("Done");
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
	}

}
