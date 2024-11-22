package com.cura.pages;

import org.openqa.selenium.By;

import com.cura.enums.WaitStrategy;

public class LandingPage extends BasePage{

	
	private final By loginLink= By.xpath("//a[text()='Login']");
	private final By homeLink=By.xpath("//a[text()='Home']");


	public CuraHealthcareMenu clickMenu() {
		clcikHealthcareMenu(WaitStrategy.CLICKABLE,"Menu Bar");
		//ExtentLogger.pass("Menu Clicked");	
		return new CuraHealthcareMenu();
	}

	public LoginPage clickLoginLink() {
		click(loginLink, WaitStrategy.CLICKABLE,"Login Link");
				
		return new LoginPage();
	}

	public LandingPage clickHomeLink() {
		click(homeLink, WaitStrategy.CLICKABLE,"Home Link");
		//ExtentLogger.pass("Home Link Clicked");		
		return this;

	}
}
