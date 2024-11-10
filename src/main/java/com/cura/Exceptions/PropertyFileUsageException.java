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
public class PropertyFileUsageException extends FrameworkExceptions {
	
/**
 * 
 */
public PropertyFileUsageException(String message) {
	super(message);

}

/**
 * 
 */
public PropertyFileUsageException(String message,Throwable cause) {
	
	super(message, cause);
}
}
