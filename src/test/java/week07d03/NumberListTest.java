package week07d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberListTest {

    NumberList list = new NumberList();

    @Test
    public void testNumberList() {
        assertTrue(list.isIncreasing2(Arrays.asList(1, 2, 2, 3)));

    }

}