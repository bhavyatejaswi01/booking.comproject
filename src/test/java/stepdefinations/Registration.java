package stepdefinations;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Registration {
	WebDriver driver;
	 @Given("^user is on home page and click on Register button$")
	    public void user_is_on_home_page_and_click_on_register_button() throws Throwable {
	        WebDriverManager.chromedriver().setup();
	        driver=new ChromeDriver();
	        driver.get("https://www.booking.com/");
	        driver.manage().window().maximize();
	    }

	    @When("^user is on Register page enter email and proceed$")
	    public void user_is_on_register_page_enter_email_and_proceed() throws Throwable {
	    	 driver.findElement(By.xpath("//a[@data-et-click='customGoal:YTBUIHOdBOcaGPaVHXT:1']")).click();
	         driver.findElement(By.id("username")).sendKeys("demoecomm@gmail.com");
	         driver.findElement(By.xpath("//button[@type='submit']")).click();
	         Thread.sleep(3000);
	        
	     
	    }

	    
		@Then("^user enter password and confirm password and proceed$")
	    public void user_enter_password_and_confirm_password_and_proceed() throws Throwable {
	    	 driver.findElement(By.id("new_password")).sendKeys("Demoecomm@1234");
	         driver.findElement(By.id("confirmed_password")).sendKeys("Demoecomm@1234");
	         driver.findElement(By.xpath("//span[text()='Create account']")).click();
	         Thread.sleep(3000);
	         System.out.print("registration is sucessful");
	         driver.close();
	    }


}
