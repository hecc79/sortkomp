/**
 * Gemeinsames Interface für alle Vorsortierungen
 * <p>
 * In Sortkomp können verschiedene Vorsortierungen vor der Anwendung des eigentlichen Sortieralgorithmus auf die
 * Ursprungsdaten angewandt werden.
 *
 * @author hecc79 Christian Hecker
 */
public interface Vorsortierung {
    /**
     * Sortiert das übergebene Feld arr vor, bevor die Sortieralgorithmen die Daten sortieren.
     *
     * @param arr Das vorzusortierende Feld
     */
    void sortiereVor(String[] arr);

}