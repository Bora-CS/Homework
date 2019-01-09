package RaiDen;

import org.openqa.selenium.By;

import utilities.Constants;
import utilities.Keywords;

public class BoraForm {

	public static void main(String[] args) {
		Keywords.startTest(Constants.BORA_FORM_URL);
		
		Keywords.implicitWait(2);
		
		Keywords.select(By.name("Course")).selectByIndex(1);
		
		Keywords.webElementAction(By.name("firstName")).sendKeys("RaiDen");
		
		Keywords.sleep(2);
		
		Keywords.webElementAction(By.name("lastName")).sendKeys("Cheung");
		
		Keywords.sleep(2);
		
		Keywords.webElementAction(By.name("pwd")).sendKeys("5201314");
		
		Keywords.sleep(2);
		
		Keywords.webElementAction(By.xpath("//input[@value='Male']")).click();
		
		Keywords.sleep(2);
		
		Keywords.webElementAction(By.name("submitForm")).click();
		
		Keywords.alert().accept();
		
		Keywords.endTest();
		

	}

}
