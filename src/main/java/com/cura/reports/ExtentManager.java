/**
 * 
 */
package com.cura.reports;

import com.aventstack.extentreports.ExtentTest;

/**
*Nov 6, 2024
*@author Praveen Sarangan
*@version 1.0
*@since 1.0
*/
public final class ExtentManager {
	/**
	 * 
	 */
	private ExtentManager() {}
	
private static ThreadLocal<ExtentTest> extTest =new ThreadLocal<>();
	
	
	 static ExtentTest getExtentTest() {
		return extTest.get();
	}
	
	 static void setExtentTest(ExtentTest test) {
		extTest.set(test);
	}
	
	 static void  unLoad() {
		extTest.remove();
	}


}
