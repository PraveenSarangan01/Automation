
package org.cura.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderOne {
	
	@DataProvider(name="login",parallel = true)
	public String[][] readData() {
	String [][] data= new String[2][2];
	data[0][0]="John Doe";
	data[0][1]="ThisIsNotAPassword";
	data[1][0]="John Doe";
	data[1][1]="ThisIsNotAPassword";
	return data;
	}
}
