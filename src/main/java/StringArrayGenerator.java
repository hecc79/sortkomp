


import java.util.Random;

public class StringArrayGenerator {
	private char[] alphabet;
	private Random zufallszahlGenerator;

	public StringArrayGenerator() {
		super();
		this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
				.toCharArray();
		zufallszahlGenerator = new Random();
	}

	private String erzeugeZufaelligesWort(int minBuchstaben, int maxBuchstaben) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < zufallszahlGenerator.nextInt(maxBuchstaben
				- minBuchstaben) + 1; i++) {
			sb.append(alphabet[zufallszahlGenerator.nextInt(alphabet.length)]);
		}
		return sb.toString();
	}

	public String[] erzeugeStringArray(int laenge, int minWortlaenge,
			int maxWortlaenge) {
		String[] ergebnis = new String[laenge];
		for (int i = 0; i < laenge; i++)
			ergebnis[i] = erzeugeZufaelligesWort(minWortlaenge, maxWortlaenge);
		return ergebnis;
	}

	public String[] erzeugeStringArray() {
		return erzeugeStringArray(1000000, 5, 50);
	}

}
