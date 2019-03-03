/**
 * 
 */
package pobj.tme5.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pobj.tme5.HashMultiSet;
import pobj.tme5.MultiSet;
import pobj.tme5.MultiSetDecorator;

/**
 * @author LAOUER Walid
 *
 */
public class HashMultiSetDecoratorTest {

MultiSet<String> m;
	
	@Before 
	public void createMultiSet() {
		MultiSet<String> n = new HashMultiSet<String>();
		m = new MultiSetDecorator<String>(n);
	}
	
	@Test 
	public void testAdd1() {
		m.add("a");
		m.add("a",5);
		assertEquals(6, m.count("a"));
	}

	@Test(expected = IllegalArgumentException.class) 
	public void testAdd2() {
		m.add("a");
		m.add("a",-1);
	}
	
	
	@Test
	public void testAdd3() {
		m.add("a", 0);
		assertEquals(m.count("a"), 0);
		m.add("a");
		assertEquals(m.count("a"), 1);
	}
	
	@Test
	public void testRemove1() {
		m.add("a", 11);
		m.remove("a");
		m.remove("a", 3);
		assertEquals(m.count("a"), 7);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void TestRemove2()  {
		m.add("a", 1);
		m.remove("a",-1);
		assertEquals(m.count("a"), 1);
	}
	
	public void TestRemove4()  {
		m.add("a", 1);
		m.remove("a", 0);
		assertEquals(m.count("a"), 1);
	}
	
	@Test
	public void TestCount() {
		assertEquals(m.count("a"), 0);
	}
	
	@Test
	public void TestAddRemove1() {
		m.add("a", 20);
		m.add("b", 30);
		assertEquals(m.size(), 50);
		m.remove("b", 5);
		assertEquals(m.count("b"), 25);
		m.remove("a", 3);
		assertEquals(m.size(), 42);
	}
	
	@Test
	public void TestAddRemove2()   {
		m.add("a", 10);
		m.remove("a", 10);
		assertEquals(m.count("a"), 0);
	}
	
	
	
	@Test
	public void TestSize()   {
		m.add("a", 15);
		m.remove("a");
		assertEquals(m.size(), 14);
	}
	
	@Test
	public void TestClear()   {
		m.add("a", 13);
		m.remove("a");
		m.clear();
		assertEquals(m.count("a"), 0);
		
	}
	
	@Test
	public void TestToString() {
		m.add("a", 11);
		m.add("b", 22);
		m.add("c", 33);
		assertEquals(m.toString(), "[a:11; b:22; c:33]");
	}
	
	

	
}

