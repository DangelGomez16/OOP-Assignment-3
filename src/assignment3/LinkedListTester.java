// Daniel A. Gomez
package assignment3;
import java.io.*;
import java.util.Scanner; 

public class LinkedListTester {
	
	public static void main(String[] args) {
		// Initialize count for adding into linked list later.
		int count = -100;

		// Copying the input file name into a string for easier use later.
		// LinkedList is also initiated.
		String filePath = "data.txt";
		LinkedList list = new LinkedList();
		
		// Method to read integers from the file and inserting them into the 
		// linked list is called. 
		getFileContents(filePath, list);

		// The organizeList method in the LinkedList class is used to to modify the
		// linked list by deleting certain nodes and adding the count in their place.
		list.organizeList(count);
		
		// After the linked list has been organized, the contents of the linked list
		// is output into the appropriate text file. 
		list.printList("processed.txt");

	}
	
	// Method is for reading the integers from the input file and inserting them one
	// by one into the newly created linked list. Any negative number in the input file
	// is ignored. 
	public static void getFileContents(String fname, LinkedList list){
		// Input file information is read by file. A scanner is initiated and set to null.
		File file = new File(fname);	
		Scanner scan = null;
		
		// As long as an exception isn't encountered, the scanner will scan the contents of
		// the file and, integer by integer, seperated by white space, is fed into the linked list
		// so long as the integer is a non-negative number. 
		try {
			scan = new Scanner(file);
			
			while(scan.hasNext()) {
				// Value holds the next integer from file to check if it's negative. If not, 
				// it is inserted.
				int value = scan.nextInt();
				
				if(value >= 0)
					list.insertNode(value);
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		// The scanner is closed by the end of the method. 
	    finally {
	        if (scan != null)
	            scan.close();
	    }
	}
	
	
}
