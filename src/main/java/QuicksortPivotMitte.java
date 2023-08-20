/**
 * Quicksort: Wählt das (linke) mittlere Element als Pivot.
 */
public class QuicksortPivotMitte extends AbtractQuicksort{

    @Override
    protected int getPivot(String[] arr, int links, int rechts) {
        return (rechts+links)/2;
    }
}
