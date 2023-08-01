

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.commons.cli.*;


public class Sortkomp {

    public static void main(String[] args) {

        int min = 0;
        int max = 0;
        int step = 0;

        SortierAlgorithmus algorithmus = null;
        Vorsortierung vorsortierung = null;
        HelpFormatter hf = new HelpFormatter();
        Writer writer = null;

        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        String cmd = "java Sortkomp";

        options.addOption(new Option("h", "Zeigt diese Übersicht an."));
        options.addOption(Option.builder("algo").required()
                .desc("Benutze den angegebenen Algorithmus")
                .hasArg().argName("Algorithmus").build()
        );
        options.addOption(Option.builder("min").required().desc("Mindestlaenge").hasArg().argName("Mindestlaenge").build());
        options.addOption(Option.builder("max").required().desc("Maximallaenge").hasArg().argName("Maximallaenge").build());
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
                throw new ParseException("Ungueltige Minimallaenge");
            }
            try {
                max = Integer.parseInt(line.getOptionValue("max"));
            } catch (NumberFormatException e) {
                throw new ParseException("Ungueltige Maximallaenge");
            }
            if (!(0 < min && min < max && max < Integer.MAX_VALUE)) {
                throw new ParseException("0 < min < max < " + Integer.MAX_VALUE);
            }
            try {
                step = Integer.parseInt(line.getOptionValue("step"));
            } catch (NumberFormatException e) {
                throw new ParseException("Ungueltige Schrittweite");
            }

            try {
                algorithmus = (SortierAlgorithmus) Class.forName(
                                line.getOptionValue("algo"))
                        .getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new ParseException("Ungueltiger Algorithmus("
                        + e + ")");
            }

            try {
                vorsortierung = (Vorsortierung) Class.forName(
                                line.getOptionValue("sort"))
                        .getDeclaredConstructor().newInstance();
            } catch (Exception e) {

                throw new ParseException("Ungueltige Vorsortierung ("
                        + e + ")");
            }
            if (line.hasOption("file")) {
                String dateiname = line.getOptionValue("file");
                if ((new File(dateiname)).exists()) {
                    throw new RuntimeException(
                            "Datei "
                                    + dateiname
                                    + " existiert bereits und wird nicht ueberschrieben.");
                }
                try {
                    writer = new BufferedWriter(new FileWriter(dateiname));
                } catch (IOException e) {
                    throw new RuntimeException("Ausgabefehler: " + e);
                }

            } else
                writer = new BufferedWriter(new OutputStreamWriter(System.out));

        } catch (ParseException e) {
            System.out.println("Ungueltiger Aufruf");
            hf.printHelp(cmd, options);
            System.exit(1);
        }
        StringArrayGenerator gen = new StringArrayGenerator();
        Testlauf test = new Testlauf(algorithmus, vorsortierung,
                gen.erzeugeStringArray(), min, max, step);
        test.exportiereDaten(writer);
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Schließen des Streams: "
                    + e.getLocalizedMessage());
        }

    }

    public static void starteTestlauf(SortierAlgorithmus algorithmus, Vorsortierung vorsortierung,
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

}
