import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
public class TestQuicksort {

    private final String[] inputs = {"bbc","abc", "aaz", "aac"};
    private final String[] correct_result = {"aac","aaz","abc","bbc"};

    private void algorithmTest(Sortieralgorithmus a) {
        String[] arr = Arrays.copyOf(inputs, inputs.length);
        a.sortiereArray(arr);
        assertEquals(Arrays.deepToString(arr), Arrays.deepToString(correct_result));
    }

    @Test
    public void testQuicksortLinks() {
        AbtractQuicksort a = new QuicksortPivotLinks();
        assertEquals(a.getPivot(inputs,0, inputs.length-1),0);
        algorithmTest(a);
    }
    @Test
    public void testQuicksortRechts() {
        AbtractQuicksort a = new QuicksortPivotRechts();
        assertEquals(a.getPivot(inputs,0, inputs.length-1),inputs.length-1);
        algorithmTest(a);
    }
    @Test
    public void testQuicksortMitte() {
        AbtractQuicksort a = new QuicksortPivotMitte();
        assertEquals(a.getPivot(inputs,0, inputs.length-1),(0 + inputs.length-1)/2);
        algorithmTest(a);
    }
    @Test
    public void testQuicksortRandom() {
        AbtractQuicksort a = new QuicksortPivotRandom();
        algorithmTest(a);
    }
    @Test
    public void testQuicksortMedian() {

        AbtractQuicksort a = new QuicksortPivotMedian();
        algorithmTest(a);
        String[] arr = {"a","b","c"};
        assertEquals(a.getPivot(arr,0,2),1);
        String[]arr2 = {"c","b","a"};
        assertEquals(a.getPivot(arr2,0,2),1);
        String[]arr3 = {"b","a","c"};
        assertEquals(a.getPivot(arr3,0,2),0);
        String[]arr4 = {"b","c","a"};
        assertEquals(a.getPivot(arr4,0,2),0);
        String[]arr5 = {"a","c","b"};
        assertEquals(a.getPivot(arr5,0,2),2);
        String[]arr6 = {"c","a","b"};
        assertEquals(a.getPivot(arr6,0,2),2);
    }
}
