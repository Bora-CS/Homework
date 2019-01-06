package seleniumUnit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

	public class unit3_BoraWeb {
	
		public static void main(String[] args) {
	
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			driver.get("file:///C:/Users/Administrator/TeamBora/MuradilE/ClassResources/index.html");
	
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			Map<String, String> myInfo = new HashMap<String, String>();
			
			myInfo.put("firstName", "RaiDen.");
			
			myInfo.put("lastName", "Cheung");
			
			myInfo.put("email", "jam1993625@gmail.com");
			
			myInfo.put("pwd", "5201314");
			
			Select dropDown = new Select(driver.findElement(By.id("course")));
			
			dropDown.selectByValue("selenium");
			
			driver.findElement(By.name("firstName")).sendKeys(myInfo.get("firstName"));
			
			driver.findElement(By.name("lastName")).sendKeys(myInfo.get("lastName"));
			
			driver.findElement(By.name("email")).sendKeys(myInfo.get("email"));
			
			driver.findElement(By.name("pwd")).sendKeys(myInfo.get("pwd"));
			
			driver.findElement(By.xpath("//input[@value='Male']")).click();
			
			driver.findElement(By.name("submitForm")).click();
			
			driver.switchTo().alert().accept();
			
			String form = driver.getCurrentUrl().split("\\?")[1];
			
			String[] formArr = form.split("&");
			
			Map<String, String> myForm = new HashMap<String, String>();
			
			for(int n=0; n<formArr.length; n++) {
				
				if(formArr[n].contains("%40")) {
					
					formArr[n] = formArr[n].replace("%40", "@");
					
				}
				
				myForm.put(formArr[n].split("=")[0], formArr[n].split("=")[1]);
			}
			
			for(String string: myInfo.keySet()) {
				
				if(!myForm.containsKey(string)) {
					
					continue;
					
				}
				
				String expectedResult = myInfo.get(string);
				
				System.out.println("The expected result of " + string + " is: " + expectedResult);
				
				String actualResult = myForm.get(string);
				
				System.out.println("The actual result of " + string + " is: " + actualResult);
				
				System.out.println("The matching verification is: " + (expectedResult.equals(actualResult) ? "Pass!" : "Fail!"));
				
				System.out.println("\n");
				
			}
			
			driver.close();
			
			driver.quit();
			
	
		}
	
	}
