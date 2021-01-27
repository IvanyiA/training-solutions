package week13d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

    Airport airport = new Airport();

    @Test
    private void readFilesTest() {
        airport.readFiles();
        assertEquals("BH2946", airport.getFlies().get(9).getRegNumber());
    }

    @Test
    void whichIsMoreTest() {
        airport.readFiles();
        assertEquals("Departure", airport.whichIsMore());
    }

    @Test
    void searchFlyByRegNumberTest() {
        airport.readFiles();
        assertEquals("Dublin", airport.searchFlyByRegNumber("FC5354").getCity());
        assertThrows(IllegalArgumentException.class,()->{
            airport.searchFlyByRegNumber("AB1234");
        });
    }

    @Test
    void searchFliesByCityTest() {
        airport.readFiles();
        assertEquals(3, airport.searchFliesByCity("Budapest", "Arrival").size());
    }

    @Test
    void searchEarliestFlyTest() {
        airport.readFiles();
        assertEquals("FG3210", airport.searchEarliestFly().getRegNumber());
    }
}