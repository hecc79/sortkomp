
public class Insertionsort extends SortierAlgorithmus {

	@Override
	public void sortiereArray(String[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (!this.vergleicheArrayPositionenKleinerGleich(arr, j, i)) {
					this.vertausche(arr, i, j);
				}
			}
		}
	}
}
