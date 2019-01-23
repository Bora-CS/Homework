package MuradilE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static MuradilE.TestKeywords.driver;
import static MuradilE.TestKeywords.testCaseStatus;

public class BoraUITest_3 {

	public static String testData = "Murad";

	public static void main(String[] args) throws InterruptedException {

		testCaseStatus = true;

		TestKeywords.startTest();

		List<WebElement> loginButtons = driver.findElements(By.xpath("//a[@href='login.html']"));

		if (loginButtons.size() != 2) {
			System.out.println("Failed to find 2 Login buttons");
			testCaseStatus = false;
		}

		for (WebElement login : loginButtons) {
			if (!login.getText().equals("Login")) {
				System.out.println("The Login button does not have the expected text: Login");
				System.out.println("Actual Text: " + login.getText());
				testCaseStatus = false;
			}
		}

		loginButtons.get(0).click();

		WebElement loginText = TestKeywords.tryToFindAnElement("Log In Text Element",
				By.xpath("//h1[@class='display-4 text-center']"));

		if (!loginText.getText().equals("Log In")) {
			System.out.println("The Log In Text is unexpected:");
			System.out.println(loginText.getText());
			testCaseStatus = false;
		}

		driver.findElement(By.name("email")).sendKeys("miller.muradil@gmail.com");

		driver.findElement(By.name("password")).sendKeys("123456");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		WebElement studentProfileText = TestKeywords.tryToFindAnElement("Log In Text Element",
				By.xpath("//h1[@class='display-4 text-center']"));

		if (!studentProfileText.getText().equals("Student Profile")) {
			System.out.println("The Student Profile Text is unexpected:");
			System.out.println(studentProfileText.getText());
			testCaseStatus = false;
		}

		WebElement logout = driver.findElement(By.xpath("//a[img]"));

		logout.click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@class='btn btn-secondary']")).click();

		Thread.sleep(1000);

		TestKeywords.tryToFindAnElement("Log In Text Element", By.xpath("//h1[@class='display-4 text-center']"));

		logout.click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@class='btn btn-info']")).click();

		if (!driver.getCurrentUrl().equals(
				"file:///Users/Muradil/eclipse-workspace/Homework/src/main/resources/MuradilE/Bora%20UI%20Test/landing.html")) {
			System.out.println("URL is wrong: "+ driver.getCurrentUrl());
			testCaseStatus = false;
		}

		TestKeywords.endTest();

		TestKeywords.checkTestCaseStatus();

	}

}
