package com.salesforce.ui.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.salesforces.cases.ProjectSpecificMethodsSelBootCamp;

public class AccountsPage extends ProjectSpecificMethodsSelBootCamp {
	
	
	 public AccountsPage(RemoteWebDriver driver) {
	 this.driver=driver; 
	  }
	
	
	public AccountsPage clickOnNew() {
		//driver.findElement(By.xpath("//div[text()='New']")).click(); 
		driver.findElement(By.xpath(prop.getProperty("AccountsPage.clickOnNew.xpath"))).click();
		return this;
	}
	
	
	public AccountsPage enterAccountName() {
		//driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Monisha Unique");		
		driver.findElement(By.xpath(prop.getProperty("AccountsPage.enterAccountName.xpath"))).click();
		return this;
	}
	
	public AccountsPage enterAccountNumber(String Account) {
		//driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Monisha Unique");		
		driver.findElement(By.xpath(prop.getProperty("AccountsPage.enterAccountNumber.xpath"))).sendKeys(Account);
		return this;
		
	}
	public AccountsPage enterFax(String Fax) {
		driver.findElement(By.xpath(prop.getProperty("AccountsPage.enterFax.xpath"))).sendKeys(Fax);
		//driver.findElement(By.xpath("//input[@name='Fax']")).sendKeys(Fax);
		return this ;
	}
	
	public AccountsPage enterWebsite(String Website) {
		driver.findElement(By.xpath(prop.getProperty("AccountsPage.enterWebsite.xpath"))).sendKeys(Website);
		//driver.findElement(By.xpath("//input[@name='Website']")).sendKeys(Website);
		return this ;
	}
	
	
	public AccountsPage clickOnOwnerShip() throws InterruptedException {
		//WebElement Ownership = driver.findElement(By.xpath("(//button[@data-value='--None--'])[3]"));
		//driver.executeScript("arguments[0].click();",Ownership);
		Thread.sleep(5000);
		WebElement Ownership=	driver.findElement(By.xpath(prop.getProperty("AccountsPage.clickOnOwnerShip.xpath")));
		driver.executeScript("arguments[0].click();",Ownership);
		return this;
	}
	
	public AccountsPage selectOwnerShip() {
		driver.findElement(By.xpath(prop.getProperty("AccountsPage.selectOwnerShip.xpath"))).click();
	//	driver.findElement(By.xpath("//span[@title='Public']")).click();
		return this;
	}
	
	public AccountsPage clickSave() {
		driver.findElement(By.xpath(prop.getProperty("AccountsPage.clickSave.xpath"))).click();
		//driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		return this;
	}
	
	public AccountsPage validateCreationName(String name) throws InterruptedException {
		//Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4000));
		WebElement final_name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Account']//following::lightning-formatted-text)[1]")));
		System.out.println(final_name.getText());
		assert final_name.getText().equals(name);
		return this;
	}
	
