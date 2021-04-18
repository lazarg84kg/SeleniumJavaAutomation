package com.seleniumframework.helper;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.seleniumframework.config.StartWebDriver;

public class ScreenShotHelper extends StartWebDriver {

	// method that takes screenshot.
	public static void takeScreenshot(String fileName) {

		try {

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src,
					new File("src/com/seleniumframework/resources/screenshots/", "Screenshot-" + fileName + ".jpg"));
			System.out.println("ScreenShot Taken!!!");
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
