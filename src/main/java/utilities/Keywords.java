package utilities;

import static utilities.DriverFactory.driver;

import org.openqa.selenium.By;

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

	public static void input(By locator, String keysToSend) {
		driver.findElement(locator).sendKeys(keysToSend);
	}

	// Creat by jimmy
	public static void refreshBrower(String url) {
		driver.navigate().refresh();
	}

}


