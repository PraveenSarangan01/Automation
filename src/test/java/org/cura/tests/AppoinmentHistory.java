/**
 * 
 */
package org.cura.tests;

import java.util.List;
import java.util.Map;

import org.cura.dataprovider.DataProviderUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cura.enums.SelectDD;
import com.cura.pages.AppoinmentHistoryPage;
import com.cura.pages.CuraHealthcareMenu;
import com.cura.pages.LoginPage;
import com.cura.pages.MakeAppoinmentPage;

/**
 * 
 * 	Description: Verify that a user can view their appointment history.
 * 	Steps:
1.	Log in to the application.
2.	Navigate to the "Profile" or "Appointments" section.
 *Expected Result: A list of past appointments is displayed.

 *Nov 19, 2024
 *@author Praveen Sarangan
 *@version 1.0
 *@since 1.0
 */
public final class AppoinmentHistory extends BaseTest {
	private AppoinmentHistory() {}


	@Test(dataProvider = "log",dataProviderClass = DataProviderUtils.class)

	public void verifyAppoinmentHistory(Map<String,String> data) {

		String values = data.get("testdata");

		String[] appoinmentData = values.split(",");



		LoginPage loginpage = new CuraHealthcareMenu().clickLoginLink();

		loginpage.enterUsername(data.get("username"))
		.enterPassword(data.get("password"))
		.clickLoginBtn();

		new MakeAppoinmentPage()
		.selectFacility(appoinmentData[0], SelectDD.ByVisibleText)
		.clickReAdmission()
		.selectHealthCareProgram(appoinmentData[1])
		.selectAppoinmentDate(appoinmentData[2])
		.typeComment(appoinmentData[3])
		.clickBookAppoinment();

		AppoinmentHistoryPage appoinmentHistorypage = new CuraHealthcareMenu().clickHistoryLink();

		List<WebElement> label = appoinmentHistorypage.getLabel();
		List<WebElement> ptext = appoinmentHistorypage.getPtext();

		for(int i=0;i<label.size();i++) {
			String labeltext = label.get(i).getText();
			String paratext = ptext.get(i).getText();
			System.out.println("Label : "
					+labeltext+" Text :"+paratext);
			//ExtentLogger.pass(labeltext +" : "+paratext);


		}








	}


}
