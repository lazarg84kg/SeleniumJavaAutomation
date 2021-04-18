package com.seleniumframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.seleniumframework.config.BasePage;

public class Contact extends BasePage {

	private WebDriver webDriver;

	// creating contact class constructor
	public Contact(WebDriver drv) {
		super(drv);
		webDriver = drv;
	}

	// Finding elements that we need for filling form on the contact page
	// all elements are searched by xpath locator
	@FindBy(xpath = "//span[@class='form-name']//input[@name='name']")
	private WebElement name;

	@FindBy(xpath = "//span[@class='form-mail']//input[@name='email']")
	private WebElement email;

	@FindBy(xpath = "//span[@class='form-telephone']//input[@name='telephone']")
	private WebElement telephone;

	@FindBy(xpath = "//span[@class='form-country']//input[@name='country']")
	private WebElement country;

	@FindBy(xpath = "//span[@class='form-city']//input[@name='city']")
	private WebElement city;

	@FindBy(xpath = "//span[@class='form-company']//input[@name='company']")
	private WebElement company;

	@FindBy(xpath = "//span[@class='form-message']//textarea[@name='message']")
	private WebElement message;
	// submit button
	@FindBy(xpath = "//p//a[text()='Send message']")
	private WebElement submit;
	// link to home page
	@FindBy(xpath = "//nav[@id='navigation']//span[text()='HOME']")
	private WebElement homePage;

	// filling up form, with some provided data
	public void fillForm() {
		name.sendKeys("Lazar Grozdanovic");
		email.sendKeys("lazarg84kg@gmail.com");
		telephone.sendKeys("+381655268549");
		country.sendKeys("Serbia");
		company.sendKeys("IT");
		message.sendKeys("Here goes some message");
	}

	// fill and submit form, and at last homePage.click lead us to home page
	public HomePage submitForm() {

		fillForm();
		submit.click();
		homePage.click();

		return new HomePage(webDriver);

	}

}
