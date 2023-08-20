import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.commons.cli.*;

/**
 * Kommandozeileninterface für Sortkomp. Aufruf mit "java SortkompCLI -h" für Hilfe.
 * <p>
 * Die Nutzung ist optional. Das Framework kann auch direkt über die Klasse Testlauf genutzt werden.
 * Die Commons CLI Library wird nur für diese Klasse benötigt.
 *
 * @author hecc79 Christian Hecker
 */
public class SortkompCLI {

    public static void main(String[] args) {

        int min = 0;
        int max = 0;
        int step = 0;

        Sortieralgorithmus algorithmus = null;
        Vorsortierung vorsortierung = null;
        HelpFormatter hf = new HelpFormatter();
        Writer writer = null;

        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        String cmd = "java SortkompCLI";

        options.addOption(new Option("h", "Zeigt diese Übersicht an."));
        options.addOption(Option.builder("algo").required().desc("Benutze den angegebenen Algorithmus").hasArg().argName("Algorithmus").build());
        options.addOption(Option.builder("min").required().desc("Mindestlänge").hasArg().argName("Mindestlänge").build());
        options.addOption(Option.builder("max").required().desc("Maximallänge").hasArg().argName("Maximallänge").build());
        options.addOption(Option.builder("step").required().desc("Schrittweite").hasArg().argName("Schrittweite").build());
        options.addOption(Option.builder("sort").required().desc("Vorsortierung").hasArg().argName("Vorsortierung").build());
        options.addOption(Option.builder("file").required().desc("Schreibe Daten in Datei").hasArg().argName("Datei").build());

        try {
            CommandLine line = parser.parse(options, args);

            if (line.hasOption("h")) {
                hf.printHelp(cmd, options);
                System.exit(0);
            }

            try {
                min = Integer.parseInt(line.getOptionValue("min"));
            } catch (NumberFormatException e) {
                throw new ParseException("Ungültige Minimallänge");
            }
            try {
                max = Integer.parseInt(line.getOptionValue("max"));
            } catch (NumberFormatException e) {
                throw new ParseException("Ungültige Maximallänge");
            }
            if (!(0 < min && min < max && max < Integer.MAX_VALUE)) {
                throw new ParseException("0 < min < max < " + Integer.MAX_VALUE);
            }
            try {
                step = Integer.parseInt(line.getOptionValue("step"));
            } catch (NumberFormatException e) {
                throw new ParseException("Ungültige Schrittweite");
            }

            try {
                algorithmus = (Sortieralgorithmus) Class.forName(line.getOptionValue("algo")).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new ParseException("Ungültiger Algorithmus(" + e + ")");
            }

            try {
                vorsortierung = (Vorsortierung) Class.forName(line.getOptionValue("sort")).getDeclaredConstructor().newInstance();
            } catch (Exception e) {

                throw new ParseException("Ungültige Vorsortierung (" + e + ")");
            }
            if (line.hasOption("file")) {
                String dateiname = line.getOptionValue("file");
                if ((new File(dateiname)).exists()) {
                    throw new RuntimeException("Datei " + dateiname + " existiert bereits und wird nicht unterschrieben.");
                }
                try {
                    writer = new BufferedWriter(new FileWriter(dateiname));
                } catch (IOException e) {
                    throw new RuntimeException("Ausgabefehler: " + e);
                }

            } else writer = new BufferedWriter(new OutputStreamWriter(System.out));

        } catch (ParseException e) {
            System.out.println("Ungültiger Aufruf");
            hf.printHelp(cmd, options);
            System.exit(1);
        }
        StringArrayGenerator gen = new StringArrayGenerator();
        Testlauf test = new Testlauf(algorithmus, vorsortierung, gen.erzeugeStringArray(), min, max, step);
        test.exportiereDaten(writer);
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Schließen des Streams: " + e.getLocalizedMessage());
        }
    }
}
