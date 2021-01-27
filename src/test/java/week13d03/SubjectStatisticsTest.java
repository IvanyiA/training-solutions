package week13d03;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SubjectStatisticsTest {

    @Test
    public void testTeacher() throws IOException {

        SubjectStatistics subjectStatistics = new SubjectStatistics();
        subjectStatistics.readFromFile("beosztas.txt");

        assertEquals(22, subjectStatistics.count("Csincsilla Csilla"));
    }

}