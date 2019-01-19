package MuzapparE;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exam1 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(
				"file:///Users/erkin/eclipse-workspace/Homework/src/main/resources/MuradilE/Bora%20UI%20Test/landing.html");
		WebElement actualText = driver.findElement(By.xpath("//div/h1"));
		String expectedText = "Bora UI Automation Test";
		if (actualText.isDisplayed() && actualText.getText().equals(expectedText)) {
			System.out.println("Validating Bora UI Automation Test Element On Homepage : pass");
		} else {
			System.out.println("Validating Bora UI Automation Test Element On Homepage : false");
		}
		WebElement actualText1 = driver.findElement(By.xpath("//div/a"));
		String expectedText1 = "Bora UI Automation";
		if (actualText1.isDisplayed() && actualText1.getText().equals(expectedText1)) {
			System.out.println("Validating Bora UI Automation Element On Homepage : pass");
		} else {
			System.out.println("Validating Bora UI Automation Element On Homepage : false");
		}
		driver.findElement(By.xpath("//ul[1]/li/a")).click();
		Thread.sleep(2000);
		WebElement actualText2 = driver.findElement(By.xpath("//div/p"));
		String expectedText2 = "Students Information";
		if (actualText2.isDisplayed() && actualText2.getText().equals(expectedText2) ) {
			System.out.println("Validating First Element On Students Information Page : pass");
		} else {
			System.out.println("Validating First Element On Students Information Page : false");
		}
		List<WebElement> students = driver.findElements(By.xpath("//tbody/tr"));
		System.out.println("There are " + (students.size() - 1) + " students ! ");
		for (int i = 1; i < students.size(); i++) {
		}
		List<WebElement> students1 = driver.findElements(By.xpath("//tbody/tr/td"));
		for (WebElement info : students1) {
			if (info.getText().contains("ppar@bora-cs.com")) {
				System.out.println("Validating The Right Fromat : pass");
			} else {
			}
		}
		for (WebElement phoneNum : students1) {

			if (phoneNum.getText().equals("202-202-2029")) {
				System.out.println("Validating My Phone Number : pass");
			} else {
			}
		}
		driver.close();
		driver.quit();
	}

}

