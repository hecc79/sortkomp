/**
 * Quicksort: Wählt immer das rechte Element als Pivot
 */
public class QuicksortPivotRechts extends AbtractQuicksort{
    @Override
    protected int getPivot(String[] arr, int links, int rechts) {
        return rechts;
    }
}
