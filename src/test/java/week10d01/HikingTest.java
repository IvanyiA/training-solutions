package week10d01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HikingTest {

    @Test
    void getPlusElevation() {

        Hiking hiking = new Hiking();

        double elevation = hiking.getPlusElevation(List.of(10.0,20.0,15.0,18.0));
        assertEquals(13, elevation);
    }
}