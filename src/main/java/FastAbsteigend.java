import java.util.Random;

public class FastAbsteigend implements Vorsortierung {

	@Override
	public void sortiereVor(String[] arr) {
		// Sortiere das Array zunaechst absteigend.
		(new Absteigend()).sortiereVor(arr);

		Random random = new Random();

		int max = (int) Math.floor(arr.length * 0.05);
		int zaehler = 0;

		while (zaehler < max) {
			int l = random.nextInt(arr.length);
			int r = random.nextInt(arr.length);
			if ((l<r && arr[l].compareTo(arr[r]) == 1)||(r<l && arr[r].compareTo(arr[l]) == 1)) {
				String tmp = arr[l];
				arr[l] = arr[r];
				arr[r] = tmp;
				zaehler++;
			}
		}
	}
}
