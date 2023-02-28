package intList;

import java.util.Arrays;

/**
 * Each instance of this class represents a sequence of characters.
 * 
 * @immutable
 */
public class IntList {
	
	class Node {
		int value;
		Node next;
	}
	
	/**
	 * @representationObject
	 */
	private Node node;
	
	
	/**
	 * @creates | result
	 * @post | result != null
	 */
	public int[] getLijst() {
		int[] lijst = new int[length()];
		Node thisnode = node;
		int i = 0;
		while (thisnode.next != null) {
			lijst[i] = thisnode.value;
			thisnode = thisnode.next;
			i+=1;
		}
		lijst[i] = thisnode.value;
		return lijst;
	}
	
	/**
	 * @inspects | this
	 */
	
	public int length() {
		int counter = 0;
		Node thisnode = node;
		while (thisnode.next != null) {
			counter +=1;
			thisnode = thisnode.next;
		}
		return counter+1;
	}
	
	/**
	 * @inspects | this
	 * @pre | 0<= index && index < length()
	 * @post | result == getLijst()[index]
	 */
	public int intAt(int index) {
		int counter = 0;
		Node thisnode = node;
		while (counter < index) {
			thisnode = thisnode.next;
		}
		return thisnode.value;
	}
	
	/**
	 * @pre | integers != null
	 * @mutates |
	 * @post | Arrays.equals(getLijst(), integers)
	 */
	public IntList(int[] integers) {
		Node thisnode = new Node();
		thisnode.value = integers[integers.length - 1];
		for (int i = 1; i<integers.length; i++) {
			Node newNode = new Node();
			newNode.value = integers[integers.length - i - 1];
			newNode.next = thisnode;
			thisnode = newNode;
		}
		this.node = thisnode;
	}
	
	/**
	 *@pre | length() > 0
	 *@mutates | this
	 *@post | length() == old(length()) -1
	 *@post | Arrays.equals(old(getLijst()), 0, length(), getLijst(), 0, length())
	 *
	 */
	public void delLast() {
		Node thisnode = node;
		
		while (thisnode.next.next != null) {
			thisnode = thisnode.next;
		}
		thisnode.next = null;
	}
	
	/**
	 * @mutates | this
	 * @post | length() == old(length())+1
	 * @post | intAt(old(length())) == integer
	 * @post | Arrays.equals(old(getLijst()), 0, old(length()),getLijst(), 0, old(length()))
	 * 
	 * 
	 */
	public void add(int integer) {
		Node thisnode = node;
		while (thisnode.next != null) {
			thisnode = thisnode.next;
		}
		thisnode.next.value = integer;
	}
}