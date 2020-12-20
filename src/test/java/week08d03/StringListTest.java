package week08d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListTest {

    @Test
    public void unionTest() {
        List<String> first = Arrays.asList("A","b","c");
        List<String> second = Arrays.asList("a","c");

        StringList stringList = new StringList();

        assertEquals(Arrays.asList("A","B","C"), stringList.stringListsUnion(first,second));

    }
}