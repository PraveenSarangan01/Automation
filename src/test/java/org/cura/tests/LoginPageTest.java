package org.cura.tests;

import java.util.Map;

import org.cura.dataprovider.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cura.driver.DriverManager;
import com.cura.pages.CuraHealthCareMenuBarPage;
import com.cura.pages.HomePage;
import com.cura.pages.LoginPage;



public final class LoginPageTest extends BaseTest{
	
	private LoginPageTest() {
		
		
	}
	
	/**
	 * Validate weather the title containing Google search
	 * validate weather the title is not null and the length of the title is 
	 * greater then 15 an less then 100.
	 * check for the links in the page---Testing mini bytes
	 * number of link displayed is exactly 10 or 15
	 * 
	 */
	/**
	 *Navigate to the Application and click Login link
	 *Enter Valid Username and Password
	 *and Click login. Login should be sucessfull
	 * @throws Exception 
	 */
	@Test(dataProvider = "log",dataProviderClass = DataProviderUtils.class)
	public void LoginTest(Map<String,String>data) throws Exception {
		
		new HomePage()
		.clickMenu().clickLoginLink();
		
		new LoginPage()
		.enterUsername(data.get("username"))
		.enterPassword(data.get("password"))
		.clickLoginBtn();
		
		new CuraHealthCareMenuBarPage()
		.clickMenuBar()
		.clickLogout();
		
		String actualtitle = DriverManager.getDriver().getTitle();
		String expectedtitle="CURA Healthcare Service";
		
		Assert.assertEquals(actualtitle, expectedtitle);
		
	}
	
	@Test(dataProvider = "log",dataProviderClass = DataProviderUtils.class)
	public void newTest(Map<String,String>data) throws Exception {
		
		new HomePage()
		.clickMenu().clickLoginLink();
		
		new LoginPage()
		.enterUsername(data.get("username"))
		.enterPassword(data.get("password"))
		.clickLoginBtn();
		
		new CuraHealthCareMenuBarPage()
		.clickMenuBar()
		.clickLogout();
		
		String actualtitle = DriverManager.getDriver().getTitle();
		String expectedtitle="CURA Healthcare Service";
		
		Assert.assertEquals(actualtitle, expectedtitle);
		
	}

}
