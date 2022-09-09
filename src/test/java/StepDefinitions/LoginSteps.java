package StepDefinitions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import Utility.Utility;
import homePage.LaunchBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Scenario;

public class LoginSteps extends LaunchBrowser {

//	LaunchBrowser launch = new LaunchBrowser();
	WebDriver wait;
	Scenario sc ;

	Utility util = new Utility();
	String USERNAME = "//*[@id='username']";
	String PASSWORD = "//*[@id='password']";
	String SUBMIT_BUTTON = "//*[@id='loginButton']";
	String LOCATION = "//ul[@id='sessionLocation']/li[contains(text(),'{LOCATION}')]";
	String Message = "//h4";
	String LOGOUT = "//a[contains(text(),'Logout')]";
	String ACTIONTOTAKE = "//a[@type=\"button\"][normalize-space()='{ACTION}']";

	
	@Given("^Lauch Openmrs$")
	public void lauch_openmrs() throws Throwable {
	
		driver.get("https://demo.openmrs.org/openmrs/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		

		// wait.until(ExpectedConditions.alertIsPresent());

	}

	@When("^Login to Openmrs with (.+) and (.+)$")
	public void login_to_openmrs_with_and(String username, String password) throws Throwable {

		util.addText(USERNAME, username);
		util.addText(PASSWORD, password);
	}

	@Then("^Click on Submit Button$")
	public void click_on_submit_button() throws Throwable {

		util.click(SUBMIT_BUTTON);
	}

	@Then("^Chosse Location (.+)$")
	public void chosse_location(String location) throws Throwable {
		LOCATION = LOCATION.replace("{LOCATION}", location);
		util.click(LOCATION);

	}

	@Then("^Verify Logged In Message (.+)$")
	public void verify_logged_in_message(String message) throws Throwable {
		//String getMessage = driver.findElement(By.xpath(Message)).getText();
		String getMessage = util.getTextData(Message);
		assertEquals(message, getMessage);
	}

	@Then("^Logout$")
	public void logout() throws Throwable {
		util.click(LOGOUT);
		

	}

	@Then("^Click on Action (.+)$")
	public void click_on_action(String action) throws Throwable {
		ACTIONTOTAKE = ACTIONTOTAKE.replace("{ACTION}", action);
		util.click(ACTIONTOTAKE);
	}

	

}
