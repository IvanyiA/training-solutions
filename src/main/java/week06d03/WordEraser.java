package week06d03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordEraser {

    public String eraseWord(String words, String word) {
        String[] arr = words.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String item : arr) {
            if (!item.equals(word)) {
                sb.append(item + " ");
            }
        }
        return sb.toString().trim();
    }

    public String eraseWordWithScanner(String words, String word) {
        Scanner scanner = new Scanner(words);
        StringBuilder result = new StringBuilder();

        while (scanner.hasNext()) {
            String s = scanner.next();
            if (!word.equals(s)) {
                result.append(s + " ");
            }
        }
        return result.toString().trim();
    }

    public String eraseWordWithList(String words, String word) {

        List<String> filteredList = new ArrayList<>();
        String[] wordsArray= words.split(" ");

        for (String item: wordsArray){
            if (!item.equals(word)){
                filteredList.add(item);
            }
        }
        return String.join(" ", filteredList);
    }

}
