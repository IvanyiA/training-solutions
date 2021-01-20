package ioreadbytes.byteacount;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {


    public int readBytesAndFindCharacterA(String fileName) {

        Path path = Path.of(fileName);

        int sumOfCharacterA = 0;
        try (InputStream inputStream = Files.newInputStream(path)) {
            byte[] buffer = new byte[1000];

            int size = 0;
            while ((size = inputStream.read(buffer)) > 0) {

                for (byte character : buffer) {
                    if (character == 97){
                        sumOfCharacterA++;
                    }
                }
            }

        } catch (IOException e) {
            throw new IllegalStateException("Can't find file!", e);
        }
        return sumOfCharacterA;
    }
}
