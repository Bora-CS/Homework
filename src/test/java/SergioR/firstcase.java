package SergioR;

import static utilities.DriverFactory.driver;

import utilities.Keywords;

public class firstcase {
	public static void main(String[] args) {

		Keywords.startTest("https://www.google.com/");

		Keywords.sleep(3);

		driver.navigate().to("https://www.youtube.com");

		Keywords.sleep(3);

		Keywords.back();

		Keywords.sleep(3);

		Keywords.endTest();

	}

}
