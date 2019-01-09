package JimmyC;

import static utilities.DriverFactory.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RefreshBrower {
     
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\jcruk\\Homework\\src\\test\\resources\\Drivers\\chromedriver.exe");
		WebDriver myDriver = new ChromeDriver();
		myDriver.navigate().to("https://www.amazon.com");
		myDriver.findElement(By.id("twotabsearchtextbox")).sendKeys("phone");
		myDriver.findElement(By.className("nav-input")).click();
		Thread.sleep(2);
		RefreshBrower
				.refreshBrower("https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=phone");

	}

	public static void refreshBrower(String url) {
		driver.navigate().refresh();
	}

}
