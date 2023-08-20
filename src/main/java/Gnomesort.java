



public class Gnomesort extends Sortieralgorithmus {

	@Override
	public void sortiereArray(String[] arr) {
		int position = 0;
		while (position < arr.length - 1) {
			if (vergleicheKleinerGleich(arr[position], arr[position + 1]))
				position++;
			else {
				vertausche(arr, position, position + 1);
				if (position == 0)
					position++;
				else
					position--;
			}
		}
	}
}
