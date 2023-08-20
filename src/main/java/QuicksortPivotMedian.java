/**
 * Quicksort: Wählt den Median aus dem linken, dem mittleren und dem rechten Element als Pivot
 */
public class QuicksortPivotMedian extends AbtractQuicksort{
    @Override
    protected int getPivot(String[] arr, int links, int rechts) {
        int mitte = (rechts+links)/2;
        if (vergleicheArrayPositionenKleinerGleich(arr,links, mitte)) {
            if (vergleicheArrayPositionenKleinerGleich(arr,rechts,links)) {
                return links;
            } else if (vergleicheArrayPositionenKleinerGleich(arr,mitte,rechts)) {
                return mitte;
            } else {
                return rechts;
            }
        } else {
            if (vergleicheArrayPositionenKleinerGleich(arr,rechts,mitte)) {
                return mitte;
            } else if (vergleicheArrayPositionenKleinerGleich(arr,links,rechts)) {
                return links;
            } else {
                return rechts;
            }
        }
    }
}
