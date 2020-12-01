package week06d01;

import java.util.List;

public class ListSelector {

    public String getEvenIndexElement(List<String> words) {
        StringBuilder result = new StringBuilder();

        if (words == null) {
            throw new IllegalArgumentException("Null parameter not excepted!");
        }
        if (words.size() != 0) {
            result.append("[");
            for (int i = 0; i < words.size(); i += 2) {
                result.append(words.get(i));
            }
            result.append("]");
        }
        return result.toString();

    }


    public String getEvenIndexElement2(List<String> words) {
        StringBuilder result = new StringBuilder();

        if (words == null) {
            throw new IllegalArgumentException("Null parameter not excepted!");
        }
        if (words.size() != 0) {
            result.append("[");
            int i = 0;
            for (String word : words) {
                if (i % 2 == 0) {
                    result.append(word);
                }
                i++;
            }
            result.append("]");
        }
        return result.toString();
    }

    public String getEvenIndexElement3(List<String> list) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i += 2) {
            sb.append(list.get(i)).append(",");
        }
        sb.deleteCharAt(list.size()-1);
        sb.append("]");
        return sb.toString();
    }

}

