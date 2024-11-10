package com.cura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cura.driver.DriverManager;
import com.cura.enums.WaitStrategy;
import com.cura.reports.ExtentLogger;
import com.cura.utils.ExplicitWaitFactory;

public class BasePage {


	protected void click(By by, WaitStrategy waitStratergy,String message ) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStratergy, by);
		element.click();
		try {
			ExtentLogger.pass(message+" is Clicked",false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//DriverManager.getDriver().findElement(by).click();
	}

	protected void sendKeys(By by, String value, WaitStrategy waitStratergy,String message) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStratergy, by);
		element.sendKeys(value);
		try {
			ExtentLogger.pass(message+" "+value+" is Entered",false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//DriverManager.getDriver().findElement(by).sendKeys(value);
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();

	}
	protected String getUrl() {
		return DriverManager.getDriver().getCurrentUrl();

	}
}
