package SergioR;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.navigate().to(
				"file:///Users/pk/eclipse-workspace/Homework/src/main/resources/MuradilE/Bora%20UI%20Test/landing.html");

		WebElement signOne = driver.findElement(By.xpath("/html/body/div/div/div/div/div/a[1]"));

		if (signOne.isDisplayed()) {
			System.out.println("found: " + signOne.getText());
		} else {
			System.out.println("first sign up was not found");

		}

		WebElement signTwo = driver.findElement(By.xpath("//*[@id=\"mobile-nav\"]/ul[2]/li[1]/a"));

		if (signTwo.isDisplayed()) {
			System.out.println("found: " + signTwo.getText());
		} else {
			System.out.println("second sign up was not found");

		}

		signOne.click();

		WebElement createText = driver.findElement(By.cssSelector("body > div > div > div > div > p"));

		if (createText.isDisplayed()) {
			System.out.println("found: " + createText.getText());
		} else {
			System.out.println("Create your Bora student account not found");

		}

		driver.findElement(By.name("name")).sendKeys("Sergio");

		driver.findElement(By.id("male")).click();

		driver.findElement(By.name("email")).sendKeys("Sergio@bora-cs.com");

		WebElement dropdown = driver.findElement(By.name("Course"));

		Select mySelect = new Select(dropdown);
		mySelect.selectByIndex(1);

		driver.findElement(By.name("password")).sendKeys("123456");

		driver.findElement(By.name("password2")).sendKeys("123456");

		driver.findElement(By.id("notarobot")).click();

		driver.findElement(By.xpath("/html/body/div/div/div/div/form/input")).submit();

		WebElement success = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/h4"));

		if (success.isDisplayed()) {
			System.out.println("found: " + success.getText());
		} else {
			System.out.println("Congratulations! not found");
		}

		WebElement back = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/a"));

		if (back.isDisplayed()) {
			System.out.println("found: " + back.getText());
		} else {
			System.out.println("Back to Homepage not found");
		}

		driver.findElement(By.linkText("Bora Coding Bootcamnp")).click();

		WebElement boraHeading = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/h1"));

		if (boraHeading.isDisplayed()) {
			System.out.println("found: " + boraHeading.getText());
		} else {
			System.out.println("Bora Coding Bootcamp not found");

		}

		driver.close();
		driver.quit();

	}

}
