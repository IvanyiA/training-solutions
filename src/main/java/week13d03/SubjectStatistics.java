package week13d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SubjectStatistics {

    private List<Subject> data = new ArrayList<>();

    public void readFromFile(String fileName) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(fileName))) {

            String[] block = new String[4];

            while ((block[0] = bufferedReader.readLine()) != null) {
                data.add(readBlock(bufferedReader, block));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file.", e);
        }
    }

    private Subject readBlock(BufferedReader bufferedReader, String[] block) throws IOException {
        for (int i = 1; i < 4; i++) {
            block[i] = bufferedReader.readLine();
        }
        return new Subject(block[0], block[1], block[2], Integer.parseInt(block[3]));
    }

    public int count(String name) {
        int sumHours = 0;
        for (Subject subject : data) {
            if (subject.getTeacherName().equals(name)) {
                sumHours += subject.getTaughtHoursNumber();
            }
        }
        return sumHours;
    }

    //"egyből olvasom, és dolgozom is fel"
    public int sumLessonsOfTeacherFromFile(String file, String teacherName) {
        int sum = 0;
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (line.equals(teacherName)) {
                    skipTwoLines(bufferedReader);
                    sum += Integer.parseInt(bufferedReader.readLine());
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file.", e);
        }
        return sum;
    }

    private void skipTwoLines(BufferedReader bufferedReader) throws IOException {
        bufferedReader.readLine();
        bufferedReader.readLine();
    }

}


