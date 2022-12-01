package smartcow.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import smartcow.pages.loginPageObj;

public class loginTest extends setUp {

	loginPageObj loginPage;
	 @Test
		public void logintoApplication() throws InterruptedException {

		  loginPage = new loginPageObj(driver);
			
			try {
				driver.findElement(loginPage.username).click();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Thread.sleep(1000);
			driver.findElement(loginPage.username).sendKeys("standard_user");
			Thread.sleep(1000);
			driver.findElement(loginPage.password).sendKeys("secret_sauce");
			driver.findElement(loginPage.loginbutton).click();
			Assert.assertTrue(driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText().contains("Products"));
			Thread.sleep(1000);

		}
	}

