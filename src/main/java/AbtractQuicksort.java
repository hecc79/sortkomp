public abstract class AbtractQuicksort extends Sortieralgorithmus {
    protected abstract int getPivot(String[] arr, int links, int rechts);

    @Override
    public void sortiereArray(String[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * Eigentliche Implementierung des Quicksort
     *
     * @param arr    Das zu sortierende Feld
     * @param links  Index des linken Bereichsendes
     * @param rechts Index des rechten Bereichsendes
     */
    private void sort(String[] arr, int links, int rechts) {

        if (rechts - links <= 0) {
            return;
        }
        int pivot = getPivot(arr, links, rechts);

        if (pivot != rechts) {
            vertausche(arr, pivot, rechts);
        }

        int l = links;
        int r = rechts;

        while (l < r) {
            while (l < r && vergleicheKleinerGleich(arr[l], arr[rechts])) {
                l++;
            }
            while (r > l && (vergleicheKleinerGleich(arr[rechts], arr[r]))) {
                r--;
            }
            if (l < r) {
                vertausche(arr, l, r);
            }
        }

        if (l != rechts) {
            vertausche(arr, l, rechts);
        }

        sort(arr, links, l - 1);
        sort(arr, r + 1, rechts);
    }
}
