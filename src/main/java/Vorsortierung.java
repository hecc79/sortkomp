/**
 * Gemeinsames Interface für alle Vorsortierungen
 * <p>
 * In Sortkomp können verschiedene Vorsortierungen vor der Anwendung des eigentlichen Sortieralgorithmus auf die
 * Ursprungsdaten angewandt werden.
 *
 * @author hecc79 Christian Hecker
 */
public abstract class Vorsortierung {
    /**
     * Sortiert das übergebene Feld arr vor, bevor die Sortieralgorithmen die Daten sortieren.
     *
     * @param arr Das vorzusortierende Feld
     */
    public abstract void sortiereVor(String[] arr);

    public static Vorsortierung getVorsortierung(String klassenname) {
        try {
            return (Vorsortierung) Class.forName(klassenname).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }

}