package com.cura.constants;

import com.cura.enums.ConfigProperty;
import com.cura.utils.ReadPropertyFile;

public final class FrameworkConstants {


	private FrameworkConstants() {

	}
	private static final String chromeDriverPath = System.getProperty("user.dir")+"/src/test/resources/driver/chromedriver.exe";

	private static final String configPath=System.getProperty("user.dir")+"/src/test/resources/config/config.properties";

	private static final String EXTENTREPORTFOLDERPATH=System.getProperty("user.dir")+"/extent-test-output/";
	private static String extentReportFilePath="";





	public static String getExtentReportFilePath() {
		if(extentReportFilePath.isEmpty()) {

			extentReportFilePath= createReportPath();
		}
		return extentReportFilePath;
	}

	

	
	private static  String createReportPath() {

		if(ReadPropertyFile.getValue(ConfigProperty.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
		}
		else {

			return EXTENTREPORTFOLDERPATH+"/index.html";
		}



	}

	public static String getChromedriverpath() {
		return chromeDriverPath;
	}

	public static String getConfigpath() {
		return configPath;
	}

}
