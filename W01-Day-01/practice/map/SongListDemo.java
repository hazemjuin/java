import java.util.HashMap;
import java.util.Map;

public class SongListDemo {
    public static void main(String[] args) {
        // Create a HashMap to store the track list with titles as keys and lyrics as values
        Map<String, String> trackList = new HashMap<>();

        // Add songs to the track list
        trackList.put("Song 1", "Lyrics for Song 1...");
        trackList.put("Song 2", "Lyrics for Song 2...");
        trackList.put("Song 3", "Lyrics for Song 3...");
        trackList.put("Song 4", "Lyrics for Song 4...");

        // Retrieve a song by its title
        String songTitle = "Song 2";
        String songLyrics = trackList.get(songTitle);
        if (songLyrics != null) {
            System.out.println("Song title: " + songTitle);
            System.out.println("Lyrics: " + songLyrics);
        } else {
            System.out.println("Song not found: " + songTitle);
        }

        // Print out all track names and lyrics
        System.out.println("\nTrack List:");
        for (Map.Entry<String, String> entry : trackList.entrySet()) {
            String trackTitle = entry.getKey();
            String lyrics = entry.getValue();
            System.out.println("Track: " + trackTitle);
            System.out.println("Lyrics: " + lyrics + "\n");
        }
    }
}
