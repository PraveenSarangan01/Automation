package com.cura.pages;

import org.openqa.selenium.By;

import com.cura.enums.WaitStrategy;

public class LoginPage extends BasePage{
	
	
	private final By textBoxuserName= By.id("txt-username");
	
	private final By textBoxpassword=By.id("txt-password");
	private final By loginBtn=By.id("btn-login");
	
	
	public LoginPage enterUsername(String userName) {
		sendKeys(textBoxuserName, userName, WaitStrategy.PRESENCE,"Username");
		
		//ExtentLogger.pass("UserName Entered");
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		sendKeys(textBoxpassword, password, WaitStrategy.PRESENCE,"Password");
		//ExtentLogger.pass("Password Entered");
		return this;
	}
	public CuraHealthCareMenuBarPage clickLoginBtn() {
		click(loginBtn, WaitStrategy.CLICKABLE,"LoginBtn");
		//ExtentLogger.pass("LoginButton Clicked");
		return new CuraHealthCareMenuBarPage();
	}
	

}
