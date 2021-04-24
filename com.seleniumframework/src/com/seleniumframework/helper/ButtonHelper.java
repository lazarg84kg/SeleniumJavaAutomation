package com.seleniumframework.helper;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.seleniumframework.config.StartWebDriver;

public class ButtonHelper extends StartWebDriver {

	// Class contains methods for manipulating with buttons, and elements

	// method clicks on particular button.
	// it takes string as a parameter (string is usually xpath or id of element)
	public static void clickButton(String locator) {
		WebElement ele = getElement(locator);
		ele.click();

	}

	// method that checks if some element is present on web page or not
	// also need parameter(string) to be passed, for certain web element
	public static boolean isElementPresent(String locator) {
		try {
			getElement(locator);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// method that performs action of drag and drop button
	// needs two parameters to be passed, 'fromLocation'-button which needs to be
	// dragged
	// and 'toLocation' where will be dragged previous button
	public static void dragAndDrop(String fromLocation, String toLocation) {
		WebElement from = getElement(fromLocation);
		WebElement to = getElement(toLocation);
		Actions builder = new Actions(driver);
		// Building a drag and drop action
		Action dragAndDrop = builder.clickAndHold(from).moveToElement(to).release(to).build();
		// Performing the drag and drop action
		dragAndDrop.perform();
	}

	// method which clicks on given web element(button, link...)
	// this method uses JavaScriptExecutor to click on web element
	// I used JSExecutor, just to show how it works.
	public static void messageWindow(String locator) {
		WebElement element = getElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// method that print to console list of web elements, in this case,
	// method print Site statistics
	// also need one parameter to be passed,
	public static void siteStats(String locator) {
		List<WebElement> stats = getElements(locator);
		System.out.println("Site statistics: ");
		for (WebElement nav : stats) {
			System.out.print(nav.getText() + "\n");
		}

	}

}
