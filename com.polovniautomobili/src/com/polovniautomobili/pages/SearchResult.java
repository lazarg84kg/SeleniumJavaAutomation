package com.polovniautomobili.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResult extends BasePage {
	private WebDriver webDriver;

	public SearchResult(WebDriver drv) {
		super(drv);
		webDriver = drv;
	}

	@FindBy(xpath = "//div[@id='search-results']//div[text()=' Kragujevac']/ancestor::article/h2/span/a")
	private WebElement specificCar;

	public CarDetails selectSpecificCar() {

		specificCar.click();
		return new CarDetails(webDriver);
	}
}
