/**
 * 
 */
package org.cura.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cura.Exceptions.InvalidExcelFilePathUsageException;

/**
 *Nov 8, 2024
 *@author Praveen Sarangan
 *@version 1.0
 *@since 1.0
 */
public final class ReadExcelFile {
	
	
	public static List<Map<String, String>> getLoginData(String sheetname)  {
		
		List<Map<String,String>>list=new ArrayList<>();

		
		try(FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/excel/testlogin.xlsx");
			
			
			XSSFWorkbook workbook=new XSSFWorkbook(fs)){
			XSSFSheet sheet = workbook.getSheet(sheetname);
			
			if(Objects.isNull(sheet)) {
				System.err.println("Sheet with name "+sheetname+" is not fount in the ExcelFile. ");
				return list;
			}

			int rowNum = sheet.getLastRowNum();
			short columnNum = sheet.getRow(0).getLastCellNum();
			
			
			for(int i=1;i<=rowNum;i++) {
				
				Map<String,String> map =new HashMap<>();
				
				for(int j=0;j<columnNum	;j++) {
					
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					XSSFCell cell=sheet.getRow(i).getCell(j);
					
					DataFormatter df= new DataFormatter();
					 String value = df.formatCellValue(cell);
					map.put(key, value);
					
				}
				list.add(map);
			}
		} catch (IOException e) {
			
			throw new InvalidExcelFilePathUsageException("Error reading Excel file:",e);
		}
		
		
		
		return list;
		
		
	}
	
}
