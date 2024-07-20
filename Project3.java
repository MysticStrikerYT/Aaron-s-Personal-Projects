		
		
		/** 
		* COP 3530: Project 3 Linked Lists  
		*This project 3 program handles several tasks such as parsing the countries3.csv file, populaitng the stack and priority queue 
		*and the user-defined menu 
		* @author Aditya Aaron Koul 
		* @version October 26th 2023 
		*/
		
		
		import java.io.*;
		import java.util.*;
		
		// TODO: Auto-generated Javadoc
/**
		 * The Class Project3.
		 */
		public class Project3 {
		
			/** The first stack. */
			//Local Declarations
			static Stack firstStack = new Stack();
			
			/** The a stack. */
			static Stack aStack = new Stack();
			
			/** The my Q. */
			static PriorityQ myQ = new PriorityQ();
			
			/**
			 *  
			 * This method takes in an integer and performs any of the
			 * specified functions of this program depending on the
			 * user input integer.
			 *
			 * @param numsel the numsel
			 * @return Void - no return value
			 */
			
			@SuppressWarnings({ "unused", "resource" })
			public static void menuSelection(int numsel) {
				
				//Switch case statements for user menu choice 
				int numChoice = numsel;
				
				//Local decl. for country objects
				String CountryName = "";
				String CapitolCity = "";
				double Population = 0;
				double GDP = 0;
				double Area = 0;
				double HappinessIndex = 0;
				
				switch(numChoice) {
				
				//HappinessIndex Interval
				case 1:
					int count = 0;
					boolean flag = true;
					while(true){ 
						//Booleans for checking, will be used later 
						//boolean checkloop = false;
						boolean check = false;
						boolean check2 = false;

						//Loop through user inputs for HappinessIndex Interval

						Scanner myReader = new Scanner(System.in);
						String x = "";
						String y = "";
						float xint = 0;
						float yint = 0;
						
						System.out.print("\nPlease enter the interval for HappinessIndex (x and y).");
						System.out.print("\nFirst number (x): ");
						x = myReader.nextLine();
						System.out.print("\nSecond number (y): ");
						y = myReader.nextLine();
						
						try {
						
						xint = Float.parseFloat(x);	
						yint = Float.parseFloat(y);
						}
						catch(Exception e){
						System.out.println("Invalid input, please try again.");
						continue;
						}
						
						if( xint < yint) {
							System.out.println("Countries of priority queue with happiness values in [5.5,6] are deleted\r\n");
							myQ.IntervalDelete();
							break;
							
							
						}
						
						else {
							System.out.println("Error. First number must be no bigger than the second. Also both inputs"
									+ " are supposed to be numbers");
						}
						}
					//Print Priority Queue	
				case 2:
					System.out.println();
					System.out.println("Name                        CAPITOL          GDPPC       APC    HappinessIndex        ");
					System.out.println("---------------------------------------------------------------------------------------");
					myQ.printRecursive(myQ.getBeginning());

					break;
					
				//Quit program
				case 3:
					System.out.println();
					System.out.println("Have a Good Day.");
					break;
				
				//Default case that handles bad input
				default:
					System.out.println();
					System.out.println("Error: Invalid input, please try again.");
					System.out.println();
					
				}
			}
		
			/**
			 *  
			 * This is the main class. The class contains the menu where the user can 
			 * Enter the name of the file (with extension) and choose the desired operations. 
			 *
			 * @param args the arguments
			 * @return Void - no return value
			 */
			@SuppressWarnings({ "resource", "unused" })
			public static void main(String[] args) {
					
				System.out.print("Enter the file name: ");  
				
				//Enter file name
				Scanner infile = new Scanner(System.in);
				//String filename = "countries3.csv";
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
						countryarray = countryarraylist.toArray(new Country[0]);

						if(testcountry.getHappinessIndex()>=4)  {
							firstStack.push(testcountry);
							aStack.push(testcountry);
							
							y++;
						}

					} //end loop
					
					System.out.println("STACK CONTENTS OF COUNTRIES THAT FALL IN GOOD, VGOOD and EXCELLENT CATEGORIES:");
					System.out.println();
					System.out.println("Name                        CAPITOL          GDPPC       APC    HappinessIndex        ");
					System.out.println("---------------------------------------------------------------------------------------");
					aStack.printRecursive(aStack.getBeginning());					
					
					System.out.println();
					System.out.println();
					
					System.out.println("QUEUE CONTENTS OF COUNTRIES THAT FALL IN GOOD, VGOOD, and EXCELLENT CATEGORIES:");
					System.out.println();
					System.out.println("Name                        CAPITOL          GDPPC       APC    HappinessIndex        ");
					System.out.println("---------------------------------------------------------------------------------------");
					while(!firstStack.isEmpty()) {
						myQ.insert(firstStack.pop());
					}
					 
					myQ.printRecursive(myQ.getBeginning());
					
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
				while(numChoice != 3) {
		
					//print menu
					System.out.println("\n\n - Countries 3 CSV Operations Menu - \n");
					System.out.println("COP3530 Project 3\n");	
					System.out.println("Instructor: Xudong Liu\n");	
					System.out.println("Array Searches and Sorts\n");
					System.out.println("There were 128 records read");
					System.out.println(" 1) Enter a HappinessIndex interval for deletions on priority queue\n"
							+ " 2) Print Priority Queue \n"
							+ " 3) Terminate Program \n"); 
					System.out.println("Enter menu selection: \n");
					
		
					try {
						int mynum = infile.nextInt();
						menuSelection(mynum);
					} catch (Exception e){
						System.out.println("Error: invalid input Please Try Again from the menu start");
		
		
					}
				}
				infile.close();
			}	
		}
