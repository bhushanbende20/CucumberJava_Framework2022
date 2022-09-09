package StepDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import Utility.Utility;
import homePage.LaunchBrowser;
import io.cucumber.java.en.Then;

public class RegisterAPatient extends LaunchBrowser {

	Utility util = new Utility();

	String ENTERGIVENNAME = "//label[contains(normalize-space(),'Given')]/parent::p/input";
	String ENTERMIDDLENNAME = "//label[contains(normalize-space(),'Middle')]/parent::p/input";
	String ENTERFIMILYNNAME = "//label[contains(normalize-space(),'Family Name')]/parent::p/input";
	String NEXTBUTTON = "//*[@id='next-button']";
	String GENDER = "//*[@name='gender']";
	String DOB_DAY = "//label[contains(text(),'Day')]/following-sibling::input";
	String DOB_MONTH = "//label[contains(text(),'Month')]/following-sibling::select";
	String DOB_Year = "//label[contains(text(),'Year')]/following-sibling::input";
	String COUNTRY = "//label[contains(text(),'Country')]/following-sibling::input";
	String PHONENO = "//*[@name='phoneNumber']";
	String RELATIONSHIPTYPE = "//*[@name='relationship_type']";
	String PERSONNAME = "//div[@id='relationship']//p[2]/input";
	String CONFIRMBUTTON = "//input[@value='Confirm']";
	String PATIENTID = "//em[contains(text(),'Patient ID')]/following-sibling::span";
	String PAGETITLE = "//h2";

	@Then("^Enter Patient Name (.+)$")
	public void enter_patient_name(String name) throws Throwable {
		String nameArr[] = name.split(" ");

		util.addText(ENTERGIVENNAME, nameArr[0]);
		util.addText(ENTERMIDDLENNAME, nameArr[1]);
		util.addText(ENTERFIMILYNNAME, nameArr[1]);
		util.click(NEXTBUTTON);

	}

	@Then("^Select Gender (.+)$") 
	public void select_gender(String gender) throws Throwable {
		util.selectDropdown(GENDER, gender);
		util.click(NEXTBUTTON);
	}

	@Then("^Select DOB (.+)$")
	public void select_dob(String dob) throws Throwable {
		String[] dob1 = dob.split("/");

		driver.findElement(By.xpath(DOB_DAY)).sendKeys(dob1[0]);
		util.selectDropdownValue(DOB_MONTH, dob1[1]);
		driver.findElement(By.xpath(DOB_Year)).sendKeys(dob1[2]);
		util.click(NEXTBUTTON);
	}

	@Then("^Enter ADDRESS (.+)$")
	public void enter_address(String address) throws Throwable {
		util.addText(COUNTRY, address);
		util.click(NEXTBUTTON);
	}

	@Then("^Enter PhoneNo (.+)$")
	public void enter_phoneno(String phoneno) throws Throwable {
		util.addText(PHONENO, phoneno);
		util.click(NEXTBUTTON);
	}

	@Then("^Add Relation (.+)$")
	public void add_relation(String relationname) throws Throwable {
		String[] arr1 = relationname.split("/");
		util.selectDropdown(RELATIONSHIPTYPE, arr1[0]);
		util.addText(PERSONNAME, arr1[1]);
		util.click(NEXTBUTTON);
	}

	@Then("^Click on Confirm Button$")
	public void click_on_confirm_button() throws Throwable {
		util.click(CONFIRMBUTTON);

	}

	@Then("^Get Patient Id$")
	public void get_patient_id() throws Throwable {
		Thread.sleep(1000);
		String id = util.getTextData(PATIENTID);
		System.out.println(id);
	}
	
    @Then("^Verify Action Tab Title (.+)$")
    public void verify_action_tab_title(String title) throws Throwable {
    	String actualpagetitle = util.getTextData(PAGETITLE);
    	assertEquals(actualpagetitle, title);
    }


}
