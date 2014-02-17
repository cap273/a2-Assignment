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
		v.append(1);
		v.append(2);
		v.append(3);
		assertEquals("[1, 2, 3]", v.toString());
		assertEquals("[3, 2, 1]", v.toStringReverse());
		assertEquals(3, v.size());
		
		/* Test prepend method */
		v.prepend(0);
		assertEquals("[0, 1, 2, 3]", v.toString());
		assertEquals("[3, 2, 1, 0]", v.toStringReverse());
		assertEquals(4, v.size());
		v.prepend(-1);
		assertEquals("[-1, 0, 1, 2, 3]", v.toString());
		assertEquals("[3, 2, 1, 0, -1]", v.toStringReverse());
		assertEquals(5, v.size());
		
		/* Test insertBefore method */
		CircularLinkedList<Integer>.Node testNode1= v.getLast().predecessor(); // Get second to last Node
		v.insertBefore(5, testNode1);
		assertEquals("[-1, 0, 1, 5, 2, 3]", v.toString());
		assertEquals("[3, 2, 5, 1, 0, -1]", v.toStringReverse());
		assertEquals(6, v.size());
		v.insertBefore(4, v.getFirst()); // insert before first node
		assertEquals("[-1, 0, 1, 5, 2, 3, 4]", v.toString());
		assertEquals("[4, 3, 2, 5, 1, 0, -1]", v.toStringReverse());
		assertEquals(7, v.size());
		
		/* Test insertAfter method */
		CircularLinkedList<Integer>.Node testNode2= v.getLast().predecessor().predecessor();
		v.insertAfter(6, testNode2);
		assertEquals("[-1, 0, 1, 5, 2, 6, 3, 4]", v.toString());
		assertEquals("[4, 3, 6, 2, 5, 1, 0, -1]", v.toStringReverse());
		assertEquals(8, v.size());
		v.insertAfter(7, v.getLast()); // Insert after last node.
		assertEquals("[-1, 0, 1, 5, 2, 6, 3, 4, 7]", v.toString());
		assertEquals("[7, 4, 3, 6, 2, 5, 1, 0, -1]", v.toStringReverse());
		assertEquals(9, v.size());
		
		/* Test remove method */
		CircularLinkedList<Integer>.Node testNode3= v.getLast().predecessor().predecessor();
		v.remove(testNode3);
		assertEquals("[-1, 0, 1, 5, 2, 6, 4, 7]", v.toString());
		assertEquals("[7, 4, 6, 2, 5, 1, 0, -1]", v.toStringReverse());
		assertEquals(8, v.size());
		v.remove(v.getFirst()); // remove head node
		assertEquals("[0, 1, 5, 2, 6, 4, 7]", v.toString());
		assertEquals("[7, 4, 6, 2, 5, 1, 0]", v.toStringReverse());
		assertEquals(7, v.size());
		w.remove(w.getFirst()); // remove only node in list
		assertEquals("[]", w.toString());
		assertEquals("[]", w.toStringReverse());
		assertEquals(0, w.size());
	}

}
