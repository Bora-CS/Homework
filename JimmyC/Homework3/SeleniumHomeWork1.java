package FirstClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumHomeWork1 {

		public static WebDriver driver;
	    public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		}
		@Test
		public void firstTest(){
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("book");
		driver.findElement(By.className("nav-search-submit")).click();
		sleep(5);
		driver.findElement(By.linkText("Children's Books")).click();
		driver.findElement(By.xpath("//a[text()='Ages 6-8 Years Old']")).click();
		sleep(5);
		driver.findElement(By.xpath("//input[@name='s-ref-checkbox-3269849011']")).click();
		 driver.findElement(By.xpath("//img[@class='a-dynamic-image image-stretch-vertical frontImage']")).click();
		}
		@AfterTest
		public static void endTest(){
		driver.close();
		driver.quit();
		}
		public static void sleep(int second){
			try {
					Thread.sleep(5*1000);
			}catch (InterruptedException e){
				e.printStackTrace();
}
				
				
				
				

}
			
}		
			
			
