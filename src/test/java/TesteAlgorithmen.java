import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class TesteAlgorithmen {
	
	private final String[] inputs = {"bbc","abc", "aaz", "aac"};
	private final String[] correct_result = {"aac","aaz","abc","bbc"};
	
	private boolean isCorrect(String [] a) {
		boolean result = true;
		for (int i = 0; i < a.length; i++) {
			result = result && a[i].equals(correct_result[i]);
			
		}
		return result;
	}
	
	private void algorithmTest(Sortieralgorithmus a) {
		String[] arr = Arrays.copyOf(inputs, inputs.length);
		System.out.println(Arrays.toString(arr));
		a.sortiereArray(arr);
		System.out.println(Arrays.toString(arr));
		assertTrue(isCorrect(arr));
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testQuicksort() {
		algorithmTest(new QuicksortPivotRandom());
	}
	
//	@Test
//	public void testInsertionsort() {
//		algorithmTest(new Insertionsort());
//	}
//	@Test
//	public void testSelectionsort() {
//		algorithmTest(new Selectionsort());
//	}
//	@Test
//	public void testBubblesort() {
//		algorithmTest(new Bubblesort());
//	}
//	@Test
//	public void testGnomesort() {
//		algorithmTest(new Gnomesort());
//	}

}
