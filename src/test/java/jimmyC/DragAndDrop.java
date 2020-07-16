package jimmyC;

import static utilities.DriverFactory.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.Keywords;

public class DragAndDrop {

	public static void main(String[] args) {

		Keywords.startTest("https://www.amazon.com");

		WebElement hover = driver.findElement(By.id("nav-link-accountList"));
		Actions act = new Actions(driver);

		act.moveToElement(hover).build().perform();

		Keywords.waitFor(2);
		WebElement myList = driver.findElement(By.xpath("//span[text()='Create a List']"));
		Keywords.waitFor(2);

		myList.click();

	}

}
