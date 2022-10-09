package com.salesforces.cases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class ProjectSpecificMethodsSelBootCamp {

	public static RemoteWebDriver driver;
	public String excelFileName ;

	@Parameters({ "URL", "BROWSER_NAME" })
	@BeforeMethod
	public void precondotion(String url, String BrowserName) throws InterruptedException {

		if (BrowserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options=new ChromeOptions();
			 options.addArguments("--disable-notifications");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if (BrowserName.equalsIgnoreCase("edge")) {
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
		}
		/*
		 * WebDriverManager.chromedriver().setup(); ChromeOptions options=new
		 ChromeOptions(); options.addArguments("--disable-notifications");
		 */

		// driver=new ChromeDriver(options);
		// driver.get(url);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
	}
	
	@AfterMethod
	public void postcondition() {

		driver.close();
		// driver.quit();
		
	}
	@DataProvider(name="Dynamic_Data")
	public String[][] testData() throws IOException  {
		String[][] data= ReadExcel.getData(excelFileName);
		return data;
	}
}



	/*
	 * WebElement elementUsername=driver.findElement(By.id("username"));
	 * elementUsername.sendKeys("hari.radhakrishnan@qeagle.com"); WebElement
	 * elementPassword=driver.findElement(By.id("password"));
	 * elementPassword.sendKeys("India$321");
	 * driver.findElement(By.xpath("//input[@type='submit']")).click();
	 * Thread.sleep(2000);
	 * 
	 * }
	 */
	

/*
 * @DataProvider(name="Dynamic_Data") public String[][] testdata() { String[][]
 * data=new String[2][5] ;
 * 
 * data[0][0]="hari.radhakrishnan@qeagle.com"; data[0][1]="India$321";
 * data[0][2]="5655"; data[0][3]="test"; data[0][4]="high";
 * 
 * data[1][0]="hari.radhakrishnan@qeagle.com"; data[1][1]="India$321";
 * data[1][2]="5455"; data[1][3]="tfdst"; data[1][4]="dff";
 * 
 * 
 * data[2][0]="hari.radhakrishnan@qeagle.com"; data[2][1]="India$321";
 * data[2][2]="5655"; data[2][3]="test"; data[2][4]="high";
 * 
 * 
 * return data;
 */
