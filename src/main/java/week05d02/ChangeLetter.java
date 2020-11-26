package week05d02;

public class ChangeLetter {

    public static final String VOWELS = "aeiou";
    public static final String REPLACE_CHAR = "*";
    public static final char[] VOWELS_CHAR = {'a', 'e', 'i', 'o', 'u'};

    public String changeVowels(String temp) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.length(); i++) {
            String s = temp.substring(i, i + 1);
            if (VOWELS.contains(s)) {
                sb.append(REPLACE_CHAR);
            } else {
                sb.append(s);
            }
        }
        return sb.toString();
    }

    public String changeVowels2(String temp) {
        for (char c : VOWELS_CHAR) {
            temp = temp.replace(c, '*');
        }
        return temp;
    }
}
