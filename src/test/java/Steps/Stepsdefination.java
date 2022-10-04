package Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Stepsdefination extends BaseClass{
	/*
	 * public ChromeDriver driver;
	 * 
	 * @Given("Launch the chrome browser") public void Launchthechromebrowser() {
	 * WebDriverManager.chromedriver().setup(); driver=new ChromeDriver();
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	 * 
	 * }
	 * 
	 * 
	 * @And("Load the url") public void Loadtheurl( ) {
	 * driver.get("http://automationpractice.com/"); }
	 * 
	 * 
	 * @And("Click on Sign in button") public void ClickonSigninbutton() {
	 * driver.findElement(By.xpath("//a[@title='Log in to your customer account']"))
	 * .click(); }
	 * 
	 * @And("Enter the username as MonishaB@example.com") public void
	 * Entertheusernameas()
	 * 
	 * { driver.findElement(By.xpath("//input[@id='email']")).sendKeys(
	 * "MonishaB@example.com"); }
	 * 
	 * @And("Enter the password as Password123") public void Enterthepasswordas() {
	 * driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Password123")
	 * ; }
	 * 
	 * @Then("Page should be signed with your name") public void
	 * Pageshouldbesignedwithyourname() {
	 * driver.findElement(By.xpath("//span[normalize-space()='Sign in']")).click();
	 * }
	 */		

		@Given("Click TShirts link")
		public void ClickTShirtslink()
		{
			driver.findElement(By.xpath("(//a[@title='T-shirts'])[2]")).click();
		}
		
		@When("Click on Faded short sleeve tshirt")
		public void ClickonFadedshortsleevetshirt()
		{
			WebElement tshirt = driver.findElement(By.xpath("(//a[@title='Faded Short Sleeve T-shirts'])[2]"));
			Actions action=new Actions(driver);
			action.moveToElement(tshirt).click().perform();
			
		}
		
		@When ("Click on Add to Cart")
		public void ClickonAddtoCart()
		{
			driver.findElement(By.xpath("//span[text()='Add to cart']")).click();
		}
		
		@And ("Click on Procced to checkout")
		public void ClickonProccedtocheckout()
		{
			driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
		}
		@When ("Click on Procced to checkout in summary page")
		public void ClickonProccedtocheckoutinsummarypage() {
			
			

			WebElement product = driver.findElement(By.xpath("//p[@class='product-name']"));
			String ProductName=product.getText();
			System.out.println(ProductName);
			
			driver.findElement(By.xpath("(//a[@title='Proceed to checkout'])[2]")).click();
		}
		@When ("Click on Procced to checkout in Address page")
		public void ClickonProccedtocheckoutinAddresspage()
		{
			driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
		}
		@When ("Click on checkbox Terms of Service in shipping page")
		public void ClickoncheckboxTermsofServiceinshippingpage()
		{
			driver.findElement(By.xpath("//input[@id='cgv']")).click();
		}
		@When ("Click on Procced to checkout in shipping page")
		public void ClickonProccedtocheckoutinshippingage()
		{
			driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		}
		@When ("Click on Pay by bank wire")
		public void ClickonPaybybankwire() {
			driver.findElement(By.xpath("//a[@class='bankwire']")).click();
		}
		
		@When ("click on I confirm my order")
		public void clickonIconfirmmyorder() {
			driver.findElement(By.xpath("//span[text()='I confirm my order']")).click();
		}
		@When ("click on the customer account")
		public void clickonthecustomeraccount()
		{
			driver.findElement(By.xpath("//a[@class='account']")).click();
		}
		
		@And ("Click on order history")
		public void Clickonorderhistory() {
			driver.findElement(By.xpath("//a[@title='Orders']")).click();
		}
		@And ("Click on Details")
		public void ClickonDetails() {
			driver.findElement(By.xpath("//tr[contains(@class,'first_item')]//span[contains(text(),'Details')]")).click();
			}
		
		@Then("Product name should be displayed")
		public void Productnameshouldbedisplayed()
		{
			driver.findElement(By.xpath("//label[contains(text(),'Faded Short Sleeve T-shirts - Color : Orange, Size')]")).click();
			WebElement order = driver.findElement(By.xpath("//div[@id='order-detail-content']/table[1]/tbody[1]/tr[1]/td[2]"));
			String producterorder=order.getText();  
			System.out.println(producterorder);
			
			//Assert.assertEquals(ProductName,producterorder );
			System.out.println("Done");
			
		}
		
	//Scenerio:	TC002 _Updating personal information
		
		@Given ("Click on profile name")
		public void Clickonprofilename()
		{
			driver.findElement(By.xpath("//a[@class='account']")).click();	
		}
		@And ("Click on Personal information")
		public void ClickonPersonalinformation()
		{
			driver.findElement(By.xpath("//a[@title='Information']")).click();
		}
		@And ("Enter First Name")
		public void EnterFirstName()
		{
			WebElement firstname = driver.findElement(By.xpath("//input[@id='firstname']"));
			String Name=firstname.getText();
			System.out.println(firstname.getText());
			firstname.clear();
			firstname.sendKeys("Monisha Baskaran ",Keys.TAB);
			
		}
		@And ("Enter Current Password")
		public void EnteronCurrentPassword()
		{
			driver.findElement(By.xpath("//input[@name='old_passwd']")).sendKeys("Password123");
		}
		@And ("Enter New password")
		public void EnterNewpassword()
		{
			driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("Password123");
		}
		@And ("Enter Confirmation Password")
		public void EnterConfirmationPassword()
		{
			driver.findElement(By.xpath("//input[@name='confirmation']")).sendKeys("Password123");
		}
		
		@When ("Click on save button")
		public void Clickonsavebutton()
		{
			driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		}
		@Then("Account Name should be updated")
		public void AccountNameshouldbeupdated()
		{
			driver.findElement(By.xpath("//a[@class='account']")).click();	

		}
		}
	


