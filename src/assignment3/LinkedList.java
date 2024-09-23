// Daniel A. Gomez
package assignment3;
import java.io.*;

// This class is for the linked list, which deals with the nodes.
public class LinkedList {
	
	// The node head is made a global, as it is accessed in every method in this
	// class. It stores the head node of the linked list.
	private Node head;
	
	// The linked list, when initiated, initiates the head node to null until 
	// a node is inserted into it. 
	public LinkedList(){
		this.head = null;
	}
	
	// Inserts node into the linked list based off the data given to it.
	public void insertNode(int data){
		
		// If the head node is null, set the head node to be a new node. 
		if(head == null){
			Node nextNode = new Node(data);
			head = nextNode;
		}
		
		// Traverse through the linked list until the last node is encountered.
		// Then, make a new node with the given data, and insert that as the next node
		// in the linked list, updating the previous nodes next pointer.
		else {
			Node temp = head;
			while(temp.next != null)
				temp = temp.next;
			
			temp.next = new Node(data);
		}
	}
	
	// Organizes the linked list by deleting nodes based off the specifications of the
	// prompt, and inserting nodes in their place based off the count value.
	public void organizeList(int count) {
		// node1 is the node that will traverse through the list, checking if the current and 
		// subsequent node meet the requirements for deletion. If so, node2, which is a node which
		// will be previous to node1, will be used to delete the node node1 is pointing to. tracker 
		// is to account for deletion of the first node in the linked list.
		Node node1 = head;
		Node node2 = head;
		int tracker = 0;
		
		// This loop will continue so long as node1 is not null, nor its next pointer.
		while(node1.next != null && node1 != null) {
			
			// If the specifications for deletion are met, the current and subsequent
			// node are deleted and replaced.
			if(node1.next.value == (node1.value * 2) + 7) {
				
				// If the node is the first node in the linked list, head is updated to
				// be two places higher in the linked list (thus deleting the current and 
				// subsequent node). The while loop then continues so as to not create errors.
				if(tracker == 0) {
					node1 = node1.next.next;
					head = node1;
					
					tracker++;
					continue;
				}
				
				// If the current nodes next pointer is pointing to the last node in the linked 
				// list, then instead of pointing to a node two places ahead of it, it points to null.
				if(node1.next.next != null)
					node1.next = node1.next.next;
				else
					node1.next = null;
				
				// In order to delete the current node, node1 is updated to point to the previous node, 
				// stored in node2, whereby its next pointer is updated to two nodes ahead to effectively 
				// delete the old current node.
				node1 = node2;
				node1.next = node1.next.next;
				
				// A new node is created with a value of whatever count currently is. This node then points
				// to the current nodes next node, and the current nodes next node is updated to point to the
				// new node. 
				Node newNode = new Node(count);
				newNode.next = node1.next;
				node1.next = newNode;
				
				// count is increased by one.
				count++;
			}
			
			// node2 is made node1, while node1 is updated to the next node. 
			node2 = node1;
			node1 = node1.next;
			
			// tracker is updated by one.
			tracker++; 
		}
		
		// The last node, after the will loop completes, is made into a node holding the last value of count.
		Node lastNode = new Node(count);
		node1.next = lastNode;
		
	}
	
	// Writes the contents of the linked list into an output file.
	public void printList(String fname) {
		// Writer is activated.
		BufferedWriter bw;
		
		// Unless an exception is encountered, whatever is held in the linked list is 
		// written into the output file integer by integer, separated by a space each.
		try {
			bw = new BufferedWriter(new FileWriter(fname));
			
			Node temp = head;
			while(temp != null) {
				bw.write(temp.value + " ");
				temp = temp.next;
			}
			
			bw.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
