package week05d05;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private List<Song> songs;

    public Playlist(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> findByLengthGreaterThan(int mins) {
        List<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getLengthInSeconds() > mins * 60L) {
                result.add(song);
            }
        }
        return result;
    }

    public String toString(List<Song> songs) {
        String songsToString = "";
        for (Song song : songs) {
            songsToString += "dalnév=" + song.getName() +
                    ", dalhossz=" + song.getLengthInSeconds() +
                    ", előadó=" + song.getArtist() + "; ";
        }
        return songsToString;
    }
}
