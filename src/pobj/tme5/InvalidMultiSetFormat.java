/**
 * 
 */
package pobj.tme5;

/**
 * @author LAOUER Walid
 *
 */
public class InvalidMultiSetFormat extends Exception{

	public InvalidMultiSetFormat(String message) {
		System.out.println("Message" + message);
	}
	
	public InvalidMultiSetFormat(String message , Throwable cause) {
		System.out.println("Message : " + message);
		System.out.println("Cause : " + cause);
	}
}
