package saucedemo.test;

import org.testng.Assert;
import org.testng.annotations.*;
import saucedemo.core.Utilities;
import saucedemo.pages.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ShoppingExperienceTest extends Utilities {
	
	@Parameters({"URL"})
	@BeforeMethod
	public void openUrl(String webUrl){
		launchBrowser();
		driver.get(webUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void finalizeTest(){
		driver.quit();
	}
	
	@Parameters({"user", "password", "itemToBuy", "firstName", "lastName", "zipCode"})
	@Test
	public void shopSite(String user, String password, String productToBuy, String firstName, String lastName, String zipCode) throws IOException {
		try {
			LoginPage login;
			ProductsPage selectItem;
			ShoppingCart checkoutItem;
			CheckoutMyInformation myInformation;
			CheckoutOverview completePurchase;
			
			login = new LoginPage();
			login.enterLoginCredentials(user, password);
			
			selectItem = new ProductsPage();
			selectItem.clickAddToCart(productToBuy);
			
			checkoutItem = new ShoppingCart();
			checkoutItem.goToCart();
			checkoutItem.validateCart(productToBuy);
			checkoutItem.clickCheckout();
			
			myInformation = new CheckoutMyInformation();
			myInformation.enterFullInformation(firstName, lastName, zipCode);
			
			completePurchase = new CheckoutOverview();
			completePurchase.finishPurchase();
		}catch (Exception e){
			testOnFailure(e.toString());
		}
	}
	
}