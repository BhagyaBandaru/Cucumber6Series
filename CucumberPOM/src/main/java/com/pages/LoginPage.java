package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;

public class LoginPage extends CommonPage {
	//page object model follows below three
	//Declaration: maintain the by locators
	//initialization: using constructor we initialize the driver
	//utilization: page actions
	//Locators always should be private
	//here we implement Encapsulation using private
	private WebDriver driver;

	// 1. By Locators: OR
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");

	// 2. Constructor of the page class:
	public LoginPage() {
		//this.driver = driver;
		this.driver=DriverFactory.getDriver();
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}

	
	  public AccountsPage doLogin(String un, String pwd) {
	  System.out.println("login with: " + un + " and " + pwd);
	  driver.findElement(emailId).sendKeys(un);
	  driver.findElement(password).sendKeys(pwd);
	  driver.findElement(signInButton).click(); return new AccountsPage(driver); }
	 

}
