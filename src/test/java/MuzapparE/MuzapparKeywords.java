package MuzapparE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MuzapparKeywords {

	public static void printValidation(String whatYourValidating, boolean condition) {
		if (condition) {
			System.out.println("Validating " + whatYourValidating + " : pass");
		} else {
			System.out.println("Validating " + whatYourValidating + " : false");
		}

	}
	
	public static WebDriver startMyTest() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(
				"file:///Users/erkin/eclipse-workspace/Homework/src/main/resources/MuradilE/Bora%20UI%20Test/landing.html");
		return driver;
	}
}
