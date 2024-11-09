/**
 * 
 */
package com.cura.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.cura.driver.DriverManager;
import com.cura.enums.ConfigProperty;
import com.cura.utils.ReadPropertyFile;

/**
 *Nov 6, 2024
 *@author Praveen Sarangan
 *@version 1.0
 *@since 1.0
 */
public final class ExtentLogger {
	private ExtentLogger() {}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}
	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);

	}
	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}


	public static void pass(String message,boolean isScreenShotNeeded) throws Exception {
		if(ReadPropertyFile.getValue(ConfigProperty.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenShotNeeded){
			ExtentManager.getExtentTest().pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}
	
	public static void fail(String message,boolean isScreenShotNeeded) throws Exception {
		if(ReadPropertyFile.getValue(ConfigProperty.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenShotNeeded){
			ExtentManager.getExtentTest().fail(message,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		}
		else {
			fail(message);
		}
	}
	
	public static void skip(String message,boolean isScreenShotNeeded) throws Exception {
		if(ReadPropertyFile.getValue(ConfigProperty.SKIPPEDTESTSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenShotNeeded){
			ExtentManager.getExtentTest().skip(message,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		}
		else {
			skip(message);
		}
	}
	
	
	public static String getBase64Image() {
		return	((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
