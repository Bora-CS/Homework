package MuradilE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static MuradilE.TestKeywords.driver;
import static MuradilE.TestKeywords.testCaseStatus;

public class BoraUITest_2 {

	public static String testData = "Murad";

	public static void main(String[] args) throws InterruptedException {

		testCaseStatus = true;

		TestKeywords.startTest();

		List<WebElement> signUpButtons = driver.findElements(By.xpath("//a[@href='register.html']"));

		if (signUpButtons.size() != 2) {
			System.out.println("Failed to find 2 Sign up buttons");
			testCaseStatus = false;
		}

		for (WebElement signUp : signUpButtons) {
			if (!signUp.getText().equals("Sign Up")) {
				System.out.println("The sign up button does not have the expected text: Sign Up");
				System.out.println("Actual Text: "+ signUp.getText());
				testCaseStatus = false;
			}
		}

		signUpButtons.get(0).click();

		driver.findElement(By.name("name")).sendKeys("Murad");

		driver.findElement(By.id("male")).click();

		driver.findElement(By.name("email")).sendKeys("miller.muradil@gmail.com");

		Select mySelect = new Select(driver.findElement(By.name("Course")));
		mySelect.selectByVisibleText("Front End Development with Angular");

		driver.findElement(By.name("password")).sendKeys("123456");

		driver.findElement(By.name("password2")).sendKeys("123456");

		driver.findElement(By.id("notarobot")).click();

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		WebElement congratsText = TestKeywords.tryToFindAnElement("Congratulations Text Element",
				By.className("alert-heading"));
		
		if (!congratsText.getText().equals("Congratulations!")) {
			System.out.println("The Congratulations Text Element has a unexpected text:");
			System.out.println(congratsText.getText());
			testCaseStatus = false;
		}
		
		driver.findElement(By.className("alert-link")).click();
		
		if (!driver.getTitle().equals("Bora Coding Bootcamp")) {
			System.out.println("The page title is unexpected: "+ driver.getTitle());
			testCaseStatus = false;
		}
		
		if (!driver.getCurrentUrl().equals("https://www.bora-cs.com/bc/")) {
			System.out.println("The current URL is unexpected: "+ driver.getCurrentUrl());
			testCaseStatus = false;
		}
		
		driver.navigate().back();
		
		WebElement backToHomepageButton = TestKeywords.tryToFindAnElement("Back to Homepage Button", By.xpath("//a[@href='landing.html']"));
		
		backToHomepageButton.click();

		Thread.sleep(2000);

		TestKeywords.endTest();

		TestKeywords.checkTestCaseStatus();

	}

}
