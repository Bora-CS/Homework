package boraFrom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Bora2 {
   
	    public static WebDriver driver;
	    public static void main(String[] args) {
		
		// Test Scenario 2 :
        System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver");
		
		driver = new ChromeDriver();
		
		driver.navigate().to("file:///Users/xiaowenhu/eclipse-workspace/Homework/src/main/resources/MuradilE/Bora%20UI%20Test/landing.html");
		
		driver.manage().toString().replaceAll("%", "/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		WebElement signupButton1 = driver.findElement(By.xpath("/html/body/div/div/div/div/div/a[1]"));
        
		if(signupButton1.isDisplayed()) {
			System.out.println("SignupButton1 is on the page " );
		}else {
			System.out.println("False");
		}
		
		WebElement signupButton2 = driver.findElement(By.xpath("/html/body/div/div/div/div/div/a[2]"));
		
		if(signupButton2.isDisplayed()) {
			System.out.println("signupButton2 is on the page");
		}else {
			System.out.println("False");
		}
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/a[1]")).click();
		
		WebElement signupPage = driver.findElement(By.xpath("/html/body/div/div/div/div/p"));
		
		if(signupPage.isDisplayed()) {
			System.out.println("Create your Bora student account is on the sign up page");
		}else {
			System.out.println("False");
		}
		
		driver.findElement(By.name("name")).sendKeys("Venus");
		
		driver.findElement(By.id("female")).click();
		
		driver.findElement(By.name("email")).sendKeys("autumn.qiu@icloud.com");
		
		WebElement element = driver.findElement(By.name("Course"));
		
		Select mySelect = new Select(element);
		 
		mySelect.selectByVisibleText("Front End Development with Angular");
		
		driver.findElement(By.name("password")).sendKeys("1234567890");
		
		driver.findElement(By.name("password2")).sendKeys("1234567890");
		
		driver.findElement(By.id("notarobot")).click();
		
		driver.findElement(By.cssSelector("body > div > div > div > div > form > input")).click();
		
		WebElement submitPage = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/h4"));
		if(submitPage.isDisplayed()) {
			System.out.println("Congratulations! is display on the page");
		}else {
			System.out.println("False");
		}
		
		WebElement backToHomePage = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/a"));
		if(backToHomePage.isDisplayed()) {
			System.out.println("backToHomePage is display on the page");
		}else {
			System.out.println("False");
		}
		
		driver.findElement(By.xpath("//a[@class= 'alert-link']")).click();
		

	    WebElement BootCampPage = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/h1"));
	    if(BootCampPage.isDisplayed()) {
	    	System.out.println("Bora Coding Bootcamp is on the page");
	    }else {
	    	System.out.println("False");
	    }
	    
	
	    driver.close();
	    driver.quit();
	    }
	    }


