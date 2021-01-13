package week06d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {

    @Test
    public void testIsIncreasing() {

        assertEquals(Series.Type.INC, new Series().calculateSeriesType(List.of(1, 2, 3, 4)));
    }

    @Test
    public void testIsDecreasing() {

        assertEquals(Series.Type.DEC, new Series().calculateSeriesType(List.of(4, 3, 2, 1)));
    }

    @Test
    public void testIsRandom() {

        assertEquals(Series.Type.RANDOM, new Series().calculateSeriesType(List.of(4, 3, 4, 1)));
    }

    @Test
    public void testExceptions() {

        assertThrows(IllegalArgumentException.class, () ->
        {
            new Series().calculateSeriesType(List.of(1));
        });
    }

}