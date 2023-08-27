package com.spreecom.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.spreecom.common.Spreecom_BasePage;
import com.spreecom.common.Spreecom_BaseSetup;
import com.spreecom.home.Spreecom_SignInPage;
import com.spreecom.utils.Spreecom_TestData;

public class Spreecom_Login_Test extends Spreecom_BaseSetup {
	Spreecom_SignInPage signIn;
	Spreecom_BasePage basePage;
	Spreecom_BaseSetup baseSetup;
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
		basePage = new Spreecom_BasePage(driver);
	}

	@Test(description = "validateLogo() method call for logo verification in base page", priority = 1)
	public void logoTest() throws Exception {
		test = extent.createTest("Test case 1", "verify logo image after openning page");
		basePage.validateLogo();
	}

	
	@Test(dataProvider = "validLogin", dataProviderClass = Spreecom_TestData.class, description = "verify Logo after login", priority = 2)
	public void validateLogoAfterValidLogin1(String email, String password) throws Exception {
		test = extent.createTest("Test case 2", "verify logo after successfully login");
		signIn = basePage.signInToSpreecom(email, password);
		signIn.validateSuccessLoginMessage();
		signIn.verifySignInPageURL();
		signIn.logout();
		signIn.validateSuccessfulLogoutMessage();
	}
	
	@Test(dataProvider = "invalidLogin",dataProviderClass = Spreecom_TestData.class, 
			description = "verify unsuccessful message after invalid login", priority = 3)
	public void validateUncessfullLoginMessage(String email, String password) throws Exception {
		test = extent.createTest("Test case 3", "verify unsuccessful message after invalid login");
		basePage.signInToSpreecom(email, password);
		basePage.validateUnsuccesfulLoginMessage();
	}
	
	
}
