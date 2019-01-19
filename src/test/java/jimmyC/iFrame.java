package jimmyC;

import static utilities.DriverFactory.driver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import utilities.Constants;
import utilities.Keywords;

public class iFrame {

	public static void main(String[] args) {

		Keywords.startTest(Constants.BORA_FORM_URL);

		Keywords.waitFor(5);

		driver.switchTo().frame("StudentInfoFrame");

		WebElement text = driver.findElement(By.xpath("//table/tbody/tr/td"));

		System.out.println(text.getText());

		driver.switchTo().defaultContent();

		driver.findElement(By.name("submitForm")).click();

		driver.switchTo().alert().accept();

		Select mySelect = new Select(driver.findElement(By.id("course")));
		mySelect.selectByValue("selenium");
		mySelect.selectByVisibleText("Front End Development with Angular");
		mySelect.selectByIndex(3);
		mySelect.selectByIndex(2);

		Select langugeSelect = new Select(driver.findElement(By.id("courseLanguage")));
		System.out.println(langugeSelect.isMultiple());

		driver.navigate().to(Constants.BORA_STUDENTS_URL);

		WebElement table = driver.findElement(By.id("studentInfo"));
		List<WebElement> rows = table.findElements(By.xpath("//tbody/tr"));
		List<WebElement> colunms = rows.get(0).findElements(By.xpath("th"));
		System.out.println(rows.size());
		System.out.println(colunms.size());

	
		
	}

		}

	
	

	
	  
	  
	  
	  
	  
	

