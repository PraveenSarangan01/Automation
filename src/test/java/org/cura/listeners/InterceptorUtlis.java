/**
 * 
 */
package org.cura.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.cura.dataprovider.ReadExcelFile;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

/**
 *Nov 9, 2024
 *@author Praveen Sarangan
 *@version 1.0
 *@since 1.0
 */
public final class InterceptorUtlis implements IMethodInterceptor{

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		List<IMethodInstance>result=null;
		List<Map<String, String>> list = ReadExcelFile.getLoginData("RUNMANAGER");
		
		if (list == null || list.isEmpty()) {
	        System.out.println("Data provider is empty.");
	        return result;
		}
		result =new ArrayList<>();


		for(int i=0;i<methods.size();i++) {
			for(int j=0;j<list.size();j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname")) 
					&& list.get(j).get("execute").equalsIgnoreCase("yes")) {
					
						methods.get(i).getMethod().setDescription(list.get(j).get("Testdescription"));
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
						methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
						result.add(methods.get(i));
					}
				}
			}
		





		return result;
	}






}
