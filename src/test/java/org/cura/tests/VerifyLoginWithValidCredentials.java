/**
 * 
 */
package org.cura.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.cura.dataprovider.DataProviderUtils;
import org.testng.annotations.Test;

import com.cura.pages.CuraHealthcareMenu;
import com.cura.pages.LoginPage;
import com.cura.pages.MakeAppoinmentPage;

/**
 * 	Test Case ID: TC01
	Description: Verify that a user can successfully log in with valid credentials.
	Steps:
1.	Navigate to the login page.
2.	Click Login Link
2.	Enter a valid username and password.
3.	Click the "Login" button.

Expected Result: User is redirected to the DashBoardPage and sees a welcome message.

 *Nov 11, 2024
 *@author Praveen Sarangan
 *@version 1.0
 *@since 1.0
 */
public final class VerifyLoginWithValidCredentials extends BaseTest{
	/**
	 * 
	 */
	private VerifyLoginWithValidCredentials() {

	}
	@Test(dataProvider = "log",dataProviderClass = DataProviderUtils.class)
	public void loginTest(Map<String,String>data) {

		LoginPage loginpage = new CuraHealthcareMenu().clickLoginLink();

		loginpage.enterUsername(data.get("username"))
		.enterPassword(data.get("password"))
		.clickLoginBtn();

		MakeAppoinmentPage appoinmentpage = new MakeAppoinmentPage();

		String actualUrl = appoinmentpage.getAppoinmentPageUrl();
		String expectedUrl ="https://katalon-demo-cura.herokuapp.com/#appointment";

		Assertions.assertThat(actualUrl).isEqualTo(expectedUrl);










	}

}
