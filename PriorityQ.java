// TODO: Auto-generated Javadoc
/**
 * @author Aditya Aaron Koul
 * @version October 26th 2023
 * The Class PriorityQ.
 */
//Start of PriorityQ Class
public class PriorityQ {
	
	/** The head. */
	private Link head;
	
	/** The tail. */
	@SuppressWarnings("unused")
	private Link tail;
	
	/** The n items. */
	int nItems = 0;

	/**
	 * Instantiates a new priority Q.
	 */
	public PriorityQ() {
		@SuppressWarnings("unused")
		Link head = null;
		@SuppressWarnings("unused")
		Link tail = null;
	}

	/**
	 * Gets the beginning.
	 *
	 * @return the beginning
	 */
	public Link getBeginning() {
		return head;
	}

	/**
	 * Insert.
	 *
	 * @param ctry the ctry
	 */
	public void insert(Country ctry) {
	    Link newLink = new Link(ctry);
	    
	    if(isEmpty()) {
	        head = newLink;
	        tail = newLink;
	        return;
	    }
	    
	    Link current = head;
	    Link previous = null;
	    
	    while(current != null && newLink.newctry.getHappinessIndex() < current.newctry.getHappinessIndex()) {
	        previous = current;
	        current = current.next;
	    }
	    
	    if(previous == null) { // At the start
	        newLink.next = head;
	        head.previous = newLink;
	        head = newLink;
	    } else if(current == null) { // At the end
	        tail.next = newLink;
	        newLink.previous = tail;
	        tail = newLink;
	    } else { // In the middle
	        previous.next = newLink;
	        newLink.previous = previous;
	        newLink.next = current;
	        current.previous = newLink;
	    }
	}
		
		/**
		 * Removes the country object link at the top of the priorityqueue.
		 *
		 * @return the country
		 */
		public Country remove() {
		if (isEmpty()) {
			return null;
		}
		Country tc = head.newctry;
		head = head.next;
		if (head != null) {
			head.previous = null;
		} else {
			tail = null;
		}
		return tc;
	}


		/**
		 * Interval delete.
		 */
		public void IntervalDelete() {
		    float lowerBound = 5.5f;
		    float upperBound = 6.0f;

		    Link current = head;
		    while (current != null) {
		        if (current.newctry.getHappinessIndex() >= lowerBound && current.newctry.getHappinessIndex() <= upperBound) {
		            current = deleteLink(current); // delete and get the next link
		        } else {
		            current = current.next;
		        }
		    }
		}
		
		/**
		 * Prints the Priority Queue recursively.
		 *
		 * @param present the present
		 */
		public void printRecursive(Link present) {
		if(present == null) {
			return;
		}
		else {
			present.displayLink();
			printRecursive(present.next);
		}
	}



	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty() {
		return (head == null);
	}


	/**
	 * Delete link.
	 *
	 * @param current the current
	 * @return the link
	 */
	public Link deleteLink(Link current) {
	    if (current == head) { // if it's the first item
	        if (head.next != null) {
	            head.next.previous = null; // next item's previous set to null
	        }
	        head = current.next; // move the head to next item
	    } else { // if it's not the first item
	        current.previous.next = current.next; // old previous's next points to current's next
	        if (current.next != null) { // if there's a next item
	            current.next.previous = current.previous; // next item's previous points to current's previous
	        }
	    }
	    
	    if (current == tail) { // if it's the last item
	        tail = current.previous; // move the tail to previous item
	        if (tail != null) { 
	            tail.next = null; // set tail's next to null
	        }
	    }

	    return current.next; // Return the next link after the deleted one
	}
}