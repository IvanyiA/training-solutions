package week14d01;

import java.util.*;

public class Indexer {

    public static void main(String[] args) {
        System.out.println(new Indexer().index(Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna", "Lajos", "Lujza")));
        // {A=[Abraham], L=[Lujza, Lajos], M=[Magdolna], O=[Odon]

//        Map feltöltése teszthez, ehhez jó a Map.of metódus 10 elemig.
//        Map<Character, List<String>> expected = new HashMap<>();
//        expected.put('A', Arrays.asList("Abraham"));
//        expected.put('L', Arrays.asList("Lujza"));
//
//        Map<Character, List<String>> expected2 =
//                Map.of('A', Arrays.asList("Abraham"), 'L', Arrays.asList("Lujza"));
    }

    public Map<Character, List<String>> index(List<String> names) {
        Map<Character, List<String>> namesByInitial = new HashMap<>();

        for (String name : names) {

            char initial = name.charAt(0);
            if (!namesByInitial.containsKey(initial)) {
                namesByInitial.put(initial, new ArrayList<>());
            }
            namesByInitial.get(initial).add(name);
        }
        return namesByInitial;
    }

}
