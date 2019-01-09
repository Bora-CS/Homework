package MuradilE;
import utilities.Constants;
import utilities.Keywords;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static utilities.DriverFactory.driver;

public class BoraForm {

	public static void main(String[] args) throws InterruptedException {
		
		
		Keywords.startTest(Constants.BORA_FORM_URL);
		Keywords.sleep(2);
		
		Keywords.select(By.name("Course")).selectByIndex(1);
		
		Keywords.webElementAction(By.name("firstName")).sendKeys("a");
		
//		Keywords.input(By.name("firstName"), "Muradil");
		Keywords.sleep(1);
//		Keywords.input(By.name("lastName"), "Erkin");
		Keywords.sleep(1);
	
		Dimension myDim = driver.findElement(By.tagName("img")).getSize();
		
		Keywords.print("The Image Width: "+ myDim.getWidth() +
						" Height: " + myDim.getHeight());
		
		
		Keywords.endTest();
	}

}
