package com.seleniumframework.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.seleniumframework.config.StartWebDriver;

public class LinkHelper extends StartWebDriver {

	// method that we are using for click on link
	// parameter which is passed is or linkText or partialLinkText
	public static void clickLink(String linkText) {

		if (driver.findElements(By.linkText(linkText)).size() == 1) {
			driver.findElement(By.linkText(linkText)).click();
		} else if (driver.findElements(By.partialLinkText(linkText)).size() == 1) {
			driver.findElement(By.partialLinkText(linkText)).click();
		} else
			throw new NoSuchElementException("Link Text Not Found : " + linkText);

	}

}