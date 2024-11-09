/**
 * 
 */
package com.cura.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cura.constants.FrameworkConstants;

/**
 *Nov 6, 2024
 *@author Praveen Sarangan
 *@version 1.0
 *@since 1.0
 */
public final class ExtentReport {
	private ExtentReport() {

	}

	private static ExtentReports extent;




	public static void initReports() {
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark=new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("CURA REPORTS");
			spark.config().setReportName("CURA Automation Tets Report");
		}
	}
	public static void flushReports()  {
		if(Objects.nonNull(extent))

		{
			extent.flush();
		}
		ExtentManager.unLoad();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void createTest(String testname) {


		//ExtentTest test=extent.createTest(testname);
		ExtentManager.setExtentTest(extent.createTest(testname));

	}
}


