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
		WebElement signIn1 = driver.findElement(By.xpath("//ul[2]/li[2]/a"));
		if (signIn1.isDisplayed()) {
			System.out.println("Validating Sign In Is Here : pass");
		} else {
			System.out.println("Validating Sign In Is Here : false");
		}
		WebElement signIn2 = driver.findElement(By.xpath("//div/a[2]"));
		if (signIn2.isDisplayed()) {
			System.out.println("Validating Another Sign In Is here : pass");
		} else {
			System.out.println("Validating Another Sign In Is here : false");
		}
		signIn1.click();
		WebElement signIpText = driver.findElement(By.xpath("//div/p"));
		String expectedSignIn = "Sign in to your Bora student account";
		if (signIpText.isDisplayed() && signIpText.getText().equals(expectedSignIn)) {
			System.out.println("Validating Im On the Sign In Page : pass");
		} else {
			System.out.println("Validating Im On the Sign In Page : false");
		}
		driver.findElement(By.name("email")).sendKeys("Muzappar@bora-cs.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div/form/input")).click();
		Thread.sleep(2000);
		WebElement img = driver.findElement(By.xpath("//div[1]/img"));
		if (img.isDisplayed()) {
			System.out.println("Validating The Img : pass");
		} else {
			System.out.println("Validating The Img : false");
		}
		WebElement studentsProfileText = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/h1"));
		String expectedStudentsProfileText = "Student Profile";
		if (studentsProfileText.isDisplayed() && studentsProfileText.getText().equals(expectedStudentsProfileText)) {
			System.out.println("Validating The Students Profile Text : pass");
		} else {
			System.out.println("Validating The Students Profile Text : false");
		}
		WebElement logOutBotton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/h1"));
		if (logOutBotton.isDisplayed()) {
			System.out.println("Validating Log Out Botton Is Displayed : pass");
		} else {
			System.out.println("Validating Log Out Botton Is Displayed : false");
		}
		driver.findElement(By.xpath("//*[@id=\"mobile-nav\"]/ul[2]/li/a")).click();
		Thread.sleep(2000);
		WebElement aleart = driver.findElement(By.id("exampleModalCenter"));
		if (aleart.isDisplayed()) {
			System.out.println("Validating Aleart Is Displayed : pass");
		} else {
			System.out.println("Validating Aleart Is Displayed : false");
		}
		driver.findElement(By.xpath("//*[@id=\"exampleModalCenter\"]/div/div/div[3]/button")).click();
		Thread.sleep(2000);
		WebElement img2 = driver.findElement(By.xpath("//ul[2]/li/a/img"));
		if (img2.isDisplayed()) {
			System.out.println("Validating Still On The Page : pass");
		} else {
			System.out.println("Validating Still On The Page : false");
		}
		driver.findElement(By.xpath("//ul[2]/li/a")).click();
		driver.findElement(By.xpath("//div[3]/a")).click();
		Thread.sleep(2000);
		WebElement homePage = driver.findElement(By.xpath("//div/h1"));
		if (homePage.isDisplayed()) {
			System.out.println("Validating Back On The Home Page : pass");
		} else {
			System.out.println("Validating Back On The Home Page : false");
		}
		driver.close();
		driver.quit();
	}

}
