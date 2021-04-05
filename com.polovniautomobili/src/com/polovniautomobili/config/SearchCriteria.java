package com.polovniautomobili.config;

public class SearchCriteria {

	//constants that are used in this project
	
	public static final String BRAND = "audi";
	public static final String MODEL = "A3";
	public static final String CHASSIS = "Limuzina";
	public static final String FUEL = "Benzin";
	public static final String DOOR_NO = "4/5 vrata";
	public static final String ENGINE_VOLUME = "2500";
	public static final String CAR_PRICE = "5000";
	public static final String AIR_CONDITION = "Automatska klima";
	
	// XPATHS used in projects
	
	public static final String CAR_XPATH ="//div[@id='search-results']//div[text()=' Kragujevac']/ancestor::article/h2/span/a";
	public static final String SHOW_PHONE_XPATH = "//section[@class='uk-grid']/descendant::div[contains(text(),'klik')]";
	public static final String PRICE_XPATH = "//div[@class='osiguranikConternt']/child::strong";
	public static final String PHONE_NUMBER_XPATH ="//section[@class='uk-grid']/descendant::a[contains(.,'0')]";
	public static final String CAR_PRICE_XPATH ="//div[@class='price-item position-relative']";
	//public static final String



}
