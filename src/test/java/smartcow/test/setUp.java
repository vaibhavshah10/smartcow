package smartcow.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.beust.jcommander.Parameters;

import smartcow.pages.loginPageObj;

public class setUp {
WebDriver driver;
	
loginPageObj loginPage;

@BeforeMethod
public void getApplicationURL() throws InterruptedException
	{
		 System.setProperty("webdriver.chrome.driver","C:/Users/Atheer/Downloads/chromedriver.exe");
		   driver=new ChromeDriver();		
			driver.manage().window().maximize();	
			driver.get("http://www.saucedemo.com");
			
}

@AfterClass
	public void quitDriver()
	{
		driver.quit();		
	}
}
