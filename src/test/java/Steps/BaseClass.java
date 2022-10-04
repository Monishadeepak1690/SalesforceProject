package Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends AbstractTestNGCucumberTests {
	public static ChromeDriver driver;

	@BeforeMethod
	public void preCondition() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	
	//1. Login to the application
	driver.get("http://automationpractice.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("MonishaB@example.com");
	 	driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Password123");
driver.findElement(By.xpath("//span[normalize-space()='Sign in']")).click();


}
	@AfterMethod
	public void PostCondition()
	{
		driver.close();
	}
}
