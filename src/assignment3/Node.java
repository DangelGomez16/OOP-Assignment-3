// Daniel A. Gomez
package assignment3;

// This class is for the nodes of the linked list.
public class Node {
	
	// The value of the node and the next node are both here to track
	// the current node's value and store the next node, which is accessible
	// from the other classes.
	int value;
	Node next;
	
	// The value is set to the data given to it, and it's next pointer set to 
	// null.
	public Node(int data){
		this.value = data;	
		this.next = null;
	}	
}
