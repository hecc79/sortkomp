import java.util.Arrays;

/**
 * Die Daten werden aufsteigend vorsortiert. Das Feld ist bereits vor dem Aufruf des Sortieralgorithmus korrekt
 * sortiert.
 *
 * @author hecc79 Christian Hecker
 */
public class Aufsteigend implements Vorsortierung {
    @Override
    public void sortiereVor(String[] arr) {
        Arrays.sort(arr);
    }
}
