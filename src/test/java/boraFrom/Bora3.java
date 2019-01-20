package boraFrom;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Bora3 {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		// Test Scenario 3 :
        System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver");
		
		driver = new ChromeDriver();
		
		driver.navigate().to("file:///Users/xiaowenhu/eclipse-workspace/Homework/src/main/resources/MuradilE/Bora%20UI%20Test/landing.html");
		
		driver.manage().toString().replaceAll("%", "/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
        WebElement LoginButton1 = driver.findElement(By.xpath("/html/body/div/div/div/div/div/a[2]"));
        
		if(LoginButton1.isDisplayed()) {
			System.out.println("LoginButton1 is on the page " );
		}else {
			System.out.println("False");
		}
		
        WebElement LoginButton2 = driver.findElement(By.xpath("//*[@id=\"mobile-nav\"]/ul[2]/li[2]/a"));
        
		if(LoginButton2.isDisplayed()) {
			System.out.println("LoginButton2 is on the page " );
		}else {
			System.out.println("False");
		}
		
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/a[2]")).click();
		
		WebElement LoginPage = driver.findElement(By.xpath("/html/body/div/div/div/div/p"));
		if(LoginPage.isDisplayed()) {
			System.out.println("LoginPage is display");
		}else {
			System.out.println("False");
		}
		driver.findElement(By.name("email")).sendKeys("autumn.qiu@icloud.com");
		driver.findElement(By.name("password")).sendKeys("venus");
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/input")).click();
		
		WebElement studentPage = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/h1"));
		if(studentPage.isDisplayed()) {
			System.out.println("New Student is displayed on Student Profile");
		}else {
			System.out.println("False");
		}
		
		WebElement studentsPage2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/p[1]"));
		if(studentsPage2.isDisplayed()) {
			System.out.println("Skill Set is displayed on the Student Profile");
		}else {
			System.out.println("False");
		}
		
		WebElement LogoutButton = driver.findElement(By.xpath("//*[@id=\"mobile-nav\"]/ul[2]/li/a"));
		if(LogoutButton.isDisplayed()) {
			System.out.println("LogoutButton is display");
		}else {
			System.out.println("False");
		}
		
		driver.findElement(By.xpath("//*[@id=\"mobile-nav\"]/ul[2]/li/a")).click();
		
		Thread.sleep(5000);
			
		WebElement Popuptext = driver.findElement(By.xpath("//*[@id=\"exampleModalCenter\"]/div/div/div[1]"));
		if(Popuptext.isDisplayed()) {
			System.out.println("Popuptext: Are you sure is display");
		}else {
			System.out.println("False");
		}
		
		driver.findElement(By.xpath("//*[@id=\"exampleModalCenter\"]/div/div/div[3]/button")).click();
		
		String currentUrl = null;
		
		currentUrl = driver.getCurrentUrl();
		
		System.out.println(currentUrl);
		
		driver.findElement(By.xpath("//*[@id=\"exampleModalCenter\"]/div/div/div[3]/button")).click();
		
		driver.findElement(By.xpath("//a[@class='btn btn-info']")).click();
		
		String LandingPage = driver.getTitle();
		
        System.out.println("ExpectedTitle is " + LandingPage );
		
		driver.close();
		
		driver.quit();
	    }
	    }
