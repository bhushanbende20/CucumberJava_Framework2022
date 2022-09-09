package Runner;


import org.junit.runner.RunWith;
import homePage.LaunchBrowser;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Feature",
		//tags="@findAPatient",
		glue= {"StepDefinitions"},
		monochrome = true,
		dryRun = false,
		
plugin={"pretty","html:target/HtmlReports.html"}
)
public class TestRunner extends LaunchBrowser{

}
