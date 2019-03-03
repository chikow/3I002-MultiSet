package pobj.tme5;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;


/**
 * @author LAOUER Walid
 * @param <T>
 *
 */
public class HashMultiSet<T> extends AbstractCollection<T> implements MultiSet<T>{
	private HashMap<T, Integer> hm;
	private int size ;

	public HashMultiSet() {
		this.hm = new HashMap<T, Integer>();
		size = 0;
	}


	public HashMultiSet(Collection<T> col) {
		hm = new HashMap<T, Integer>();
		for (T elm : col) {
			add(elm);
		}
	}

	/* (non-Javadoc)
	 * @see pobj.tme4.MultiSet#add(java.lang.Object, int)
	 */
	@Override
	public boolean add(T e, int count) {
		if (count < 0) 
			throw new IllegalArgumentException("Argument Negatif !");
		if(count!=0) {

			if(hm.containsKey(e)) {
				hm.put(e,hm.get(e) + count);
			}else
				hm.put(e, count);
			size+=count;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see pobj.tme4.MultiSet#add(java.lang.Object)
	 */
	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stu
		if (hm.containsKey(e)) {
			hm.put(e, hm.get(e)+1);
			size++;
			return true;
		}
		hm.put(e, 1);
		size++;
		return true;
	}

	/* (non-Javadoc)
	 * @see pobj.tme4.MultiSet#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object e) {
		// TODO Auto-generated method stub
		T eT = (T) e;
		if(hm.containsKey(e)) {
			hm.put((T) e, count(eT)-1);
			size--;
			return true;
		}	
		return false;
	}

	/* (non-Javadoc)
	 * @see pobj.tme4.MultiSet#remove(java.lang.Object, int)
	 */
	@Override
	public boolean remove(Object e, int count) {
		if (count < 0) 
			throw new IllegalArgumentException("Argument Negatif !");
		if(count!=0) {
		T eT = (T) e;
		if (count(eT) < count)
			throw new IllegalArgumentException("Le nombre doit être inferieur !");
		if (hm.containsKey(e) && count>0 && count(eT)>=count){
			hm.put(eT, count(eT)-count);
			size-=count;
			return true;
		}}
		return false;
	}

	/* (non-Javadoc)
	 * @see pobj.tme4.MultiSet#count(java.lang.Object)
	 */
	@Override
	public int count(T o) {
		// TODO Auto-generated method stub
		if (hm.containsKey(o)) {
			return hm.get(o);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see pobj.tme4.MultiSet#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		hm.clear();

	}

	/* (non-Javadoc)
	 * @see pobj.tme4.MultiSet#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	public Iterator<T> iterator() {
		return new HashMultiSetIterator ();
	}

	public Map<T, Integer> getHash() {
		return hm;
	}


	private class HashMultiSetIterator implements Iterator<T>{
		private int index,nbr;
		private Iterator<Entry<T, Integer>> iterator;
		private T key ;


		public HashMultiSetIterator() {
			iterator = hm.entrySet().iterator();
			index = 0;
			nbr=0;	
		}



		/* (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (index < size());

		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public T next() {
			// TODO Auto-generated method stub
			if(!hasNext()) throw new NoSuchElementException();

			if(nbr == 0) {
				Map.Entry<T, Integer> map = iterator.next();
				key = map.getKey();
				nbr = map.getValue();
			}
			index++;
			nbr--;


			return key;
		}



	}


	/* (non-Javadoc)
	 * @see pobj.tme4.MultiSet#elements()
	 */
	@Override
	public List<T> elements() {
		// TODO Auto-generated method stub
		List<T> elements = new ArrayList(this);
		Set<T> s = new HashSet<>(elements);
		elements = new ArrayList(s);	
		return elements;
	}


	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("[");
		Iterator<Entry<T, Integer>> it = hm.entrySet().iterator();
	    while(it.hasNext()){
	    	Entry<T, Integer> e = it.next();
	    	T data = e.getKey();
	    	int val = e.getValue();
	    	b.append(data + ":" + val + "; ");
	    }
	    b.deleteCharAt(b.length()-2);
	    b.deleteCharAt(b.length()-1);
	    b.append("]");
		return b.toString();
	
	}
	@Override
	public boolean isConsistent() {
		Iterator<Entry<T, Integer>> it = hm.entrySet().iterator();
		int som = 0;
		while (it.hasNext()) {
			Entry<T, Integer> e= it.next();
			int val = e.getValue();
			if (val > 0) {
				som += val;
				continue;
			}
			return false;
		}
		if (som == size())
			return true;
		
		return false;
		
	}
}
