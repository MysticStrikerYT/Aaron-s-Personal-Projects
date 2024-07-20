	//Imports
	import java.util.*;
	import java.io.*;
	// TODO: Auto-generated Javadoc
		
		/**
		 * The Class Project2.
		 * 
		 * @author Aditya Aaron Koul
		 * @version October 4th 2023 
		 */
		public class Project2 {
	
	
		/** The my stack. */
		//Global declarations
		 static Stack myStack;
		 
	 	/** The priority Q. */
	 	static PriorityQ thePriorityQ;
	
		//Menu select method
		/**
		 * the Menu Select method handles all the user inputs for the menu 
		 * @param numSel 
		 * @param StackArray
		 */
		public static void menuSelection(int numSel, Country [] StackArray) {
			
			//user menu choice for switch case statements
			int numChoice = numSel;
			
			//Local Declarations for country objects 
			String CountryName = "";
			String CapitolCity = "";
			double Population = 0;
			double GDP = 0;
			double Area = 0;
			double HappinessIndex = 0;
	
			switch(numChoice) {
			//print country stack
			case 1:
				System.out.println("Display Stack Contents");
				System.out.println("Name                        CAPITOL          GDPPC       APC    HappinessIndex        ");
				System.out.println("---------------------------------------------------------------------------------------");
				myStack.PrintStack();
				break;
	
				//first check if the is empty or not 
				case 2:
					System.out.println();
					if(myStack.isEmpty()) {
						System.out.println("There's nothing to pop off the stack "
								+ "\n try inserting a country into the stack"
								+ "\n before attempting to pop another country from the stack again "
								);
	
					}
					//pop a country object off the stack 
					else {
						Country pc = null;
					 pc = myStack.pop(pc);
						if(pc != null) {
				           System.out.println(pc.getName() + " A Country has been popped from the stack");
	
						} else {
							System.out.println("Error occurred while popping the country from the stack.");				
							}
					System.out.println();
					break;
					}
				//push a country onto the stack
				case 3:
				Scanner myReader = new Scanner(System.in);
				//first check if the stack is full 
				if(myStack.isFull()) {
					System.out.println();
					System.out.println("The Stack is full, unable to push a country into it"
							+ "\n try popping a country off the stack"
							+ "before trying to push a country into the stack again");
					System.out.println();
				}
				else {
					// make the user input the data for the fields for the user-defined country object and then push it into the stack 
					try {
						System.out.print("Enter Name: ");
						CountryName = myReader.nextLine();
						System.out.print("Enter Capitol: ");
						CapitolCity = myReader.nextLine();
						System.out.print("Enter Population: ");
						Population  = myReader.nextDouble();
						System.out.println("Enter GDP: ");
						GDP = myReader.nextDouble();
						System.out.print("Enter Area: ");
						Area = myReader.nextDouble();
						System.out.println("Enter HappinessIndex: ");
						HappinessIndex = myReader.nextDouble();
						Country ctrypush = new Country(CountryName, CapitolCity,Population,GDP,Area, HappinessIndex);
						myStack.pushCountry(ctrypush);
						System.out.println("One country New Country is pushed onto Stack.\r\n");
					} catch (Exception e){
						System.out.println("Error: possible input mismatch User-Defined Country Object not pushed onto stack ");
						myReader.nextLine();
					}
	
				}
				break;
				
				case 4:
				//print priority queue
				System.out.println("Display Priority Queue Contents (Sorted by Happiness Index)");
				System.out.println("Name                           CAPITOL          GDPPC       APC    HappinessIndex        ");
				System.out.println("---------------------------------------------------------------------------------------");
				thePriorityQ.PrintQueue();
				break;
					
				case 5:
					// first check if the priority queue is empty 
					System.out.println();
					if(thePriorityQ.isEmpty()) {
						System.out.println("There's nothing to remove from the priority queue"
								+"\n try inserting a country into the priority queue"
								+ " before attempting to remove another country from it ");
						
						
					} else {
						// remove a country object from the PriorityQ 

						Country rc = thePriorityQ.Remove();
						
						if(rc != null) {
				            System.out.println("Removed " + rc.getName() + " from the priority queue.");
	
						} else {
				            System.out.println("Error occurred while removing the country from the priority queue.");
				            System.out.println();
						
					
						}
					}
					break;
						
					
	
				case 6:
				
				Scanner	MyReader = new Scanner(System.in);
					//Check to see if the PriorityQ is full 
					if(thePriorityQ.isFull()) {
						System.out.println();
						System.out.println("The PriorityQ is full unable to push a country into it"
								+ "try removing a country off the PriorityQ"
								+ "before trying to insert a country into it again");
						System.out.println();
					} else {
						// make the user input the data for the fields for the user-defined country object and then push it into the stack 
						try {
							System.out.print("Enter Name: ");
							CountryName = MyReader.nextLine();
							System.out.print("Enter Capitol: ");
							CapitolCity = MyReader.nextLine();
							System.out.print("Enter Population: ");
							Population  = MyReader.nextDouble();
							System.out.println("Enter GDP: ");
							GDP = MyReader.nextDouble();
							System.out.print("Enter Area: ");
							Area = MyReader.nextDouble();
							System.out.print("Enter Happiness Index: ");
							HappinessIndex = MyReader.nextDouble();
							Country ctry = new Country(CountryName,CapitolCity,Population, GDP, Area, HappinessIndex);				
							thePriorityQ.insert(ctry);
							System.out.println("One country Another Country is inserted onto priority queue.\r\n"
									+ "");
						} catch (Exception e){
							System.out.println("Error: possible input mismatch please try again");
						}
					}
					break;
	
					//Terminate program 
					case 7:
					System.out.println();
					System.out.println("Have a Good Day");
					break;
	
					default :
					System.out.println();
					System.out.println("Error Invalid Input Please Try Again");
					System.out.println();
				}
			}
	
		
		/**
		 * The main method.
		 *handles the reading and parsing of the CSV file and handles populating the Stack and PriorityQ with the country objects 
		 * @param args the arguments
		 * @throws FileNotFoundException the file not found exception if the file name entered is incorrect 
		 */
		public static void main (String [] args) throws FileNotFoundException {
	
			System.out.print("Enter the file name: ");  
	
			//Enter file name
			Scanner infile = new Scanner(System.in);
			String filename = infile.nextLine();
			FileReader fileRead = null;
			Scanner reader = null;
			String[] c = null;
			
			//Parsing CSV file
			Country[] countryarray = null;
				try {
				fileRead = new FileReader(filename);
				reader = new Scanner(fileRead); 
				c = reader.nextLine().split(",");
	
				int y = 0;
				ArrayList<Country> countryarraylist = new ArrayList<>(); // Create an ArrayList object
	
	
				while(reader.hasNextLine()) {
	
					//Reading and storing data values into the Country objects
					c = reader.nextLine().split(",");
					//Populating the Stack and PriorityQ of country objects 
					String Name= c[0];
					String CapitolCity = c[1];
					Double Population = Double.parseDouble(c[2]);
					double GDPPC = Double.parseDouble(c[3]);
					Double APC = Double.parseDouble(c[4]);
					double HappinessIndex = Double.parseDouble(c[5]);
					
					Country testcountry =  new Country(Name, CapitolCity, Population, GDPPC, APC, HappinessIndex); 
					countryarraylist.add(testcountry);
					y++;
					
				}
				countryarray = countryarraylist.toArray(new Country[0]);
				//creating the stack and PriorityQ with the size of the array 
				myStack = new Stack (129);
				thePriorityQ = new PriorityQ(129);
				//pushing and inserting the country objects into the Stack and PriorityQ
				for(int i = 0; i<128; i++) {
					myStack.pushCountry(countryarray[i]);
					thePriorityQ.insert(countryarray[i]);
	
				}
				
			} catch (Exception e) {
				System.out.println("\nError: " + e);
				}finally {
				
				try {
					
					fileRead.close();
					reader.close();
	
				}catch(Exception e){
					System.out.println("\nError: " + e);
				}
			}
	
	
			//Menu Start
			int numChoice = 0;
			while(numChoice != 7) {
	
				//print menu
				System.out.println("\n\n - Countries 2 CSV Operations Menu - \n");
				System.out.println("COP3530 Project 2\n");	
				System.out.println("Instructor: Xudong Liu\n");	
				System.out.println("Array Searches and Sorts\n");
				System.out.println("There were 128 records read");
				System.out.println(" 1) Print Stack\n"
						+ " 2) Pop a country object from stack \n"
						+ " 3) Push a country object onto stack  \n"
						+ " 4) Print Priority Queue \n"
						+ " 5) Remove a country object from priority queue \n"
						+ " 6) Insert a country object into priority queue \n"
						+ " 7) Terminate Program \n"); 
				System.out.println("Enter menu selection: \n");
				
	
				try {
					int mynum = infile.nextInt();
					menuSelection(mynum, countryarray);
				} catch (Exception e){
					System.out.println("Error: invalid input Please Try Again");
	
	
				}
			}
			infile.close();
		}	
	}
	
	
