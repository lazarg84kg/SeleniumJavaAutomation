package com.seleniumframework.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.seleniumframework.config.StartWebDriver;
import com.seleniumframework.helper.AlertHelper;
import com.seleniumframework.helper.ButtonHelper;
import com.seleniumframework.helper.LinkHelper;
import com.seleniumframework.helper.ScreenShotHelper;
import com.seleniumframework.helper.WindowHelper;

public class TestElements extends StartWebDriver {

	// A test class that contains multiple test methods for testing web elements.

	@Test(priority = 0)
	public void newWindowTest() {
		System.out.println("Test New Window");
		System.out.println("===============");
		WindowHelper.waitElement("//button[@id='button1']");
		// after maximization, click on 'New Window button'
		ButtonHelper.clickButton("button1");
		// switches from parent window to new opened browser after click.
		WindowHelper.switchTo(1);
		// switch to new window, and wait for element to be visible,
		// in this case this is //navigation menu for mobile view
		WindowHelper.waitElement("//nav[@id='navigation']/a[@id='mobile-menu']");
		// wait.until(ExpectedConditions.visibilityOf(getElement("//nav[@id='navigation']/a[@id='mobile-menu']")));
		// now we get and print page title to the console
		WindowHelper.getPageTitle();
		// and at last, switching to parent window and closes 'New Window'
		WindowHelper.switchToParentWithClose();
		Reporter.log("Additional information is saved");
	}

	// test case uses JavaScriptExecutor, just for demonstration
	@Test(priority = 1)
	public void newMessageTest() {
		System.out.println("Test New Window Message");
		System.out.println("===============");
		// test case will open new messsage window
		ButtonHelper.messageWindow("//button[contains(text(),'New Mess')]");
		// just opens the new window, closes it
		WindowHelper.switchTo(1);

		WindowHelper.switchToParentWithClose();
		// and then clicks on link, element found by.partialLinkText
		LinkHelper.clickLink("This is");
		// link opens new tab, so we need to switch to new tab
		WindowHelper.switchTo(1);
		try {
			// assertion if search button exists on page
			Assert.assertEquals(ButtonHelper.isElementPresent("//a[@class='submit']"), true);
			System.out.println("Search Button Present");
		} catch (AssertionError e) {
			System.out.println("Search Button not present");

		}
		// back to parent window
		WindowHelper.switchToParentWithClose();
		// sending "message" to report
		Reporter.log("New message window log");
	}

	@Test(priority = 2)
	public void alertButtonTest() {
		System.out.println("Test Alert Button");
		System.out.println("===============");
		// asserting for element presence. with message to console.
		try {
			Assert.assertEquals(ButtonHelper.isElementPresent("//button[@id='alert']"), true);
		} catch (AssertionError e) {
			System.out.println("Alert Button not present");
			throw e;
		}
		System.out.println("Alert Button Present!!!");
		// since the element exists, now we click on Alert button
		ButtonHelper.clickButton("//button[@id='alert']");

		// nex step is printing text from Alert Box
		AlertHelper.getText();
		// and at last, accepting of alert message box.
		AlertHelper.clickOk();
	}

	@Test(priority = 3)
	public void dragNdropTest() {
		System.out.println("Drag and Drop Test");
		System.out.println("===============");
		// for start, we are checking if elements are present on the page
		if (ButtonHelper.isElementPresent("//button[@id='draga']")
				&& ButtonHelper.isElementPresent("//button[@id='dragb']"))
			// if they are/not present message is sent
			System.out.println("Elements are present!");
		else
			System.out.println("Elements are not Present!!!");
		// at last, we drag and drop
		ButtonHelper.dragAndDrop("//button[@id='draga']", "//button[@id='dragb']");

	}

	@Test(priority = 4)
	public void siteStats() {
		System.out.println("Site statistics");
		System.out.println("===============");
		String baseUrl = "http://www.seleniumframework.com/about-2/";
		// navigate to new page... url is given as parameter
		WindowHelper.navigateToPage(baseUrl);
		// asserting that the page is open or not
		Assert.assertTrue(baseUrl.equals(WindowHelper.getUrl()), "New Page Not Opened");

		// printing site statistics
		ButtonHelper.siteStats("//div[@class='wpb_wrapper']/descendant::small");
		// demonstration of window resizing
		WindowHelper.setWinSize(800, 600);
		// at last, take screenshot
		ScreenShotHelper.takeScreenshot("sitestats");
	}
}
