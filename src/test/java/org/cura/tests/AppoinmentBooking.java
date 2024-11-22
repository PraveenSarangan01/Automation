/**
 * 
 */
package org.cura.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.cura.dataprovider.DataProviderUtils;
import org.testng.annotations.Test;

import com.cura.enums.SelectDD;
import com.cura.pages.AppoinmentConfirmationPage;
import com.cura.pages.CuraHealthcareMenu;
import com.cura.pages.LoginPage;
import com.cura.pages.MakeAppoinmentPage;

/**
 * 	Test Case ID: TC03
 * 	Description: Verify that a user can book an appointment.
 * 
 * Steps:
1.	Log in to the application.
2.	Navigate to the "Make Appointment" section.
3.	Fill in the appointment details (date, time, type of care).
4.	Click the "Book Appointment" button.

Expected Result: Appointment confirmation is displayed with appointment details.

 * 
 * 
 * 
 *Nov 16, 2024
 *@author Praveen Sarangan
 *@version 1.0
 *@since 1.0
 *
 */
public final class AppoinmentBooking extends BaseTest {
	/**
	 * 
	 */
	private AppoinmentBooking() {
		// TODO Auto-generated constructor stub
	}

	@Test(dataProvider = "log",dataProviderClass = DataProviderUtils.class)

	public void verifyUserCanBookAppoinment(Map<String,String> data) {

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

		String actual =new AppoinmentConfirmationPage().assertPageHeading();

		Assertions.assertThat(actual).isEqualTo(data.get("expectedvalue"));

		System.out.println(actual);

	}

}
