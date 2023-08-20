



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;



public class Testlauf {

	private final Sortieralgorithmus alg;

	private final Vorsortierung sort;


	private final int[] arraylaengen;
	private final long[] leseoperationen;
	private final long[] schreiboperationen;
	private final long[] vergleiche;
	private final long[] vertauschungen;

	public Testlauf(Sortieralgorithmus alg, Vorsortierung sort, String[] arr,
					int min, int max, int step) {
		super();
		this.alg = alg;
		this.sort = sort;


		int length = (max - min) / step + 1;

		arraylaengen = new int[length];
		for (int i = 0; i < length; i++)
			arraylaengen[i] = min + (i * step);
		leseoperationen = new long[length];
		schreiboperationen = new long[length];
		vergleiche = new long[length];
		vertauschungen = new long[length];

		for (int i = 0; i < arraylaengen.length; i++) {
			alg.reset();
			String[] a = Arrays.copyOf(arr, arraylaengen[i]);
			alg.sortiereArray(a);
			leseoperationen[i] = alg.getLeseoperationen();
			schreiboperationen[i] = alg.getSchreiboperationen();
			vergleiche[i] = alg.getVergleiche();
			vertauschungen[i] = alg.getVertauschungen();
		}

	}

    public static void starteTestlauf(Sortieralgorithmus algorithmus, Vorsortierung vorsortierung,
									  int min, int max, int step, String dateiname) {
        Writer writer;
        try {
            writer = new BufferedWriter(new FileWriter(dateiname));
        } catch (IOException e) {
            throw new RuntimeException("Ausgabefehler: " + e);
        }

        Testlauf lauf = new Testlauf(algorithmus, vorsortierung, new StringArrayGenerator().erzeugeStringArray(), min, max, step);
        lauf.exportiereDaten(writer);
    }

    /**
	 * Exportiert die gesammelten Daten in eine CSV Textdatei.
	 * 
	 * @param dateiname
	 *            Name der Datei, in die die Daten exportiert werden sollen. Die
	 *            Datei darf noch nicht existieren.
	 */

	public void exportiereDaten(String dateiname) {

		try {
			Writer writer = new BufferedWriter(new FileWriter(dateiname));
			exportiereDaten(writer);
			writer.close();
		} catch (Exception e) {
			System.err.println("Fehler beim Schreiben der Datei " + dateiname);
			System.exit(1);
		}

	}

	public void exportiereDaten(Writer w) {

		try {
			
			String separator = ";";
			w.write("n" + separator + "vergleiche" + separator
					+ "vertauschungen" + separator + "leseoperationen"
					+ separator + "schreiboperationen" + separator
					+ "algorithmus" + separator + "vorsortierung" + "\n");
			for (int i = 0; i < this.arraylaengen.length; i++) {
				w.write(this.arraylaengen[i] + separator
						+ this.vergleiche[i] + separator
						+ this.vertauschungen[i] + separator
						+ this.leseoperationen[i] + separator
						+ this.schreiboperationen[i] + separator
						+ alg.getClass().getSimpleName() + separator
						+ sort.getClass().getSimpleName() + "\n");
			}
			w.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
