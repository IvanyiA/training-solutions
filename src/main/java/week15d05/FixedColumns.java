package week15d05;

import java.util.ArrayList;
import java.util.List;

public class FixedColumns {

    public static void main(String[] args) {
        String s = "alma,, \"körte, körte\", meggy,";
        StringBuilder stringBuilder = new StringBuilder();
        List<String> parts = new ArrayList<>();
        boolean insideValue = false;       //mivel egysorban szeretném az idézőjeles "körte, körtét" látni
        for (char c : s.toCharArray()) {
            if (c == '\"') {
                insideValue = !insideValue;
            }
            if (c != ',') {
                stringBuilder.append(c);
            } else {
                if (!insideValue) {       //csak akkor tegye listába, ha már kiért else if
                    parts.add(stringBuilder.toString());    //a sb alapértelmezetten whitespace-szel indul
                    stringBuilder = new StringBuilder();
                } else {
                    stringBuilder.append(",");
                }
            }
        }
        parts.add(stringBuilder.toString());
//        System.out.println(parts);
        for (String element : parts) {
            System.out.println(element);
        }
    }

}
