package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	
	@FindBy(css="div.cart_item")
	WebElement cartList;
	
	@FindAll(value = @FindBy(css = "div.cart_item"))
	List<WebElement> items;
	
	@FindBy(id="remove-sauce-labs-backpack")
	WebElement rmvBtn;
	
	@FindBy(css="button[data-tests='continue-shopping']")
	WebElement contBtn;
	
	@FindBy(id="checkout")
	WebElement chkoutBtn;
	
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
	public boolean isItemAdded() {
		return cartList.isDisplayed();
	}
	
	public void checkoutItems() {
		chkoutBtn.click();
	}
	
	public void removeItems() {
		rmvBtn.click();
	}
	
	
}
