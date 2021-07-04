package com.unitedcloud.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	// BasePage class that inits Page factory,
	// so we can use @FindBy annotations

	public BasePage(WebDriver drv) {
		PageFactory.initElements(drv, this);
	}

}
