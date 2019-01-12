package MuradilE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.Constants;
import utilities.Keywords;

import static utilities.DriverFactory.driver;

public class randomTest {

	public static void main(String[] args) {
		Keywords.startTest(Constants.BORA_STUDENTS_URL);
		
		Keywords.searchForDataInTable("Phar@qq.com", By.id("studentInfo"));
				
        Keywords.endTest();
	}
}
