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
		WebElement actualText = driver.findElement(By.xpath("/html/body/div/div/div/div/div/h1"));
		if (actualText.isDisplayed()) {
			System.out.println("Validating First Element On Homepage : pass");
		} else {
			System.out.println("false");
		}
		WebElement actualText1 = driver.findElement(By.className("navbar-brand"));
		if (actualText1.isDisplayed()) {
			System.out.println("Validating Sconed Element On Homepage : pass");
		} else {
			System.out.println("false");
		}
		driver.findElement(By.className("nav-link")).click();
		Thread.sleep(2000);
		WebElement actualText2 = driver.findElement(By.xpath("/html/body/div/div/div/div/p"));
		if (actualText2.isDisplayed()) {
			System.out.println("Validating First Element On Students Information Page : pass");
		} else {
			System.out.println("false");
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

