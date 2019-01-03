import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTestCase { //Class Name

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		String getUrl = driver.getCurrentUrl();
		System.out.println(getUrl);
		String title = driver.getTitle();
		System.out.println(title);

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Phone");
		driver.findElement(By.xpath("//input[@value = 'Go']")).click();
		getUrl = driver.getCurrentUrl();
		System.out.println(getUrl);
		title = driver.getTitle();
		System.out.println(title);

		driver.close();
		driver.quit();

		System.out.println("Test Success");
	}

}
