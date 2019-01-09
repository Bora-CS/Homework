package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	public static WebDriver driver;
	
	public static void startChromeDriver () {
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static void stopChromeDriver() {
		driver.close();
		driver.quit();
	}
}
