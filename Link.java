
	// TODO: Auto-generated Javadoc
/**
 * @author Aditya Aaron Koul
 * @version October 26th 2023
	 * The Class Link.
	 */
	public class Link {
	
	/** The newctry. */
	public Country newctry;
	
	/** The next. */
	Link next;
	
	/** The previous. */
	Link previous;
	
	/**
	 * Instantiates a new link.
	 *
	 * @param ctry the ctry
	 */
	//this method is the constructor to create the link object 
	public Link(Country ctry) { 
				newctry = ctry;
				next = null;
				previous= null;
			}

	/**
	 * Display link.
	 */
	public void displayLink() {

	newctry.printCountryReport();
			}
	}
	