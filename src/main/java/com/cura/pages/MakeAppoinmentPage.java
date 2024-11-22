/**
 * 
 */
package com.cura.pages;

import org.openqa.selenium.By;

import com.cura.driver.DriverManager;
import com.cura.enums.SelectDD;
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
	private final By facility=By.id("combo_facility"); 
	
	private final By  readmission=By.id("chk_hospotal_readmission");
	private final By program=By.id("radio_program_medicaid");
	private final By visitdate=By.id("txt_visit_date");
	private final By comment=By.id("txt_comment");
	private final By booking=By.id("btn-book-appointment");
	private final By historyLink=By.xpath("//a[normalize-space(text())='History']");
	
	
	public AppoinmentHistoryPage clickHistory() {
		click(historyLink, WaitStrategy.CLICKABLE, "History Link");
		return new  AppoinmentHistoryPage();
	}
	
	public  MakeAppoinmentPage clickMenuBar() {
		click(healthCareMenu, WaitStrategy.CLICKABLE, "HealthCareMenu");
		
		return this;
	}
	
	public  LandingPage clickLogout() {
		click(logoutLink, WaitStrategy.CLICKABLE,"LogoutLink");
		return new LandingPage();
	}
	
	public String getAppoinmentPageUrl() {
		return getUrl();
	}
	
	public String assertPageHeading() {
		
	return	DriverManager.getDriver().findElement(welcomeMsg).getText();
		
	}
	public MakeAppoinmentPage selectHealthCareProgram(String value) {
		clickRadioBtn(program, value, WaitStrategy.PRESENCE_OF_ALL,"HelathCareProgram" );
		return this;
}

	public MakeAppoinmentPage selectFacility(String value,SelectDD dd) {
		selectDropDown(facility, value, WaitStrategy.PRESENCE, dd, "Facility");
		return this;
	}
	public MakeAppoinmentPage selectAppoinmentDate(String value) {
		selectDate(visitdate, value, WaitStrategy.VISIBLE,"Appoinment Date");
		return this;
	}
	public MakeAppoinmentPage typeComment(String value) {
		
		typeText(comment, value, WaitStrategy.PRESENCE, "Comments");
		return this;
	}
	public AppoinmentConfirmationPage clickBookAppoinment() {
		click(booking, WaitStrategy.CLICKABLE, "Book Appoinment Btn");
		return new AppoinmentConfirmationPage();
	}
	public MakeAppoinmentPage clickReAdmission() {
		click(readmission, WaitStrategy.CLICKABLE,"ReAddmision");
		return this;
		
	}
}