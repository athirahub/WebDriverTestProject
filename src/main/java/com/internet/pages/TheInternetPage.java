package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.Proxywrapper;

public class TheInternetPage extends Page {

	public TheInternetPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By formAuthentication = By.xpath("//a[contains(text(),'Form Authentication')]");
	private By checkBoxes = By.cssSelector("a[href='/checkboxes']");

	public LoginPage clickformAuthentication() {
		((Proxywrapper) driver).click(formAuthentication);
		return new LoginPage(driver, true);
	}

	public CheckBoxesPage clickCheckBoxes() {
		((Proxywrapper) driver).click(checkBoxes);
		return new CheckBoxesPage(driver, true);
	}

}
