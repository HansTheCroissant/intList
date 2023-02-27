package intList;

import java.util.Arrays;

/**
 * Each instance of this class represents a sequence of characters.
 * 
 * @immutable
 */
public class intList {
	
	/**
	 * @representationObject
	 */
	private int[] integers;
	
	/**
	 * @creates | result
	 * @post | result != null
	 */
	public int[] getLijst() {
		return integers.clone();
	}
	
	/**
	 * @inspects | this
	 * @post | result == getLijst().length
	 */
	
	public int length() {
		return integers.length;
	}
	
	/**
	 * @inspects | this
	 * @pre | 0<= index && index < length()
	 * @post | result == getLijst()[index]
	 */
	public int intAt(int index) {
		return integers[index];
	}
	
	/**
	 * @pre | integers != null
	 * @mutates |
	 * @post | Arrays.equals(getLijst(), integers)
	 */
	public intList(int[] integers) {
		this.integers = integers.clone();
	}
	
	/**
	 *@pre | length() > 0
	 *@mutates | this
	 *@post | length() == old(length()) -1
	 *@post | Arrays.equals(old(getLijst()), 0, length(), getLijst(), 0, length())
	 *
	 */
	public void delLast() {
		int[] integersNew = new int[integers.length-1];
		System.arraycopy(integers, 0, integersNew, 0, integersNew.length);
		integers = integersNew;
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
		int[] integersNew = new int[integers.length+1];
		System.arraycopy(integers, 0, integersNew, 0, integers.length);
		integersNew[integers.length] = integer;
		integers = integersNew;
	}
}