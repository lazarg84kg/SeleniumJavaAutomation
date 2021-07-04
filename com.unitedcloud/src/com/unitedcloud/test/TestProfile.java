package com.unitedcloud.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.unitedcloud.config.StartWebDriver;
import com.unitedcloud.pages.ChooseProfile;
import com.unitedcloud.pages.CreateProfile;
import com.unitedcloud.pages.LoginPage;
import com.unitedcloud.pages.ProfilePage;

public class TestProfile extends StartWebDriver {

	@Test
	public void testProfileCreation() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);

			LoginPage lp = new LoginPage(driver);

			ChooseProfile cp = lp.submitLogin(filename.getUsername(), filename.getPassword());

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='create']/button")));

			CreateProfile createP = cp.submitChooseProfile();

			ProfilePage pp = createP.submitProfile();

			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[@class='card']/descendant::span[@class='card__profile-type']")));

			String expectedProfileType = "ADULT";
			String actualProfileType = pp.getProfileType();
			Assert.assertEquals(actualProfileType, expectedProfileType, "Profile Type not OK!");
			// adding coment to testng report
			Reporter.log("Test passed, all OK!");

			pp.deleteProfile();

		} catch (AssertionError e) {
			// adding coment to testng report
			Reporter.log("Test Failed, Something went wrong!!!" + e);
		}
	}

}
