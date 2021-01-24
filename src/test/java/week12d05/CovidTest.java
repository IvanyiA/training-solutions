package week12d05;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CovidTest {

    @Test
    public void testWordCounter() {
        Covid covid = new Covid();

                InputStream inputStream = CovidTest.class.getResourceAsStream("/index.html");//file classpath-ról beolvasás
        //        Path file = Path.of("src/main/resources/index.html");
//        try {
//            URL url = new URL("https://index.hu");   //hálózatról beolvasás
//            InputStream inputStream = url.openStream();
            int counter = covid.wordCounter("koronavírus", new BufferedReader(new InputStreamReader(inputStream)));
            assertEquals(1, counter);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    @Test
    public void testWordCounterWithSimpleFile() {
        Covid covid = new Covid();
//        InputStream inputStream = CovidTest.class.getResourceAsStream("/testdata.txt");//file classpath-ról beolvasás
//        Path file = Path.of("src/main/resources/testdata.txt");   //file-ból beolvasás
        String sample = "koronavírus\nalma\nkörte\nkoronavírus\nmeggy\nkoronavírus"; //memóriából beolvasás
        int counter = covid.wordCounter("koronavírus", new BufferedReader(new StringReader(sample)));
        assertEquals(3, counter);
    }

}