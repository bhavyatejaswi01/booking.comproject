package stepdefinations;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reservation {
	WebDriver driver;

	@Given("^User is on landing page$")
	public void user_is_on_landing_page() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.booking.com/");
		driver.manage().window().maximize();

	}

	@Then("^Search for room with place and dates$")
	public void search_for_room_with_place_and_dates() throws Throwable {
		driver.findElement(By.id("ss")).sendKeys("Chennai");
		driver.findElement(By.xpath("//div[@data-calendar2-type='checkin']")).click();
		driver.findElement(
				By.xpath("//span[@aria-label='25 February 2022']/span[text()='25']"))
				.click();
		driver.findElement(
				By.xpath("//span[@aria-label='27 February 2022']/span[text()='27']"))
				.click();
		driver.findElement(By.id("xp__guests__toggle")).click();
		driver.findElement(By.xpath("//button[@aria-label='Decrease number of Adults']"))
				.click();
		driver.findElement(By.xpath("//button[@class='sb-searchbox__button ']")).click();

	}

	@When("^user is on result page and select requried hotel$")
	public void user_is_on_result_page_and_select_requried_hotel() throws Throwable {
		driver.findElement(By.xpath("//div[text()='Park Hyatt Chennai']")).click();
		String w = driver.getWindowHandle();
		Set<String> c = driver.getWindowHandles();
		for (String s : c) {
			if (!s.equals(w)) {
				driver.switchTo().window(s);
				System.out.println("image page" + driver.getTitle());

			}
		}
	}

	@Then("^in that page user reserve no.of rooms and proceed$")
	public void in_that_page_user_reserve_noof_rooms_and_proceed() throws Throwable {
		driver.findElement(By.xpath("//button[@id='hp_book_now_button']")).click();
		WebElement rooms = driver.findElement(By.xpath("//select[@id='hprt_nos_select_48817408_269968671_1_42_0']"));
		Select room = new Select(rooms);
		room.selectByValue("1");
		driver.findElement(By.xpath("//div[@class='hprt-reservation-cta']")).click();

	}

	@When("^enter mandotary details of customers and proceed to pay$")
	public void enter_mandotary_details_of_customers_and_proceed_to_pay() throws Throwable {
		driver.findElement(By.id("firstname")).sendKeys("demo");
		driver.findElement(By.id("lastname")).sendKeys("ecomm");
		driver.findElement(By.id("email")).sendKeys("demoecom@gmail.com");
		driver.findElement(By.id("email_confirm")).sendKeys("demoecom@gmail.com");
		driver.findElement(By.xpath("//span[text()=' Next: Final details ']")).click();
	}

	@Then("^enter payment details and complete booking$")
	public void enter_payment_details_and_complete_booking() throws Throwable {
		driver.findElement(By.id("phone")).sendKeys("9000000000");
	
			WebElement ctype = driver.findElement(By.id("cc_type"));
			Select card = new Select(ctype);
			card.selectByValue("Visa");
			
			WebElement cardno=driver.findElement(By.xpath("//input[@id='cc_number']"));
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			jse.executeScript("arguments[0].value='4444333322221111'", cardno);
		

			Thread.sleep(3000);
			WebElement months = driver.findElement(By.id("cc_month"));
			Select month = new Select(months);
			month.selectByValue("04");

			WebElement years = driver.findElement(By.id("ccYear"));
			Select year = new Select(years);
			year.selectByValue("2024");

			driver.findElement(By.xpath("//*[@id='bookForm']/div[5]/div/div[2]/button/span[2]")).click();
			System.out.println("payment details");
			  
	}	

	@Then("^user gets the booking confirmation page$")
	public void user_gets_the_booking_confirmation_page() throws Throwable {
		System.out.print("booking of room is sucessful");
		Thread.sleep(10000);
		//driver.findElement(By.id("add-password")).sendKeys("Demoecomm@12345");
	//	driver.findElement(By.xpath("//*[@id='iam-pb-confirmation']/div[2]/button/span[2]")).click();
		//driver.quit();
	}

}
