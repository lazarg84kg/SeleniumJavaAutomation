package com.unitedcloud.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteProfile extends BasePage{

	private WebDriver webDriver;
	public DeleteProfile(WebDriver drv) {
		super(drv);
		webDriver = drv;
	}
	@FindBy(xpath="//button[contains(text(),'Delete profile')]")
	private WebElement deleteProfile;

	public DeleteProfile submitDeleteProfile() {
		deleteProfile.click();
		return new DeleteProfile(webDriver);
	}
}
