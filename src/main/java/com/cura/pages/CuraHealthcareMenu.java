/**
 * 
 */
package com.cura.pages;

import org.openqa.selenium.By;

import com.cura.enums.WaitStrategy;

/**
*Nov 19, 2024
*@author Praveen Sarangan
*@version 1.0
*@since 1.0
*/
public final class CuraHealthcareMenu extends BasePage{
	
	private final By loginLink= By.xpath("//a[text()='Login']");
	private final By homeLink=By.xpath("//a[text()='Home']");
	private final By logoutLink=By.xpath("//a[normalize-space(text())='Logout']");
	private final By historyLink=By.xpath("//a[normalize-space(text())='History']");
	private final By profileLink=By.xpath("//a[normalize-space(text())='Profile']");
	
	
	public LandingPage clickHomeLink() {
		clcikHealthcareMenu(WaitStrategy.CLICKABLE,"Menu bar");
		click(homeLink, WaitStrategy.CLICKABLE,"Home Link");
		return new LandingPage();
		
	}
	
	public LoginPage clickLoginLink() {
		clcikHealthcareMenu(WaitStrategy.CLICKABLE,"Menu bar");
		click(loginLink, WaitStrategy.CLICKABLE,"Login Link");
		return new LoginPage();
		
	}
	public AppoinmentHistoryPage clickHistoryLink() {
		clcikHealthcareMenu(WaitStrategy.CLICKABLE,"Menu bar");
		click(historyLink, WaitStrategy.CLICKABLE,"History Link");
		return new AppoinmentHistoryPage();
		
	}
	public UserProfilePage clickProfileLink() {
		clcikHealthcareMenu(WaitStrategy.CLICKABLE,"Menu bar");
		click(profileLink, WaitStrategy.CLICKABLE,"Profile Link");
		return new UserProfilePage();
		
	}
	public LandingPage clickLogOutLink() {
		clcikHealthcareMenu(WaitStrategy.CLICKABLE,"Menu bar");
		click(logoutLink, WaitStrategy.CLICKABLE,"Logout Link");
		return new LandingPage();
		
		
	}
	

}
