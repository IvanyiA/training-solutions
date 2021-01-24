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

            int size;
            while ((size = inputStream.read(buffer)) > 0) {
                //for (byte character : buffer) {} állítólag nem jó, mert ha az utolsó adagnál a puffer kapaciása nagyobb, mint a maradék beolvasandó, akkor feltölti a maradékkal puffert, de a puffer fennmaradó részében bennemarad az előző beolvasás egy része, habár nekem működött az eredeti verzió is.
                for (int i = 0; i < size; i++) {
//                    if (character == 97) {
                        if (buffer[i] == 97) {
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
