/**
 * 
 */
package com.cura.pages;

import org.openqa.selenium.By;

import com.cura.driver.DriverManager;

/**
*Nov 16, 2024
*@author Praveen Sarangan
*@version 1.0
*@since 1.0
*/
public  class AppoinmentConfirmationPage extends BasePage{
	
	/**
	 * 
	 */
	public AppoinmentConfirmationPage() {
		// TODO Auto-generated constructor stub
	}
	
	private final By pageHeading=By.xpath("//div[@class='col-xs-12 text-center']//p[1]");
	
	
	public String assertPageHeading() {
	return	DriverManager.getDriver().findElement(pageHeading).getText();
		
		
		
	}

}
