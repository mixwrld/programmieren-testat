import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "playlist.csv";
        PlaylistReader reader = new PlaylistReader();

        try {
            // 1. Daten einlesen (Eingabe)
            List<Song> playlist = reader.loadData(filePath);

            // 2. Daten verarbeiten (Logik)
            PlaylistAnalyzer analyzer = new PlaylistAnalyzer(playlist);
            int totalDuration = analyzer.calculateTotalDuration();
            Song longestSong = analyzer.findLongestSong();
            double averageDuration = analyzer.calculateAverageDuration();

            // 3. Ergebnisse ausgeben (Ausgabe)
            System.out.println("--- Spotify Playlist Analyse ---");
            System.out.println("Anzahl der Songs: " + playlist.size());
            System.out.println("Gesamtdauer: " + totalDuration + " Sekunden");
            System.out.printf("Durchschnittliche Dauer: %.2f Sekunden%n", averageDuration);

            if (longestSong != null) {
                System.out.println("Längster Song: '" + longestSong.getTitle() + 
                                   "' von " + longestSong.getArtist() +
                                   " (" + longestSong.getDurationInSeconds() + " Sek.)");
            }

        } catch (FileNotFoundException e) {
            System.err.println("Fehler: Die Datei '" + filePath + "' wurde nicht gefunden.");
        } catch (NumberFormatException e) {
            System.err.println("Fehler: Die CSV-Datei enthält ungültige Zahlenwerte.");
        }
    }
}