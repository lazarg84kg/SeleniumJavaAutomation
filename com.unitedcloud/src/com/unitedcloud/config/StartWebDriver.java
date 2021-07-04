package com.unitedcloud.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class StartWebDriver {

	// class which starts WebDriver, set browser(chrome or firefox)

	public static WebDriver driver = null;

	public static ReadConfigProperty filename = null;

	@BeforeTest
	public void setUp() {
		try {
			filename = new ReadConfigProperty();
			if ("firefox".equalsIgnoreCase(filename.getBrowser())) {
				// path to geckodriver(firefox browser)
				System.setProperty("webdriver.gecko.driver", "src/com/unitedcloud/resources/geckodriver");
				driver = new FirefoxDriver();
			} else if ("chrome".equalsIgnoreCase(filename.getBrowser())) {
				// path to chromedriver(for chrome browser)
				System.setProperty("webdriver.chrome.driver", "src/com/unitedcloud/resources/chromedriver");
				driver = new ChromeDriver();
			}
			// getting url from config.properties file
			driver.get(filename.getUrl());
			// at start, maximizes browser window
			driver.manage().window().maximize();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// method closes all WebDriver instances after test is executed.
	@AfterTest
	public void tearDown() {
		try {
			driver.quit();
			if (driver != null)
				driver = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
