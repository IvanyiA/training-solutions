package week05d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    @Test
    public void createSong() {
        Song song = new Song("dalcím", 365, "előadó");
        assertEquals("dalcím", song.getName());
        assertEquals(365, song.getLengthInSeconds());
        assertEquals("előadó", song.getArtist());
    }

    @Test
    public void emptyName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Song("", 365, "előadó"));
        assertEquals("Name is needed.", exception.getMessage());
    }

}