package com.salesforces.cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC006_CreateNewServiceAppointment {
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

	
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys("Creating Service appoinments"+Keys.ENTER);
		
		driver.findElement(By.xpath("(//input[contains(@class,'default input')])[2]")).sendKeys("Monisha Unique");
		driver.findElement(By.xpath("(//span[contains(@class,'itemLabel slds-truncate')])[2]")).click();
	
		
		
		driver.findElement(By.xpath("//span[text()='Account Name']/following::input[1]")).sendKeys("Monisha");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Earliest Start Permitted']/following::input")).sendKeys("9/17/2022");
		
		//driver.findElement(By.xpath("//input[@id='797:1134;a-time']")).click();
		//driver.findElement(By.xpath("//div[@id='2683:0']//li[@id='0130']")).sendKeys("6:00 AM");
	
		
		
		driver.findElement(By.xpath("(//label[@class='form-element__label']/following-sibling::input)[3]")).sendKeys("9/22/2022");
		
		driver.findElement(By.xpath("//button[@title='Save']//span[contains(@class,'label bBody')][normalize-space()='Save']")).click();
		
		String text =driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Service ");
		driver.findElement(By.xpath("//ul[contains(@class,'al-modal-list slds-grid')]//li[1]")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("SA-0007");
		
				
		
		
		
		
		
		
	}
}
