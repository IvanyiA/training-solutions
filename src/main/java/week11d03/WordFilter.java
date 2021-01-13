package week11d03;

import java.util.ArrayList;
import java.util.List;


public class WordFilter {


    public List<String> wordsWithChar(List<String> words, char c) {
        List<String> filteredList = new ArrayList<>();
        for (String word : words) {
            if (word.contains(String.valueOf(c))) {
                filteredList.add(word);
            }
        }
        return filteredList;
    }

    public List<String> wordsWithChar2(List<String> words, char c) {
        List<String> filteredList = new ArrayList<>();
        for (String word : words) {
            if (word.indexOf(c) >= 0) {
                filteredList.add(word);
            }
        }
        return filteredList;
    }
}
