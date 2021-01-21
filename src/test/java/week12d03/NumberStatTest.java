package week12d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberStatTest {

    @Test

    public void findSmallestUnique() {
        NumberStat numberStat = new NumberStat();

        numberStat.readFromFile("src/main/resources/text.txt");
        assertEquals(2, numberStat.findSmallestUnique());

    }

}