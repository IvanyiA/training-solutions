package week05d02;

public class ChangeLetter {

    public static final String VOWELS = "aeiou";
    public static final String REPLACE_CHAR = "*";

    public String changeVowels(String target) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            String c = target.substring(i, i + 1);
            if (VOWELS.contains(c)) {
                builder.append(REPLACE_CHAR);
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
