package MuzapparE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exam3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(
				"file:///Users/erkin/eclipse-workspace/Homework/src/main/resources/MuradilE/Bora%20UI%20Test/landing.html");
		WebElement signIn1 = driver.findElement(By.xpath("//*[@id=\"mobile-nav\"]/ul[2]/li[2]/a"));
		if (signIn1.isDisplayed()) {
			System.out.println("Sign In is here");
		} else {
			System.out.println("false");
		}
		WebElement signIn2 = driver.findElement(By.xpath("/html/body/div/div/div/div/div/a[2]"));
		if (signIn2.isDisplayed()) {
			System.out.println("Another Sign In is here");
		} else {
			System.out.println("false");
		}

		signIn1.click();
		WebElement signIpText = driver.findElement(By.xpath("/html/body/div/div/div/div/p"));
		if (signIpText.isDisplayed()) {
			System.out.println("im on the sign in page");
		} else {
			System.out.println("false");
		}
		driver.findElement(By.name("email")).sendKeys("Muzappar@bora-cs.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/input")).click();
		Thread.sleep(2000);
		WebElement img = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[1]/img"));
		if (img.isDisplayed()) {
			System.out.println("Found the img");
		} else {
			System.out.println("false");
		}
		WebElement studentsProfileText = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/h1"));
		if (studentsProfileText.isDisplayed()) {
			System.out.println("Found the students profile text");
		} else {
			System.out.println("false");
		}
		WebElement logOutBotton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/h1"));
		if (logOutBotton.isDisplayed()) {
			System.out.println("Log out botton is displayed");
		} else {
			System.out.println("false");
		}
		driver.findElement(By.xpath("//*[@id=\"mobile-nav\"]/ul[2]/li/a")).click();
		Thread.sleep(2000);
		WebElement aleart = driver.findElement(By.id("exampleModalCenter"));
		if (aleart.isDisplayed()) {
			System.out.println("Aleart is displayed");
		} else {
			System.out.println("false");
		}
		driver.findElement(By.xpath("//*[@id=\"exampleModalCenter\"]/div/div/div[3]/button")).click();
		Thread.sleep(2000);
		WebElement img2 = driver.findElement(By.xpath("//*[@id=\"mobile-nav\"]/ul[2]/li/a/img"));
		if (img2.isDisplayed()) {
			System.out.println("Im still on the page");
		} else {
			System.out.println("false");
		}
		driver.findElement(By.xpath("//*[@id=\"mobile-nav\"]/ul[2]/li/a")).click();
		driver.findElement(By.xpath("//*[@id=\"exampleModalCenter\"]/div/div/div[3]/a")).click();
		Thread.sleep(2000);
		WebElement homePage = driver.findElement(By.xpath("/html/body/div/div/div/div/div/h1"));
		if (homePage.isDisplayed()) {
			System.out.println("Im back on the home page");
		} else {
			System.out.println("false");
		}
		driver.close();
		driver.quit();
	}

}
