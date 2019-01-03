import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Amazon {
	
  @Test
  public void test() {
	  
	  System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver" );
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("https://www.amazon.com");
	  
	  sleep(5);
	  
	  
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Alexa Spot");
	  driver.findElement(By.className("nav-input")).click();
	  
	  driver.findElement(By.xpath("//html/body//h2[text()=\"Echo Spot - Smart Display with Alexa - Black\"]")).click();
	  
	  driver.findElement(By.xpath("//img[@class='imgSwatch']")).click();
	  
	  driver.findElement(By.id("add-to-cart-button")).click();
	  
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  driver.findElement(By.xpath("//div[contains(@class,'a-popover a-popover-modal a-declarative')]")).click();
	  driver.findElement(By.className("a-button-input")).click();
	  
	  driver.findElement(By.className("a-button-text")).click();
	
	  
	  
//	  driver.switchTo().frame("iframe0");
//	  driver.findElement(By.className("a-button-input")).click();
//	  driver.switchTo().frame("a-popover-content-8");
//	  driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
//	  //Switching to Alert
//	  Alert alert = driver.switchTo().alert();
	  
//	  driver.switchTo().alert().accept();
//	  driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
//	  
//	  //Capturing alert message
//	  String alertMessage = driver.switchTo().alert().getText();
//	  System.out.println(alertMessage);
//	  try {
//		Thread.sleep(5000);
//	} catch (InterruptedException e) {
//		
//		e.printStackTrace();
//	}
//	  
//	  alert.accept();
	  
  }
  private void sleep(int i) {
	
	
}

}
`