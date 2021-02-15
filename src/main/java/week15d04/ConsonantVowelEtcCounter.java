package week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class ConsonantVowelEtcCounter {

    public ConsonantVowelEtc countAll(Reader reader) {
        ConsonantVowelEtc cve = new ConsonantVowelEtc(0, 0, 0);

        try (BufferedReader bufferedReader = new BufferedReader(reader)) {
            int ch;
            while ((ch = bufferedReader.read()) >= 0) {
                count(ch, cve);
            }

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        return cve;
    }


    private void count(int ch, ConsonantVowelEtc cve) {
        String consonants = "bBcCdDfFgGhHjJkKlLmMnNpPqQrRsStTvVwWxXyYzZ";
        String vowels = "aAáÁeEéÉiIíÍoOóÓöÖőŐuUúÚüÜűŰ";

        if (consonants.indexOf((char) ch) >= 0) {
            cve.setConsonant();
        } else if (vowels.indexOf((char) ch) >= 0){
            cve.setVowel();
        } else if((char)ch !=' '){
            cve.setEtc();
        }
    }

}
