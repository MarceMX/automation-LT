package saucedemo.pages;

import org.openqa.selenium.By;
import saucedemo.core.Utilities;
import static org.testng.Assert.assertEquals;

public class CheckoutOverview extends Utilities {
	By shoppingCart = By.id("finish");
	By headerPurchaseComplete = By.className("title");
	
	public void finishPurchase(){
		driver.findElement(shoppingCart).click();
		validatePurchaseCompletion();
	}
	
	public void validatePurchaseCompletion(){
		String expectedHeader;
		String headerText;
		
		expectedHeader = "CHECKOUT: COMPLETE!";
		headerText = driver.findElement(headerPurchaseComplete).getText();
		
		assertEquals(headerText, expectedHeader);
		System.out.println(headerText + " header is displayed. Purchase was completed.");
	}
}