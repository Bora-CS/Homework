package MuzapparE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Exam1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = MuzapparKeywords.startMyTest();
		
		WebElement actualText = driver.findElement(By.xpath("//div/h1"));
		String expectedText = "Bora UI Automation Test";

		MuzapparKeywords.printValidation(expectedText + " Element On Homepage ",
				actualText.isDisplayed() && actualText.getText().equals(expectedText));

		WebElement actualText1 = driver.findElement(By.xpath("//div/a"));
		String expectedText1 = "Bora UI Automation";

		MuzapparKeywords.printValidation(expectedText1 + " Element On Homepage ",
				actualText1.isDisplayed() && actualText1.getText().equals(expectedText1));

		driver.findElement(By.xpath("//ul[1]/li/a")).click();
		Thread.sleep(2000);
		WebElement actualText2 = driver.findElement(By.xpath("//div/p"));
		String expectedText2 = "Students Information";

		MuzapparKeywords.printValidation(expectedText2 + " On Students Information Page ",
				actualText2.isDisplayed() && actualText2.getText().equals(expectedText2));

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
