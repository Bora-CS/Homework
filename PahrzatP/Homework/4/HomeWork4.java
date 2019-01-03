import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmazonTestCase {
	static WebDriver driver;

	@Test
	public void FirstTC() {

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/"); // TC_001
		driver.manage().window().maximize();
		String getUrl = driver.getCurrentUrl();
		System.out.println(getUrl); // TC_001
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Phone"); // TC_002
		driver.findElement(By.xpath("//input[@value = 'Go']")).click(); // TC_003
		getUrl = driver.getCurrentUrl();
		System.out.println(getUrl); // TC_004
		title = driver.getTitle();
		System.out.println(title);

		driver.close(); // TC_005
		driver.quit(); // TC_005
		System.out.println("TestCase Success");
	}
}