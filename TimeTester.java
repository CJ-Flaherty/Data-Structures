import java.io.File;
import java.util.*;
public class TimeTest {

	public static void main(String[] args) throws Exception, Underflow {
		System.out.println("Enter Filename:");
		Scanner scan = new Scanner(System.in);
		String file = scan.nextLine();
		int choice = -1;
		while(choice != 0) {
		System.out.println("ADT Menu\r\n" + 
				"0. Quit\r\n" + 
				"1. LinkedList (insert at end)\r\n" + 
				"2. StackArray\r\n" + 
				"3. StackList\r\n" + 
				"4. QueueList\r\n" + 
				"5. ArrayList\r\n" + 
				"6. array\r\n" +
				"7. Binary Search Tree\r\n" +
				"8. AVL Tree \r\n" +
				"9. SC Hash Table \r\n" +
				"10. QP Hash Table \r\n");
		choice = scan.nextInt();
		System.out.println("Your Choice >> " + choice);
		
		if(choice == 1) {
			System.out.println("CPU Time: " + LinkedList(file));
		}
		if(choice == 2) {
			System.out.println("CPU Time: " + StackArray(file));
		}
		if(choice == 3) {
			System.out.println("CPU Time: " + Stacklist(file));
		}
		if(choice == 4) {
			System.out.println("CPU Time: " + Queuelist(file));
		}
		if(choice == 5) {
			System.out.println("CPU Time: " + Arraylist(file));
		}
		if(choice == 6) {
			System.out.println("CPU Time: " + Array(file));
		}
		if(choice == 7) {
			System.out.println("CPU Time: " + BST(file));
		}
		if(choice == 8) {
			System.out.println("CPU Time: " + AVL(file));
		}
		if(choice == 9) {
			System.out.println("CPU Time: "  + SC(file));
		}
		if(choice == 10) {
			System.out.println("CPU Time: " + QP(file));
		}
		
		//scan.close();
		}
	}
	
	public static long LinkedList(String filename) throws Exception { //do the operations with a linkedlist
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(new File(filename));
		sc.nextLine();
		sc.useDelimiter(" ");
		LinkedList<Integer> list = new LinkedList<Integer>();
		while(sc.hasNext()) {
			String text = sc.next();
			char inout = text.charAt(0);
			int value = Integer.parseInt(text.substring(1));
			Integer intvalue =  Integer.valueOf(value);
			if(inout == 'i') {
				list.add(intvalue);
			}
			if(inout == 'd') {
				list.remove(intvalue);
			}
			else {
				//sc.nextLine();
			}
			
			}
		long end = System.currentTimeMillis();
		sc.close();
		return (end - start);
		}
	
	public static long StackArray(String filename) throws Exception { //do the operations with a stack array
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(new File(filename));
		sc.nextLine();
		sc.useDelimiter(" ");
		Stack<Integer> stack = new Stack<Integer>();
		while(sc.hasNext()) {
			String text = sc.next();
			char inout = text.charAt(0);
			int value = Integer.parseInt(text.substring(1));
			Integer intvalue = Integer.valueOf(value);
			if(inout == 'i') {
				stack.push(intvalue);
			}
			if(inout == 'd') {
				stack.pop();
			}
		}
		long end = System.currentTimeMillis();
		sc.close();
		return end - start;
		
	}
	
	public static long Stacklist(String filename) throws Exception, Underflow { //Do the operations with a stacklist
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(new File(filename));
		sc.nextLine();
		sc.useDelimiter(" ");
		StackLi stack = new StackLi();
		while(sc.hasNext()) {
			String text = sc.next();
			char inout = text.charAt(0);
			int value = Integer.parseInt(text.substring(1));
			Integer intvalue = Integer.valueOf(value);
			if(inout == 'i') {
				stack.push(intvalue);
			}
			if(inout == 'd') {
				stack.pop( );
			}
			stack.isEmpty();
		}
		long end = System.currentTimeMillis();
		sc.close();
		return end - start;
		
	}
	
