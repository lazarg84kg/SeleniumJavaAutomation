package com.seleniumframework.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.seleniumframework.config.BasePage;

public class HomePage extends BasePage {

	// creating HomePage class constructor
	public HomePage(WebDriver drv) {
		super(drv);
	}

	// finding list of web elements, by xpath locator
	@FindBy(xpath = "//nav[@id='navigation']//ul[@id='main-nav']/li/a/span")
	private List<WebElement> navigation;
	// finding single web element also by xpath locator
	@FindBy(xpath = "//div[@class='wpb_wrapper']/descendant::h2/span/strong")
	private WebElement heading;

	// method that returns heading from page, with previosly given condition
	// in xpath.
	public String getPageHeading() {
		return heading.getText();
	}

	// method prints to console list ov web elements. in this case
	// list is navigation menu. Number of elements and every element from nav menu.
	public void navMenuItems() {

		System.out.println("Total items in Navigation Menu: " + navigation.size());
		for (WebElement nav : navigation) {
			System.out.print(nav.getText() + " ");
		}
		System.out.println("\n");
	}

	// method that is used in test case, that prints data that we are asked for.
	public void printHomeData() {
		System.out.println(getPageHeading());
		navMenuItems();
	}

}
