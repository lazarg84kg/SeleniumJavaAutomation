package com.polovniautomobili.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.polovniautomobili.config.SearchCriteria;

import java.util.List;

public class CarDetails extends BasePage {

	//class that will show us some car details
	// in this case, we need to print owner phone(s), car price, registration price, 
	
	public CarDetails(WebDriver drv) {
		super(drv);
	}

	@FindBy(xpath = SearchCriteria.SHOW_PHONE_XPATH)
	private WebElement showPhone;

	@FindBy(xpath = SearchCriteria.PRICE_XPATH)
	private List<WebElement> cena;

	@FindBy(xpath = SearchCriteria.PHONE_NUMBER_XPATH)
	private List<WebElement> broj;

	@FindBy(xpath = SearchCriteria.CAR_PRICE_XPATH)
	private WebElement carPrice;

	public void cenaReg() {
		System.out.println("Cena registracije u intervalu: ");
		for (WebElement e : cena)
			System.out.print(" " + e.getText() + "\n");
	}

	public void carPrice() {
		System.out.println("Cena vozila: " + carPrice.getText());
	}

	public void stampajBroj() {
		showPhone.click();
		System.out.println("Broj Telefona: ");
		for (WebElement e : broj)
			System.out.println(e.getText());
	}

	public void printData() {
		stampajBroj();
		cenaReg();
		carPrice();
	}
}
