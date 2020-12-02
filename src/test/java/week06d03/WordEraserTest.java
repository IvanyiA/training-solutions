package week06d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordEraserTest {

    @Test
    public void eraseWordTest() {
        WordEraser we = new WordEraser();
        String original ="alma körte barack alma körte birsalma";
        String result ="körte barack körte birsalma";

        assertEquals(result, we.eraseWord(original, "alma"));
    }

    @Test
    public void eraseWordWithScanner (){
        WordEraser we = new WordEraser();
        String original ="alma körte barack alma körte birsalma";
        String result ="körte barack körte birsalma";

        assertEquals(result, we.eraseWordWithScanner(original, "alma"));
    }

}