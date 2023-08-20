/**
 * Abstrakte Oberklasse für alle Sortierverfahren
 *
 * @author hecc79 Christian Hecker
 */
public abstract class Sortieralgorithmus {

    private int schreiboperationen, leseoperationen, vergleiche, vertauschungen;

    public Sortieralgorithmus() {
        reset();
    }

    /**
     * @return Anzahl der durchgeführten Leseoperationen
     */
    public int getLeseoperationen() {
        return leseoperationen;
    }

    /**
     * @return Anzahl der durchgeführten Schreiboperationen
     */
    public int getSchreiboperationen() {
        return schreiboperationen;
    }

    /**
     * @return Anzahl der durchgeführten Vergleiche
     */
    public int getVergleiche() {
        return vergleiche;
    }

    /**
     * @return Anzahl der durchgeführten Vertauschungen
     */
    public int getVertauschungen() {
        return vertauschungen;
    }

    /**
     * Löscht alle erfassten Protokolldaten
     */
    public void reset() {
        schreiboperationen = 0;
        leseoperationen = 0;
        vergleiche = 0;
        vertauschungen = 0;
    }

    /**
     * Sortiert das Array arr aufsteigend. Diese Methode muss in allen erbenden
     * Klassen implementiert werden. Bei der Implementierung ist darauf zu
     * achten, dass die Methoden zur Operationszählung verwendet werden.
     *
     * @param arr zu sortierendes Array
     */
    public abstract void sortiereArray(String[] arr);

    /**
     * Vergleicht zwei Strings in einem String[], protokolliert dabei die
     * Operationen
     *
     * @param arr Array
     * @param a   Index des ersten Strings im Array
     * @param b   Index des zweiten Strings im Array
     * @return true, wenn arr[a]<=arr[b]
     */
    public boolean vergleicheArrayPositionenKleinerGleich(String[] arr, int a, int b) {
        return vergleicheKleinerGleich(arr[a], arr[b]);
    }

    /**
     * Vergleicht zwei Strings a ≤ b, protokolliert dabei die Operationen
     *
     * @param a String a
     * @param b String b
     * @return true, wenn a<=b
     */
    public boolean vergleicheKleinerGleich(String a, String b) {
        this.zaehleVergleich();
        return a.compareTo(b) <= 0;
    }

    /**
     * Vertauscht im Array arr die Werte an Position i mit denen der Position j.
     * Die Vertauschung wird als eine Vertauschungsoperation gezählt.
     *
     * @param arr Das Array, in dem zwei Werte getauscht werden sollen.
     * @param i   Eine gültige Position in arr
     * @param j   Eine gültige Position in arr != i
     */
    public void vertausche(String[] arr, int i, int j) {
        // Überprüfung der Parameter
        if ((i > arr.length) || (i < 0) || (j > arr.length) || (j < 0) || (i == j)) {
            throw new IllegalArgumentException(i + " " + j);
        }

        // Führe Vertauschung durch
        String swp = arr[i];
        arr[i] = arr[j];
        arr[j] = swp;

        // Zähle Vertauschung
        this.zaehleVertauschung();
    }

    public void zaehleLeseoperation() {
        this.zaehleLeseoperationen(1);
    }

    public void zaehleLeseoperationen(int anzahl) {
        // Überprüfung der Parameter
        if (anzahl <= 1) {
            throw new IllegalArgumentException();
        }
        leseoperationen += anzahl;
    }

    public void zaehleSchreiboperation() {
        this.zaehleSchreiboperationen(1);
    }

    public void zaehleSchreiboperationen(int anzahl) {
        schreiboperationen += anzahl;
    }

    public void zaehleVergleich() {
        this.zaehleVergleiche(1);
    }

    public void zaehleVergleiche(int anzahl) {
        // Überprüfung der Parameter
        if (anzahl < 1) {
            throw new IllegalArgumentException();
        }
        vergleiche += anzahl;
        leseoperationen += anzahl * 2;
    }

    public void zaehleVertauschung() {
        this.zaehleVertauschungen(1);
    }

    public void zaehleVertauschungen(int anzahl) {
        // Überprüfung der Parameter
        if (anzahl < 1) {
            throw new IllegalArgumentException();
        }
        vertauschungen += anzahl;
        leseoperationen += anzahl * 3;
        schreiboperationen += anzahl * 3;
    }

}
