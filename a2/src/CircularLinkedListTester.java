import static org.junit.Assert.*;

import org.junit.Test;


public class CircularLinkedListTester {

	@Test
	public void testConstructor() {
		/* First test toString and toStringReverse methods on empty list. */
		CircularLinkedList<Integer> v= new CircularLinkedList<Integer>(); // create empty list
		assertEquals("[]", v.toString());
		assertEquals("[]", v.toStringReverse());
		assertEquals(0, v.size());
		
		/* Create a list of Strings and test */
		CircularLinkedList<String> w= new CircularLinkedList<String>();
		w.prepend("Hello ");
		assertEquals("[Hello ]", w.toString());
		assertEquals("[Hello ]", w.toStringReverse());
		assertEquals(1, w.size());
		
		
		/* Test append method */
		v.append(2);
		v.append(4);
		v.append(6);
		assertEquals("[2, 4, 6]", v.toString());
		assertEquals("[6, 4, 2]", v.toStringReverse());
		assertEquals(3, v.size());
		/* Test prepend method */
		v.prepend(65);
		assertEquals("[65, 2, 4, 6]", v.toString());
		assertEquals("[6, 4, 2, 65]", v.toStringReverse());
		assertEquals(4, v.size());
		v.prepend(97);
		assertEquals("[97, 65, 2, 4, 6]", v.toString());
		assertEquals("[6, 4, 2, 65, 97]", v.toStringReverse());
		assertEquals(5, v.size());
		
		
	}

}
