package seleniumUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Wait;

	public class Unit1 {
		WebDriver driver;
		@Test(priority = 0)
		public void firstTest() {
			
			driver.get("https://www.amazon.com");
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phone");
			driver.findElement(By.xpath("//input[@value='Go']")).click();
			WebElement dropDown = driver.findElement(By.xpath("//select[@id='sort']"));
			Select mySel = new Select(dropDown);
			
			mySel.selectByValue("price-desc-rank");
		
			
			
			
			sleep(5);
			
			
			
	}
	@Test(priority = 1)
	public void secondTest() {
		driver.get("https://www.amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("macbook");
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		driver.findElement(By.xpath("//a[contains(@title,'Apple MacBook Air (13-inch Retina display, 1.6GHz dual-core Intel Core i5, 128GB) - Silver (Latest Model)')]//h2[contains(@class,'a-text-normal')]")).click();
		driver.findElement(By.xpath("//button[@id='a-autoid-18-announce']")).click();
		driver.findElement(By.xpath("//button[@id='a-autoid-19-announce']//div//div//img[@class='imgSwatch']")).click();
		sleep(5);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
		if(!driver.findElement(By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']")).isDisplayed()) {
			System.out.println("Item in cart doesn't match.");
		}
	}
	
	
	@BeforeTest
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		 driver = new ChromeDriver();
	}
	
	
	
	@AfterTest
	public void endtBrowser() {
		driver.close();
		driver.quit();
	}
	
	
	
	
	
	
	
	

	
	
	
	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
