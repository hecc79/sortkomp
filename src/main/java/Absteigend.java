



import java.util.Arrays;


public class Absteigend implements Vorsortierung {

	@Override
	public void sortiereVor(String[] arr) {
		Arrays.sort(arr);
		for (int l = 0; l < arr.length / 2; l++) {
			int r = arr.length - 1 - l;
			String tmp = arr[l];
			arr[l] = arr[r];
			arr[r] = tmp;
		}
	}

}
