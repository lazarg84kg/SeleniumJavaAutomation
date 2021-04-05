package com.polovniautomobili.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class StartWebDriver {

	public static WebDriver driver = null;

	
	
	@BeforeSuite
	public void setUp() {
		try {
			ReadConfigProperty file = new ReadConfigProperty();
			if ("firefox".equalsIgnoreCase(file.getBrowser())) {
				System.setProperty("webdriver.gecko.driver", "src/com/polovniautomobili/resources/geckodriver");
				driver = new FirefoxDriver();
			} else if ("chrome".equalsIgnoreCase(file.getBrowser())) {
				System.setProperty("webdriver.chrome.driver", "src/com/polovniautomobili/resources/chromedriver");
				driver = new ChromeDriver();
			}

			driver.get(file.getUrl());
			driver.manage().window().maximize();
			//driver.manage().timeouts().pageLoadTimeout(file.getPageWait(),TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void tearDown() {
		try {
			driver.close();
			driver.quit();
			if (driver != null)
				driver = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
