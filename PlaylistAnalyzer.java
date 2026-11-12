import java.util.List;

public class PlaylistAnalyzer {
    private List<Song> songs;

    public PlaylistAnalyzer(List<Song> songs) {
        this.songs = songs;
    }

    public int calculateTotalDuration() {
        int total = 0;
        for (Song song : songs) {
            total += song.getDurationInSeconds();
        }
        return total;
    }

    public Song findLongestSong() {
        if (songs.isEmpty()) {
            return null;
        }

        Song longest = songs.get(0);
        for (Song song : songs) {
            if (song.getDurationInSeconds() > longest.getDurationInSeconds()) {
                longest = song;
            }
        }
        return longest;
    }

    public double calculateAverageDuration() {
        if (songs.isEmpty()) {
            return 0.0;
        }
        return (double) calculateTotalDuration() / songs.size();
    }
}