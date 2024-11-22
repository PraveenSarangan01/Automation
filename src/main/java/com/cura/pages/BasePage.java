package com.cura.pages;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cura.driver.DriverManager;
import com.cura.enums.SelectDD;
import com.cura.enums.WaitStrategy;
import com.cura.reports.ExtentLogger;
import com.cura.utils.ExplicitWaitFactory;

public class BasePage {
	private final By menu=By.xpath("//a[@id='menu-toggle']//i[1]");
	
protected void clcikHealthcareMenu(WaitStrategy waitStrategy,String message) 
{
	WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, menu);
	
	element.click();
	ExtentLogger.pass(message+" is Clicked", false);
}

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
			ExtentLogger.pass(message+" "+"---"+value+"---"+" is Entered",false);
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
	
	protected void clickRadioBtn(By by,String value,WaitStrategy waitstrategy,String message) {
		if(Objects.nonNull(value)) {
			List<WebElement> radio = ExplicitWaitFactory.performExplicitWaitWithList(waitstrategy, by);
			
			
			
			for (WebElement select : radio) {
				String element = select.getAttribute("value");
				if(element.equalsIgnoreCase(value)) {
					select.click();
					ExtentLogger.pass(message+" is Selected", false);
				}
				else {
					throw new IllegalArgumentException("Entered value is invalid " + element +" Input" +value);
				}
				
			}
		}
		
		
	}
	
	protected void selectDropDown(By by,String value,WaitStrategy waitstrategy,SelectDD dd,String message) {
		if(Objects.nonNull(value)) {
			WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
			
			Select select = new Select(element);
			
			switch (dd) {
			case ByIndex :
					select.selectByIndex(Integer.parseInt(value));
					ExtentLogger.pass(message+" is Selected", false);
					
				break;
			case ByValue :
				select.selectByValue(value);
				ExtentLogger.pass(message+" is Selected", false);
			break;
			case ByVisibleText :
				select.selectByVisibleText(value);
				ExtentLogger.pass(message+" is Selected", true);
			break;

			default:
				
				break;
			}
		}
	}
	
	protected void selectDate(By by,String value,WaitStrategy waitstrategy,String message) {
		if(Objects.nonNull(value)) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.sendKeys(value);
		ExtentLogger.pass(message+" is Selected", false);
		
	}
	}
	protected void typeText(By by,String value,WaitStrategy waitStrategy,String message) {
		if(Objects.nonNull(value)) {
			WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
			element.sendKeys(value);
			ExtentLogger.pass(message+" is Typed", false);
		
	}}
	
	protected void getText(By by,String message) {
		DriverManager.getDriver().findElement(by).getText();
		ExtentLogger.pass("Get Text From "+message,false);
	}
	
	}
	
