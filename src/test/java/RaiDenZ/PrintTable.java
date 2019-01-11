package RaiDenZ;

import static utilities.DriverFactory.driver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.Constants;
import utilities.Keywords;

public class PrintTable {

	public static void main(String[] args) {
		
		Keywords.startTest(Constants.BORA_STUDENTS_URL);
		
		List<List<WebElement>> column = new ArrayList<List<WebElement>>();
		
		List<WebElement> heading = driver.findElements(By.xpath("html/body/table/tbody/tr/th"));
		
		List<WebElement> row1 = driver.findElements(By.xpath("html/body/table/tbody/tr[2]/td"));
		
		List<WebElement> row2 = driver.findElements(By.xpath("html/body/table/tbody/tr[3]/td"));
		
		List<WebElement> row3 = driver.findElements(By.xpath("html/body/table/tbody/tr[4]/td"));
		
		column.add(heading);
		
		column.add(row1);
		
		column.add(row2);
		
		column.add(row3);
		
		for(int x=0; x < column.size() ;x++) {
			
		
			System.out.format("%-20s%-20s%-20s\n", column.get(x).get(0).getText(), column.get(x).get(1).getText(), column.get(x).get(2).getText());
		}
		
		
		
		Keywords.endTest();
	}

}
