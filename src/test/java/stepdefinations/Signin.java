package stepdefinations;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Signin {
	WebDriver driver;

	
	@Given("^user is on home page and click on sign-in button$")
	public void user_is_on_home_page_and_click_on_signin_button() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.booking.com/");
		driver.manage().window().maximize();
	}
  
	@When("^user is on login page enter email and proceed$")
	public void user_is_on_login_page_enter_email_and_proceed() throws Throwable {
		driver.findElement(By.xpath("//a[@data-et-click='customGoal:YTBUIHOdBOcaGPaVHXT:2']")).click();
		driver.findElement(By.id("username")).sendKeys("demoecomm.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);

	}
    
	@When("^valid enter password and proceed$")
	public void valid_enter_password_and_proceed() throws Throwable {
		driver.findElement(By.id("password")).sendKeys("Demoecomm@1234");
    	driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div[1]/div/div/div/div/div/div/form/button"))
				.click();
	//	driver.close();
		

	}
 
    @Then("^user get login sucess$")
    public void user_get_login_sucess() throws Throwable {
      Thread.sleep(3000);
      System.out.print("sign-in is sucessful");
   // System.out.print("booking of room is successful"+driver.getTitle());
    	driver.close();
    }

}
