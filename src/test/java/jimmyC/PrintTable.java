package jimmyC;

import static utilities.DriverFactory.driver;

import java.util.List;
import java.util.Formatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.Constants;
import utilities.Keywords;

public class PrintTable {

	public static void main(String[] args) {

		Keywords.startTest(Constants.BORA_STUDENTS_URL);

		WebElement table = driver.findElement(By.id("studentInfo"));
		List<WebElement> rows = table.findElements(By.xpath("tbody/tr"));
		System.out.println("Number of Rows is " + rows.size());
		List<WebElement> columns = rows.get(0).findElements(By.xpath("th"));
		System.out.println("Number of columns is " + columns.size());
		for (WebElement rowData : table.findElements(By.tagName("th"))) {
			System.out.print(rowData.getText());
		}

		for (WebElement row : rows) {
			List<WebElement> columnData = row.findElements(By.tagName("td"));
			for (WebElement columnInput : columnData) {
				System.out.print(columnInput.getText());
			}
			
			//String [] string1 = {"Name","Email","Phone Number"};
			//String [] string2 = {"Jimmy","Jimmy@gmail.com","202-202-2022"};
			//String [] string3 = {"Phar","Phar@qq.com","800-808-0000"};
			//String [] string4 = {"Sergio","Sergio@fbi.com","911"};
			
			System.out.println();

		}
	}

}
