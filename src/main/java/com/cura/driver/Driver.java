package com.cura.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cura.constants.FrameworkConstants;
import com.cura.enums.ConfigProperty;
import com.cura.utils.ReadPropertyFile;


public final class Driver {
	private Driver() {
		
	}
	
	
	
	
	

	public static void initDriver() throws Exception {
		if(Objects.isNull(DriverManager.getDriver())) {
		System.setProperty("webdriver.chrome.driver",FrameworkConstants.getChromedriverpath());
		WebDriver driver = new ChromeDriver();
		DriverManager.setDriver(driver);
		DriverManager.getDriver().get(ReadPropertyFile.getValue(ConfigProperty.URL));
		}
		
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unLoad();
		}
	}

	

}
