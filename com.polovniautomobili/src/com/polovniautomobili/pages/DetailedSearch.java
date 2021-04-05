package com.polovniautomobili.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.polovniautomobili.config.ReadConfigProperty;
import com.polovniautomobili.config.SearchCriteria;

public class DetailedSearch extends BasePage {
	//in this class we are searching for elements that we need 
	//so we can find car with specification that we're given.
	//specification is in read me file of this project 
	
	private WebDriver webDriver;
	ReadConfigProperty file = new ReadConfigProperty();

	public DetailedSearch(WebDriver drv) {
		super(drv);
		webDriver = drv;
	}

	@FindBy(id = "brand")
	private WebElement brand;

	@FindBy(id = "model")
	private WebElement model;

	@FindBy(id = "chassis")
	private WebElement chassis;

	@FindBy(id = "fuel")
	private WebElement fuel;

	@FindBy(id = "door_num")
	private WebElement doorNo;

	@FindBy(id = "engine_volume_to")
	private WebElement engineTo;

	@FindBy(id = "price_to")
	private WebElement maxPrice;

	@FindBy(id = "air_condition")
	private WebElement ac;

	@FindBy(id = "submit_1")
	private WebElement submitSearch;

	@FindBy(id = "year_to")
	private WebElement yearTo;

	public void selectBrand() {
		poll.click();
		banner.click();

		Select sel = new Select(brand);
		sel.selectByValue(SearchCriteria.BRAND);

	}

	public void selectModel() {
		Select sel = new Select(model);
		sel.selectByVisibleText(SearchCriteria.MODEL);
	}

	public void selectChassis() {
		Select sel = new Select(chassis);
		sel.selectByVisibleText(SearchCriteria.CHASSIS);
		// sel.selectByVisibleText("Kupe");
	}

	public void selectFuel() {
		Select sel = new Select(fuel);
		sel.selectByVisibleText(SearchCriteria.FUEL);
	}

	public void selectDoorNo() {
		Select sel = new Select(doorNo);
		sel.selectByVisibleText(SearchCriteria.DOOR_NO);
	}

	public void selectEngine() {
		engineTo.sendKeys(SearchCriteria.ENGINE_VOLUME);
	}

	public void carPrice() {
		maxPrice.sendKeys(SearchCriteria.CAR_PRICE);
	}

	public void selectAC() {
		Select sel = new Select(ac);
		sel.selectByVisibleText(SearchCriteria.AIR_CONDITION);
	}

	public SearchResult detailedSearch() {
		selectBrand();
		// selectModel();
		selectChassis();
		selectFuel();
		selectDoorNo();
		selectEngine();
		carPrice();
		selectAC();
		submitSearch.click();
		return new SearchResult(webDriver);
	}

}
