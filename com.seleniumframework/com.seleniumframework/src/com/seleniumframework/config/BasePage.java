package com.seleniumframework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	// BasePage class that inits Page factory,
	// so we can use @FindBy annotations to find web elements
	// We use initElements method to initialize web elements
	public BasePage(WebDriver drv) {
		PageFactory.initElements(drv, this);
	}

}