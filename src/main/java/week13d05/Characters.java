package week13d05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Characters {

    public int uniqueCharacterCounter(String word) {
        char[] charactersOfAWord = word.toLowerCase().toCharArray();

        Set<Character> uniqueCharacters = new HashSet<>();

        for (char character : charactersOfAWord) {
            if (isEnglishLowerCaseChar(character)) {
                uniqueCharacters.add(character);
            }
        }
        return uniqueCharacters.size();
    }

    private boolean isEnglishLowerCaseChar(char character) {
        return character >= 'a' && character <= 'z';
    }

    public Map<Character, Integer> uniqueCharacterCounterInMap(String word) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char character = word.toLowerCase().charAt(i);
            if (result.containsKey(character)) {
                result.put(character, result.get(character) + 1);
            } else {
                result.put(character, 1);
            }
        }
        return result;
    }

}
