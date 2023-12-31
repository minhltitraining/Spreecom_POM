package com.spreecom.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.spreecom.common.Spreecom_BasePage;
import com.spreecom.common.Spreecom_BaseSetup;
import com.spreecom.home.Spreecom_MenPage;

public class Spreecom_MenPage_Test extends Spreecom_BaseSetup {
	
	Spreecom_MenPage menPage;
	Spreecom_BasePage basePage;
	Spreecom_BaseSetup baseSetup;
	private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = getDriver();
		basePage = new Spreecom_BasePage(driver);
	}

	@Test(priority = 1)
	public void validateWomenPage() throws Exception {
		test = extent.createTest("Test case 2", "verify men page");
		menPage = basePage.goToMenPage();
		Thread.sleep(2000);
		menPage.validateURL();
	}
	
	@Test(priority = 2)
	public void validateTitle() {
		menPage.validateTitle();
	}
	
	@Test(priority = 3)
	public void validateText() {
		menPage.validateAllTexts();
	}
}
