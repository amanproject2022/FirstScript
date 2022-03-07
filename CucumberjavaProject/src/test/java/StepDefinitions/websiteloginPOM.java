package StepDefinitions;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.loginpage;
import io.cucumber.java.en.*;


public class websiteloginPOM {
	WebDriver driver=null;
	loginpage login;
	
	@Given("user is on website login page")

	public void user_is_on_website_login_page() {

		String baseUrl = "https://example.testproject.io/web/";
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath is:"+projectpath);

		System.out.println("Inside step-user is on website login page");

		System.setProperty("webdriver.chrome.driver", projectpath+"/src/test/resources/Drivers/chromedriver.exe");
		driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		// Opening the login page

		driver.get(baseUrl);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		String expTitle="TestProject Demo";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		String actTitle=driver.getTitle();
		if(expTitle.equals(actTitle))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");


	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username,String password) throws InterruptedException {
		
		login=new loginpage(driver);
		login.loginwithvalidcredentials(username, password);
		Thread.sleep(2000);
         
         	}

	@And("user clicks on login")
	public void user_clicks_on_login() throws InterruptedException {
		
     login.clicklogin();
	Thread.sleep(2000);
		
		
	}

	@Then("login successful navigate to website homepage")
	public void login_successful_navigate_to_website_homepage() throws InterruptedException {
		System.out.println("login successful navigate to website homepage");

		driver.getPageSource().contains("TestProject Example page");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}





















