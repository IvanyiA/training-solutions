package week14d01;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IndexerTest {

    @Test
    public void indexTest() {
        Indexer indexer=new Indexer();
        List<String> inputList =new ArrayList<>(Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna", "Lajos", "Lujza"));

        Map<Character, List<String>> expected = new HashMap<>();
        expected.put('L', Arrays.asList("Lujza", "Lajos", "Lujza"));
        expected.put('A', Arrays.asList("Abraham"));
        expected.put('M', Arrays.asList("Magdolna"));
        expected.put('O', Arrays.asList("Odon"));

        Map<Character, List<String>> actualResult = indexer.index(inputList);
        assertEquals(expected, actualResult);

        System.out.println(actualResult);

    }

}