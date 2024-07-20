				 
				
				/** 
				* COP 3530: Project 5 HashTables  
				*This Project 5 program handles several tasks such as parsing the countries5.csv file, populating the HashTable  
				*and the user-defined menu 
				* 
				* @author Aditya Aaron Koul 
				* @version December 5th 2023 
				*/
				//Imports
				import java.io.*;
				import java.util.*;
				
				/**
				 * The Class Project5.
				 */
				//Project5 class start
				public class Project5 {
				
					/** The hash. */
					//Global declarations.
					static HashTables hash = new HashTables(257);
					
					/**
					 *  
					 * This method takes in an integer and performs all of the
					 * specified functions of the user-defined menu depending on the
					 * integer option the user entered.
					 *
					 * @param num the num
					 * @return Void - no return value
					 */
					@SuppressWarnings("unused")
					public static void menuOption(int num) {
						
						//Local decl
						String ccname = "";
						int numChoice = num;
						
						//Start switch 
						switch(numChoice) {
							
						
						//Print out the hash table
						case 1:
							System.out.println("\nHASH TABLE CONTENTS");
							System.out.println();
							System.out.println("INDEX   COUNTRY NAME \t\t       Population Density ");
							System.out.println("------------------------------------------------");
							hash.displayTable();
							break;
						
						//Delete a country from the hashtable
						case 2:
							Scanner deleteCountry = new Scanner(System.in);
							String cccname = "";
							
							System.out.print("Enter Country Name: ");
							cccname = deleteCountry.nextLine();
							
							System.out.println("The Searched Country has been deleted from the Hash Table.");
							
							try {
								hash.delete(cccname);
							} catch (Exception e) {
								System.out.println("Error: " + e);
								System.out.println("The Country that was entered is not a Country.");
							}
							break;
										
						//Insert a country into the hashtable
						case 3:
							Scanner insertcountry= new Scanner(System.in);
							String ctryname = "";
							long population = 0;
							long area = 0;
							
							System.out.println("Enter Country Name: ");
							ctryname = insertcountry.nextLine();
							System.out.println("Enter Country Population: ");
							population = insertcountry.nextLong();
							System.out.println("Enter Country Area: ");
							area = insertcountry.nextLong();
							
							hash.insert(ctryname, population, area);
							System.out.println("The user-defined country is inserted into the hash table \n");
							break;
						
						//Find a country and return the population density value and array index of the country that the user searched for
						case 4:
							Scanner findcountry = new Scanner(System.in);
							String country = "";
							
							System.out.print("Enter Country Name: ");
							country = findcountry.nextLine();
							
							try {
								System.out.println("\nCOUNTRY NAME \t\t       Population Density ");
								System.out.println("----------------------------------------");
								System.out.println("\nThe searched country is found at index: " + hash.find(country));
							} catch(Exception e) {
								System.out.println("\nError: " + e);
								System.out.println("Country may not exist in the hash table. Please try again.");
							}
							break;
						
						//Print the number of empty and collided cells from the hashtable	
						case 5: 
							hash.printEmptyAndCollidedCells();
							break;
						
						
						
						//Exit the program
						case 6:
							System.out.println("Have a Good Day.");
							break;
							
						//Default case	
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
					@SuppressWarnings({ "resource", "unused" })
					
					public static void main(String[] Args) {
					    System.out.print("Enter the file name: ");
		
					    // Enter file name
					    Scanner infile = new Scanner(System.in);
					    String filename = infile.nextLine();
					    FileReader fileRead = null;
					    Scanner reader = null;
					    String[] c = null;
		
					    // Parsing CSV file
					    Country[] countryarray = null;
					    try {
					        fileRead = new FileReader(filename);
					        reader = new Scanner(fileRead);
					        c = reader.nextLine().split(",");
		
					        int y = 0;
					        ArrayList<Country> countryarraylist = new ArrayList<>(); // Create an ArrayList object
		
					        while (reader.hasNextLine()) {
					            // Reading and storing data values into the Country objects
					            c = reader.nextLine().split(",");
					            // Populating the HashTable with the country objects
					            String CountryName = c[0];
					            String CapitolCity = c[1];
					            long Population = Long.parseLong(c[2]);
					            double GDPPC = Double.parseDouble(c[3]);
					            long countryarea = Long.parseLong(c[4]);
					            double HappinessIndex = Double.parseDouble(c[5]);
					            long populationdensity = countryarea / Population * 100000;
					            double APC = countryarea;
					            Country testcountry = new Country(CountryName, CapitolCity, Population, GDPPC, APC,HappinessIndex);
					            countryarraylist.add(testcountry);
					            y++;
					            countryarray = countryarraylist.toArray(new Country[0]);
					            try {
					                hash.insert(CountryName, Population, countryarea);
		
					            } catch (Exception e) {
					                e.printStackTrace();
					            }
		
					        }
					        fileRead.close();
					        //read user input for the user-defined menu
					        Scanner numReader = new Scanner(System.in);
					        int numChoice = 0;
					        while (numChoice != 6) {
		
					            // Print out the user-defined menu
					            System.out.println("\n\n - Countries 5 CSV Operations Menu - \n"
					                    + "\n"
					                    + "1) Print Hash Table \n"
					                    + "2) Delete a Country \n"
					                    + "3) Insert a Country \n"
					                    + "4) Search and print a country and its population density for a given name\n"
					                    + "5) Print Number of Empty & Collided Cells \n"
					                    + "6) Exit");
		
					            System.out.print("\n" + "Enter menu selection: ");
					            
					            try {
					                int mynum = numReader.nextInt();
					                menuOption(mynum);
					            } catch (Exception e) {
					                System.out.println("\nError: " + e);
					                
					                e.printStackTrace();
		
					            } finally {
					                // System.out.println("Error: invalid input. Please try again from the menu start.");
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