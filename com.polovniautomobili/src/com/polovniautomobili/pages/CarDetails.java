package com.polovniautomobili.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CarDetails extends BasePage {

	public CarDetails(WebDriver drv) {
		super(drv);
	}

	@FindBy(xpath = "//section[@class='uk-grid']/descendant::div[contains(text(),'klik')]")
	private WebElement showPhone;

	@FindBy(xpath = "//div[@class='osiguranikConternt']/child::strong")
	private List<WebElement> cena;

	@FindBy(xpath = "//section[@class='uk-grid']/descendant::a[contains(.,'0')]")
	private List<WebElement> broj;

	@FindBy(xpath = "//div[@class='price-item position-relative']")
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
