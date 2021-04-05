package com.polovniautomobili.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	public BasePage(WebDriver drv) {
		PageFactory.initElements(drv, this);
	}

	// elements that can be used multiple times
	@FindBy(className = "_ado-responsiveFooterBillboard-hover")
	protected WebElement banner;
	@FindBy(xpath = "//a[text()='U redu']")
	protected WebElement acceptCookies;
	@FindBy(id = "btn_poll_no")
	protected WebElement poll;
}