/**
 * 
 */
package com.cura.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cura.driver.DriverManager;

/**
*Nov 16, 2024
*@author Praveen Sarangan
*@version 1.0
*@since 1.0
*/
public  class AppoinmentHistoryPage extends BasePage{
	private final By histortTitle=By.xpath("//div[@class='panel-heading']");
	
	private final By labelvalue=By.xpath("//div[@class='panel-body']//label");
	private final By ptagvalue=By.xpath("//div[@class='panel-body']//p");
	
	private final By historyDetails=By.xpath("//div[@class='panel-body']//p/text()");
	
	public void getHistoryPageHeading() {
		getText(histortTitle, "Appoinment History Title");
	}
	
	public void getHistoryDetails() {
		getText(historyDetails, "HistoryDetails");
	}
	
	public List<WebElement> getLabel() {
		return DriverManager.getDriver().findElements(labelvalue);
	}
	
	public List<WebElement> getPtext() {
		return DriverManager.getDriver().findElements(ptagvalue);
	}

	
	
}