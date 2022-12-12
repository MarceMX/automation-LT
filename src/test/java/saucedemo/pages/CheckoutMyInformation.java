package saucedemo.pages;

import org.openqa.selenium.By;
import saucedemo.core.Utilities;


public class CheckoutMyInformation extends Utilities {
	By firstNameField = By.id("first-name");
	By lastNameField = By.id("last-name");
	By zipCodeField = By.id("postal-code");
	
	public void enterFullInformation(String firstName, String lastName, String zipCode){
		typeFirstName(firstName);
		typeLastName(lastName);
		typeZipCode(zipCode);
		System.out.println("Checkout information has been entered");
		continueCheckout();
	}
	public void typeFirstName(String firstName){
		driver.findElement(firstNameField).sendKeys(firstName);
	}
	
	public void typeLastName(String lastName){
		driver.findElement(lastNameField).sendKeys(lastName);
	}
	
	public void typeZipCode(String zipCode){
		driver.findElement(zipCodeField).sendKeys(zipCode);
	}
	
	public void continueCheckout(){
		driver.findElement(By.id("continue")).click();
	}
}