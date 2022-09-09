package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import homePage.LaunchBrowser;

public class Utility extends LaunchBrowser {

	public void selectDropdown(String dropdownPath, String opt) {
		Select options = new Select(driver.findElement(By.xpath(dropdownPath)));
		options.selectByVisibleText(opt);
	}

	public void selectDropdownValue(String dropdownPath, String opt) {
		Select options = new Select(driver.findElement(By.xpath(dropdownPath)));
		options.selectByValue(opt);
	}

	public void addText(String path, Keys keys) {
		driver.findElement(By.xpath(path)).sendKeys(keys);
	}

	public void click(String path) {
		driver.findElement(By.xpath(path)).click();
	}

	public String getTextData(String path) {
		return driver.findElement(By.xpath(path)).getText();
	}
	
	public void addText(String path, String text) {
		driver.findElement(By.xpath(path)).sendKeys(text);
	}
}
