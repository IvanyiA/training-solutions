package week14d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassNotebookTest {

    @Test
    public void howToManipulateTheOriginalListThroughGetter() {
        ClassNotebook classNotebook = new ClassNotebook(new ArrayList<>(List.of(
                new Student("John"),
                new Student("Bill"))));

        classNotebook.getStudents().add(new Student("Jane"));
        System.out.println(classNotebook.getStudents().size());
    }

    @Test
    public void sortNotebookTest() {
        ClassNotebook classNotebook = new ClassNotebook(new ArrayList<>(List.of(
                new Student("John"),
                new Student("Jane"),
                new Student("Bill"),
                new Student("Jack"))));

        List<Student> result = classNotebook.sortNotebook();
        assertEquals("John", classNotebook.getStudents().get(0).getStudentName());

        assertEquals("Bill", result.get(0).getStudentName());
        assertEquals("John", result.get(3).getStudentName());




    }

}

