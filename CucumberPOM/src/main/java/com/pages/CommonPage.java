package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.factory.DriverFactory;

public class CommonPage {
	WebDriver driver;
	// LoginPage loginPageCl;
	 CommonPage commonPage;
	//public LoginPage loginPageCl = new LoginPage();

	public CommonPage() {
		this.driver=DriverFactory.getDriver();
	}	

	public String getPageTitle() {
		
		return DriverFactory.tlDriver.get().getTitle();
	}

	/*
	 * public void clickOnButton(WebElement element) {
	 * 
	 * element.click(); }
	 */
}
