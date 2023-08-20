



public class Selectionsort extends Sortieralgorithmus {


	@Override
	public void sortiereArray(String[] arr) {
		for (int i = 0; i < arr.length-1;i++) {
			int min_idx = i;
			for (int j = i+1; j < arr.length; j++) {
				if (!vergleicheArrayPositionenKleinerGleich(arr, min_idx, j)) {
					min_idx = j;
				}
			}
			if (i!=min_idx) {
				vertausche(arr, i, min_idx);
			}
		}
	}
}