	public AccountsPage validateToastMessage() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4000));
		WebElement toast=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]"))));
		String toastMessage=toast.getText();
		System.out.println(toastMessage);
		assert toastMessage.equals("Account \"Salesforce Automation by POM\" was created.");
		return this;
	}
	
	public AccountsPage searchbox(String name) {
		 // driver.findElement(By.xpath("(//input[@type='search'])[2]")).clear();
		 // driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(name);
		 // driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
		  driver.findElement(By.xpath(prop.getProperty("AccountsPage.searchbox.xpath"))).sendKeys(name);
		  return this;
	}
	
	public AccountsPage selectFromSearchResult() throws InterruptedException {
		//WebElement ele=driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a"));
		//WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(500));
		driver.findElement(By.xpath(prop.getProperty("AccountsPage.selectFromSearchResult.xpath"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		WebElement n=new WebDriverWait(driver,Duration.ofSeconds(8)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a"))));
		n.click();
		return this;
	}
	
	public AccountsPage Edit() {
		//driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.xpath(prop.getProperty("AccountsPage.Edit.xpath"))).click();
		
		//edit.click();
		return this;
	}
	
	public AccountsPage phonetextbox(String phone) {
	
		//driver.findElement(By.xpath("//input[@name='Phone']")).sendKeys(phone);
		driver.findElement(By.xpath(prop.getProperty("AccountsPage.phonetextbox.xpath"))).sendKeys(phone);
		return this;
	}
	
	public AccountsPage typebutton() throws InterruptedException {
		//driver.findElement(By.xpath("//label[text()='Type']//parent::lightning-combobox//child::button")).click();
		Thread.sleep(5000);
		WebElement type=driver.findElement(By.xpath(prop.getProperty("AccountsPage.typebutton.xpath")));
		driver.executeScript("arguments[0].click();",type);
		
		return this;
	}
	
	public AccountsPage typeoption() {
		//driver.findElement(By.xpath("//span[@title='Technology Partner']")).click();
		driver.findElement(By.xpath(prop.getProperty("AccountsPage.typeoption.xpath"))).click();
		return this;
	}
	
	public AccountsPage industrybutton() {
		driver.findElement(By.xpath(prop.getProperty("AccountsPage.industrybutton.xpath"))).click();
		//driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//label[text()='Industry']//parent::lightning-combobox//child::button")));
		return this;
	}
	
	public AccountsPage industryoption() {
		WebElement accountspage=driver.findElement(By.xpath(prop.getProperty("AccountsPage.industryoption.xpath")));
		driver.executeScript("arguments[0].click();",accountspage);
		
		//driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[@title='Healthcare']")));
		return this;
	}
	
	public AccountsPage typeBillingAddress(String address) {
		driver.findElement(By.xpath(prop.getProperty("AccountsPage.typeBillingAddress.xpath"))).sendKeys(address);
		//driver.executeScript("arguments[0].value='"+address+"';", driver.findElement(By.xpath("//label[text()='Billing Street']//following-sibling::div//textarea")));
		return this;
	}
	
	public AccountsPage typeShippingAddress(String address) {
		driver.findElement(By.xpath(prop.getProperty("AccountsPage.typeShippingAddress.xpath"))).sendKeys(address);
		driver.findElement(By.xpath("//label[text()='Shipping Street']//parent::lightning-textarea//child::textarea")).sendKeys("Shipping address");
		return this;
	}
	
	public AccountsPage clickCustomerPriority() {
		WebElement Customer= driver.findElement(By.xpath(prop.getProperty("AccountsPage.clickCustomerPriority.xpath")));
		driver.executeScript("arguments[0].click();",Customer);
		
		//driver.executeScript("arguments[0].click();",clickOnCustomer);
		//driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//label[text()='Customer Priority']//parent::lightning-combobox//child::span")));
		return this;
	}
	
	public AccountsPage selectCustomerPriority() {
		WebElement Selectcustomer=driver.findElement(By.xpath(prop.getProperty("AccountsPage.selectCustomerPriority.xpath")));
		driver.executeScript("arguments[0].click();",Selectcustomer);
		//driver.findElement(By.xpath("//span[@title='Low']")).click();
		return this;
	}
	
	public AccountsPage clickOnSLA() {
		driver.findElement(By.xpath(prop.getProperty("AccountsPage.clickOnSLA.xpath"))).click();
		//driver.findElement(By.xpath("//label[text()='SLA']//parent::lightning-combobox//descendant::button")).click();
		return this;
	}
	
	public AccountsPage selectSLA() {
		driver.findElement(By.xpath(prop.getProperty("AccountsPage.selectSLA.xpath"))).click();
	//	driver.findElement(By.xpath("//span[@title='Silver']")).click();
		return this;
	}
	
	public AccountsPage clickOnActiveLabel() {
		WebElement Acive=driver.findElement(By.xpath(prop.getProperty("AccountsPage.clickOnActiveLabel.xpath")));
		driver.executeScript("arguments[0].click();",Acive);
		
		//driver.findElement(By.xpath("//label[text()='Active']//parent::lightning-combobox//child::span")).click();
		return this;
	}
	
	public AccountsPage clickOnNoActive() {
		WebElement NOAcive=driver.findElement(By.xpath(prop.getProperty("AccountsPage.clickOnNoActive.xpath")));
		driver.executeScript("arguments[0].click();",NOAcive);
		//driver.findElement(By.xpath("//span[@title='No']")).click();
		return this;
	}
	
	public AccountsPage clickOnUpSellOppo() {
		driver.findElement(By.xpath(prop.getProperty("AccountsPage.clickOnUpSellOppo.xpath"))).click();
		//driver.findElement(By.xpath("//label[text()='Upsell Opportunity']//parent::lightning-combobox//child::button")).click();
		return this;
	}
	
	public AccountsPage selectNoUpsellOppo() {
		driver.findElement(By.xpath(prop.getProperty("AccountsPage.selectNoUpsellOppo.xpath"))).click();
		//driver.findElement(By.xpath("//span[@title='No']")).click();
		return this;
	}
	
	public AccountsPage enterAccountNamesearch(String input)
	{
		driver.findElement(By.xpath(prop.getProperty("AccountsPage.selectFromSearchResult.xpath"))).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(input, Keys.ENTER);
		return this;
	}
	
	public AccountsPage deleteAccountName ()
	{
		WebElement accountName = driver.findElement(By.xpath("(//a[text()='Monisha'])[1]"));
		driver.executeScript("arguments[0].click();", accountName);
		driver.findElement(By.xpath("(//tbody/tr/td[6]//a)[1]")).click();
		return this;
	}
	
	public AccountsPage clickDelete ()
	{
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		return this;
	}
	
	public AccountsPage clickConfirmDelete()
	{
		WebElement confirmation=driver.findElement(By.xpath("//h2[text()='Delete Account']/following::span[text()='Delete']"));
		driver.executeScript("arguments[0].click();", confirmation);
		return this;
	}
	 
	
	public AccountsPage validatePhoneNum(String phone) {
		String phone_num=driver.findElement(By.xpath("//tbody//tr[1]//td[4]//span[@dir='ltr']")).getText();
		assert phone_num.equals(phone);
		return this;
	}
	
	public void waitForClickability(WebElement ele) {
		 new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(ele));
	}

}