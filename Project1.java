			/**
			*COP3530 Project 1 Array Searches and sorts

			*<p>
			*This project uses a CSV (comma separated values file) to accumulate
			data for a list of countries and sort them using a myriad of sorting methods
			, the methods sort the data based on the countries Name,Happinessindex, and GDP.<p>
			*<p>
			*The required input for the Project1 class are as follows:
			*The CSV file and menu input. From there, 
			*the program will parse the CSV file and 
			*sort the data through whatever sorting method
			*has been requested by the user.<p>
			* @author Aditya Aaron Koul (N01185590)
			* @version August 31 2023 
			*/
			
			//imports
			import java.io.*;
			import java.util.*;
			import java.io.BufferedReader;
			import java.io.File;
			import java.io.FileNotFoundException;
			import java.io.FileReader;
			import java.io.IOException;
			import java.io.Reader;
			import java.util.Scanner;
			//Class Start 
			@SuppressWarnings("unused")
			public class Project1 {
			
				//Global Declarations 
				static Country [] countryarray = new Country[129];
				/**
			 * This method sorts the names of the countries from the countries1.csv file using the insertion sort algorithm.
			 * <p>
			 * What's passed in is a country object array of all the countries from the CSV file. 
			 * <p>
			 * This method uses two loops a for loop to iterate through the entire array of country objects and then a while loop to compare the country name of the country
			 * object at index countryarray[inner] to the temporary variable littlecountry which is of type country
			<p>	
			 * and if they match the index variable [inner] 
			 * shifts 1 to the right in the array of country objects and then its inserted back into the array
			 * <p>
			 * Since this method is a void method 
			 * it doesn't return anything
			 * <p>
			 * @param Country[] countryarray - Country object array
			 * <p>
			 * @return void - no return value
			 * <p>
			 * @author Aditya Aaron Koul 
			 * <p>
			 * @version September 16 2023 
			 */

				//insertion sort algorithm for sorting countries by name 
				
				public static void SortCountryArraybyName(Country [] countryarray) {
						  int inner = countryarray.length;
						for(int outer = 1; outer<countryarray.length-1; outer++) {
						Country littlecountry = countryarray[outer];
						 inner = outer-1;
						 
						while(inner>=0 && countryarray[inner].getName().compareTo(littlecountry.getName()) > 0) {
							countryarray[inner+1] = countryarray[inner]; // shift item to right
							inner--;
								countryarray[inner+1] = littlecountry; // insert it back item

									
					}

							}
							}

				/**
			 * This method sorts the GDPPerCapita of the countries from the countries1.csv file using the bubble sort algorithm.
			 * <p>
			 * What's passed in is a country object array of all the countries from the CSV file. 
			 * <p>
			 * This method uses two for loops one to iterate through the entire array of country objects and the other for loop to compare the GDPPerCap of the country
			 * objects at indexes countryarray[inner] and countryarray[lowest]
				<p>	
			 * and if they match the index variable [lowest] 
			 * shifts 1 to the left in the array of country objects and then its inserted back into the array of country objects 
			 * <p>
			 * Since this method is a void method 
			 * it doesn't return anything
			 * <p>
			 * @param Country[] countryarray - Country object array
			 * <p>
			 * @return void - no return value
			 * <p>
			 * @author Aditya Aaron Koul 
			 * <p>
			 * @version September 16 2023 
			 */
		
			public static void sortCountryArraybyGDPPerCap(Country [] countryarray) {
				//Bubble sort algorithm for GDPPC sorting 
				for(int outer = 0; outer<countryarray.length-1; outer++) {
				int lowest = outer;
				Country littlecountry = null;
				int inner = countryarray.length;
				for(inner = outer+1; inner<countryarray.length-1; inner++) {
						if(countryarray[inner].getGDPperCap() < countryarray[lowest].getGDPperCap()) {
							lowest = inner;
			}

					}
					if(lowest != outer) {
						littlecountry = countryarray[lowest];
						countryarray[lowest] = countryarray[outer];
						countryarray[outer] = littlecountry;
					}
				
				}

		}
			/**
		 * This method sorts the HappinessIndex of the countries from the countries1.csv file using the selection sort algorithm.
		 * <p>
		 * What's passed in is a country object array of all the countries from the CSV file. 
		 * <p>
		 * This method uses two for loops one to iterate through the entire array of country objects and the other for loop to compare the HappinessIndex of the country
		 * objects at indexes countryarray[inner] and countryarray[lowest]
			<p>	
		 * and if they match the index variable [lowest] 
		 * shifts 1 to the left in the array of country objects and then its inserted back into the array of country objects 
		 * <p>
		 * Since this method is a void method 
		 * it doesn't return anything
		 * <p>
		 * @param Country[] countryarray - Country object array
		 * <p>
		 * @return void - no return value
		 * <p>
		 * @author Aditya Aaron Koul 
		 * <p>
		 * @version September 16 2023 
		 */

			public static void sortCountryArraybyHappinessIndex(Country [] countryarray) {
				
				//selection sort algorithm for happiness index sorting
						for(int outer = 0; outer<countryarray.length-1; outer++) {
						int lowest = outer;
						Country littlecountry = null;
						int inner = countryarray.length;
						for( inner = outer+1; inner<countryarray.length-1; inner++) {
								if(countryarray[inner].getHappinessIndex() < countryarray[lowest].getHappinessIndex()) {
									lowest = inner;
					}

							}
							if(lowest != outer) {
								littlecountry = countryarray[lowest];
								countryarray[lowest] = countryarray[outer];
								countryarray[outer] = littlecountry;
							}
						
						}

				}
			
			/**
		 * This method checks to see if the array of country objects is sorted and if the array is sorted it implements a binarysearch algorithm 
		 * to search for the country object thats at the beginning of the csv file 
		 * <p>
		 * Since this method is a void method 
		 * it doesn't return anything
		 * <p>
		 * @param Country[] countryarray - Country object array
		 * <p>
		 * @return void - no return value
		 * <p>
		 * @author Aditya Aaron Koul 
		 * <p>
		 * @version September 16 2023 
		 */


			public static Country[] sortArrayofCountries(Country [] countryarray) {
			if(countryarray[0].getName().equals("Brazil")){
					System.out.println("Array is sorted starting binary search");
				} else {
						System.out.println("The country you searched for wasn't found please try again ");
				}
					
			
			
			return countryarray;
			}
			

				
			/**
		 * This method searches for a user-defined country using the binary search algorithm.
		 * <p>
		 * What's passed in is a country object array of all the countries from the CSV file and a string variable called SearchKey 
		 * <p>
		 * This method uses a while loop one to set lowerobund less than or equal to upperbound
		 * and then it uses an int variable called check to compare SearchKey to the name of the country object at index mid in the array of country objects
			<p>	
		 * then this method uses a if else-if statement to determine if the user-defined country object is in the lower half or the upper half of the array of country objects 
		 * <p>
		 * and if the user-defiend country object is not found the method returns -1 
		 * Since this method is a void method 
		 * it doesn't return anything
		 * <p>
		 * @param Country[] countryarray - Country object array
		 * <p>
		 * @author Aditya Aaron Koul 
		 * <p>
		 * @version September 16 2023 
		 */

			//Binary Search Algorithm 
			public static int BinarySearch(String SearchKey, Country[] countryarray) {
				int lowerbound = 0;
				int upperbound = countryarray.length-1;
				int mid = 0;
				while(lowerbound <= upperbound) {
						 mid = lowerbound + (upperbound - lowerbound) / 2;
						int check = SearchKey.compareTo(countryarray[mid].getName());
						if(countryarray[mid].getName().compareTo(SearchKey) == 0) {
						return mid;	
						
						} else if(countryarray[mid].getName().compareTo(SearchKey) > 0 ) {
							upperbound = mid - 1; //SearchKey is in upper half

						} else {
							lowerbound = mid + 1; //SearchKey is in upper half
					 }
					}
					
					
					return -1; //not found
					
					 }
 
			/**
			 * This method searches for a user-defined country using the Sequential search algorithm.
			 * <p>
			 * What's passed in is a country object array of all the countries from the CSV file and a string variable called SearchKey 
			 * <p>
			 * This method uses a for loop to iterate through the entire array of country objects 
			 * and then it uses an int variable called check to compare SearchKey to the name of the country object at index mid in the array of country objects
				<p>	
			 * then this method uses an if statement to compare the name of the user-defined country object to search key 
			 * <p>
			 * and if the user-defined country object is found the method returns 1 
			 * <p>
			 * but if the user-defined country object is not found the method return -1
			 * <p>
			 * @param Country[] countryarray - Country object array
			 * <p>
			 * @author Aditya Aaron Koul 
			 * <p>
			 * @version September 16 2023 
			 */
				public static int SequentialSearch(String SearchKey, Country[] countryarray) {
					int j;
					for(j = 0; j <countryarray.length; j++) {
						
					}
					
					j = countryarray.length;
					while(j<countryarray.length) {
						if(countryarray[j].getName().compareTo(SearchKey) > 0) {
							
							j++;

						break;
						
						}
					if (j > countryarray.length) 
					return 1;
				else
					return -1;
					
					
					}
					return j;
				}			
			
			/**
			 * @param Country [] countryarray - Country object array
			 * @return Void - no return value
			 * @throws FileNotFoundException 
			 */
			
			/**
			 * This method takes in an integer as its input and then performs any of the
			 * specified functions of this program's menu depending upon the integer 
			 * the user inputs 
			 * 	
			 * @param int numOption - number option for the menu selection
			 * @throws FileNotFoundException 
			 * @ return Void - no return value
			 */
			
			//Menu choice method
			public static void menuOption(int numSel) throws FileNotFoundException {
				//User menu option for switch case statements
				int numChoice = numSel;
				switch(numChoice) {
				//Print country report
				case 1:
				//System.out.println();
				System.out.println("Country Report Print Out - Entire List");
				//System.out.println();
				System.out.println("Name \t  CAPITOL\t GDPPC\t  HappinessIndex\t APC\t");	
				System.out.println("--------------------------------------------------");
				for(int x = 0; x < countryarray.length-1; x++) {
					countryarray[x].printCountryReport(countryarray);	
					
					}
					break;
				//Sort Countries by Name
				case 2:
				SortCountryArraybyName(countryarray);
				System.out.println("Countries have been sorted by name");
				break;
				
				
				//Sort Countries by HappinessIndex using Selection Sort 
				case 3:
				sortCountryArraybyHappinessIndex(countryarray);
				System.out.println("Countries have been sorted by their Happinessindex");
				break;
				
				//Sort Countries by GDPPC using Bubble Sort 
				case 4:
				//System.out.println();
				sortCountryArraybyGDPPerCap(countryarray);
				System.out.println("Countries have been sorted by their GDPPC");
				break;
				
				//Find and Print a country for a given name using binary search if the data is sorted by name or sequential search if the data is not sorted 
					case 5:
					System.out.println();
					System.out.println("Please enter a country name:");
					Scanner ctryname = new Scanner(System.in);
					String cname = ctryname.nextLine();
					countryarray = sortArrayofCountries(countryarray);
					int mid = BinarySearch(cname,countryarray);
					 mid = SequentialSearch(cname,countryarray);
					 for(mid = 0; mid>countryarray.length; mid++) {
					countryarray[mid].printCountryReport(countryarray);	
							
					 	}
						break;
				
					case 6:
					KendallsTauMatrix();
					System.out.println();
					System.out.println("Kendall's Tau Matrix is a work in progress");
					break;
					
					case 7:
					System.out.println();
					System.out.println("Have a Wonderful Day");
					break;
					//Default case that handles bad inputs
					default:
					System.out.println();
					System.out.println("invalid input, Please enter a new input");
					System.out.println();
					
				}
			}
			public static void KendallsTauMatrix() {
				
			}
				
				public static void main (String [] args) throws FileNotFoundException {
					
					 System.out.print("Enter the file name: ");  
			          

					//Enter file name
			         Scanner infile = new Scanner(System.in);
					String filename = infile.nextLine();
					FileReader fileRead = null;
					Scanner reader = null;
					String[] c = null;
					//Parsing CSV file
					try {
					fileRead = new FileReader(filename);
					reader = new Scanner(fileRead); 
					c = reader.nextLine().split(",");
					
					
					int y = 0;
					while(reader.hasNextLine()) {
						
						//Reading and storing data values into the Country objects
						c = reader.nextLine().split(",");
						//Populating the array of country objects 
						String Name= c[0];
						String CapitolCity = c[1];
						Double Population = Double.parseDouble(c[2]);
						double gdp = Double.parseDouble(c[3]);
						Double area = Double.parseDouble(c[4]);
						double Happinessindex = Double.parseDouble(c[5]);
						//Create new Country object
						countryarray [y] = new Country(Name, CapitolCity, Population, gdp ,area, Happinessindex);
						y++;

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
				System.out.println("\n\n - Countries 1 CSV Operations Menu - \n");
				System.out.println("COP3530 Project 1\n");	
				System.out.println("Instructor: Xudong Liu\n");	
				System.out.println("Array Searches and Sorts\n");
				System.out.println("There were 128 records read");
				System.out.println(" 1) Print a Countries Report\n"
						+ " 2) Sort by Country Names\n"
						+ " 3) Sort by Happiness index \n"
						+ " 4) Sort by GDP per Capita \n"
						+ " 5) Find and Print a given Country \n"
						+ " 6) Print Kendalls Tau Matrix \n"
						+ " 7) Terminate Program \n"); 
				System.out.println("Enter menu selection: \n");
				int mynum = infile.nextInt();
				menuOption(mynum);

						try {
					
					} catch (Exception e){
					System.out.println("Error: invalid input Please Try Again");

			
			}
			}
			infile.close();
			}	
			}
			
			
