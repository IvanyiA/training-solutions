package collectionsset.collectionshashset;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StringsHandler {


    public Set<String> filterUniqueStrings(Collection<String> testCollection) {
        Set<String> uniqueStrings = new HashSet<>(testCollection);
        return uniqueStrings;
    }

    public Set<String> selectIdenticalStrings(Set<String> strings, Set<String> anotherStrings) {
        strings.retainAll(anotherStrings);
        return strings;
    }

}