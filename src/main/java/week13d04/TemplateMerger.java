package week13d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TemplateMerger {

    public String merge(Path template, List<Employee> employees) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String line = Files.readString(template);
            for (Employee employee : employees) {
                String replaced = line.replace("{nev}", employee.getName());
                replaced = replaced.replace("{ev}", Integer.toString(employee.getYearOfBirth()));
//                System.out.println(replaced);
                stringBuilder.append(replaced).append("\n");

            }
            return stringBuilder.toString();

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public static void main(String[] args) {
        Path template = Path.of("employee-template.txt");
        List<Employee> employees = List.of(
                new Employee("John Doe", 1980),
                new Employee("Jack Doe", 1990));

        String result = new TemplateMerger().merge(template, employees);
        System.out.println(result);
    }
}
