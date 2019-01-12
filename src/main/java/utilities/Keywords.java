package utilities;

import static utilities.DriverFactory.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Keywords {

	public static void waitFor(int seconds) {
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

	public static void print(Object message) {
		System.out.println(message);
	}

	public static void click(By locator) {
		driver.findElement(locator).click();
	}

	public static void input(By locator, String keysToSend) {
		driver.findElement(locator).sendKeys(keysToSend);
	}

	public static boolean searchForDataInTable(String expectedValue, By tableLocator) {
		boolean isFound = false;

		WebElement table = driver.findElement(tableLocator);
		int rowNum = table.findElements(By.tagName("tr")).size();
		int colNum = table.findElements(By.tagName("th")).size();

		for (int i = 2; i <= rowNum; i++) {
			for (int j = 1; j <= colNum; j++) {
				WebElement currentEle = table.findElement(By.xpath("//tr[" + i + "]/td[" + j + "]"));
				if (currentEle.getText().equals(expectedValue)) {
					isFound = true;
				}
			}
		}

		print("Value " + expectedValue + " found: " + isFound);
		return isFound;
	}
}
