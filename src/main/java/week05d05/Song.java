package week05d05;

import java.util.List;

public class Song {

    private final String name;
    private final long lengthInSeconds;
    private final String artist;

    public Song(String name, long lengthInSeconds, String artist) {
        parametersCheck (name, lengthInSeconds, artist);
        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getArtist() {
        return artist;
    }

    private void parametersCheck (String name, long lengthInSeconds, String artist) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is needed.");
        }
        if (lengthInSeconds <= 0){
            throw new IllegalArgumentException("Song length is missing.");
        }
        if (artist == null || artist.isBlank()) {
            throw new IllegalArgumentException("Artist is needed.");
        }
    }


}
