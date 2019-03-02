package pobj.tme5;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.AbstractCollection;

public class MultiSetDecorator<T> extends AbstractCollection<T> implements MultiSet<T> {

	MultiSet<T> decorator;

	public MultiSetDecorator(MultiSet<T> decorator) {
		this.decorator = decorator;
	}
	
	public boolean isConsistent() {
		List<T> elem = elements();
		int som = 0;
		for(T e : elem) {
			int val = count(e);
			if (val <= 0) {
				return false;
			}
			som += val;
		}
		
		if (som == size())
			return true;
		
		return false;
		
	}
	
	public boolean add(T e, int count) {
		boolean r = decorator.add(e, count);
		assert isConsistent();
		return r;
	}

	public boolean add(T e) {
		boolean r = decorator.add(e);
		assert isConsistent();
		return r;
	}

	public boolean remove(Object e) {
		boolean r = decorator.remove(e);
		assert isConsistent();
		return r;
	}

	public boolean remove(Object e, int count) {
		boolean r = decorator.remove(e, count);
		assert isConsistent();
		return r;
	}

	public int count(T o) {
		return decorator.count(o);
	}

	public void clear() {
		decorator.clear();
	}

	public int size() {
		return decorator.size();
	}

	public List<T> elements() {
		return decorator.elements();
	}
	
	public boolean isEmpty() {
		return decorator.isEmpty();
	}

	public boolean contains(Object o) {
		return decorator.contains(o);
	}

	public Iterator<T> iterator() {
		return decorator.iterator();
	}
	
	public boolean containsAll(Collection<?> c) {
		return decorator.containsAll(c);
	}

	public boolean addAll(Collection<? extends T> c) {
		return decorator.addAll(c);
	}

	public boolean removeAll(Collection<?> c) {
		return decorator.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return decorator.retainAll(c);
	}

	public boolean equals(Object o) {
		return decorator.equals(o);
	}

	public int hashCode() {
		return decorator.hashCode();
	}
	
	public String toString() {
		return decorator.toString();
	}
	
	
}