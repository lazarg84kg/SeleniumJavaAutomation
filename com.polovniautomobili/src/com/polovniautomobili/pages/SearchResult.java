package com.polovniautomobili.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.polovniautomobili.config.SearchCriteria;

public class SearchResult extends BasePage {
	private WebDriver webDriver;

	public SearchResult(WebDriver drv) {
		super(drv);
		webDriver = drv;
	}

	// class that show us searching result, and take us to the car details page
	// CARXPATH is set in SearchCriteria class and take us to the specific sar,
	// in this example car needs to be from Kragujevac
	
	@FindBy(xpath = SearchCriteria.CARXPATH)
	private WebElement specificCar;

	public CarDetails selectSpecificCar() {

		specificCar.click();
		return new CarDetails(webDriver);
	}
}
