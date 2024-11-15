/**
 * 
 */
package org.cura.dataprovider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.testng.annotations.DataProvider;

/**
*Nov 8, 2024
*@author Praveen Sarangan
*@version 1.0
*@since 1.0
*/
public final class DataProviderUtils {
	
	
	
	@DataProvider(name = "log")
	public static Object[] getData(Method m) throws IOException {
		String testName = m.getName();
		
		List<Map<String, String>> list=ReadExcelFile.getLoginData("login");
		if(Objects.isNull(list)) {
			System.err.println("EXcel File is empty");
		}
		
		List<Map<String,String>> smallList= new ArrayList<>();
	for(int i=0;i<list.size();i++) {
		if(list.get(i).get("testname").equalsIgnoreCase(testName)) {
			if(list.get(i).get("execute").equalsIgnoreCase("yes")){
				smallList.add(list.get(i));
				
			}
		}
		
		
	}
		
		
		
		
		
		if(smallList.isEmpty()) {
			System.err.println("Testcase name Not Matching");
		}
		
		return smallList.toArray();
		
	}

}
