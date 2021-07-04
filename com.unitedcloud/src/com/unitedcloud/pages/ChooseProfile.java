package com.unitedcloud.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChooseProfile extends BasePage {

	private WebDriver webDriver;

	public ChooseProfile(WebDriver drv) {
		super(drv);
		webDriver = drv;
	}

	// webElement - button which we use for creating a new profile
	@FindBy(xpath = "//div[@class='create']/button")
	private WebElement createProfile;

	public CreateProfile submitChooseProfile() {
		createProfile.click();
		return new CreateProfile(webDriver);
	}
}
