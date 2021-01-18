package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Register {


    public void newMark(Path path, int mark) {

        try {

            if (Files.exists(path)) {
                Files.writeString(path, mark + "\n", StandardOpenOption.APPEND);

            } else Files.writeString(path, Integer.toString(mark));

        } catch (IOException ioe) {
            throw new IllegalStateException("Can't open the file" + path.getFileName());
        }
    }


    public void average(Path path) {

        try {
            List<String> marks = Files.readAllLines(path);

            double sum = 0;
            for (String mark : marks) {
                sum += Double.parseDouble(mark);
            }

            Files.writeString(path, "average: " + (sum / marks.size()), StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't open the file" + path.getFileName());
        }
    }
}
