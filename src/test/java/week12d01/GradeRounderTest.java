package week12d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GradeRounderTest {

    @Test
    void roundGradesTest() {

        GradeRounder gradeRounder = new GradeRounder();

        int[] grades = new int[]{38,89,86};

        assertEquals("[38, 90, 86]", Arrays.toString(gradeRounder.roundGrades(grades)));

    }
}