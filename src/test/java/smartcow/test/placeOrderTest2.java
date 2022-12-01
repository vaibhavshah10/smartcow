package smartcow.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import smartcow.utils.commonUtils;

import smartcow.pages.loginPageObj;
import smartcow.pages.placeOrderPageObj;

public class placeOrderTest2 extends setUp {
	public loginPageObj loginPage;
    public placeOrderPageObj placeOrderPage;
    public commonUtils commonutils;
    
    @Test
	public void standard_user() throws InterruptedException {
    	placeOrderPageObj placeOrderPage = new placeOrderPageObj(driver);
		loginPageObj loginPage = new loginPageObj(driver);
		commonUtils commonutils = new commonUtils(driver);		
		Thread.sleep(2000);
		boolean val = driver.findElement(placeOrderPage.addToCart).isDisplayed();
		Assert.assertTrue(driver.findElement(placeOrderPage.addToCart).getText().equalsIgnoreCase("ADD TO CART"));
		Boolean btnText = false;
		Boolean cntFlag = false;
		for(int i=0;i<2;i++) {
		if(val==true) {
			commonutils.clickOnBtn(placeOrderPage.addToCart);
			Thread.sleep(1000);
			btnText = commonutils.compareText(By.xpath("//*[@id='remove-sauce-labs-backpack']"), "REMOVE");
			Assert.assertTrue(btnText);
			cntFlag = commonutils.getText(placeOrderPage.cartCount,"1");
			Assert.assertTrue(cntFlag);
			break;
		}
		else {
			Thread.sleep(2000);		
		}
		}
		Thread.sleep(2000);
		val = false;
		val = driver.findElement(placeOrderPage.addToCart).isDisplayed();
		Assert.assertTrue(driver.findElement(placeOrderPage.addToCart).getText().equalsIgnoreCase("ADD TO CART"));
		btnText = false;
		cntFlag = false;
		for(int i=0;i<2;i++) {
		if(val==true) {
			commonutils.clickOnBtn(placeOrderPage.addToCart);
			Thread.sleep(1000);
			btnText = commonutils.compareText(By.xpath("//*[@id='remove-sauce-labs-backpack']"), "REMOVE");
			Assert.assertTrue(btnText);
			cntFlag = commonutils.getText(placeOrderPage.cartCount,"1");
			Assert.assertTrue(cntFlag);
			break;
		}
		else {
			Thread.sleep(2000);		
		}
		}
		Thread.sleep(1000);
		val = false;		
		commonutils.clickOnBtn(placeOrderPage.fname);
		val = commonutils.enterText(placeOrderPage.fname, "zzz");
		Assert.assertTrue(val);
		val = false;
		Thread.sleep(1000);
		commonutils.clickOnBtn(placeOrderPage.lname);
		val = commonutils.enterText(placeOrderPage.lname, "abc");
		Assert.assertTrue(val);
		val = false;
		Thread.sleep(1000);
		commonutils.clickOnBtn(placeOrderPage.postalcode);
		val = commonutils.enterText(placeOrderPage.postalcode, "123");
		Assert.assertTrue(val);

		commonutils.clickOnBtn(placeOrderPage.continueBtn);	
		commonutils.compareText(By.xpath("//*[@id='header_container']/div[2]/span"), "Checkout: Overview");
		commonutils.clickOnBtn(placeOrderPage.finishBtn);
		commonutils.compareText(placeOrderPage.getcompleteOrderConfirmText, "THANK YOU FOR YOUR ORDER");
		commonutils.compareText(By.xpath("//*[@id='header_container']/div[2]/span"), "Checkout: Complete!");	
		Thread.sleep(1000);	
    }
    
/*	@Test
	public void addToCart() throws InterruptedException {
		placeOrderPageObj placeOrderPage = new placeOrderPageObj(driver);
		loginPageObj loginPage = new loginPageObj(driver);
		commonUtils commonutils = new commonUtils(driver);		
		Thread.sleep(2000);
		boolean val = driver.findElement(placeOrderPage.addToCart).isDisplayed();
		Assert.assertTrue(driver.findElement(placeOrderPage.addToCart).getText().equalsIgnoreCase("ADD TO CART"));
		Boolean btnText = false;
		Boolean cntFlag = false;
		for(int i=0;i<2;i++) {
		if(val==true) {
			commonutils.clickOnBtn(placeOrderPage.addToCart);
			Thread.sleep(1000);
			btnText = commonutils.compareText(By.xpath("//*[@id='remove-sauce-labs-backpack']"), "REMOVE");
			Assert.assertTrue(btnText);
			cntFlag = commonutils.getText(placeOrderPage.cartCount,"1");
			Assert.assertTrue(cntFlag);
			break;
		}
		else {
			Thread.sleep(2000);		
		}
		}
	}

	@Test
	public void checkOut() throws InterruptedException {
		placeOrderPageObj placeOrderPage = new placeOrderPageObj(driver);
		loginPageObj loginPage = new loginPageObj(driver);
		commonUtils commonutils = new commonUtils(driver);
		Thread.sleep(1000);
		driver.findElement(placeOrderPage.shoppingCart).click();
		commonutils.clickOnBtn(placeOrderPage.shoppingCart);
		Thread.sleep(1000);
		Boolean val = false;
		val = commonutils.compareText(By.xpath("//*[@id='header_container']/div[2]/span"),"Your Cart");
		Assert.assertTrue(val);
		val = false;
		driver.findElement(placeOrderPage.checkout).click();
		val = commonutils.compareText(By.xpath("//*[@id='header_container']/div[2]/span"),"Checkout: Your Information");
		Assert.assertTrue(val);
	}
		
	@Test
	public void completeOrder() throws InterruptedException {
		Thread.sleep(1000);
		placeOrderPageObj placeOrderPage = new placeOrderPageObj(driver);
		loginPageObj loginPage = new loginPageObj(driver);
		commonUtils commonutils = new commonUtils(driver);

		Thread.sleep(1000);
		Boolean val = false;		
		commonutils.clickOnBtn(placeOrderPage.fname);
		val = commonutils.enterText(placeOrderPage.fname, "zzz");
		Assert.assertTrue(val);
		val = false;
		Thread.sleep(1000);
		commonutils.clickOnBtn(placeOrderPage.lname);
		val = commonutils.enterText(placeOrderPage.lname, "abc");
		Assert.assertTrue(val);
		val = false;
		Thread.sleep(1000);
		commonutils.clickOnBtn(placeOrderPage.postalcode);
		val = commonutils.enterText(placeOrderPage.postalcode, "123");
		Assert.assertTrue(val);

		commonutils.clickOnBtn(placeOrderPage.continueBtn);	
		commonutils.compareText(By.xpath("//*[@id='header_container']/div[2]/span"), "Checkout: Overview");
		commonutils.clickOnBtn(placeOrderPage.finishBtn);
		commonutils.compareText(placeOrderPage.getcompleteOrderConfirmText, "THANK YOU FOR YOUR ORDER");
		commonutils.compareText(By.xpath("//*[@id='header_container']/div[2]/span"), "Checkout: Complete!");
		
		Thread.sleep(1000);		
	} */
	
	
	@AfterTest
	public void quitDriver()
	{
		driver.quit();		
	}

}
