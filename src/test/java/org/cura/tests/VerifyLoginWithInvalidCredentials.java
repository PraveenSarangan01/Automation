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
import com.cura.reports.ExtentLogger;

/**
 * 	Test Case ID: TC02
 * 	Description: Verify that a user cannot log in with invalid credentials.
 * Steps:
1.	Navigate to the login page.
2.	Enter an invalid username and password.
3.	Click the "Login" button.

	Expected Result: An error message is displayed indicating invalid credentials
 * 
 * 
 *
 *Nov 11, 2024
 *@author Praveen Sarangan
 *@version 1.0
 *@since 1.0
 */
public final class VerifyLoginWithInvalidCredentials extends BaseTest {
	/**
	 * 
	 */
	private VerifyLoginWithInvalidCredentials() {
		// TODO Auto-generated constructor stub
	}

	@Test(dataProvider = "log",dataProviderClass = DataProviderUtils.class)
	public void loginWithInvalidCredentials(Map<String,String>data) {

		//new CuraHealthcareMenu().clickLoginLink();

		//CuraHealthcareMenu menu = new CuraHealthcareMenu();
		//LoginPage loginpage = menu.clickLoginLink();

		LoginPage loginpage = new CuraHealthcareMenu().clickLoginLink();



		loginpage.enterUsername(data.get("username"))
		.enterPassword(data.get("password"))
		.clickLoginBtn();

		String actualErrorMessage = loginpage.getErrorMessage();


		Assertions.assertThat(actualErrorMessage).isEqualTo(data.get("expectedvalue"));
		ExtentLogger.pass("Actual :"+actualErrorMessage +" Expected :"+data.get("expectedvalue"));


	}


}
