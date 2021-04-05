package com.polovniautomobili.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	// class that opens home pahe, polovniautomobili.com,
	// closes banner, accept cookies and lead us to
	// detailed car search

	private WebDriver webDriver;

	public HomePage(WebDriver drv) {
		super(drv);
		webDriver = drv;
	}

	@FindBy(name = "isDetailed")
	private WebElement searchDetail;

	public DetailedSearch closeBannerAndCookies() {
		banner.click();
		acceptCookies.click();
		searchDetail.click();
		return new DetailedSearch(webDriver);

	}
}
