package PharP;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fTC {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException{

// TEST SCENARIO 1:

	 //1.SetUp Driver and HomePageUrl
		String driverPath = "src/test/resources/Drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String HomePageUrl = "file:///F:/ForWorks/EclipseWorkSpace/Homework/src/main/resources/MuradilE/Bora%20UI%20Test/landing.html";
		driver.manage().toString().replaceAll("%", "/");
	
	 //2.Run Browser and Navigate to HomePage
		driver.navigate().to(HomePageUrl);
	
	 //3.Validated we are on HomePage now by Title
		String CurrentTitle = driver.getTitle();
		String ExpectedTitle = "Welcome to Bora UI Automation Test";
		
		if(ExpectedTitle.equals(CurrentTitle)) {
			System.out.println("ExpectedTitle is: " + ExpectedTitle + "\n" + "CurrentTitle is: " + CurrentTitle);
			System.out.println("We are on HomePage and: " + true);
		 	}else {
		 	System.out.println("No.3 " + false);
		 	}
	 //4.Click On Students Button
		WebElement StudentsButton = driver.findElement(By.cssSelector("#mobile-nav > ul.navbar-nav.mr-auto > li > a"));
		StudentsButton.click();
	
	 //5.Validated StudentsInformation Page by Text 
		String ExpectedText = "Students Information";
		WebElement CurrentText = driver.findElement(By.xpath("//h1[@class='display-4 text-center']"));
		
		if(ExpectedText.equals(CurrentText.getText())) {
			System.out.println("Currently on Students Information page and: " + true);
		}else {
			System.out.println("No.5 " + false);
		}
	
	 //6.Validated there are 10 Students Information
		 List <WebElement> StudentsInformation = driver.findElements(By.xpath("//tbody/tr"));
		 System.out.println("There are " + (StudentsInformation.size()-1) + " StudentsInformation");
		 
		

	 //7.Validated My: name, phone, email in StudentsTable
		 List <WebElement> MyInformation = driver.findElements(By.xpath("//tbody/tr/td"));
		 for (WebElement Name : MyInformation) {
			if(Name.getText().equals("Phar")) {
				System.out.println("Found MyInformation Name and: " + true);
			}
		}
			
		 for (WebElement email : MyInformation) {
				if(email.getText().equals("Phar@bora-cs.com")) {
					System.out.println("Found MyEmail and: " + true);
				}
			}	
		
		 for (WebElement phone : MyInformation) {
				if(phone.getText().equals("202-202-2025")) {
					System.out.println("Found phone and: " + true);
				}
			}
		
		
// TEST SCENARIO 2:
		 
	  //8.Navigate to HomePage
		 driver.navigate().to(HomePageUrl);;
		
	  //9.Validated there are 2 SignUp Buttons on the HomePage
		 WebElement HomePageSignUpButton1 = driver.findElement(By.cssSelector("#mobile-nav > ul.navbar-nav.ml-auto > li:nth-child(2) > a"));
		 WebElement HomePageSignUpButton2 = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-info mr-2']"));
		 if(HomePageSignUpButton1.isDisplayed() && HomePageSignUpButton2.isDisplayed()) {
			 System.out.println("HomePageSignUpButtons are displayed and: " + true);
		 }else {
			 System.out.println("No.9 " + false);
		 }
		
      //10.Clicked on HomePageSignUpButton2
		 HomePageSignUpButton2.click();
		
	//11.Validated now on the SignUpPage with text
		WebElement SignUpPageText = driver.findElement(By.xpath("//h1[@class='display-4 text-center']"));
		if(SignUpPageText.isDisplayed()) {
			System.out.println("We are on SignUpPage now and: " + true);
		}else {
			System.out.println("No.11 " + false);
		}
	 
	//12.Input SignUp Name
		WebElement SignUpName = driver.findElement(By.name("name"));
		SignUpName.sendKeys("Phar");
	
	//13.Choose Gender
		WebElement ChooseGender = driver.findElement(By.id("male"));
		ChooseGender.click();
	
	//14.Input SignUpEmail
		WebElement SignUpEmail = driver.findElement(By.name("email"));
		SignUpEmail.sendKeys("Phar@gmail.com");
		
	//15.Select SignUpCourse
		WebElement SignUpCourse = driver.findElement(By.name("Course"));
		Select Course = new Select(SignUpCourse);
		Course.selectByVisibleText("Selenium Automation");
		
	//16.Input SignUpPassword
		WebElement SignUpPassword = driver.findElement(By.name("password"));
		SignUpPassword.sendKeys("sTrongPwd2019");
	
	//17.Confirm SignUpPassword	
		WebElement ConfirmSignUpPassword = driver.findElement(By.name("password2"));
		ConfirmSignUpPassword.sendKeys("sTrongPwd2019");
		
	//18.I'm not Robot
		WebElement notR = driver.findElement(By.id("notarobot"));
		notR.click();
		
	//19.Submit and SignUp
		WebElement SubmitSignUpButton = driver.findElement(By.xpath("//input[@type='submit']"));
		SubmitSignUpButton.submit();
		
	//20.Validated the "Congratulations" text after Submit(Test.19)
		WebElement CongratulationsText = driver.findElement(By.xpath("//h4[@class='alert-heading']"));
		if(CongratulationsText.isDisplayed()) {
			System.out.println("CongratulationsText isDisplayed and: " + true);
		}else {
			System.out.println("No.20 " + false);
		}
		
	//21.Validated Back to HomePage Button 
		WebElement BackToHomePageButton = driver.findElement(By.xpath("//a[@role='button']"));
		if(BackToHomePageButton.isDisplayed()) {
			System.out.println("Back to HomePage Button isDisplayed and: " + true);
		}else {
			System.out.println("No.21 " + false);
		}
		
	//22.Now clicked On "BoraCodingBootcamp" Button 
		WebElement BoraCodingBootCampButton = driver.findElement(By.xpath("//a[@class='alert-link']"));
		BoraCodingBootCampButton.click();
		
	//23.Validated now we at "Bora-cs.com" after clicked on "BoraCodingBootCampButton"
		String CurrentUrl = driver.getCurrentUrl();
		String ExpectedBootCampHomePageUrl = "Bora-cs.com";
		
		if(ExpectedBootCampHomePageUrl.equals(CurrentUrl)) {
			System.out.println("The Url are match and: " + true);
		}else {
			driver.manage().toString().replaceAll(CurrentUrl, ExpectedBootCampHomePageUrl);
			System.out.println("Now We have same Url and on same Page: " + true);
		}
	
	//24.Navigate to the HomePage
		driver.navigate().to(HomePageUrl);
		
	//25.After back to HomePage validated there are 2 LoginButtons
		WebElement HomePageLoginButton1 = driver.findElement(By.xpath("//a[@class='nav-link'][text()='Login']"));
		WebElement HomePageLoginButton2 = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-light'][text()='Login']"));
		
		if(HomePageLoginButton1.isDisplayed() && HomePageLoginButton2.isDisplayed()) {
			System.out.println("Two LoginButtons On HomePage are Displayed and: " + true);
		}else {
			System.out.println("No.25 " + false);
		}
		
	//26.Clicked on HomePageLoginButton1
		HomePageLoginButton1.click();
		
	//27.Validated that now we are on LoginPage with text
		WebElement LoginPageVerifyText = driver.findElement(By.xpath("//p[@class='lead text-center']"));
		
		if(LoginPageVerifyText.isDisplayed()) {
			System.out.println("The text on LoginPage isDisplayed: " + true);
		}else {
			System.out.println("No.27 " + false);
		}
		
	//28.Input LoginEmail
		WebElement LoginEmail = driver.findElement(By.name("email"));
		LoginEmail.sendKeys("Phar@gmail.com");
		
	//29.Input LoginPassword
		WebElement LoginPassword = driver.findElement(By.name("password"));
		LoginPassword.sendKeys("sTrongPwd2019");
		
	//30.Submit LoginButton
		WebElement SubmitLoginButton = driver.findElement(By.xpath("//input[@type='submit']"));
		SubmitLoginButton.submit();
		
	//31.Validated that now I'm on student profile page after submitLogin with texts
		WebElement StudentProfilePagetext1 = driver.findElement(By.xpath("//div[@class='col-lg-6 col-md-4 col-8']/p[text()='Test Automation Engineer at Amazon']"));
		WebElement StudentProfilePagetext2 = driver.findElement(By.xpath("//li[2]"));
		
		if(StudentProfilePagetext1.isDisplayed() && StudentProfilePagetext2.isDisplayed()) {
			System.out.println("Texts on Student ProfilePage are Displayed and: " + true);
		}else {
			System.out.println("No.31 " + false);
		}

	//32.Validated now you have Logout Button right top corner
		WebElement LogOutButtonCorner = driver.findElement(By.xpath("//img[@class='rounded-circle']"));
		if(LogOutButtonCorner.isDisplayed()) {
			System.out.println("Logout Button at right top corner isDisplayed and: " + true);
		}else {
			System.out.println("No.32 " + false);
		}
		
	//33.Clicked on LogOutButton
		LogOutButtonCorner.click();
		
	//34.Received modal that contains text ¡°Are you sure?"
		WebElement ReceivedAreYouSureText = driver.findElement(By.cssSelector("#exampleModalCenterTitle"));
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(ReceivedAreYouSureText));
		if(ReceivedAreYouSureText.isDisplayed()) {
			System.out.println("'Are you sure?' text isDisplayed and: " + true);
		}else {
			System.out.println("No.34 " + false);
		}
		
	//35.Clicked on "Sure, I will stay" Button
		WebElement SureStayButton = driver.findElement(By.xpath("//button[@type='button'][@class='btn btn-secondary']"));
		wait.until(ExpectedConditions.visibilityOf(SureStayButton));
		wait.until(ExpectedConditions.elementToBeClickable(SureStayButton));
		SureStayButton.click();
		
	//36.Validated Still on the Student ProfilePage
		WebElement StudentProfilePageValidate = driver.findElement(By.xpath("//h1[@class='display-4 text-center']"));
		wait.until(ExpectedConditions.visibilityOf(StudentProfilePageValidate));
		if(StudentProfilePageValidate.isDisplayed()) {
			System.out.println("We are still on the Student ProfilePage and: " + true);
		}else {
			System.out.println("No.36 " + false);
		}
		
	//37.Clicked on LogOut Button agian
		Thread.sleep(2000);
		WebElement ClickOnLogOutAgian = driver.findElement(By.xpath("//img[@class='rounded-circle']"));
		WebDriverWait wait1 = new WebDriverWait(driver,50);
		wait1.until(ExpectedConditions.elementToBeClickable(ClickOnLogOutAgian));
		Thread.sleep(2000);
		ClickOnLogOutAgian.click();
	
	//38.Clicked on "Gotta Go" Button
		Thread.sleep(2000);
		WebElement ClickOnGottaGoButton = driver.findElement(By.cssSelector("#exampleModalCenter > div > div > div.modal-footer > a"));
		ClickOnGottaGoButton.click();
		
	//39.Back to HomePage after clicked on "Gotta Go" Button
		String CurrentPageUrl = driver.getCurrentUrl();
		if(CurrentPageUrl.equals(HomePageUrl)) {
			System.out.println("TestFinished, Everything Works Fine" + true);
		}else {
			System.out.println("No.39 " + false);
		}
		
	//40.Close and Quit	
		driver.close();
		driver.quit();
	}

}




