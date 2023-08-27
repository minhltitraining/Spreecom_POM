package com.spreecom.utils;

import org.testng.annotations.DataProvider;

public class Spreecom_TestData {

	@DataProvider(name = "validLogin")
	public Object[][] validLogin() {
		return new Object[][] {
			{"minh@spree.com", "123456"},
		};
	}
	
	@DataProvider(name = "invalidLogin")
	public Object[][] invalidLogin() {
		return new Object[][] {
			{"minh@spree.com", "12345678"},
		};
	}
	
}
