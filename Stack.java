	// TODO: Auto-generated Javadoc
/**
 *  * The stack class contains several variables and methods that are needed
 * to create and perform operations on a given
 * stack 
 * The goal for this stack class is to create
 * a stack of Country Objects using an array from which a user can choose to 
 * push, pop, and display the contents of the stack.
 * 
 * @author Aditya Aaron Koul
 * @version October 26th 2023
	 * The Class Stack.
	 */
	public class Stack {
		
		/** The head. */
		//local declarations
		private Link head;
		
		/** The tail. */
		private Link tail;
		
		/**
		 * Instantiates a new stack.
		 */
		public Stack() { 
			this.head = null;
			this.tail = null;
		}
		
		/**
		 * Checks if is empty.
		 *
		 * @return true, if is empty
		 */
		public boolean isEmpty() {
			//boolean bool = false;
			 return head == null;
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
		 * Push.
		 *
		 * @param Ctry the ctry
		 */
		public void push(Country Ctry) {
			Link nLink = new Link(Ctry);
    		if(isEmpty()) {
    			head = tail = nLink;		
    		} else {
    		nLink.next = head;
    		head = nLink;
    	}
		}
		
		/**
		 * Pop.
		 *
		 * @return the country
		 */
		public Country pop() {
	        if (isEmpty()) {
	            return null;
	        }
	        Country pc = head.newctry;
	        if (head == tail) {
	            head = tail = null;
	        } else {
	            head = head.next;
	        }
	        return pc;
	    }
		
		
		/**
		 * Insert last.
		 *
		 * @param newctry the newctry
		 */
		public void insertLast(Country newctry) {
		    Link newLink = new Link(newctry);
		    if (isEmpty()) {
		    	head = newLink;
		    	//head = tail = newLink;
		    } else {
		    	tail.next = newLink;
		        
		    }
	        tail = newLink;

		}
		
		/**
		 * Display link.
		 */
		public void displayLink() {
			Link present = head;
			while(present != null) {
				present.displayLink();
				present = present.next;
			}
			System.out.println();
		}
		
		/**
		 * Prints the Stack recursively.
		 *
		 * @param current the current
		 */
		public void printRecursive(Link current) {
			if(current == null) {
					return;
				}
		
			else {
				current.displayLink();
				printRecursive(current.next);
			}
		}
	}
		