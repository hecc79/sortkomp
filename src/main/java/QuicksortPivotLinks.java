/**
 * Quicksort: Wählt immer das linke Element als Pivot
 */
public class QuicksortPivotLinks extends AbtractQuicksort{
    @Override
    protected int getPivot(String[] arr, int links, int rechts) {
        return links;
    }
}
