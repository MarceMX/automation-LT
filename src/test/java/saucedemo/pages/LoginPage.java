package saucedemo.pages;

import org.openqa.selenium.By;
import saucedemo.core.Utilities;

public class LoginPage extends Utilities {
	By userField = By.id("user-name");
	By passwordField = By.id("password");
	By loginButton = By.id("login-button");
	
	public void enterLoginCredentials(String user, String password){
		typeUserName(user);
		typePassword(password);
		clickLogin();
		System.out.println("User logged into application: " + user);
	}
	
	public void typeUserName(String user){
		driver.findElement(userField).sendKeys(user);
	}
	
	public void typePassword(String password){
			driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickLogin(){
			driver.findElement(loginButton).click();
	}
}
