package com.unitedcloud.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateProfile extends BasePage {

	private WebDriver webDriver;

	public CreateProfile(WebDriver drv) {
		super(drv);
		webDriver = drv;
	}

	// webElements which we are using to fill form when we create profile
	@FindBy(xpath = "//input[@id='profile-name']")
	private WebElement profileName;
	@FindBy(xpath = "//div[@class='age']//label[@for='AGE_18_PLUS']")
	private WebElement age;
	@FindBy(xpath = "//input[@id='year']")
	private WebElement birthYear;
	@FindBy(xpath = "//div[@class='avatar']//label[@for='22']")
	private WebElement avatar;

	@FindBy(xpath = "//button[contains(text(),'Create profile')]")
	private WebElement createProfile;

	// method simulate click on avatar pic
	// in this case i used JavascriptExecutor, to show how it works.
	public void clickAvatar() {
		JavascriptExecutor selectAvatar = (JavascriptExecutor) webDriver;
		selectAvatar.executeScript("arguments[0].click();", avatar);
	}

	public ProfilePage submitProfile() {
		// fills profile name
		profileName.sendKeys("Lazar");
		// click on age
		age.click();
		// filling input field with birth year
		birthYear.sendKeys("1984");
		// select Avatar
		clickAvatar();
		// at last, click on button 'Create Profile'
		createProfile.click();
		return new ProfilePage(webDriver);
	}

}
