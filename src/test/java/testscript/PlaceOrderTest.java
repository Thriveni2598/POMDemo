package testscript;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductListPage;

public class PlaceOrderTest {
	
	WebDriver driver;
	LoginPage loginPage;
	ProductListPage listPage;
	CartPage cartPage;
	CheckOutPage checkOutPage;
	
	public PlaceOrderTest() {
		TestBase.initDriver();
		driver= TestBase.getDriver();
		loginPage = new LoginPage(driver);
		listPage = new ProductListPage(driver);
		cartPage = new CartPage(driver);
		checkOutPage = new CheckOutPage(driver);
		
	}
	
	@BeforeTest
	public void setup() {
		TestBase.openUrl("https://www.saucedemo.com/");
	}
	
  @Test(priority =1)
  public void loginTest() {
	  loginPage.ValidLogin("standard_user", "secret_sauce");
  }
  
  @Test(priority =2)
  public void addItemTest() {
	  boolean isOnProductPage = listPage.isOnProducts();
	  Assert.assertTrue(isOnProductPage);
	  listPage.addToCart();
	  listPage.viewCart();
	  Assert.assertTrue(cartPage.isItemAdded());
  }
  
  //@Test(priority = 3)
  
 // public void removeTest() {
//	  cartPage.removeItems();
 // }
  
  @Test(priority =3)
 
  public void checkOutTest() {
	  cartPage.checkoutItems();
	  checkOutPage.provideDetails("Test", "User", "22345");
	  checkOutPage.checkoutOrder();
	  Assert.assertTrue(checkOutPage.isOrderSuccess());
	  
  }
  
  
}
