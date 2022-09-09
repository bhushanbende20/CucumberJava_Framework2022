package StepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;

import homePage.LaunchBrowser;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends LaunchBrowser {

	@Before
	public void openBrowser() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@After
	public void closethedriver() throws Throwable {
		driver.quit();
	}

 
}
