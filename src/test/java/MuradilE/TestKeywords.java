package MuradilE;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.Constants;

public class TestKeywords {
	
	public static WebDriver driver; 
	
	public static boolean testCaseStatus = true;
	
	public static void endTest() {
		driver.close();
		
		driver.quit();
	}

	public static void startTest() {
		String applicationURL = "file:///Users/Muradil/eclipse-workspace/Homework/src/main/resources/MuradilE/Bora%20UI%20Test/landing.html";
		
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
		
		driver = new ChromeDriver();
		
		driver.get(applicationURL);
	}
	
	public static WebElement tryToFindAnElement (String nameOfElement, By locator) {
		WebElement targetElement = null;
		try {
			targetElement = driver.findElement(locator);
		} catch (NoSuchElementException e) {
			System.out.println("Element " + nameOfElement + " is not found");
			testCaseStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return targetElement;		
	}
	
	public static void checkTestCaseStatus () {
		if (testCaseStatus) {
			System.out.println("Test Case: Passed!");
		} else {
			System.out.println("Test Case: Failed!");
		}
	}
	
}
