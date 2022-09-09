package StepDefinitions;


import Utility.Utility;
import homePage.LaunchBrowser;
import io.cucumber.java.en.Then;

public class FindARecord extends LaunchBrowser {
	Utility util = new Utility();

	String PATIENTID = "//*[@id='patient-search']";
	String PATIENTTABLE = "";

	@Then("^Enter A PatientID (.+) and Search$")
	public void enter_a_patientid_and_search(String patientid) throws Throwable {
		util.addText(PATIENTID, patientid);
	}

	@Then("^Verify The PatientID (.+)$")
	public void verify_the_patientid(String patientid) throws Throwable {
		util.getTextData(patientid);
	}
}
