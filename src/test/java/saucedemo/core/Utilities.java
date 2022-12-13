package saucedemo.core;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Utilities {
	
	public static  WebDriver driver = null;
	
	public void launchBrowser(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public void testOnFailure(String exceptionMessage) throws IOException {
		System.out.println("Test not completed. Test Execution: FAIL. Exception: " + "\n" + exceptionMessage);
		screenshotTake();
		Assert.assertTrue(false);
	}
	
    public void screenshotTake() throws IOException {
		Date currentDate = new Date();
		String screenshotFileName = currentDate.toString().replace(" ","-").replace(":", "-");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//" + screenshotFileName + ".png"));
    }
}