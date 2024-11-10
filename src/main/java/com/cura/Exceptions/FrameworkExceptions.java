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
public class FrameworkExceptions extends RuntimeException{
	
	public FrameworkExceptions(String message) {
		super(message);	
	}
	
	public FrameworkExceptions(String message ,Throwable cause) {
		super(message,cause);
		}

}
