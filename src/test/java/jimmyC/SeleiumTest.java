package jimmyC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleiumTest {

	
		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.navigate().to("file:///C:/Users/jcruk/Homework/src/main/resources/MuradilE/Bora%20UI%20Test/landing.html");
		
			String expeacedUtl = driver.getCurrentUrl();
			
			if(expeacedUtl.contains("landing.html")){
				System.out.println( "I am on the landing page");
			}else{
				System.out.println("I am ont on the Landing page");
			}
		
			driver.findElement(By.xpath("//div/ul/li/a[contains(text(),'Students')]")).click();
			WebElement StudentsInfo= driver.findElement(By.xpath("//div/h1"));
			
			String studentsInfoExpectedTitle = "Students Information";
			
		    if(StudentsInfo.getText().equals(studentsInfoExpectedTitle)){
		    	System.out.println("I am at the Students informaton page" );
		    }else{
		    	System.out.println("I am not at the Students informaton page");
		    }

		    WebElement table = driver.findElement(By.id("studentInfo"));
		    List<WebElement> rowInfo = table.findElements(By.xpath("tbody/tr"));
		    for (int i = 0; i < rowInfo.size()-1; i++) {
		    	if(i==0){
		    		List<WebElement> thInfo = rowInfo.get(1).findElements(By.tagName("th"));
		    		System.out.println(thInfo.get(i).getText());
		    	}else{
		    		 List<WebElement> colInfo =rowInfo.get(1).findElements(By.tagName("td"));
		    		 System.out.println(colInfo.get(i).getText());
			}
		   
		    	driver.navigate().to("file:///C:/Users/jcruk/Homework/src/main/resources/MuradilE/Bora%20UI%20Test/landing.html");
		    	WebElement signUp = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-info mr-2']"));
		    	
		    	String signUpButton = "signUp";
		    	if(signUp.getText().contains(signUpButton)){
		    		System.out.println("Sign Up Button is dipalye!");
		    	}else{
		    		System.out.println("Sign Up Button is not dipalye!");
		    	}
		    		
		    	WebElement login = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-light']"));
		    	String loginButton ="login";
		    	if(login.getText().contains(loginButton)){
		    		System.out.println("login Button is dipalye!");
		    	}else{
		    		System.out.println("login Button is not dipalye!");
		    	}
		    	
		    	driver.findElement(By.xpath("//a[@class='btn btn-lg btn-info mr-2']")).click();
		        String signUpUrl = driver.getCurrentUrl();
		        if(signUpUrl.contains("register.htm")){
		        	System.out.println("I am on the sign up page! ");
		        }else{
		        	System.out.println("I am not on the sign up page! ");
		        }
		    
		        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("jimmy");
		        
		        driver.findElement(By.xpath("//input[@id='male']")).click();
		        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("chungj868@gmail.com");
			    Select mySelect = new Select(driver.findElement(By.xpath("//select")));
			    mySelect.selectByValue("selenium");
		 
			    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("jimmy12345");
			    driver.findElement(By.xpath("//input[@name='password2']")).sendKeys("jimmy12345");
			    driver.findElement(By.id("//input[@id='notarobot']")).click();
			    driver.findElement(By.xpath("//input[@type='submit']")).submit();
			    
			    WebElement successMessage = driver.findElement(By.xpath("//h4[@class='alert-heading']"));
			    String successful = "Congratulations!";
			    
			    if(successMessage.getText().contains(successful)){
			    	System.out.println("Congratulations text is dispaly! ");
			    }else{
			    	System.out.println("Congratulations test is not dispaly! ");
			    }
			    
			  WebElement backToHomePage =  driver.findElement(By.xpath("//a[@class='btn btn-primary btn-info btn-block']"));
			  String backHomeButton = "Back to Home Page";
			  if (backToHomePage.getText().contains(backHomeButton)){
				  System.out.println("Back to Home page is displayed!");
			  }else{
				  System.out.println("Back to Home page is not displayed!");
			  }
		    }
		    
		    
		    
		    
		    
		    
				
			}
		    
		   
		   
	



	}


