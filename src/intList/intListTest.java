package intList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import strings_ir.String;

class intListTest {

	@Test
	void test() {
		
		int[] lijst = {1, 2, 3, 4};
		intList mijnLijst = new intList(lijst);
		assertArrayEquals(
				new int[] {1, 2, 3, 4},
				mijnLijst.getLijst()
				);
		assertEquals(4, mijnLijst.length());
		assertEquals(1, mijnLijst.intAt(0));
		mijnLijst.delLast();
		mijnLijst.add(5);
		
		int[] lijstNew = {1, 2, 3, 5};
		intList mijnLijstNew = new intList(lijstNew);
		assertArrayEquals(
				new int[] {1, 2, 3, 5},
				mijnLijstNew.getLijst()
		);
	}
}
