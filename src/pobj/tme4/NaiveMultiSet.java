/**
 * 
 */
package pobj.tme4;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author LAOUER Walid
 * @param <T>
 *
 */
public class NaiveMultiSet<T> extends AbstractCollection<T> implements MultiSet<T>{
	private List<T> list;

	public NaiveMultiSet() {
		list = new ArrayList<T>();
	}

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new NaiveMultiSetIterator();
	}

	/* (non-Javadoc)
	 * @see pobj.tme4.MultiSet#add(java.lang.Object, int)
	 */
	@Override
	public boolean add(T e, int count) {
		if (count == 0) { return false; }
		for (int i=0; i<count; i++) {
			list.add(e);
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see pobj.tme4.MultiSet#add(java.lang.Object)
	 */
	@Override
	public boolean add(T e) {
		list.add(e);
		return true;
	}

	/* (non-Javadoc)
	 * @see pobj.tme4.MultiSet#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object e) {
		T e1 = (T) e;
		if (count(e1) != 0) {
			for (int i=0; i<list.size(); i++) {
				if (list.get(i).equals(e)) {
					list.remove(i);
					break;
				}
			}
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see pobj.tme4.MultiSet#remove(java.lang.Object, int)
	 */
	@Override
	public boolean remove(Object e, int count) {
		T e1 = (T) e;
		if ((count(e1) != 0) && (count != 0) && (count(e1) >= count)) {
			for (int i=0; i<list.size(); i++) {
				if (count != 0) {
					if (list.get(i).equals(e)) {
						list.remove(i);
						count--;
					}
				} else {
					break;
				}
			}
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see pobj.tme4.MultiSet#count(java.lang.Object)
	 */
	@Override
	public int count(T o) {
		int cpt = 0;
		for (T e : list) {
			if (e.equals(o)) {
				cpt++;
			}
		}
		return cpt;
	}

	/* (non-Javadoc)
	 * @see pobj.tme4.MultiSet#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		list.clear();
	}

	/* (non-Javadoc)
	 * @see pobj.tme4.MultiSet#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();

	}

	/* (non-Javadoc)
	 * @see pobj.tme4.MultiSet#elements()
	 */
	@Override
	public List<T> elements() {
		Set<T> s = new HashSet<>(list);
		List<T> elements = new ArrayList<T>(s);
		return elements;
	}
	
	private class NaiveMultiSetIterator implements Iterator<T> {
		private int i = 0;

		@Override
		public boolean hasNext() {
			return i < size();
		}

		@Override
		public T next() {
			return list.get(i++);
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		} 

	}

}
