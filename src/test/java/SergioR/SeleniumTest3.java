package SergioR;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest3 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.navigate().to(
				"file:///Users/pk/eclipse-workspace/Homework/src/main/resources/MuradilE/Bora%20UI%20Test/landing.html");

		WebElement logOne = driver.findElement(By.xpath("/html/body/div/div/div/div/div/a[2]"));

		if (logOne.isDisplayed()) {
			System.out.println("found: " + logOne.getText());
		} else {
			System.out.println("first log in was not found");

		}

		WebElement logTwo = driver.findElement(By.xpath("//*[@id=\"mobile-nav\"]/ul[2]/li[2]/a"));

		if (logTwo.isDisplayed()) {
			System.out.println("found: " + logOne.getText());
		} else {
			System.out.println("second log in was not found");

		}

		logOne.click();

		WebElement logHeader = driver.findElement(By.xpath("/html/body/div/div/div/div/h1"));

		if (logHeader.isDisplayed()) {
			System.out.println("found: " + logHeader.getText());
		} else {
			System.out.println("log in header not found");
		}

		driver.findElement(By.name("email")).sendKeys("Sergio@bora-cs.com");

		driver.findElement(By.name("password")).sendKeys("123456");

		driver.findElement(By.cssSelector("body > div > div > div > div > form > input")).submit();

		WebElement skillSet = driver.findElement(By.cssSelector(
				"body > div.profiles > div > div > div > div > div > div.col-md-4.d-none.d-lg-block > h4"));

		if (skillSet.isDisplayed()) {
			System.out.println("found: " + skillSet.getText());
		} else {
			System.out.println("skill set not found");

		}

		WebElement stuPro = driver.findElement(By.cssSelector("body > div.profiles > div > div > div > h1"));
		if (stuPro.isDisplayed()) {
			System.out.println("found: " + stuPro.getText());
		} else {
			System.out.println("student profile not found");

		}

		WebElement logOut = driver.findElement(By.xpath("//*[@id=\"mobile-nav\"]/ul[2]/li/a"));
			if (logOut.isDisplayed()) {
			System.out.println("found: " + logOut.getText());
		} else {
			System.out.println("log out not found");
		}

		logOut.click();
		
		Thread.sleep(3000);

		WebElement modalContent = driver.findElement(By.cssSelector("#exampleModalCenterTitle"));
		if (modalContent.isDisplayed()) {
			System.out.println("found: " + modalContent.getText());
		} else {
			System.out.println("Are you sure not found");
		}
		
		driver.findElement(By.xpath("//*[@id=\"exampleModalCenter\"]/div/div/div[3]/button")).click();
		
		if (stuPro.isDisplayed()) {
			System.out.println("found: " + stuPro.getText());
		} else {
			System.out.println("student profile not found");

		}

		Thread.sleep(1000);
		
		logOut.click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\"exampleModalCenter\"]/div/div/div[3]/a")).click();
		
		Thread.sleep(1000);
		
		WebElement welcome = driver.findElement(By.cssSelector("body > div > div > div > div > div > p"));
		
		if (welcome.isDisplayed()) {
			System.out.println("found: " + welcome.getText());
		} else {
			System.out.println("homepage not found");
		}

		driver.close();
		driver.quit();

	}

}
