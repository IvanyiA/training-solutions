package week05d05;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {

    Song song1 = new Song("a", 60, "a");
    Song song2 = new Song("b", 120, "b");
    Song song3 = new Song("c", 180, "c");

    List<Song> songs = new ArrayList<>(List.of(song1, song2, song3));

    Playlist playlist = new Playlist(songs);

    @Test
    void findByLengthGreaterThan() {

        assertEquals(2, playlist.findByLengthGreaterThan(1).size());
    }

    @Test
    void toStringTest() {
        assertEquals("dalnév=a, dalhossz=60, előadó=a; " +
                "dalnév=b, dalhossz=120, előadó=b; " +
                "dalnév=c, dalhossz=180, előadó=c; ", playlist.toString(songs));
    }

    @Test
    void greaterThanToStringTest() {
        assertEquals("dalnév=b, dalhossz=120, előadó=b; " +
                "dalnév=c, dalhossz=180, előadó=c; ", playlist.toString(playlist.findByLengthGreaterThan(1)));
    }


}