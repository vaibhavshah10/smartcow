package smartcow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class placeOrderPageObj {
   WebDriver driver;
	
   public placeOrderPageObj(WebDriver driver) {
	   this.driver = driver;
   }
   
   public By addToCart = By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']");
   public By cartCount = By.xpath("//*[@id='shopping_cart_container']/a/span");
   
   public By shoppingCart = By.xpath("//*[@id='shopping_cart_container']/a");
   public By checkout = By.xpath("//*[@id='checkout']");
 //*[@id="checkout"]
   public By fname = By.xpath("//*[@id='first-name']");
   public By lname = By.xpath("//*[@id='last-name']");
   public By removeBtnText = By.xpath("//*[@id='remove-sauce-labs-backpack']");
   public By mycartText = By.xpath("//*[@id='header_container']/div[2]/span");
   public By checkOutInfoText = By.xpath("//*[@id='header_container']/div[2]/span");
   public By checkOutOverviewText = By.xpath("//*[@id='header_container']/div[2]/span");
   public By postalcode = By.xpath("//*[@id='postal-code']");
   public By finishBtn = By.xpath("//*[@id='finish']");
   public By continueBtn = By.xpath("//*[@id='continue']");
  public By getcompleteOrderConfirmText = By.xpath("//*[@id='checkout_complete_container']/h2");  
  public By getCheckoutCompleteMsg = By.xpath("//*[@id='header_container']/div[2]/span");
  public By problmenuserCheckoutErr = By.xpath("//*[@id='checkout_info_container']/div/form/div[1]/div[4]/h3");
 
}