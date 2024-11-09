package com.cura.pages;

import org.openqa.selenium.By;

import com.cura.enums.WaitStrategy;

public class HomePage extends BasePage{

	private final By menu=By.xpath("//a[@id='menu-toggle']//i[1]");
	private final By loginLink= By.xpath("//a[text()='Login']");
	private final By homeLink=By.xpath("//a[text()='Home']");


	public HomePage clickMenu() {
		click(menu, WaitStrategy.CLICKABLE,"Menu");
		//ExtentLogger.pass("Menu Clicked");	
		return this;
	}

	public LoginPage clickLoginLink() {
		click(loginLink, WaitStrategy.CLICKABLE,"Login Link");
				
		return new LoginPage();
	}

	public HomePage clickHomeLink() {
		click(homeLink, WaitStrategy.CLICKABLE,"Home Link");
		//ExtentLogger.pass("Home Link Clicked");		
		return this;

	}
}
