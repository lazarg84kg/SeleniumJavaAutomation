package com.seleniumframework.helper;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumframework.config.StartWebDriver;

public class WindowHelper extends StartWebDriver {

	// Class contains methods that are used for manipulation with windows
	// navigation and window resizing

	// method that switches between windows.
	// new opened window or new opened tab.
	// needs index of window/tab as parameter to be passed
	public static void switchTo(int index) {
		try {
			List<String> win = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(win.get(index));
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException("Invalid Window Index : " + index);
		}

	}

	// method that bring us back to parent window, from newly opened window/tab.
	// method also closes window/tab that was previously open
	public static void switchToParentWithClose() {
		List<String> win = new ArrayList<String>(driver.getWindowHandles());

		for (int i = 1; i < win.size(); i++) {
			driver.switchTo().window(win.get(i));
			driver.close();
		}
		driver.switchTo().window(win.get(0));

	}

	// method that helps us to get page title, and print it to console
	public static String getPageTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}

	// method for navigation, takes us to given url
	// needs url as parameter to be passed
	public static void navigateToPage(String url) {
		driver.navigate().to(url);
	}

	public static String getUrl() {
		return driver.getCurrentUrl();
	}

	// method maximizes window
	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

	// method that helps us to change window size
	// needs two parameters to be passed(height and width)
	public static void setWinSize(int x, int y) {
		Dimension dimension = new Dimension(x, y);
		driver.manage().window().setSize(dimension);
	}

	public static void waitElement(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}

}