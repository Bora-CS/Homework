package PharP;

import org.openqa.selenium.By;

import utilities.Constants;

import utilities.Keywords;

public class mFTC {

	public static void main(String[] args) throws Exception {

		Keywords.startTest(Constants.BORA_FORM_URL);

		Keywords.click(By.name("submitForm"));

		Keywords.click(By.xpath("//input[@onclick='popUp()']"));

		Keywords.endTest();

	}
}
