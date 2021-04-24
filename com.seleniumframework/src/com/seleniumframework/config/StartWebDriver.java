package com.seleniumframework.config;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class StartWebDriver {

	public static WebDriver driver = null;

	// method setting up webdriver, chrome or firefox,
	// it depends which browser we set in config file.
	@BeforeSuite
	public void setUp() {
		try {
			ReadConfigProperty file = new ReadConfigProperty();
			if ("firefox".equalsIgnoreCase(file.getBrowser())) {
				System.setProperty("webdriver.gecko.driver", "src/com/seleniumframework/resources/geckodriver");
				driver = new FirefoxDriver();
			} else if ("chrome".equalsIgnoreCase(file.getBrowser())) {
				System.setProperty("webdriver.chrome.driver", "src/com/seleniumframework/resources/chromedriver");
				driver = new ChromeDriver();
			}
			// getting url, from file
			driver.get(file.getUrl());
			// maximizes window at startup
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// method getElement, as a parameter needs string(locator)
	// which will be used for finding web element on web page.
	// in this case i used just xpath locator, and id for finding elements
	// simillary would be e.g. for tagName, className, name, cssLocator
	public static WebElement getElement(String locator) {

		if (driver.findElements(By.id(locator)).size() == 1) {
			return driver.findElement(By.id(locator));
		} else
			return driver.findElement(By.xpath(locator));

	}

	// as previous method this does the same job, but this time
	// instead findElement i used findElements, so i can manipulate
	// with list of web elements.
	public static List<WebElement> getElements(String locator) {

		if (driver.findElements(By.id(locator)).size() == 1) {
			return driver.findElements(By.id(locator));
		} else
			return driver.findElements(By.xpath(locator));

	}

	// method that closes browser and webdriver instance. in this case:
	@AfterSuite
	public void tearDown() {
		try {
			driver.close();// closes browser which is in focus and closes activ webdriver instance
			driver.quit();// closes all the browsers and all the active we driver instances.
			if (driver != null)
				driver = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
