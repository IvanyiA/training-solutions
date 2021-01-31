package week13d04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TemplateMergerTest {

    @Test
    public void mergeTest() {
        TemplateMerger templateMerger = new TemplateMerger();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", 1980));
        employees.add(new Employee("Jack Doe", 1990));

        String result = templateMerger.merge(Path.of("employee-template.txt"), employees);

        assertEquals("Az alkalmazott neve: John Doe, születési éve: 1980\n" +
                "Az alkalmazott neve: Jack Doe, születési éve: 1990\n", result);

    }

}