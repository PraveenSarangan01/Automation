/**
 * 
 */
package com.cura.pages;

import org.openqa.selenium.By;

import com.cura.driver.DriverManager;
import com.cura.enums.WaitStrategy;

/**
*Nov 10, 2024
*@author Praveen Sarangan
*@version 1.0
*@since 1.0
*/
public  class MakeAppoinmentPage extends BasePage{
	
	private final By healthCareMenu=By.xpath("//a[@id='menu-toggle']//i[1]");
	private final By logoutLink=By.xpath("//a[normalize-space(text())='Logout']");
	private final By welcomeMsg =By.xpath("//h2[normalize-space(text())='Make Appointment']");
	
	
	public  MakeAppoinmentPage clickMenuBar() {
		click(healthCareMenu, WaitStrategy.CLICKABLE, "HealthCareMenu");
		
		return this;
	}
	
	public  HomePage clickLogout() {
		click(logoutLink, WaitStrategy.CLICKABLE,"LogoutLink");
		return new HomePage();
	}
	
	public String getAppoinmentPageUrl() {
		return getUrl();
	}
	
	public String assertPageHeading() {
		
	return	DriverManager.getDriver().findElement(healthCareMenu).getText();
	
	

}

	
}