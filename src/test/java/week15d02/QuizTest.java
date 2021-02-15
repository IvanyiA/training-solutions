package week15d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    Quiz quiz = new Quiz();

    @BeforeEach
    void setUp() {
        quiz.readFile(Path.of("kerdesek.txt"));
    }

    @Test
    public void readFile(){
        assertEquals(57, quiz.getQuestions().size());
    }
}