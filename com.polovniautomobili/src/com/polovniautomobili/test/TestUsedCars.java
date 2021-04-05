package com.polovniautomobili.test;

import org.testng.annotations.Test;

import com.polovniautomobili.config.StartWebDriver;
import com.polovniautomobili.pages.CarDetails;
import com.polovniautomobili.pages.DetailedSearch;
import com.polovniautomobili.pages.HomePage;
import com.polovniautomobili.pages.SearchResult;


public class TestUsedCars extends StartWebDriver{

	String expectedTitle="Polovni automobili ";
	
	@Test
	public void testUsedCars() {
		HomePage hp = new HomePage(driver);
	
		if(driver.getTitle() != null && driver.getTitle().contains(expectedTitle)){
			  System.out.println("Web page is opened");
			}
			else{
			  System.out.println("Web page could not open.");
			}
		DetailedSearch ds = hp.closeBannerAndCookies();
		SearchResult sr= ds.detailedSearch();
		CarDetails cd = sr.selectSpecificCar();
		cd.printData();
	}
}
