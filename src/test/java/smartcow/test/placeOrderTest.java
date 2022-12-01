package smartcow.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import smartcow.utils.commonUtils;

import smartcow.pages.loginPageObj;
import smartcow.pages.placeOrderPageObj;

public class placeOrderTest extends setUp {
	public loginPageObj loginPage;
    public placeOrderPageObj placeOrderPage;
    public commonUtils commonutils;
    
    @Test(priority=0)
	public void standard_user() throws InterruptedException {
		placeOrderPageObj placeOrderPage = new placeOrderPageObj(driver);
		loginPageObj loginPage = new loginPageObj(driver);
		commonUtils commonutils = new commonUtils(driver);
		commonutils.implicitWait(1);
		try {
			driver.findElement(loginPage.username).click();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	driver.findElement(loginPage.username).sendKeys("standard_user");
	driver.findElement(loginPage.password).sendKeys("secret_sauce");
	driver.findElement(loginPage.loginbutton).click();
	commonutils.implicitWait(1);
	
	boolean val = driver.findElement(placeOrderPage.addToCart).isDisplayed();
		Assert.assertTrue(driver.findElement(placeOrderPage.addToCart).getText().equalsIgnoreCase("ADD TO CART"));
		Boolean btnText = false;
		Boolean cntFlag = false;
		for(int i=0;i<2;i++) {
		if(val==true) {
			commonutils.clickOnBtn(placeOrderPage.addToCart);
			//Thread.sleep(1000);
			commonutils.implicitWait(1);
			btnText = commonutils.compareText(placeOrderPage.removeBtnText, "REMOVE");
			Assert.assertTrue(btnText);
			cntFlag = commonutils.getText(placeOrderPage.cartCount,"1");
			Assert.assertTrue(cntFlag);
			break;
		}
		else {
			commonutils.implicitWait(1);
		}
		}
		
		driver.findElement(placeOrderPage.shoppingCart).click();
		commonutils.clickOnBtn(placeOrderPage.shoppingCart);
		//Thread.sleep(1000);
		commonutils.implicitWait(1);
		val = false;
		//val = commonutils.compareText(By.xpath("//*[@id='header_container']/div[2]/span"),"Your Cart");
		val = commonutils.compareText(placeOrderPage.mycartText,"Your Cart");
		Assert.assertTrue(val);
		val = false;
		driver.findElement(placeOrderPage.checkout).click();
		val = commonutils.compareText(By.xpath("//*[@id='header_container']/div[2]/span"),"Checkout: Your Information");
		Assert.assertTrue(val);
		val = false;		
		commonutils.clickOnBtn(placeOrderPage.fname);
		val = commonutils.enterText(placeOrderPage.fname, "zzz");
		Assert.assertTrue(val);
		val = false;
		//Thread.sleep(1000);
		commonutils.implicitWait(1);

		commonutils.clickOnBtn(placeOrderPage.lname);
		val = commonutils.enterText(placeOrderPage.lname, "abc");
		Assert.assertTrue(val);
		val = false;
		//Thread.sleep(1000);
		commonutils.implicitWait(1);

		commonutils.clickOnBtn(placeOrderPage.postalcode);
		val = commonutils.enterText(placeOrderPage.postalcode, "123");
		Assert.assertTrue(val);

		commonutils.clickOnBtn(placeOrderPage.continueBtn);	
  		commonutils.compareText(placeOrderPage.checkOutOverviewText, "Checkout: Overview");
		commonutils.clickOnBtn(placeOrderPage.finishBtn);
		commonutils.compareText(placeOrderPage.getcompleteOrderConfirmText, "THANK YOU FOR YOUR ORDER");
  		commonutils.compareText(placeOrderPage.getCheckoutCompleteMsg, "Checkout: Complete!");	
		//Thread.sleep(1000);	
    }
    
    @Test(priority=1)
  	public void performance_user() throws InterruptedException {
  		placeOrderPageObj placeOrderPage = new placeOrderPageObj(driver);
  		loginPageObj loginPage = new loginPageObj(driver);
  		commonUtils commonutils = new commonUtils(driver);
  		
  		//Thread.sleep(1000);
  		commonutils.implicitWait(1);

  		try {
  			driver.findElement(loginPage.username).click();
  		} catch (Exception e) {
  			e.printStackTrace();
  		}		

  	driver.findElement(loginPage.username).sendKeys("performance_glitch_user");
  	driver.findElement(loginPage.password).sendKeys("secret_sauce");
  	driver.findElement(loginPage.loginbutton).click();

  		Thread.sleep(1000);
  		boolean val = driver.findElement(placeOrderPage.addToCart).isDisplayed();
  		Assert.assertTrue(driver.findElement(placeOrderPage.addToCart).getText().equalsIgnoreCase("ADD TO CART"));
  		Boolean btnText = false;
  		Boolean cntFlag = false;
  		for(int i=0;i<2;i++) {
  		if(val==true) {
  			commonutils.clickOnBtn(placeOrderPage.addToCart);
  			commonutils.implicitWait(1);
  			btnText = commonutils.compareText(placeOrderPage.removeBtnText, "REMOVE");
  			Assert.assertTrue(btnText);
  			cntFlag = commonutils.getText(placeOrderPage.cartCount,"1");
  			Assert.assertTrue(cntFlag);
  			break;
  		}
  		else {
  			commonutils.implicitWait(1);
  		}
  		}
  		
  		driver.findElement(placeOrderPage.shoppingCart).click();
  		commonutils.clickOnBtn(placeOrderPage.shoppingCart);
  		//Thread.sleep(1000);
  		commonutils.implicitWait(1);
  		val = false;
  		//val = commonutils.compareText(By.xpath("//*[@id='header_container']/div[2]/span"),"Your Cart");
		val = commonutils.compareText(placeOrderPage.mycartText,"Your Cart");
  		Assert.assertTrue(val);
  		val = false;
  		driver.findElement(placeOrderPage.checkout).click();
  		val = commonutils.compareText(placeOrderPage.checkOutInfoText,"Checkout: Your Information");
  		Assert.assertTrue(val);
  		val = false;		
  		commonutils.clickOnBtn(placeOrderPage.fname);
  		val = commonutils.enterText(placeOrderPage.fname, "zzz");
  		Assert.assertTrue(val);
  		val = false;
  		//Thread.sleep(1000);
  		commonutils.clickOnBtn(placeOrderPage.lname);
  		val = commonutils.enterText(placeOrderPage.lname, "abc");
  		Assert.assertTrue(val);
  		val = false;
  		//Thread.sleep(1000);
  		commonutils.clickOnBtn(placeOrderPage.postalcode);
  		val = commonutils.enterText(placeOrderPage.postalcode, "123");
  		Assert.assertTrue(val);

  		commonutils.clickOnBtn(placeOrderPage.continueBtn);	
  		commonutils.compareText(placeOrderPage.checkOutOverviewText, "Checkout: Overview");
  		commonutils.clickOnBtn(placeOrderPage.finishBtn);
  		commonutils.compareText(placeOrderPage.getcompleteOrderConfirmText, "THANK YOU FOR YOUR ORDER");
  		commonutils.compareText(placeOrderPage.getCheckoutCompleteMsg, "Checkout: Complete!");	
//  		Thread.sleep(1000);	
      }
 
    @Test(priority=2)
  	public void problem_user() throws InterruptedException {
  		placeOrderPageObj placeOrderPage = new placeOrderPageObj(driver);
  		loginPageObj loginPage = new loginPageObj(driver);
  		commonUtils commonutils = new commonUtils(driver);
  		//Thread.sleep(1000);
  		commonutils.implicitWait(1);
  		try {
  			driver.findElement(loginPage.username).click();
  		} catch (Exception e) {
  			e.printStackTrace();
  		}		

  	driver.findElement(loginPage.username).sendKeys("problem_user");
  	driver.findElement(loginPage.password).sendKeys("secret_sauce");
  	driver.findElement(loginPage.loginbutton).click();

  		//Thread.sleep(1000);
  		boolean val = driver.findElement(placeOrderPage.addToCart).isDisplayed();
  		Assert.assertTrue(driver.findElement(placeOrderPage.addToCart).getText().equalsIgnoreCase("ADD TO CART"));
  		Boolean btnText = false;
  		Boolean cntFlag = false;
  		for(int i=0;i<2;i++) {
  		if(val==true) {
  			commonutils.clickOnBtn(placeOrderPage.addToCart);
  			commonutils.implicitWait(1);
  			btnText = commonutils.compareText(placeOrderPage.removeBtnText, "REMOVE");
  			Assert.assertTrue(btnText);
  			cntFlag = commonutils.getText(placeOrderPage.cartCount,"1");
  			Assert.assertTrue(cntFlag);
  			break;
  		}
  		else {
  			commonutils.implicitWait(1);
  		}
  		} 
  		
  		driver.findElement(placeOrderPage.shoppingCart).click();
  		commonutils.clickOnBtn(placeOrderPage.shoppingCart);
  		commonutils.implicitWait(1);
  		val = false;
  		//val = commonutils.compareText(By.xpath("//*[@id='header_container']/div[2]/span"),"Your Cart");
		val = commonutils.compareText(placeOrderPage.mycartText,"Your Cart");
  		Assert.assertTrue(val);
  		val = false;
  		driver.findElement(placeOrderPage.checkout).click();
  		//val = commonutils.compareText(By.xpath("//*[@id='header_container']/div[2]/span"),"Checkout: Your Information");
  		val = commonutils.compareText(placeOrderPage.checkOutInfoText,"Checkout: Your Information");
  		Assert.assertTrue(val);
  		val = false;		
  		commonutils.clickOnBtn(placeOrderPage.fname);
  		val = commonutils.enterText(placeOrderPage.fname, "zzz");
  		Assert.assertTrue(val);
  		val = false;
  		//Thread.sleep(1000);
  		commonutils.implicitWait(1);
  		commonutils.clickOnBtn(placeOrderPage.postalcode);
  		val = commonutils.enterText(placeOrderPage.postalcode, "123");
  		Assert.assertTrue(val);

  		commonutils.clickOnBtn(placeOrderPage.continueBtn);  
  		commonutils.compareText(placeOrderPage.problmenuserCheckoutErr, "Error: Last Name is required");
      }
    
    @AfterMethod
	public void quitDriver()
	{
		driver.quit();		
	}

}
