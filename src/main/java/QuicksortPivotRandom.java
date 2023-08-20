/**
 * Quicksort: Wählt ein zufälliges Element als Pivot.
 */
public class QuicksortPivotRandom extends AbtractQuicksort {

    @Override
    protected int getPivot(String[] arr, int links, int rechts) {
        //Wähle ein zufälliges Pivot-element
        return (int) ((Math.random() * (rechts - links)) + links);
    }

}
