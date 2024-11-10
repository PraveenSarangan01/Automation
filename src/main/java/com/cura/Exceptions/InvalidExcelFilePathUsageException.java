/**
 * 
 */
package com.cura.Exceptions;

/**
*Nov 11, 2024
*@author Praveen Sarangan
*@version 1.0
*@since 1.0
*/
@SuppressWarnings("serial")
public class InvalidExcelFilePathUsageException extends FrameworkExceptions{
	/**
	 * 
	 */
	public InvalidExcelFilePathUsageException(String message) {
		super(message);
		
	}
	/**
	 * 
	 */
	public InvalidExcelFilePathUsageException(String message,Throwable cause) {
		super(message, cause);
	}

}
