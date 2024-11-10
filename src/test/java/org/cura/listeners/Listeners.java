/**
 * 
 */
package org.cura.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.cura.reports.ExtentLogger;
import com.cura.reports.ExtentReport;

/**
 *Nov 6, 2024
 *@author Praveen Sarangan
 *@version 1.0
 *@since 1.0
 */
public final class Listeners implements ITestListener,ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReports();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.flushReports();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+" is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {



		ExtentLogger.fail(result.getMethod().getMethodName()+" is Failled",true);


		ExtentLogger.fail(result.getThrowable().toString());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+" is Skipped");
	}


}
