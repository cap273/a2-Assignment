/* Time spent on a2:  hh hours and mm minutes.
 * Name:
 * Netid: 
 * What I thought about this assignment:
 *
 *
 */

/** An instance is a circular doubly linked list. */
public class CircularLinkedList<E> {
    private Node head; // a node of linked list (null if none)
    private int size;  // Number of nodes in linked list.

    /** Constructor: an empty linked list. */
    public CircularLinkedList() {
    }

    /** Return the number of values in this list. */
    public int size() {
        return size;
    }

    /** Return the first node of the list (null if the list is empty). */
    public Node getFirst() {
        return head;
    }

    /** Return the last node of the list (null if the list is empty). */
    public Node getLast() {
        if (head == null)
            return null;
        return head.pred;
    }

    /** If this circular list is empty, return null.
     *  Otherwise, move down the list in circular fashion, so that the
     *  first node becomes the last node, the second becomes the first, ec. */
    public Node moveDown() {
        if (head != null) {
            head= head.succ;
        }
        return head;
    }

    /** Return the value of node e of this list.
     * Precondition: e must be a node of this list; it may not be null. */
    public E valueOf(Node e) {
        assert e != null;
        return e.value;
    }

    /** Return a representation of this list: its values, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * 
     * E.g. for the list containing 6 3 8 in that order, the result it "[6, 3, 8]". */
    public String toString() {
        /* Note: This method should NOT refer to field size. It refers to
         * field head and all the succ fields of the nodes. Reason: It allows
         * toString to be used in testing head and all the succ fields. */
    	
    	// Return empty brackets if list is empty
    	if (getFirst() == null) {
    		return "[]";
    	}
    	
    	Node thisNode= getFirst(); // get pointer to head node
    	String listString= "[" + thisNode.getValue(); // add value of head node to String output
    	
    	// Loop through linked list until it circles back to head node.
    	while (thisNode.successor() != getFirst()) {
    		// Move node to be examined down the list
    		thisNode= thisNode.successor();
    		
    		// Progressively append to listString
    		listString += ", " + thisNode.getValue();
    	}
    	
    	// When while loop ends, close off listString with brackets and return.
    	return listString + "]";

    }

    /** Return a representation of this list: its values in reverse, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * 
     * E.g. for the list containing 6 3 8 in that order, the result it "[8, 3, 6]".*/
    public String toStringReverse() {
        /* Note: This method should NOT refer to field size. It refers to
         * field head and all the pred fields of the nodes. Reason: It allows
         * toStringReverse to be used in testing head and all the pred fields. */
    	
    	// Return empty brackets if list is empty
    	if (getLast() == null) {
    		return "[]";
    	}
    	
    	Node thisNode= getLast(); // get pointer to predecessor of head node (last node)
    	String listString= "[" + thisNode.getValue(); // add value of last node to String output
    	
    	// Loop through linked list until it circles back to last node.
    	while (thisNode.predecessor() != getLast()) {
    		// Move node to be examined down the list
    		thisNode= thisNode.predecessor();
    		
    		// Progressively append to listString
    		listString += ", " + thisNode.getValue();
    	}
    	
    	// When while loop ends, close off listString with brackets and return.
    	return listString + "]";
    	
    }

    /** Append value v to the list. */
    public void append(E v) {
        /* Note: this method views the list as a list with a first and
         * a last value. It adds a new value at the end, not changing any
         * others. */
    	
    	// Create node to be appended.
    	Node newNode= new Node(null, v, null);
    	
    	/* If list is originally empty, newNode becomes the list head and its own  
    	 * successor and predecessor */
        if (getLast() == null) {
        	head= newNode;
        	newNode.pred= newNode;
        	newNode.succ= newNode;
        			
        } 
        /* Otherwise, append newNode to list */
        else {
        	newNode.pred= getLast(); //predecessor of newNode becomes previous last node
        	newNode.succ= getFirst(); //successor of newNode becomes list head
        	getLast().succ= newNode; //successor of previous last node becomes newNode
        	getFirst().pred= newNode; //predecessor of list head becomes newNode
        	
        }
        
        size += 1; // Increase number of nodes count of list by 1.
        
    }

    /** Prepend value v to the list. */
    public void prepend(E v) {
        /* Note: this method views the list as a list with a first and
         * a last value. It adds a new value at the beginning, so head
         * should end up pointing to the new node. */

    	// Create node to be appended.
    	Node newNode= new Node(null, v, null);
    	
    	/* If list is originally empty, newNode becomes the list head and its own  
    	 * successor and predecessor */
        if (getFirst() == null) {
        	head= newNode;
        	newNode.pred= newNode;
        	newNode.succ= newNode;
        			
        } 
        /* Otherwise, prepend newNode to list */
        else {
        	/* Change pred and succ fields in newNode */
        	newNode.succ= getFirst(); //successor of newNode becomes previous first node
        	newNode.pred= getLast(); //predecessor of newNode becomes last node
        	
        	/* Change succ field in last node and pred field in previous first node.
        	 * Note that the order in which this is done is important. If the pred field
        	 * of previous first node is changed first to newNode, calling getLast() will 
        	 * return newNode instead of the last node.
        	 */
        	getLast().succ= newNode; //successor of last node becomes newNode
        	getFirst().pred= newNode; //predecessor of previous first node becomes newNode
        	
        	/* update list head to newNode */
        	head= newNode;
        	
        }
        
        size += 1; // Increase number of nodes count of list by 1.
    }

    /** Insert value v in a new node before node e of this circular list.
     * Precondition: e must be a node of this list, i.e. it may not be null. */
    public void insertBefore(E v, Node e) {
        /* Note: This method views the list as a circular list, so it doesn't
         * really matter which node head points to when the method is done.
         * However, we require that head does not change. */

        // Write this method and delete this comment
    }

    /** Insert value v in a new node after node e.
     * Precondition: e must be a node of this list, i.e. it may not be null. */
    public void insertAfter(E v, Node e) {
        /* Note: This method views the list as a circular list, so it doesn't
         * really matter which node head points to when the method is done.
         * However, we require that head does not change. */

        // Write this method and delete this comment
    }

    /** Remove node e from this list.
     *  Precondition: e must be a node of this list, i.e. it may not be null. */
    public void remove(Node e) {
        assert e != null;
        /* Note: if the head (first) node is being removed and size >= 2, head
         * should end up pointing at head's successor. */

        // Write this method and delete this comment
    } 



    /*********************/

    /** An instance is a node of this list. */
    public class Node {
        /** Predecessor of this node on the list (null if the list is empty). */
        private Node pred;

        /** The value of this element. */
        private E value; 

        /** Successor of this node on the list. (null if the list is empty). */
        private Node succ; 

        /** Constructor: an instance with predecessor p (p can be null),
         * successor s (s can be null), and value v. */
        private Node(Node p, E v, Node s) {
            pred= p;
            value= v;
            succ= s;
        }

        /** Return the value of this node. */
        public E getValue() {
            return value;
        }

        /** Return the predecessor of this node e in the list. */
        public Node predecessor() {
            return pred;
        }

        /** Return the successor of this node in this list. */
        public Node successor() {
            return succ;
        }
    }

}