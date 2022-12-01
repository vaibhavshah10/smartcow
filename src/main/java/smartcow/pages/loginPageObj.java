package smartcow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginPageObj {
	
	WebDriver driver;
	
	 public loginPageObj(WebDriver driver) {
	        this.driver = driver;
	    }

       public By username =  By.id("user-name");
       public By password =  By.id("password");
       public By loginbutton =  By.id("login-button");
       public By burgerMenu = By.id("react-burger-menu-btn");
       public By logoutSideBarLink = By.id("logout_sidebar_link");
}
