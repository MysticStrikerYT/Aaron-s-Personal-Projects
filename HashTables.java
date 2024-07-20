		
		/** 
		 * The HashTables class generates a hash table 
		 * using countries from the Countries5.CSV file. The class
		 * contains a node class and a "CountryRecord" 
		 * class that takes care of the various functions that
		 * the user can perform on the hash table Like printing the hashtable
		 * Inserting a user-defined country into the hashtable
		 * deleting a country from the hashtable etc.
		 * @author Aditya Aaron Koul
		 * @version December 5th 2023 
		 */
		
		//Imports
		import java.io.*;
		import java.util.*;
		
		/**
		 * The Class HashTables.
		 */
		//Class HashTables Start
		@SuppressWarnings("unused")
		class HashTables {
			
			/**
			 * The Class Node.
			 */
			//Node Class Start
			private class Node { 
				
				/** The name. */
				String name; 
				
				/** The population. */
				double population; 
				
				/** The area. */
				double area; 
				
				/** The next node. */
				@SuppressWarnings("unused")
				public Node nextNode;
				Node previousNode;
				
				/**
				 * This is a constructor for the node class that 
				 * create the node objects with the values for the name population and area fields.
				 *
				 * @param name the name
				 * @param population the population
				 * @param area the area
				 */
				
				public Node(String name, double population, double area) { 
					this.name = name; 
					this.population = population; 
					this.area = area; 
				} 
				
				/**
				 * This method prints out the nodes with the country name
				 * and PopulationDensity values by dividing the area of the country by it's population then 
				 * multiplying the result of that operation by 100000 and then type-casting that result to a long variable.
				 */
				public void printNode() { 
				      System.out.printf("%-30s %-20.4f\n", name, (long)area/population*100000); 
				} 
			} 
			
			/**
			 * The Class CountryRecord.
			 */
			//CountryRecord Class Start
			public class CountryRecord {
				
				/** The first. */
				//Local Declarations
				private Node first;
				
				/** The tail. */
				private Node tail;
				/**
				 * This is a constructor for the 
				 * CountryRecord class that creates a type
				 * CountryRecord. Nodes are stored and manipulated
				 * in this list as part of the hashtable's functionality
				 */
				public CountryRecord() {
					first = null;
					tail = null;
				}
				
				/**
				 * Inserts the given node into the hash
				 * table and orders it using a double-ended
				 * singly-linked list. Insertions happen at the
				 * end of the list.
				 *
				 * @param aNode the a node
				 */
				public void insert(Node aNode) {
				    if (first == null) {
				        first = aNode;
				        tail = aNode; 
				    } else {
				        Node current = first;
				        while (current.nextNode != null) {
				            current = current.nextNode;
				        }
				        current.nextNode = aNode;
				        aNode.previousNode = current; 
				        tail = aNode; 
				    }
				}
								
				/**
				 * Finds the location of a given country by searching for the name of the country
				 * and returns the country node.
				 *
				 * @param country the country
				 * @return current - node with the desired country
				 */
				public Node find(String country) {
			        Node present = first;
			        while(present != null) { 
			            if(present.name.equals(country)) {
			            	return present;
			            }
			            present = present.nextNode;
			        }
			        return null;
			    }								
				/**
				 * Deletes a country node from the hash table based on the name
				 * of the given country that the user selects.
				 *
				 * @param newNode the new node
				 */
				public void delete(Node newNode) {
				    if (first == null) {
				        System.out.println("Country may not exist in the hash table. Please try again.");
				        return;
				    }

				    Node before = null;
				    Node present = first;

				    while (present != null && !(newNode.name.equals(present.name))) {
				        before = present;
				        present = present.nextNode;
				    }

				    if (before == null) {
				        first = first.nextNode;
				    } else {
				        before.nextNode = present.nextNode;
				    }
				}
								
				/**
				 * This getEmpty method returns an integer value depending on if a cell is empty or not empty in 
				 * the hash table.
				 * it returns a 1 if the cell in the hashtable is empty or it 
				 * returns a zero if the cell in the hashtable is empty 
				 * @return empty - integer
				 */
				public int getEmptyCells() {
					Node present = first;
					int empty = 0;
					if(present == null) {
						return 1;
					}
					else {
						return 0;
					}
				}
				
				/**
				 * This getEmpty method returns an integer value depending on if a cell is empty or not empty in 
				 * the hash table.
				 * it returns a 1 if the cell in the hashtable is collided or it 
				 * returns a zero if the cell in the hashtable is not collided
				 * @return col - integer
				 */
				public int getCollidedCells() {
					Node present = first;
					int col = 0;
					int collided = 0;
					while(present != null) {
						collided++;				
						present = present.nextNode;
					}
					if(collided > 1) {
						col = 1;
						return col;
					}
					else {
						col = 0;
						return col;
					}
				}
				
				/**
				 * Prints out all the cells from the hash table with
				 * countries or "Empty" if the cell is empty.		 * 
				 */
				public void displayList() {
					Node present = first;
					
					if(present == null) {
						System.out.println("\tEmpty");
					}
					else {
						while(present != null) {
							System.out.print("\t");
							present.printNode();
							present = present.nextNode;
						}
					}
				}
			}
		
			//Local Declarations
			/** The hash array. */
			private CountryRecord[] hashArray;
			
			/** The array size. */
			private int arraySize;
			
			/** The name. */
			private String name = "";
			
			/** The population. */
			private long population;
			
			/** The area. */
			private long area;
			
			
			/**
			 * Constructor for the HashTable class.
			 * Creates HashTable object.
			 *
			 * @param size the size
			 */
			public HashTables(int size) {
				arraySize = size;
				hashArray = new CountryRecord[arraySize];
				for(int j = 0; j < arraySize; j++) {
					hashArray[j] = new CountryRecord();
				}
			}
		
			/**
			 * This method inserts a country name, population value and
			 * area value into a country node with the help
			 * of the insert method in the CountryRecord class.
			 *
			 * @param country the country
			 * @param population the population
			 * @param area the area
			 */
			public void insert(String country, double population, double area) {
				Node aNode = new Node(country, population, area);
				int hashValue = hashFunc(country);
				hashArray[hashValue].insert(aNode);
			}
			
			/**
			 * Deletes a country based on the name; passes
			 * a node onto the delete method in the CountryRecord
			 * class for deletion.
			 *
			 * @param country the country
			 */
				public void delete(String country) {
				Node aNode = new Node(country, population, area);
		        int hashVal = hashFunc(country);
		        hashArray[hashVal].delete(aNode);
		    }
			
			/**
			 * Finds a country based on the name and returns
			 * the population density as well as the index of where
			 * the country is in the hash table by using the find
			 * method in the CountryRecord class.
			 * 	
			 *
			 * @param country the country
			 * @return hashVal - hash value
			 */
				public int find(String country) {
					int hashVal = hashFunc(country);
					hashArray[hashVal].find(country);
					hashArray[hashVal].find(country).printNode();
					return hashVal;
				}				
			
			/**
			 * Provides a hash code for a country
			 * by country name and returns that.
			 *
			 * @param name the name
			 * @return ssum % 257, hash code
			 */
			public int hashFunc(String name) {
				int ssum = 0;
				for(char ccc: name.toCharArray()) {
					ssum += ccc;
				}
				return ssum % 257;
			}
			
			/**
			 * Prints the number of empty and collided
			 * cells from the hashtable using the getEmptyCells and getCollidedCells
			 * methods in the CountryRecord class. 
			 */
			public void printEmptyAndCollidedCells() {
				int empty = 0;
				int collision = 0;
				
				for(int i = 0; i < hashArray.length; i++) {
					if(hashArray[i].getEmptyCells() == 1) {
						empty++;
					}
					if(hashArray[i].getCollidedCells() == 1) {
						collision++;
					}
				}
				System.out.println("Number of Empty Cells: " + empty);
				System.out.println("Number of Collided Cells: " + collision);
			}
			
			/**
			 * Displays the hash table using the displayList method
			 * in the CountryRecord class.
			 * 
			 */
			public void displayTable() {
				for(int j = 0; j < arraySize; j++) {
					System.out.print(j + ". ");
					hashArray[j].displayList();
					System.out.print("");
				}
			}
		}