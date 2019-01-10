package utilities;

import static utilities.DriverFactory.driver;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Keywords {
	
	private static final String FileUtils = null;

	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void startTest(String url) {
		try {
			DriverFactory.startChromeDriver();
			driver.navigate().to(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void endTest() {
		DriverFactory.stopChromeDriver();
	}
	
	public static void print(String message) {
		System.out.println(message);
	}
	
	public static void click(By locator) {	
		driver.findElement(locator).click();
	}
	
	public static void input(By locator, String keysToSend) {
		driver.findElement(locator).sendKeys(keysToSend);
	}
	
	// Venus "getTitle" method.
	public static void getTitle() {
		System.out.println(driver.getTitle());
	}
	
	
		
	
	}
	

