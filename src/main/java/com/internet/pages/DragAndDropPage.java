package com.internet.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.Proxywrapper;
import com.internet.utils.Utils;

public class DragAndDropPage extends Page {
	private static final String PAGE_URL = "/drag_and_drop ";

	public DragAndDropPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By draggable = By.cssSelector("#column-a");
	private By droppable = By.cssSelector("#column-b");

	public void dragAndDrop() {
		((Proxywrapper) driver).dragAndDrop(draggable, droppable);
	}

	public String getTextA() {
		return ((Proxywrapper) driver).getText(draggable);
	}

	public String getTextB() {
		return ((Proxywrapper) driver).getText(droppable);
	}

	public boolean isTextExchanged() {

		if (getTextA().equals("B") && getTextB().equals("A")) {
			return true;
		}
		return false;
	}
}
