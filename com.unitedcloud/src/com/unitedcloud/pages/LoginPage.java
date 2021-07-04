package com.unitedcloud.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	private WebDriver webDriver;

	public LoginPage(WebDriver drv) {
		super(drv);
		webDriver = drv;
	}

	// xpaths for finding WebElements for username, password and login button
	@FindBy(xpath = "//form[@class='form']/descendant::input[@id='username']")
	private WebElement username;
	@FindBy(xpath = "//form[@class='form']/descendant::input[@id='password']")
	private WebElement password;
	@FindBy(xpath = "//form[@class='form']/descendant::button[@type='submit']")
	private WebElement submit;

	// method of return type Choose profile, gets as arguments username and password
	public ChooseProfile submitLogin(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		submit.click();
		return new ChooseProfile(webDriver);
	}
}
