package com.internet.Tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.Baseclass;
import com.internet.pages.DragAndDropPage;
import com.internet.pages.LoginPage;
import com.internet.pages.Page;
import com.internet.pages.TheInternetPage;

public class DragAndDropPageTest extends Baseclass {
	TheInternetPage internet;
	DragAndDropPage drag;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new TheInternetPage(webdriver, true);
		drag = internet.clickDragAndDrop();
	}

	@Test
	public void textExchangedAfterDragTest() {
		drag.dragAndDrop();
		Assert.assertEquals(drag.isTextExchanged(), true);
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
