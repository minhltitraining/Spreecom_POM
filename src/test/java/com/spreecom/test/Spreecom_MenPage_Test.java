package com.spreecom.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.spreecom.common.Spreecom_BasePage;
import com.spreecom.common.Spreecom_BaseSetup;
import com.spreecom.home.Spreecom_MenPage;
import com.spreecom.home.Spreecom_SignInPage;
import com.spreecom.utils.Spreecom_TestData;

public class Spreecom_MenPage_Test extends Spreecom_BaseSetup {
	
	Spreecom_MenPage menPage;
	Spreecom_SignInPage signIn;
	Spreecom_BasePage basePage;
	Spreecom_BaseSetup baseSetup;
	private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = getDriver();
		basePage = new Spreecom_BasePage(driver);
	}

	@Test(dataProvider = "validLogin", dataProviderClass = Spreecom_TestData.class, priority = 1)
	public void validateWomenPage(String email, String password) throws Exception {
		test = extent.createTest("Test case 4", "verify woman page");
		signIn = basePage.signInToSpreecom(email, password);
		menPage = signIn.goToMenPage();
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
