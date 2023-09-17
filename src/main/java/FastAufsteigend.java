import java.util.Random;

/**
 * Die Daten sind fast absteigend vorsortiert. Ca. 10 % der Einträge werden paarweise vertauscht.
 *
 * @author hecc79 Christian Hecker
 */
public class FastAufsteigend extends Vorsortierung {

    @Override
    public void sortiereVor(String[] arr) {
        // Sortiere das Array zunächst absteigend.
        (new Aufsteigend()).sortiereVor(arr);

        Random random = new Random();

        int max = (int) Math.floor(arr.length * 0.05);
        int i = 0;

        while (i < max) {
            int l = random.nextInt(arr.length);
            int r = random.nextInt(arr.length);
            if ((l < r && arr[l].compareTo(arr[r]) > 0) || (r < l && arr[r].compareTo(arr[l]) > 0)) {
                String tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                i++;
            }
        }
    }
}
