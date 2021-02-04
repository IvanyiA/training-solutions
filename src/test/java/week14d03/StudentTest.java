package week14d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    public void createStudent() {
        Student student = new Student("John");

        assertEquals("John", student.getStudentName());
        assertEquals(0, student.getNotes().size());
    }

    @Test
    public void addNoteTest(){
        Student student = new Student("John");

        student.addNote("math", 4);
        assertEquals(1, student.getNotes().size());

        student.addNote("math", 5);
        assertEquals(1, student.getNotes().size());

        student.addNote("biology", 3);
        assertEquals(2, student.getNotes().size());

        assertEquals(5, student.getNotes().get("math").get(1));
        assertEquals(3, student.getNotes().get("biology").get(0));


    }

}