package MuradilE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoraForm {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver");
		WebDriver myDriver = new ChromeDriver();
		myDriver.navigate().to("file:///Users/Muradil/eclipse-workspace/Homework/src/main/resources/MuradilE/index.html");
		Thread.sleep(2000);
		
		System.out.println("Landed on Bora Application Form Page");
		
		myDriver.close();
		myDriver.quit();

	}

}
