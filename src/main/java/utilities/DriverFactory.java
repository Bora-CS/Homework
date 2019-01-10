package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	public static WebDriver driver;
	
	public static void startChromeDriver () throws Exception {
		String driverPath = determineOSandGetDriverPath();
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	private static String determineOSandGetDriverPath() throws Exception {
		String os = System.getProperty("os.name");
	    System.out.println("Operating System: " + os);
	    if (os.toLowerCase().startsWith("mac")) {
	    	OperatingSystem = "MAC";
	    	return Constants.CHROME_DRIVER_PATH_MAC;
	    } else if (os.toLowerCase().startsWith("windows")) {
	    	OperatingSystem = "WINDOWS";
	    	return Constants.CHROME_DRIVER_PATH_WINDOWS;
	    } else {
	    	OperatingSystem = "UNKNOWN";
	    	throw new Exception("Unknown Operating System: " + os); 
	    }
	}

	public static void stopChromeDriver() {
		driver.close();
		driver.quit();
	}
	
	private static String OperatingSystem;
	
	public static String getOperatingSystem() {
		return OperatingSystem;
	}

}
