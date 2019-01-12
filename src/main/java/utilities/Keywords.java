package utilities;

import static utilities.DriverFactory.driver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
	
	public static String getCurrentTimeStamp() {
		Date myDate = new Date();
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssS").format(myDate);
		return timeStamp;
	}
	
	public static void takeScreenShot() {
		waitFor(1);
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File ScrFile = scrShot.getScreenshotAs(OutputType.FILE);
		File ProjectFile = new File("target/ScreenShots/SH" + getCurrentTimeStamp()+ ".jpeg");
		try {
			FileUtils.copyFile(ScrFile, ProjectFile);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void dragAndDrop(WebElement from, WebElement to) {
		Actions act = new Actions(driver);
		act.clickAndHold(from).moveToElement(to).release().build().perform();
	}
	
	public static void hoverOverToElement(By locator) {
		WebElement elementToHover = driver.findElement(locator);
		Actions act = new Actions(driver);
		act.moveToElement(elementToHover).build().perform();
	}
}
