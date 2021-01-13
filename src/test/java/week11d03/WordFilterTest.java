package week11d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordFilterTest {

    @Test
    void wordsWithChar() {

        WordFilter wordFilter = new WordFilter();

        List<String> words = new ArrayList<>(Arrays.asList("alma", "körte"));
        List<String> result = new ArrayList<>(Arrays.asList("alma"));

        assertEquals("[alma]", wordFilter.wordsWithChar(words, 'a').toString());
    }

    @Test
    void wordsWithEmptyList() {

        WordFilter wordFilter = new WordFilter();

        List<String> result = wordFilter.wordsWithChar(Arrays.asList("alma", "körte"), 'z');

        assertEquals(0, result.size());
    }



}