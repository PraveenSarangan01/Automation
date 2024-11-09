/**
 * 
 */
package com.cura.pages;

import org.openqa.selenium.By;

import com.cura.enums.WaitStrategy;

/**
*Nov 10, 2024
*@author Praveen Sarangan
*@version 1.0
*@since 1.0
*/
public  class CuraHealthCareMenuBarPage extends BasePage{
	
	private final By healthCareMenu=By.xpath("//a[@id='menu-toggle']//i[1]");
	private final By logoutLink=By.xpath("//a[normalize-space(text())='Logout']");
	
	
	public  CuraHealthCareMenuBarPage clickMenuBar() {
		click(healthCareMenu, WaitStrategy.CLICKABLE, "HealthCareMenu");
		
		return this;
	}
	
	public  HomePage clickLogout() {
		click(logoutLink, WaitStrategy.CLICKABLE,"LogoutLink");
		return new HomePage();
	}
	
	
	
	

}
