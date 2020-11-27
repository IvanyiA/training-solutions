package week05d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListCounterTest {

    @Test

    public void startsWithACounter() {
        ListCounter listCounter = new ListCounter();
        List<String> testlist = Arrays.asList("Alma", "körte", "szilva", "ananász", "meggy");

        assertEquals(2, listCounter.startsWithACounter(testlist));
    }

    @Test

    public void startWithAEmptyListTest() {
        ListCounter listCounter = new ListCounter();
        List<String> testlist = new ArrayList<>();

        assertEquals(0, listCounter.startsWithACounter(testlist));
    }

    @Test

    public void startsWithANonAListTest(){
        ListCounter listCounter= new ListCounter();
        List<String> testlist= Arrays.asList("körte", "szilva");

        assertEquals(0, listCounter.startsWithACounter(testlist));
    }
}