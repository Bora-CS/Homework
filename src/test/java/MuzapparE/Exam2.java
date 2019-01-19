package MuzapparE;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exam2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(
				"file:///Users/erkin/eclipse-workspace/Homework/src/main/resources/MuradilE/Bora%20UI%20Test/landing.html");
		WebElement signUp1 = driver.findElement(By.xpath("//ul[2]/li[1]/a"));
		if (signUp1.isDisplayed()) {
			System.out.println("Validating Sign up is here : pass");
		} else {
			System.out.println("Validating Sign up is here : false");
		}
		WebElement signUp2 = driver.findElement(By.xpath("//div/a[1]"));
		if (signUp2.isDisplayed()) {
			System.out.println("Validating Sconed Sign up is here : pass");
		} else {
			System.out.println("Validating Sconed Sign up is here :false");
		}
		signUp1.click();
		Thread.sleep(2000);

		WebElement signUpText = driver.findElement(By.xpath("//div/p"));
		if (signUpText.isDisplayed()) {
			System.out.println("Validating Im On The Sign Up Page : pass");
		} else {
			System.out.println("Validating Im On The Sign Up Page : false");
		}
		driver.findElement(By.name("name")).sendKeys("Muzappar");
		driver.findElement(By.id("male")).click();
		driver.findElement(By.name("email")).sendKeys("Muzappar@bora-cs.com");
		Select mySelect = new Select(driver.findElement(By.name("Course")));
		mySelect.selectByVisibleText("Selenium Automation");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("password2")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.id("notarobot")).click();
		driver.findElement(By.xpath("//div/form/input")).click();
		Thread.sleep(2000);
		WebElement congraText = driver.findElement(By.xpath("//div[1]/h4"));
		String expectedConText = "Congratulations!";
		if (congraText.isDisplayed() && congraText.getText().equals(expectedConText)) {
			System.out.println("Validating Congratulations Text : pass");
		} else {
			System.out.println("Validating Congratulations Text : false");
		}
		WebElement goBackToHomePage = driver.findElement(By.xpath("//div[2]/a"));
		if (goBackToHomePage.isDisplayed()) {
			System.out.println("Validating go back to homepage button : pass");
		} else {
			System.out.println("Validating go back to homepage button : false");
		}
		WebElement boraCodingBootCamp = driver.findElement(By.xpath("//div[1]/p[2]/a"));
		boraCodingBootCamp.click();
		WebElement contectInfo = driver.findElement(By.xpath("//div[2]/div/div/div[2]/div[2]/h2"));
		if (contectInfo.isDisplayed()) {
			System.out.println("Validating Bora Coding Bootcamp Is Dispalayed : pass");
		} else {
			System.out.println("Validating Bora Coding Bootcamp Is Dispalayed : false");
		}
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
