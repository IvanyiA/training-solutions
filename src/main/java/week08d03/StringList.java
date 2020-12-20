package week08d03;

import java.util.*;

public class StringList {

    public List<String> stringListsUnion(List<String> first, List<String> second) {
        List<String> unio = new ArrayList<>(toUppercaseLists(first));

        for (String s : second) {
            if (!unio.contains(s.toUpperCase())) {
                unio.add(s.toUpperCase());
            }
        }
        Collections.sort(unio);
        return unio;
    }

    private List<String> toUppercaseLists(List<String> imput) {
        List<String> upperCased = new ArrayList<>();

        for (String s : imput) {
            upperCased.add(s.toUpperCase());
        }
        return upperCased;
    }


    private boolean containsIgnoreCase(List<String> words, String element) {
        for (String s : words) {
            if (s.toUpperCase().equals(element.toUpperCase())) {
                return true;
            }
        }
        return false;
    }



}
