
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeWorkBora {

	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		
		driver = new ChromeDriver();
		
		driver.navigate().to("file:///Users/xiaowenhu/Desktop/Git/TeamBora/MuradilE/ClassResources/index.html");
		
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(2000);
		
		Select selectList = new Select(driver.findElement(By.id("course")));
		
		selectList.selectByValue("selenium");
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("firstName")).sendKeys("Venus");
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("lastName")).sendKeys("Hu");
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("pwd")).sendKeys("1234567890");
		
		Thread.sleep(2000);
		
		WebElement gender = driver.findElement(By.xpath("//input[@value='Female']"));
		
		Thread.sleep(2000);
		
		System.out.println("Female - Selected:" + gender.isSelected());
		
		Thread.sleep(2000);
		
		gender.click();
		
		driver.findElement(By.name("submitForm")).click();
		
		Thread.sleep(2000);
		
	    driver.switchTo().alert().accept();
	    
	    driver.close();
	    
	    driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
