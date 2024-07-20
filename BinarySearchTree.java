			
			
			/**
			 * This is the binary search tree class
			 * that creates and manipulates a binary
			 * search tree that is filled with nodes
			 * of various countries and their GDPPCs.
			 * 
			 * @author Aditya Aaron Koul
			 * @version November 16th 2023 
			 *
			 */
			
			//Class start
			
			public class BinarySearchTree {
				
				//Local declaration
				Node root;
			
				/** 
				 * This method is the constructor for the 
				 * binary search tree
				 * 
				 **/
				public BinarySearchTree() {
			
					root = null;
			
				}
			
				/**
				 * This method inserts country nodes into the binary search tree.
				 * The user provides the country name and Happiness values of the country nodes
				 * 
				 * @param countryName - country name
				 * @param GDPPC - country GDPPC
				 */
				
				public void insert(Country name, double happiness) {
				    Node theNode = new Node();
				    theNode.StoredCountry = name;
			
				    if (root == null) {
				        root = theNode;
				    } else {
				        Node current = root;
				        Node parent;
			
				        while (true) {
				            parent = current;
				            int comparison = name.getName().compareTo(current.StoredCountry.getName());
			
				            if (comparison < 0) {
				                current = current.leftChild;
				                if (current == null) {
				                    parent.leftChild = theNode;
				                    return;
				                }
				            } else {
				                current = current.rightChild;
				                if (current == null) {
				                    parent.rightChild = theNode;
				                    return;
				                }
				            }
				        }
				    }
				}
						/**
				 * This method finds a country based on the country name
				 * which is provided by the user and then generates a path to the country that the user searched for.
				 * 
				 * @param name - country name
				 * @return Country names to show the path taken to find the desired country
				 */
				@SuppressWarnings("unused")
				public Node find(String name, String key) {
				    Node current = root; // start at root
				    StringBuilder path = new StringBuilder("--> " + current.StoredCountry.getName() + " ");
			
				    int compareValue = key.compareTo(current.StoredCountry.getName());
			
				    while (current != null && compareValue != 0) { // if no match
				        if (compareValue < 0) {
				            current = current.leftChild; // follow leftChild
				            if (current != null) {
				                path.append("TO>> " + current.StoredCountry.getName() + " ");
				            }
				        } else {
				            current = current.rightChild; // follow rightChild
				            if (current != null) {
				                path.append("TO>> " + current.StoredCountry.getName() + " ");
				            }
				        }
			
				        if (current == null) {
				            return null; // not found; boundary condition
				        }
				        compareValue = key.compareTo(current.StoredCountry.getName());
				    }
			
				    if (current != null) {
				        System.out.println("Arrived at: " + current.StoredCountry.getName() + " with Happiness Index: " + current.StoredCountry.getHappinessIndex());
				        System.out.println("Path to the searched country is = " + path.toString());
				    }
			
				    return current; // returns reference to node
				}
				/**
				 * This method deletes a user-specified country
				 * from the binary search tree.
				 * 
				 * @param name - country name
				 */
				public void delete(String name) {
				    Node current = root;
				    Node parent = null;
				    boolean isLeftChild = true;
			
				    // Find the node to delete
				    while (current != null && !current.StoredCountry.getName().equals(name)) {
				        parent = current;
			
				        if (name.compareTo(current.StoredCountry.getName()) < 0) {
				            isLeftChild = true;
				            current = current.leftChild;
				        } else {
				            isLeftChild = false;
				            current = current.rightChild;
				        }
				    }
			
				    // If the node to delete is not found
				    if (current == null) {
				        System.out.println("Node not found.");
				        return;
				    }
			
				    // Case 1: Node to delete has no children
				    if (current.leftChild == null && current.rightChild == null) {
				        if (current == root) {
				            root = null;
				        } else if (isLeftChild) {
				            parent.leftChild = null;
				        } else {
				            parent.rightChild = null;
				        }
				    }
				    // Case 2: Node to delete has one child
				    else if (current.rightChild == null) {
				        if (current == root) {
				            root = current.leftChild;
				        } else if (isLeftChild) {
				            parent.leftChild = current.leftChild;
				        } else {
				            parent.rightChild = current.leftChild;
				        }
				    } else if (current.leftChild == null) {
				        if (current == root) {
				            root = current.rightChild;
				        } else if (isLeftChild) {
				            parent.leftChild = current.rightChild;
				        } else {
				            parent.rightChild = current.rightChild;
				        }
				    }
				    // Case 3: Node to delete has two children
				    else {
				        Node successor = getSuccessor(current);
			
				        if (current == root) {
				            root = successor;
				        } else if (isLeftChild) {
				            parent.leftChild = successor;
				        } else {
				            parent.rightChild = successor;
				        }
			
				        successor.leftChild = current.leftChild;
				    }
				}
			
				
				/**
				 * Prints the binary search tree in the In-order traversal 
				 * 
				 * @param localRoot - the root node.
				 */
				public void printInorder(Node localRoot) {
					if (localRoot != null) {
						printInorder(localRoot.leftChild);
						System.out.printf("%-35s   \t\t\t" + "%-10.3f\n", localRoot.StoredCountry.getName(), localRoot.StoredCountry.getHappinessIndex());
						printInorder(localRoot.rightChild);
					}
				}
			
				/**
				 * Prints the binary search tree in the Preorder traversal 
				 * 
				 * @param localRoot - the root node.
				 */
				public void printPreorder(Node localRoot) {
					if (localRoot != null) {
						System.out.printf("%-35s   \t\t\t" + "%-10.3f\n", localRoot.StoredCountry.getName(), localRoot.StoredCountry.getHappinessIndex());
						printPreorder(localRoot.leftChild);
						printPreorder(localRoot.rightChild);
					}
				}
			
				/**
				 * Prints the binary search tree in the Postorder traversal 
				 * 
				 * @param localRoot - the root node.
				 */
				public void printPostorder(Node localRoot) {
					if (localRoot != null) {
						printPostorder(localRoot.leftChild);
						printPostorder(localRoot.rightChild);
						System.out.printf("%-35s   \t\t\t" + "%-10.3f\n", localRoot.StoredCountry.getName(), localRoot.StoredCountry.getHappinessIndex());
					}
				}
			
				/**
				 * Gets successor node from the node that is going to be deleted from the binary search tree.
				 * 
				 * @param delNode - the node that will be deleted
				 * @return successor node to the node that will get deleted
				 */
				
				@SuppressWarnings("unused")
				private Node getSuccessor(Node delNode) {
					Node successorParent = delNode;
					Node successor = delNode;
					Node present = delNode.rightChild; 
					
					while(present != null) {
						successorParent = successor;
						successor = present;
						present = present.leftChild; 
					}
					
					if(successor != delNode.rightChild) 
					{ 
						successorParent.leftChild = successor.rightChild;
						successor.rightChild = delNode.rightChild;
					}
					return successor;
				}
				
				
				    
				
				
			
			
			
				/**
				 * This method performs a recursive in-order traversal of the binary search tree, starting from the left subtree, 
				 * then processing the current node, and finally moving to the right subtree.
				 * @param c: The number of top countries to print.
				 *@param countryarray: The array used to store the top countries.
				 *@param firstIndex: The index in the array where the insertion starts.
				 *@param localRoot: The current root node of the binary search tree.
				*if (localRoot != null && firstIndex < c):
				*The method starts by checking if the current node (localRoot) is not null and if the starting index 
				*is less than the 
				*specified maximum number of countries (c). 
				*If either condition is false, the method stops further recursion.			
				*if (countryarray[firstIndex] == null || localRoot.StoredCountry.getHappinessIndex() < countryarray[firstIndex].getHappinessIndex()):
				*This condition checks whether the current country in the binary search tree has a lower happiness index than the 
				*current maximum in the countryarray at the given index.
				*If true, it proceeds to insert the current country at the correct position in the array to maintain ascending order based on happiness index.
				*The while loop is responsible for shifting existing elements to make space for the new element (localRoot.StoredCountry) in the array.
				*printBottomCountries(c, countryarray, startingIndex + 1, localRoot.rightChild);
				*This line initiates a recursive call to the right subtree, continuing the recursive in-order traversal.
			**/

				public void printBottomCountries(int c, Country[] countryarray, int firstIndex, Node localRoot) {
				    if (localRoot != null && firstIndex < c) {
				        printBottomCountries(c, countryarray, firstIndex, localRoot.leftChild);

				        if (countryarray[firstIndex] == null || localRoot.StoredCountry.getHappinessIndex() < countryarray[firstIndex].getHappinessIndex()) {
				            int populateIndex = firstIndex;

				            while (firstIndex > 0 && (countryarray[firstIndex - 1] == null || localRoot.StoredCountry.getHappinessIndex() < countryarray[populateIndex - 1].getHappinessIndex())) {
				                countryarray[firstIndex] = countryarray[firstIndex - 1];
				                populateIndex--;
				            }

				            countryarray[populateIndex] = localRoot.StoredCountry;
				        }

				        printBottomCountries(c, countryarray, firstIndex + 1, localRoot.rightChild);
				    }
				}
				
				/**
				 * This method gets and returns the root node of the BinarySearchTree

				 */
				public Node getRoot() {
				    return root;
				}
						
				    
				
				    
				
				   
			
				
				/**
				 * This method performs a recursive in-order traversal of the binary search tree, starting from the left subtree, 
				 * then processing the current node, and finally moving to the right subtree.
				 * @param c: The number of top countries to print.
				 *@param countryarray: The array used to store the top countries.
				 *@param firstIndex: The index in the array where the insertion starts.
				 *@param localRoot: The current root node of the binary search tree.
				*The method checks whether the current country's happiness index is greater than the happiness index of the country
				 *at the current insertion position in the array.
				*If it is, it shifts existing elements to make space for the new element, ensuring the array remains sorted in descending order.
				*The new country is then inserted at the correct position in the array.
Re				 */
				public void printTopCountries(int c, Country[] countryarray, int firstIndex, Node localRoot) {
				    if (localRoot != null && firstIndex < c) {
				        printTopCountries(c, countryarray, firstIndex, localRoot.leftChild);

				        if (countryarray[firstIndex] == null || localRoot.StoredCountry.getHappinessIndex() > countryarray[firstIndex].getHappinessIndex()) {
				            int populateIndex = firstIndex;

				            while (populateIndex > 0 && (countryarray[populateIndex - 1] == null || localRoot.StoredCountry.getHappinessIndex() > countryarray[populateIndex - 1].getHappinessIndex())) {
				                countryarray[populateIndex] = countryarray[populateIndex - 1];
				                populateIndex--;
				            }

				            countryarray[populateIndex] = localRoot.StoredCountry;
				        }

				        printTopCountries(c, countryarray, firstIndex + 1, localRoot.rightChild);
				    }
				}
			}