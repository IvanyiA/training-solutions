package ioreadbytes.byteacount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ByteCheckerTest {
    ByteChecker byteChecker = new ByteChecker();


    @Test
    public void readBytesAndFindAsTest() {

        assertEquals(3, byteChecker.readBytesAndFindCharacterA("src/main/resources/data.dat"));
    }
}