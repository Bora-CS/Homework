package MuradilE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static MuradilE.TestKeywords.driver;
import static MuradilE.TestKeywords.testCaseStatus;

public class BoraUITest_1 {

	public static String testData = "Murad";

	public static void main(String[] args) throws InterruptedException {
		
		testCaseStatus = true;
		
		TestKeywords.startTest();

		driver.findElement(By.xpath("//a[@href='students.html']")).click();

		WebElement table = TestKeywords.tryToFindAnElement("the students information table", By.id("studentInfo"));

		if (table != null) {
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			int numberOfStudents = rows.size() - 1;

			if (numberOfStudents != 10) {
				System.out.println("The number of Students is not 10");
				testCaseStatus = false;
			}

			List<WebElement> names = table.findElements(By.xpath("//tr/td[1]"));

			boolean found = false;
			for (int i = 0; i < names.size(); i++) {
				if (names.get(i).getText().equals(testData)) {
					String email = driver.findElement(By.xpath("//tr[" + (i + 2) + "]/td[2]")).getText();
					String phoneNumber = driver.findElement(By.xpath("//tr[" + (i + 2) + "]/td[3]")).getText();

					if (!email.contains("@bora-cs.com")) {
						System.out.println("The email is not formatted correctly: " + email);
						testCaseStatus = false;
					}

					if (!phoneNumber.contains("202-202-20")) {
						System.out.println("The phone number is not correct: " + phoneNumber);
						testCaseStatus = false;
					}
					found = true;
				}
			}

			if (!found) {
				testCaseStatus = false;
			}
		}

		Thread.sleep(2000);

		TestKeywords.endTest();

		TestKeywords.checkTestCaseStatus();

	}

}
