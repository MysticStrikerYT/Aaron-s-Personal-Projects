
		/** 
		* COP 3530: Project 4 Binary Search Trees  
		* <p> 
		*This project 3 program handles several tasks such as parsing the countries3.csv file, populaitng the BinarySearchTree 
		*and the user-defined menu 
		* 
		* @author Aditya Aaron Koul 
		* @version November 16th 2023 
		*/
		
		//Imports
		import java.io.File;
		import java.io.FileReader;
		import java.io.IOException;
		import java.util.*;
		
			
		/**
		 * The Class Project4.
		 */
		//Class start
		@SuppressWarnings("unused")
		public class Project4 {
			
			/** The tree. */
			//BST Declaration
			static BinarySearchTree tree = new BinarySearchTree();
			
			
			/**
			 *  
			 * This method takes in an integer and performs any of the
			 * specified functions of this program depending on the
			 * user input integer.
			 *
			 * @param numSel the num sel
			 * @return Void - no return value
			 */
			public static void menuSelection(int numSel) {
				
				//Local decl
				String ctryname = "";
				int numChoice = numSel;
				
				switch(numChoice) {
				
				//Countries List in-order
				case 1:
					System.out.print("\n"
							+ "--PRINTING COUNTRIES: IN-ORDER--"
							+ "\n"
							+ "COUNTRY                                                 HappinessIndex"
							+ "\n--------------------------------------------------------------------------\n");
					tree.printInorder(tree.root);
					break;
					
				//Countries list pre-order	
				case 2:
					System.out.print("\n"
							+ "--PRINTING COUNTRIES:  PRE-ORDER--"
							+ "\n"
							+ "COUNTRY                                                 HappinessIndex"
							+ "\n--------------------------------------------------------------------------\n");
					tree.printPreorder(tree.root);
					break;
					
				//Countries list post-order	
				case 3:
					System.out.print("\n"
							+ "--PRINTING COUNTRIES: POST-ORDER--"
							+ "\n"
							+ "COUNTRY                                                 HappinessIndex"
							+ "\n--------------------------------------------------------------------------\n");
					tree.printPostorder(tree.root);
					break;
					
					//Country insertion
				case 4:
				    Scanner myScan = new Scanner(System.in);
				    System.out.print("\nEnter Country Name: ");
				    String countryname = myScan.nextLine();
				    System.out.print("\nEnter Country HappinessIndex: ");
				    double happinessIndex = myScan.nextDouble();

				    // Create a Country object with the provided data
				    Country country = new Country(countryname, happinessIndex);

				    // Call the insert method with the Country object
				    tree.insert(country, happinessIndex);

				    System.out.println(countryname + " with happiness index value of " + happinessIndex + " is inserted.\n");
				    break;
								
								
				//Country deletion	
				case 5:
					Scanner theScan = new Scanner(System.in);
					System.out.print("\nEnter Country Name for Deletion: ");
					ctryname = theScan.next();
					System.out.println(ctryname);
					
					tree.delete(ctryname);
					
					System.out.println("Country has been deleted from the Binary Search Tree.");
					
					break;
					
				//Country search	
				case 6:
					Scanner ctryreader = new Scanner(System.in);
					System.out.print("\nEnter Country Name to Search: ");
					 countryname = ctryreader.nextLine();
					
					tree.find(ctryname, countryname);
					System.out.println("Country is not found");

					break;
				
					
				case 7:
				    System.out.println("Enter the number of countries:");
				    Scanner bottomScanner = new Scanner(System.in);
				    int c = bottomScanner.nextInt();
				    Country[] countryarray = new Country[c]; // Assuming you want to store the bottom c countries
				    System.out.println("Bottom 5 countries regarding happiness:\r\n"
				    		+ "");
				    System.out.println("Name                                   Happiness\r\n"
				    		+ "");
				    System.out.println("--------------------------------------------------\r\n"
				    		+ "");
				    // Call the recursive printBottomCountries method with the created array and root as the starting point
				    tree.printBottomCountries(c, countryarray, 0, tree.getRoot());

				    // Print the information of the bottom countries in ascending order
				    for (int i = 0; i < c && countryarray[i] != null; i++) {
				        Country Country = countryarray[i];
				        System.out.printf("%-35s\t\t%-10.3f\n", Country.getName(), Country.getHappinessIndex());
				    }
				    break;
				case 8:
				    System.out.println("Enter the number of countries:");
				    Scanner topscan = new Scanner(System.in);
				    int topcountry = topscan.nextInt();
				    Country[] topcountryarray = new Country[topcountry]; 
				    System.out.println("Top 5 countries regarding happiness:\r\n"
				    		+ "");
				    System.out.println("Name                                   Happiness\r\n"
				    		+ "");
				    System.out.println("--------------------------------------------------\r\n"
				    		+ "");

				    // Call the recursive printTopCountries method with the created array and root as the starting point
				    tree.printTopCountries(topcountry, topcountryarray, 0, tree.getRoot());

				    // Print the information of the top countries in descending order
				    for (int i = 0; i < topcountry && topcountryarray[i] != null; i++) {
				        Country Country = topcountryarray[i];
				        System.out.printf("%-35s\t\t%-10.3f\n", Country.getName(), Country.getHappinessIndex());
				    }
				    break;
				//Exit program	
				case 9:
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
			 * @param Args the arguments
			 * @return Void - no return value
			 */
			@SuppressWarnings("resource")
			public static void main(String[] Args) {
				
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
						//Populating the Binary Search Tree with the country objects 
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
					try {
						tree.insert(testcountry,HappinessIndex);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				fileRead.close();
				
				//Print the menu and get user input
				Scanner numReader = new Scanner(System.in);
				int numChoice = 0;
				while(numChoice != 9) {
		
					//Print menu
					System.out.println("\n\n - Countries 4 CSV Operations Menu - \n"
							+ "\n"
							+ "1) Print Tree Inorder \n"
							+ "2) Print Tree Preorder \n"
							+ "3) Print Tree Postorder \n"
							+ "4) Insert a Country with Name & HappinessIndex \n"
							+ "5) Delete a Country for a Given Name \n"
							+ "6) Search and Print a Country and its Path for a Given Name \n"
							+ "7) Print Bottom Countries Regarding HappinessIndex \n"
							+ "8) Print Top Countries Regarding HappinessIndex \n" 
							+ "9) Exit");
					
					System.out.print("\n" + "Enter menu selection: ");
					
	                try {
	                    int mynum = numReader.nextInt();
	                    menuSelection(mynum);
	                } catch (Exception e) {
	                    System.out.println("\nError: " + e);
	                } finally {
	                    //System.out.println("Error: invalid input. Please try again from the menu start.");
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (fileRead != null) {
	                try {
	                    fileRead.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (reader != null) {
	                reader.close();
	            }
	        }
	        infile.close();
	    }
	}
	
