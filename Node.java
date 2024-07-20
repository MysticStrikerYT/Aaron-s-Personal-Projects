/**
 * This node class creates the node object that will be used in the binary search tree
 * class. The nodes can hold two attributes of the country node objects:
 * the country's name and the country's HappinessIndexes.
 * 
 * @author Aditya Aaron Koul
 * @version November 16th 2023
 */
public class Node {

    /** The Country Node called StoredCountry. */
    public Country StoredCountry;

    /** The left child Node. */
    public Node leftChild;

    /** The right child Node. */
    public Node rightChild;

    /**
     * Display node
     * This displayNode method prints out the name and happinessindex values for the Inorder, Preorder, and PostOrder Traversals for options 1-3 for the 
     * Project4 menu by calling the getName and getHappinessIndex methods on the StoredCountry node 
     */
    public void displayNode() {
        System.out.printf(StoredCountry.getName(), StoredCountry.getHappinessIndex());
    }
}
