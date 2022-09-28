package com.internet.utils;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;






public class Proxywrapper implements WebDriver,JavascriptExecutor {
	private WebDriver driver;
	public static JavascriptExecutor jse;
	public Proxywrapper(WebDriver wd) {
		driver = wd;
	}

	@Override
	public Object executeScript(String script, Object... args) {
		
		return null;
	}

	@Override
	public Object executeAsyncScript(String script, Object... args) {
		
		return null;
	}

	@Override
	public void get(String url) {
		Proxywrapper.this.driver.get(url);
		
	}

	@Override
	public String getCurrentUrl() {
		return Proxywrapper.this.driver.getCurrentUrl();
		
	}

	@Override
	public String getTitle() {
		return 	Proxywrapper.this.driver.getTitle();
		
	}

	@Override
	public List<WebElement> findElements(By by) {
		return Proxywrapper.this.driver.findElements(by);
		
	}

	@Override
	public WebElement findElement(By by) {
		return Proxywrapper.this.driver.findElement(by);
		
	}

	@Override
	public String getPageSource() {
		return Proxywrapper.this.driver.getPageSource();
		
	}

	@Override
	public void close() {
		 Proxywrapper.this.driver.close();
		
	}
	public void click(By locator) {
		this.waitForElementToBeClickable(locator, 5).click();
	}


	@Override
	public void quit() {
		 Proxywrapper.this.driver.quit();
		
	}

	@Override
	public Set<String> getWindowHandles() {
		return Proxywrapper.this.driver.getWindowHandles();
		
	}

	@Override
	public String getWindowHandle() {
		return Proxywrapper.this.driver.getWindowHandle();
		
		
	}

	public String getText(By locator) {
		try {

			WebElement element = this.waitForElementToBeVisible(locator,10);
			return element.getText().trim();
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void sendKeys(By by, String keysInput) {
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(driver.findElement(by)))
				.sendKeys(keysInput);
	}

	public boolean isDisplayed(By by) {
		try {
			waitForElementToBeVisible(by, 10);
			return this.findElement(by).isDisplayed();
		} catch (Exception e) {
			
		}
		return false;
	}

	public boolean isEnabled(By by) {
		try {
			waitForElementToBeVisible(by, 10);
			return this.findElement(by).isEnabled();
		} catch (Exception e) {
			
		}
		return false;
	}
	public boolean isSelected(By by) {
		try {
			waitForElementToBeVisible(by, 5);
			return this.findElement(by).isSelected();
		} catch (Exception e) {
			
		}
		return false;
	}

	public void selectFromDropDown(WebElement element, String value) {
		waitForElementToBeSelectable(element);
		Select sc = new Select(element);
		try {
			sc.selectByValue(value);
		} catch (Exception e) {
			sc.selectByVisibleText(value);
		}
	}
	public  List<WebElement> isElementsDisplayed(By by) {
		return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}
	public String[] textOfElements(By by) {
	List<WebElement>partial	=isElementsDisplayed(by);
		String[] texts=new String[partial.size()];
		for(int i=0;i<partial.size();i++) {
			texts[i]=partial.get(i).getText();
		}
		return texts;
	}
	

	public void switchToNewTab(By element) {
		String parentHandle = this.getWindowHandle();
		waitForElementToBeClickable(element, 5);

		Set<String> allWindowHandles = this.getWindowHandles();
		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(parentHandle)) {
				this.switchTo().window(windowHandle);
			}
		}

	}
	public void scrollIntoViewUsingJavascript(By by) {
		jse = (JavascriptExecutor)driver ;
		
		jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
		click(by);
	}

	public void acceptAlert() {
		new WebDriverWait(this, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent()).accept();
	}

	public void dismissAlert() {
		new WebDriverWait(this, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent()).dismiss();
	}

	public WebElement waitForElementToBeClickable(By locator, int timeOutInSeconds) {
		return new WebDriverWait(this,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement waitForElementToBeVisible(By Locator, int timeOutInSeconds) {
		return new WebDriverWait(this,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}

	public void waitForElementToBeSelectable(WebElement element) {
		new WebDriverWait(this, Duration.ofSeconds(10)).until(ExpectedConditions.elementSelectionStateToBe(element, true));
	}
	public void submit(By by) {
		waitForElementToBeClickable(by, 15).submit();
		
	}



	@Override
	public TargetLocator switchTo() {
		
		return null;
	}

	@Override
	public Navigation navigate() {
		return Proxywrapper.this.driver.navigate();
		
	}

	@Override
	public Options manage() {
		
		return Proxywrapper.this.driver.manage();
	}

}
