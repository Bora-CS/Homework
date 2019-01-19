package boraFrom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoraAutomation {

	public static WebDriver driver;
	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver");
		
		driver = new ChromeDriver();
		
		driver.navigate().to("file:///Users/xiaowenhu/eclipse-workspace/Homework/src/main/resources/MuradilE/Bora%20UI%20Test/landing.html");
		
		driver.manage().toString().replaceAll("%", "/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		String actualTitle = driver.getTitle();
        System.out.println("ActualTitle is " + actualTitle );
		
		driver.findElement(By.xpath("//a[@class = 'nav-link']")).click();
		
		String actualText = driver.findElement(By.xpath("/html/body/nav/div/a")).getText();
		System.out.println("Expected Text is " + actualText);
		
		WebElement table = driver.findElement(By.id("studentInfo"));

		List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		
		System.out.println("Rows: "+listOfRows.size());
		
		int row_count = driver.findElements(By.xpath("//*[@id='studentInfo']/div[5]/table/tbody/tr")).size();
		System.out.println("Number Of Rows = "+ row_count);
		
		int colum_count = driver.findElements(By.xpath("//*[@id='studentInf']/div[5]/table/tbody/tr[1]/td")).size();
		System.out.println("Number of Colums = " + colum_count);
	    
		for (int i =1 ; i < row_count ; i++) {
			System.out.println(row_count);
		   			}
		for (int i = 1; i < colum_count; i++) {
		System.out.println(colum_count);
		}
		

		driver.close();
		driver.quit();
		
		
		
	} 
       public static void actualTitle() {
		
		
	}
//	public static void getTitle(String actualTitle) {
//		driver.get("file:///Users/xiaowenhu/eclipse-workspace/Homework/src/main/resources/MuradilE/Bora%20UI%20Test/landing.html");
//		actualTitle = driver.getTitle();
//		System.out.println("ActualTitle is " + actualTitle);
//	}
	public static void getText(String actualText) {
//		driver.get("file:///Users/xiaowenhu/eclipse-workspace/Homework/src/main/resources/MuradilE/Bora%20UI%20Test/landing.html");
//		actualText = driver.findElement(By.xpath("//p[@class= 'lead text-center']")).getText();
//		System.out.println("ExpectedText is " + actualText);
	}

    
}
