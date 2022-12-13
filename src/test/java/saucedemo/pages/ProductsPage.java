package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import saucedemo.core.Utilities;

import java.util.Locale;

public class ProductsPage extends Utilities {
	By productLink = By.className("inventory_item_name");
	
	/*	For this exercise I only specified the entry for 1 parameter,
	the ideal practice is to set a variable that takes n number of products.*/
	public void selectProduct(String productName){
		//Select the link
		driver.findElement(By.linkText(productName)).click();
		//Click Add To Cart button
		clickAddToCart(productName);
	}
	
	/* This method will add to cart the product, check the button Remove will be displayed
	 once the Add To Cart button is clicked and the element is added to shopping cart*/
	public void clickAddToCart(String productName){
		String prodName;
		String pName;
		boolean removeBtn;
		boolean addCart;
		
		//Replace spaces by "-" char to add into button id
		prodName = productName.replace(" ", "-");
		pName = prodName.toLowerCase(Locale.ROOT);
		driver.findElement(By.id("add-to-cart-" + pName)).click();
		
		removeBtn = driver.findElement(By.id("remove-" + pName)).isDisplayed();
		addCart = driver.findElement(By.linkText("1")).isDisplayed();
		if ((removeBtn) && (addCart)){
			System.out.println("Add to Cart - " + productName + " has been added to the cart");
		}
	}
}