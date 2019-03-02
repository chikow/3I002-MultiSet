/**
 * 
 */
package pobj.tme5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import pobj.util.Chrono;

/**
 * @author LAOUER Walid
 *
 */
public class WordCount {
	public static void main(String[] args) throws IOException {

		HashMultiSet<String> hm = new HashMultiSet<String>();
		MultiSetDecorator<String> hms = new MultiSetDecorator<String>(hm);
		System.out.println("Trace d’exécution de wordcount sur le fichier texte avec HashMultiSet : ");
		Chrono chrono = new Chrono(); 
		wordcount(hms);
		chrono.stop();

//				System.out.println("Trace d’exécution de wordcount sur le fichier texte avec NaiveMultiSet : ");
//				NaiveMultiSet<String> nms = new NaiveMultiSet<String>();
//				Chrono chrono2 = new Chrono();
//				wordcount(nms);
//				chrono2.stop();


	}

	public static void wordcount(MultiSet<String> ms) throws IOException {
		String file = "data/WarAndPeace.txt";
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while((line = br.readLine()) != null) {
			for (String word : line.split("\\P{L}+")) {
				ms.add(word);
			}
		}
		br.close();

		class MultiSetComparator<T> implements Comparator<T>{
			MultiSet<T> ms;

			public MultiSetComparator(MultiSet<T> ms) {
				this.ms = ms;
			}

			/* (non-Javadoc)
			 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
			 */
			@Override
			public int compare(T o1, T o2) {
				// TODO Auto-generated method stub
				return Integer.compare(ms.count(o2), ms.count(o1));
			}
		}
		
		System.out.println(ms.toString());
		
//		Comparator<String> c = new MultiSetComparator<String>(ms);
//
//		List<String> sorted = ms.elements();
//		sorted.sort(c);
//		for (int i=0; i<10; i++) {
//			String e = sorted.get(i);
//			System.out.println(e + " : " + ms.count(e));
//		}

	}

}

