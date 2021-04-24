package com.seleniumframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.seleniumframework.config.BasePage;

public class PracticeForm extends BasePage {

	private WebDriver webDriver;

	//creating of PracticeForm page constructor
	public PracticeForm(WebDriver drv) {
		super(drv);
		webDriver = drv;

	}

	// finds link 'CONTACT'
	@FindBy(xpath = "//nav[@id='navigation']//span[text()='CONTACT']")
	private WebElement contact;

	// clicks on 'CONTACT' link
	public void clickContact() {
		contact.click();
	}

	// and returns Contact Page
	public Contact contactPage() {
		clickContact();
		return new Contact(webDriver);
	}

}
