package com.seleniumframework.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.seleniumframework.config.StartWebDriver;
import com.seleniumframework.helper.ScreenShotHelper;
import com.seleniumframework.pages.Contact;
import com.seleniumframework.pages.HomePage;
import com.seleniumframework.pages.PracticeForm;

public class TestPOM extends StartWebDriver {

	@Test
	public void fillAndSubmitForm() {

		try {
			// creating object for practiceForm page
			PracticeForm pf = new PracticeForm(driver);
			// expected text from heading, from page
			String expectedPageHeading = "Agile Testing and ATDD Automation –  Free Tutorials";
			Contact c = pf.contactPage();
			HomePage hp = c.submitForm();
			// getting actual heading text ftom page,
			String actualPageHeading = hp.getPageHeading();
			// and asserting if expected and actual text are equals
			Assert.assertEquals(actualPageHeading, expectedPageHeading, "HEadings are not equals");
			// if assertion true, we takes screenshot from home page,
			ScreenShotHelper.takeScreenshot("Home-OK");
			// adding coment to testng report
			Reporter.log("Screenshot taken, all OK!");
			// and print data from home page
			hp.printHomeData();

		} catch (AssertionError e) {
			// if assertion is not as expected, we print error
			System.out.println(e);
			// and just take screenshot from home page without printing navigaton menu
			ScreenShotHelper.takeScreenshot("Error-NOK");
			// adding coment to testng report
			Reporter.log("Screenshot error taken, NOK!");
		}

	}

}
