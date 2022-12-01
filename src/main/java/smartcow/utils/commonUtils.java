package smartcow.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class commonUtils {
	   WebDriver driver;

	public commonUtils(WebDriver driver) {
		   this.driver = driver;
	}

	public void clickOnBtn(By element) {
		try {
		driver.findElement(element).click();
		}
		catch (Exception e) {
			System.out.println("Button not visible/clickable"); 
		}
	}
	
	public boolean compareText(By element, String compareStr) {
		boolean val = false;
		try {
			driver.findElement(element).getText().equalsIgnoreCase(compareStr);
			val = true;
		}
		catch (Exception e) {
			System.out.println("Text match not found"); 
		}
		return val;
	}
	
	public boolean getText(By element, String cnt) {
		boolean val = false;
		try {
			driver.findElement(element).getText().contains(cnt);
			val = true;
		}
		catch (Exception e) {
			System.out.println("Count not  match"); 
		}
		return val;
	}
	
	public boolean enterText(By element, String text) {
		boolean val = false;
		try {
			driver.findElement(element).sendKeys(text);
			val = true;
		}
		catch (Exception e) {
			System.out.println("Count not  match"); 
		}
		return val;
	}
	
	public void implicitWait(int i) {
		driver.manage().timeouts().implicitlyWait(i,TimeUnit.SECONDS);
	}
}
