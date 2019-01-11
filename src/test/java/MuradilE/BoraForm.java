package MuradilE;

import utilities.Constants;
import utilities.Keywords;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static utilities.DriverFactory.driver;

import java.util.Iterator;
import java.util.List;

public class BoraForm {

	public static void main(String[] args) throws InterruptedException {

		Keywords.startTest(Constants.BORA_STUDENTS_URL);
		
		
		Keywords.waitFor(2);
		
		Keywords.endTest();
	}

}