	public static long Queuelist(String filename) throws Exception, Underflow { //do the operations witha  queue list
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(new File(filename));
		sc.nextLine();
		sc.useDelimiter(" ");
		QueueLi queue = new QueueLi();
		while(sc.hasNext()) {
			String text = sc.next();
			char inout = text.charAt(0);
			int value = Integer.parseInt(text.substring(1));
			if(inout == 'i') {
				queue.enqueue(value);
			}
			if(inout == 'd') {
				queue.dequeue();
			}
		}
		long end = System.currentTimeMillis();
		sc.close();
		return end - start;
		
	}
	
	public static long Arraylist(String filename) throws Exception { // do the operations with an arraylist
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(new File(filename));
		sc.nextLine();
		sc.useDelimiter(" ");
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(sc.hasNext()) {
			String text = sc.next();
			char inout = text.charAt(0);
			int value = Integer.parseInt(text.substring(1));
			Integer intvalue = Integer.valueOf(value);
			if(inout == 'i') {
				list.add(intvalue);
			}
			if(inout == 'd') {
				list.remove(intvalue); 
			}
		}
		long end = System.currentTimeMillis();
		sc.close();
		return end - start;
		
	}
	
	public static long Array(String filename) throws Exception { // do the operations with an array
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(new File(filename));
		sc.nextLine();
		sc.useDelimiter(" ");
		int[] array = new int[250000];
		while(sc.hasNext()) {
			String text = sc.next();
			char inout = text.charAt(0);
			int value = Integer.parseInt(text.substring(1));
			int index = 0;
			if(inout == 'i') {
				array[index] = value;
				index++;
			}
			if(inout == 'd') {
				int i = 0;
				boolean found = false;
				while(i < array.length && found == false) {
					if(array[i] == value) {
						array[i] = -1;
						found = true;
					}
					i++;
				}
			}
		}
		long end = System.currentTimeMillis();
		sc.close();
		return end - start;

	
	}
	
	public static long BST(String filename) throws Exception { //do the operations with a BST
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(new File(filename));
		sc.nextLine();
		sc.useDelimiter(" ");
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		while(sc.hasNext()) {
			String text = sc.next();
			char inout = text.charAt(0);
			int value = Integer.parseInt(text.substring(1));
			if(inout == 'i') {
				tree.insert(value);
			}
			if(inout == 'd') {
				tree.remove(value);
			}
		}
		long end = System.currentTimeMillis();
		sc.close();
		return end - start;
		
	}
	
	public static long AVL(String filename) throws Exception{ //do the operations with an AVL tree
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(new File(filename));
		sc.nextLine();
		sc.useDelimiter(" ");
		AvlTree<Integer> tree = new AvlTree<Integer>();
		while(sc.hasNext()) {
			String text = sc.next();
			char inout = text.charAt(0);
			int value = Integer.parseInt(text.substring(1));
			if(inout == 'i') {
				tree.insert(value);
			}
			if(inout == 'd') {
				tree.remove(value);
			}
		}
		long end = System.currentTimeMillis();
		sc.close();
		return end - start;
				
	}

	public static long SC(String filename) throws Exception{ // do the operations with a SC hash table
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(new File(filename));
		sc.nextLine();
		sc.useDelimiter(" ");
		SeparateChainingHashTable<Integer> table = new SeparateChainingHashTable<Integer>(500000);
		while(sc.hasNext()) {
			String text = sc.next();
			char inout = text.charAt(0);
			int value = Integer.parseInt(text.substring(1));
			if(inout == 'i') {
				table.insert(value);
			}
			if(inout == 'd') {
				table.remove(value);
			}
		}
		long end = System.currentTimeMillis();
		sc.close();
		return end - start;
		
	}

	public static long QP(String filename) throws Exception{ //do the operations with a QP hash table
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(new File(filename));
		sc.nextLine();
		sc.useDelimiter(" ");
		QuadraticProbingHashTable<Integer> table = new QuadraticProbingHashTable<Integer>(500000);
		while(sc.hasNext()) {
			String text = sc.next();
			char inout = text.charAt(0);
			int value = Integer.parseInt(text.substring(1));
			if(inout == 'i') {
				table.insert(value);
			}
			if(inout == 'd') {
				table.remove(value);
			}
		}
		long end = System.currentTimeMillis();
		sc.close();
		return end - start;
		
	}
		
	

}


