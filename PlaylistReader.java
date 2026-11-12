import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaylistReader {
    
    public List<Song> loadData(String filePath) throws FileNotFoundException {
        List<Song> songs = new ArrayList<>();
        File file = new File(filePath);

        // Der Scanner liest die Datei Zeile für Zeile
        try (Scanner scanner = new Scanner(file)) {
            
            // Kopfzeile der CSV-Datei überspringen
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                // Sicherstellen, dass die Zeile exakt 3 Spalten hat
                if (parts.length == 3) {
                    String title = parts[0].trim();
                    String artist = parts[1].trim();
                    int duration = Integer.parseInt(parts[2].trim());
                    
                    songs.add(new Song(title, artist, duration));
                }
            }
        }
        return songs;
    }
}