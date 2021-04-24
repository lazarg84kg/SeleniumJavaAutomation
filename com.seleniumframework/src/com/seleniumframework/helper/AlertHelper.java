package com.seleniumframework.helper;

import org.openqa.selenium.Alert;

import com.seleniumframework.config.StartWebDriver;

public class AlertHelper extends StartWebDriver {

	// class for Alert manipulation

	private static Alert alert = null;

	// method that accept alert condition
	// (beside this we can send data to the alert box (sendkeys), or dismiss alert
	// condition )
	public static void clickOk() {
		alert = driver.switchTo().alert();
		alert.accept();

	}

	// This method captures the message from the alert box.
	// and prints it to std.out
	public static String getText() {
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		return alert.getText();

	}

}