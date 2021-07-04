package com.unitedcloud.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

	public ProfilePage(WebDriver drv) {
		super(drv);

	}

	// web element used for assertion in test method
	@FindBy(xpath = "//div[@class='card']/descendant::span[@class='card__profile-type']")
	private WebElement profileType;

	// web element - button for deleting profile
	@FindBy(xpath = "//div[@class='card']//button[contains(text(), 'Delete')]")
	private WebElement deleteProfile;

	// method returns profile type
	public String getProfileType() {
		return profileType.getText();
	}

	public void deleteProfile() {
		deleteProfile.click();
	}

}
