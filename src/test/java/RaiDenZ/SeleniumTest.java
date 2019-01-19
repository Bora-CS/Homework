package RaiDenZ;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		String homePageUrl = "file:///C:/Users/raide/eclipse-workspace/Homework/src/main/resources/MuradilE/Bora%20UI%20Test/landing.html";

		// Test Scenario 1
		System.out.println("Test Scenario 1");
		
		driver.get(homePageUrl);
		
		System.out.println("1.Navigated to the application home page");
		
		Thread.sleep(2000);

		String boraTitle = driver.findElement(By.xpath("//h1[@class='display-3 mb-4']")).getText();
		String ExpectedBoraTitile = "Bora UI Automation Test";

		if (boraTitle.equals(ExpectedBoraTitile)) {
			System.out.println("2.Bora title matches!");
		} else {
			System.out.println("2.Bora title doesn't match!");
		}

		String ExpectedUrlTitle = "Welcome to Bora UI Automation Test";

		String urlTitle = driver.getTitle();

		if (urlTitle.equals(ExpectedUrlTitle)) {
			System.out.println("2.Url title matches!");

		} else {
			System.out.println("2.Url title doesn't matches!");
		}

		driver.findElement(By.xpath("//a[@href='students.html\']")).click();
		
		System.out.println("3.Went to Students page");

		Thread.sleep(2000);

		List<WebElement> row = driver.findElements(By.xpath("//table[@id='studentInfo']/tbody/tr"));
		
		List<WebElement> column = driver.findElements(By.xpath("//table[@id='studentInfo']/tbody/tr/th"));
		
		String myName = "Raiden";
		String nameFound = null;
		String email = null;
		String myPhoneNum = "202-202-2031";
		
		int studentNum = 10;
		if (studentNum == row.size() - 1) {
			System.out.println("5.It's correct that there are 10 students!");
		} else {
			System.out.println("5.10 students is not correct!");
		}

		for (int n = 2; n < row.size(); n++) {
			for (int x = 1; x < column.size(); x++) {

				nameFound = driver.findElement(By.xpath("//table[@id='studentInfo']/tbody/tr[" + n + "]/td[" + x + "]"))
						.getText();

				if (myName.equals(nameFound)) {
					System.out.println("My name is: " + myName);
					System.out.println("4.My name found, I am in the student informations!");
				}

				email = driver.findElement(By.xpath("//table[@id='studentInfo']/tbody/tr[" + n + "]/td[2]")).getText();
				if (email.equals(myName + "@bora-cs.com")) {
					
					System.out.println("My email is: " + email);

					System.out.println("6.Email format is correct!");

					String phoneNum = driver
							.findElement(By.xpath("//table[@id='studentInfo']/tbody/tr[" + n + "]/td[3]")).getText();
					if (phoneNum.equals(myPhoneNum)) {
						System.out.println("My phone number is: " + myPhoneNum);
						System.out.println("6.My phone number is correct!");
					}
					break;
				}

			}

		}
		

		// TestScenario 2
		System.out.println("");
		System.out.println("Test Scenario 2");

		driver.get(homePageUrl);
		
		System.out.println("1.Navigated to the application home page");

		
		List<WebElement> signUpBtn = driver.findElements(By.xpath("//a[@href='register.html']"));
		
		if (signUpBtn.size() == 2) {
			System.out.println("2.Validating 2 Sign up buttons passed!");
		}

		signUpBtn.get(0).click();
		
		System.out.println("3.Clicked on Sign up.");
		
		Thread.sleep(2000);

		if (driver.getCurrentUrl().contains("register.html")) {
			System.out.println("4.I'm in sign up page!");
		}

		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("RaiDen");

		driver.findElement(By.xpath("//input[@id='male']")).click();

		driver.findElement(By.name("email")).sendKeys("jam1993625@gmail.com");

		Select select = new Select(driver.findElement(By.name("Course")));

		select.selectByValue("selenium");

		driver.findElement(By.name("password")).sendKeys("5201314");

		driver.findElement(By.name("password2")).sendKeys("5201314");

		driver.findElement(By.id("notarobot")).click();
		
		System.out.println("5.Form filled!");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		String successText = driver.findElement(By.className("alert-heading")).getText();

		if (successText.equals("Congratulations!")) {
			System.out.println("6.You are successful to sumit your form!");
		}

		String goBackHomePath = driver.findElement(By.xpath("//a[@class='btn btn-primary btn-info btn-block']"))
				.getAttribute("href");

		if (goBackHomePath.contains("landing.html")) {
			System.out.println("7.The button is sure to bring you back to homepage!");
		}

		driver.findElement(By.xpath("//a[@class='alert-link']")).click();

		System.out.println("8.Clicked on 'Bora Coding Bootcamp'.");
		
		Thread.sleep(2000);

		String boraCsUrl = "https://www.bora-cs.com";

		if (driver.getCurrentUrl().contains(boraCsUrl)) {

			System.out.println("8.You are in Bora-cs.com!");

		}

		Thread.sleep(2000);

		// Test Scenario 3
		System.out.println("");

		System.out.println("Test Scenario 3");

		
		driver.get(homePageUrl);
		
		System.out.println("1.Navigated to the application home page");

		List<WebElement> loginBtn = driver.findElements(By.xpath("//a[@href='login.html']"));

		if (loginBtn.size() == 2) {
			System.out.println("2.Validating that there are 2 login buttons passed!");
		}

		loginBtn.get(0).click();
		
		System.out.println("3.Clicked on Login.");
		
		if (driver.getCurrentUrl().contains("login.html")) {

			System.out.println("4.You are in login page!");
		}

		driver.findElement(By.name("email")).sendKeys("Raiden@bora-cs.com");

		driver.findElement(By.name("password")).sendKeys("5201314");

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		System.out.println("5.Logged in with valid information.");

		Thread.sleep(2000);

		String studentProfileLogo = driver.findElement(By.xpath("//h1[@class='display-4 text-center']")).getText();

		if ((driver.getCurrentUrl().contains("loggedIn.html")) && (studentProfileLogo.equals("Student Profile"))) {

			System.out.println("6.You are in student profile page!");
		}

		WebElement logOutBtn = driver.findElement(By.xpath("//img[@class='rounded-circle']"));
		String logOutStyle = driver.findElement(By.xpath("//img[@class='rounded-circle']")).getAttribute("style");

		if ((logOutStyle.contains("margin-right")) && (logOutBtn.isEnabled())) {

			System.out.println("7.Logout button is on the right top coner");
		}

		logOutBtn.click();
		
		System.out.println("8.Clicked on logout.");

		Thread.sleep(2000);

		WebElement popUp = driver.findElement(By.xpath("//div[@class='modal-content']"));

		if (popUp.isDisplayed()) {

			System.out.println("9.You recieve model 'Are you sure?' pop up window");
		}

		driver.findElement(By.xpath("//button[@class='btn btn-secondary']")).click();

		if ((driver.getCurrentUrl().contains("loggedIn.html")) && (studentProfileLogo.equals("Student Profile"))) {

			System.out.println("10.After you click 'Sure, I will stay', you are still on this page!");
		}

		Thread.sleep(2000);

		logOutBtn.click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@class='btn btn-info']")).click();

		if (driver.getCurrentUrl().equals(homePageUrl)) {

			System.out.println("10.After you click 'Gotta go!', you go back to homepage!");
		}

		Thread.sleep(2000);

		driver.close();
		
		driver.quit();

	}

}
