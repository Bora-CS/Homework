package boraFrom;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoraAutomation {

	public static WebDriver driver;
	public static void main(String[] args) {
		
        // Test Scenario 1 :
		System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver");
		
		driver = new ChromeDriver();
		
		driver.navigate().to("file:///Users/xiaowenhu/eclipse-workspace/Homework/src/main/resources/MuradilE/Bora%20UI%20Test/landing.html");
		
		driver.manage().toString().replaceAll("%", "/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		String actualTitle = driver.getTitle();
        System.out.println("ExpectedTitle is " + actualTitle );
		
		driver.findElement(By.xpath("//a[@class = 'nav-link']")).click();
		
		String actualText = driver.findElement(By.xpath("/html/body/nav/div/a")).getText();
		System.out.println("ExpectedText is " + actualText);
		
		WebElement table = driver.findElement(By.id("studentInfo"));

		List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		
		System.out.println("Rows: "+listOfRows.size());
		
		int row_count = driver.findElements(By.xpath("//*[@id='studentInfo']/tbody/tr")).size();
		System.out.println("Number Of Rows = "+ row_count);
		
		int colum_count = driver.findElements(By.xpath("//*[@id='studentInfo']//th")).size();
		System.out.println("Number of Colums = " + colum_count);
	    
		
		for (int i = 2; i <= row_count; i++) {
			
		for (int j = 1; j <= colum_count; j++) {
			
		driver.findElement(By.xpath("//*[@id=\"studentInfo\"]/tbody/tr["+ i +"]/td" + "["+ j +"]")).getText();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"studentInfo\"]/tbody/tr["+ i +"]/td" + "["+ j +"]")).getText());
			}
			
		}
        String tableInfo = driver.findElement(By.xpath("//*[@id=\"studentInfo\"]/tbody/tr[8]/td[2]")).getText();
        if(tableInfo.matches(tableInfo)) {
        	System.out.println("Venus Email Adress is " + tableInfo);
        }else {
        	System.out.println("False");
        }
        
        String tableInfo2 = driver.findElement(By.xpath("//*[@id=\"studentInfo\"]/tbody/tr[8]/td[3]")).getText();
        if(tableInfo2.matches(tableInfo2)) {
        	System.out.println("Venus PhoneNum is " + tableInfo2);
        }else {
        	System.out.println("False");
        }

		driver.close();
		driver.quit();
		
	} 
       public static void actualTitle() {	
		
	}

	public static void getText(String actualText) {

	}

    
    }
