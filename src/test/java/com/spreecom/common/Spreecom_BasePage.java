package com.spreecom.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spreecom.home.Spreecom_SignInPage;

public class Spreecom_BasePage {
	private WebDriver driver;
	
	@FindBy(xpath = "(//img[@title='Spree Demo Site'])[1]")
	WebElement logoSpreecom;
	
	@FindBy(xpath = "//button[@id='account-button']//*[name()='svg']")
	WebElement iconAccount;
	
	@FindBy(xpath = "//a[normalize-space()='LOGIN']")
	WebElement linkLogin;
	
	@FindBy(id = "spree_user_email")
	WebElement txtEmail;
	
	@FindBy (id = "spree_user_password")
	WebElement txtPassword;
	
	@FindBy (name = "commit")
	WebElement btnLogin;
	
	@FindBy (xpath = "//span[normalize-space()='Invalid email or password.']")
	WebElement unsuccessfulLoginMessage;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public Spreecom_BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean validateLogo() {
		return logoSpreecom.isDisplayed();
	}
	
	public boolean validateUnsuccesfulLoginMessage() {
		return unsuccessfulLoginMessage.isDisplayed();
	}
	public Spreecom_SignInPage signInToSpreecom(String email, String password) throws Exception {
		clickIconAccount();
//		Thread.sleep(2000);
		clickLinkLogIn();
//		Thread.sleep(2000);
		enterEmail(email);
		enterPassword(password);
		submitButton();
//		Thread.sleep(2000);
		return new Spreecom_SignInPage(driver);
	}

	private void clickLinkLogIn() {
		linkLogin.click();
		
	}

	private void clickIconAccount() {
		iconAccount.click();
		
	}

	private void submitButton() {
		btnLogin.click();
	}

	private void enterPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}

	private void enterEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
}
