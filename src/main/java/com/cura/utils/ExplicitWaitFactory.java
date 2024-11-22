package com.cura.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cura.driver.DriverManager;
import com.cura.enums.WaitStrategy;

public class ExplicitWaitFactory {
	
	private static final long timeOut=10;
	
	
	public static WebElement performExplicitWait(WaitStrategy waitStratergy, By by) {
		
		WebDriverWait driverWait =new WebDriverWait(DriverManager.getDriver(),timeOut );
		
		switch(waitStratergy) {
		
		case CLICKABLE:
		return	driverWait.until(ExpectedConditions.elementToBeClickable(by));
			
		case PRESENCE:
		return	driverWait.until(ExpectedConditions.presenceOfElementLocated(by));
			
		case VISIBLE:
		return	driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
		
		
			
			
			default:
				throw new IllegalArgumentException("Invalid wait strategy: " + waitStratergy);
		}
	}
	
	
	
public static List<WebElement> performExplicitWaitWithList(WaitStrategy waitStratergy, By by) {
			
WebDriverWait driverWait =new WebDriverWait(DriverManager.getDriver(),timeOut );
			

	switch(waitStratergy) {
			case PRESENCE_OF_ALL:
		    return	driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));

			case VISIBLITY_OF_ALL:
				return driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	
			default:
				throw new IllegalArgumentException("Invalid wait strategy: " + waitStratergy);
	
	
	}
	
		}
}
