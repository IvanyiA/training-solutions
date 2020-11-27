package week05d03;

import java.util.List;

public class ListCounter {

    public int startsWithACounter(List<String> words) {

        int count = 0;

        for (String w : words) {
            if (w.toUpperCase().startsWith("A")) {
                count++;
            }
        }
        return count;
    }

    public int startsWithACounter2(List<String> words) {

        int numberOfWordsWithA = 0;

        for (String each : words) {
            String firstLetter = each.substring(0, 1).toUpperCase();
            if ("A".equals(firstLetter)) {
                numberOfWordsWithA++;
            }
        }
        return numberOfWordsWithA;

    }

    public int startsWithACounter3(List<String> words) {

        int count = 0;

        for (String w : words) {
            if (w.toUpperCase().charAt(0) == 'A') {
                count++;
            }
        }
        return count;
    }

}
