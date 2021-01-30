package collectionsset.collectionstreeset;

import java.util.Set;
import java.util.TreeSet;

public class WordFilter {

    public Set<String> filterWords(String[] randomStrings) {
        Set<String> orderedString = new TreeSet<String>();
        for (String str : randomStrings) {
            orderedString.add(str);
        }
        return orderedString;
    }
}
