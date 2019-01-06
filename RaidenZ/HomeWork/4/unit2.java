package seleniumUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class unit2 {
	
		WebDriver driver;
	
		@BeforeTest
		public void startBrowser() {
	
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
	
			driver = new ChromeDriver();
	
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	
		}
	
		@AfterTest
		public void endBrowser() {
			driver.close();
			driver.quit();
		}
	
		@Test(priority = 0)
		public void cleaneranceTest() {
	
			driver.get("https://www.walmart.com");
	
			System.out.println(driver.getTitle());
	
			driver.findElement(By.xpath("//div[@class='Header-leftNav']//button[@type='button']")).click();
	
			sleep(1);
	
			driver.findElement(By.xpath("//div[@class='GlobalHeaderDepartmentsMenu']//button[1]")).click();
	
			sleep(1);
	
			driver.findElement(By.xpath("//a[contains(text(),'Christmas Decor')]")).click();
	
			WebElement itemToBuy = driver.findElement(By.xpath(
					"//ul[@class='search-result-gridview-items four-items']//li[2]//div[1]//div[2]//div[5]//div[1]//span[2]//a[1]"));
	
			String nameOfItemToBuy = itemToBuy.getAttribute("aria-label");
	
			itemToBuy.click();
	
			String itemName = driver.findElement(By.xpath(
					"//div[@class='hide-content-max-m prod-TitleSection hf-BotRow']//div[contains(text(),'Lightshow Christmas Lights Projection Snowflurry b')]"))
					.getText();
	
			Assert.assertEquals(itemName, nameOfItemToBuy);
	
			sleep(2);
	
			Assert.assertTrue(driver.findElement(By.xpath("//select[contains(@placeholder,'Qty:')]")).isDisplayed());
	
			Select numberDropDown = new Select(driver.findElement(By.xpath("//select[contains(@placeholder,'Qty:')]")));
	
			numberDropDown.selectByIndex(1);
	
			String howManyToBuy = numberDropDown.getFirstSelectedOption().getText();
	
			driver.findElement(By.xpath("//div[@class='prod-product-cta-add-to-cart display-inline-block']//button[@type='button']")).click();
	
			sleep(2);
	
			driver.findElement(By.xpath("//div[@class='cart-pos-view-cart']//button[@type='button']")).click();
			
			String nameOfItemInCart = driver.findElement(By.xpath("//a[@class='js-btn-product btn-fake-link cart-item-name-link']")).getText();
			
			Assert.assertEquals(nameOfItemInCart, itemName);
	
			Select checkOutSelect = new Select(driver.findElement(By.xpath(
					"//div[@class='pos-relative cart-quantity-s text-center']//div[@class='text-left']//div[@class='js-item-quantity cart-item-quantity']//span//div[@class='Cart-Common-QuantitySelector quantity-selector']//div//select[@class='field-input field-input--secondary']")));
	
			Assert.assertEquals(checkOutSelect.getFirstSelectedOption().getText(), howManyToBuy);
	
		}
	
		public static void sleep(int seconds) {
	
			try {
	
				Thread.sleep(seconds * 1000);
	
			} catch (InterruptedException e) {
	
				// TODO Auto-generated catch block
				e.printStackTrace();
	
			}
	
		}
	
	}
