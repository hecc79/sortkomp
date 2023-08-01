public class Quicksort extends SortierAlgorithmus {

    public void sortiereArray(String[] arr) {
		sort(arr, 0, arr.length - 1);
    }

    private void sort(String[] arr, int links, int rechts) {

        if (rechts - links <= 0) {
            return;
        }
        int pivot = (int) ((Math.random() * (rechts - links)) + links);
        // int pivot = (rechts+links)/2;
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
