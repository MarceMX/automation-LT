package saucedemo.pages;

import org.openqa.selenium.By;
import saucedemo.core.Utilities;

import static org.testng.Assert.*;

public class ShoppingCart extends Utilities {
	By shoppingCart = By.className("shopping_cart_link");
	By itemLink = By.className("inventory_item_name");
	By checkout = By.id("checkout");
	
	public void goToCart(){
		driver.findElement(shoppingCart).click();
	}
	
	public void validateCart(String productName){
		boolean prodCart;
		String itemCart;
		
		prodCart = driver.findElement(By.linkText(productName)).isDisplayed();
		itemCart = driver.findElement(itemLink).getText();
		assertEquals(productName, itemCart);
		if (prodCart){
			System.out.println(itemCart + " product is displayed in the cart");
		}
	}
	
	public void clickCheckout(){
		driver.findElement(checkout).click();
	}
}