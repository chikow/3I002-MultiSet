/**
 * 
 */
package pobj.tme5.test;

import java.util.List;

import pobj.tme5.InvalidMultiSetFormat;
import pobj.tme5.MultiSet;
import pobj.tme5.MultiSetParser;

/**
 * @author LAOUER Walid
 *
 */
public class MultiSetParserTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			MultiSet<String> ms = MultiSetParser.parse("data/Parse.txt");
			List<String> sorted = ms.elements();
			for (int i=0; i< ms.elements().size(); i++) {
				String e = sorted.get(i);
				System.out.println(e + ": " + ms.count(e));
			}
			
		} catch (InvalidMultiSetFormat e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		

	}

}
