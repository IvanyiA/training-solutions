package week06d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ListSelectorTest {

    ListSelector ls = new ListSelector();

    @Test
    public void getEvenIndexElement() {
        assertEquals("[almabarack]", ls.getEvenIndexElement(Arrays.asList("alma", "körte", "barack")));
    }

    @Test
    public void getEvenIndexElementsWithNull() {
        assertThrows(IllegalArgumentException.class, () -> ls.getEvenIndexElement(null));
    }

    @Test
    public void getEvenIndexElementsWithEmptyList() {
        assertEquals("", ls.getEvenIndexElement(Arrays.asList()));
    }

}