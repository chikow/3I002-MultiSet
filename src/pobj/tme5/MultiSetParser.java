/**
 * 
 */
package pobj.tme5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author LAOUER Walid
 *
 */
public class MultiSetParser {

	public static MultiSet<String> parse (String fileName) throws InvalidMultiSetFormat{
		MultiSet<String> ms = new HashMultiSet<String>();
		String line;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			throw new InvalidMultiSetFormat("Fichier introuvable : ", e.getCause());
		}

		try {
			for (line = br.readLine(); line!= null; line = br.readLine()) {
				String [] parts = line.split(":");
				ms.add(parts[0], Integer.decode(parts[1].trim()));
				
			}

		} catch(ArrayIndexOutOfBoundsException e) {
			throw new InvalidMultiSetFormat("Erreur d'indice / ':' introuvable", e.getCause());
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			throw new InvalidMultiSetFormat("La chaine n'est un pas un entier : ", e.getCause());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new InvalidMultiSetFormat("ERROR IOEXECPTION : ", e.getCause());
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new InvalidMultiSetFormat("ERROR IOEXECPTION : ", e.getCause());
		}

		return ms;
	}

}
