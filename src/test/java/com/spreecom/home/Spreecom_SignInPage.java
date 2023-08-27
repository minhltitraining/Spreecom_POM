package com.spreecom.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Spreecom_SignInPage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//span[normalize-space()='Logged in successfully']")
	WebElement messageLoginSuccess;
	
	@FindBy(xpath = "//button[@id='account-button']//*[name()='svg']")
	WebElement btnAccount;
	
	@FindBy(xpath = "//a[normalize-space()='LOGOUT']")
	WebElement linkLogout;
	
	@FindBy(xpath = "//span[normalize-space()='Signed out successfully.']")
	WebElement messageLogout;

	
	@FindBy(xpath = "//a[@class='nav-link main-nav-bar-item main-nav-bar-category-button dropdown-toggle'][normalize-space()='Women']")
	WebElement linkWomen;
	
	@FindBy(xpath = "//a[@class='nav-link main-nav-bar-item main-nav-bar-category-button dropdown-toggle'][normalize-space()='Men']")
	WebElement linkMen;
	
	
	@FindBy(xpath = "//a[@class='nav-link main-nav-bar-item main-nav-bar-category-button dropdown-toggle'][normalize-space()='Sportswear']")
	WebElement linkSportswear;
	
	public Spreecom_SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateSuccessLoginMessage() {
		return messageLoginSuccess.isDisplayed();
	}
	
	public boolean verifySignInPageURL() {
		String pageURL = driver.getCurrentUrl();
		String expectedPageURL = "https://demo.spreecommerce.org/account";
		return pageURL.equalsIgnoreCase(expectedPageURL);
		
	}
	
	public void logout() throws InterruptedException {
		btnAccount.click();
//		Thread.sleep(2000);
		linkLogout.click();
	}
	
	public boolean validateSuccessfulLogoutMessage() {
		return messageLogout.isDisplayed();
	}
	
	public Spreecom_WomenPage goToWomenPage() {
		linkWomen.click();
		return new Spreecom_WomenPage(driver);
	}
	
	public Spreecom_MenPage goToMenPage() {
		linkMen.click();
		return new Spreecom_MenPage(driver);
		
	}
	
	public Spreecom_SportswearPage goToSportswearPage() {
		linkSportswear.click();
		return new Spreecom_SportswearPage(driver);
	}
}
