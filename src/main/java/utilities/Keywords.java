package utilities;

import static utilities.DriverFactory.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Keywords {
	
	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void startTest(String url) {
		DriverFactory.startChromeDriver();
		driver.navigate().to(url);
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
	
//	public static void input(By locator, String keysToSend) {
//		driver.findElement(locator).sendKeys(keysToSend);
//	}
	
	public static void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public static void submit(By locator) {
		driver.findElement(locator).submit();
	}
	
	public static void explicitWait(int time, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static Select select(By locator) {
		Select mySle = new Select(driver.findElement(locator));
		return mySle;
	}
	
	public static WebElement webElementAction(By locator) {
		return driver.findElement(locator);
	}
	
	public static Alert alert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}

	
}
