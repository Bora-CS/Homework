package SergioR;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.navigate().to(
				"file:///Users/pk/eclipse-workspace/Homework/src/main/resources/MuradilE/Bora%20UI%20Test/landing.html");

		WebElement element = driver.findElement(By.xpath("/html/body/nav/div/a"));

		if (element.isDisplayed()) {
			System.out.println("found: " + element.getText());
		} else {
			System.out.println("not found");

		}

		driver.findElement(By.xpath("//*[@id=\"mobile-nav\"]/ul[1]/li/a")).click();

		WebElement stuinfotext = driver.findElement(By.xpath("/html/body/div/div/div/div/h1"));

		if (stuinfotext.isDisplayed()) {
			System.out.println("found: " + stuinfotext.getText());
		} else {
			System.out.println("not found");
		}

		WebElement table = driver.findElement(By.id("studentInfo"));

		List<WebElement> rows = table.findElements(By.xpath("//*[@id=\"studentInfo\"]/tbody/tr"));

		if ((rows.size() - 1) == 10) {
			System.out.println("there are 10 students");
		} else {
			System.out.println("there are not 10 students");
		}

		for (int i = 1; i < rows.size(); i++) {

			List<WebElement> student = rows.get(i).findElements(By.tagName("td"));

			System.out.println(student.get(0).getText());

		}

		WebElement email = driver
				.findElement(By.cssSelector("#studentInfo > tbody > tr:nth-child(10) > td:nth-child(2)"));

		if (email.isDisplayed()) {
			System.out.println("email found: " + email.getText());
		} else {
			System.out.println("email not found");

		}

		WebElement phone = driver
				.findElement(By.cssSelector("#studentInfo > tbody > tr:nth-child(10) > td:nth-child(3)"));

		if (phone.isDisplayed()) {
			System.out.println("phone number found: " + phone.getText());
		} else {
			System.out.println("phone number not found");

		}

		driver.close();
		driver.quit();
	}

}
