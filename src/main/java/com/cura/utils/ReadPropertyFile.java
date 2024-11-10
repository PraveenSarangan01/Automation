	package com.cura.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import com.cura.Exceptions.PropertyFileUsageException;
import com.cura.constants.FrameworkConstants;
import com.cura.enums.ConfigProperty;

public final class ReadPropertyFile {
	
	private ReadPropertyFile() {
		
	}
	private static Properties property=new Properties();
	
	static {
		try {
			property.load(new FileInputStream(FrameworkConstants.getConfigpath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getValue(ConfigProperty key)  {
		
		
		
		if(Objects.isNull(key)||Objects.isNull(property.getProperty(key.name().toLowerCase()))){
			throw new PropertyFileUsageException("property name"+key+"is not found, please Check config.property");
		}
		
		return property.getProperty(key.name().toLowerCase());
		
	
	}

}
