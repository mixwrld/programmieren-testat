public class Song {
    private String title;
    private String artist;
    private int durationInSeconds;

    public Song(String title, String artist, int durationInSeconds) {
        this.title = title;
        this.artist = artist;
        this.durationInSeconds = durationInSeconds;
    }

    public String getTitle() { 
        return title; 
    }
    
    public String getArtist() { 
        return artist; 
    }
    
    public int getDurationInSeconds() { 
        return durationInSeconds; 
    }
}