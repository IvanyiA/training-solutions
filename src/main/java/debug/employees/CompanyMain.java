package debug.employees;

import java.util.ArrayList;
import java.util.List;

public class CompanyMain {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Kovács Szilveszter", 1986);
        Employee employee2 = new Employee("Kovács Szilvia", 1987);
        Employee employee3 = new Employee("Nagy Jenő", 1981);

        Company company = new Company(new ArrayList<>());

        company.addEmployee(employee1);
        company.addEmployee(employee2);
        company.addEmployee(employee3);

        Employee nagy = company.findEmployeeByName("Nagy Jenő");
        System.out.println(nagy.getName() + " " + nagy.getYearOfBirth());

        List<String> names = company.listEmployeeNames();
        System.out.println(names);
    }
}



