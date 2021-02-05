package week14d04;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTransformOperations {

    public List<Employee> transformToUppercased(List<Employee> employeesConstructorStringParameter) {
        List<Employee> uppercasedEmployeesNewEmptyList = new ArrayList<>();

        for (Employee employeeConstructorStringParameter : employeesConstructorStringParameter) {
            Employee reallyNewObject = new Employee(employeeConstructorStringParameter.getName().toUpperCase());
            uppercasedEmployeesNewEmptyList.add(reallyNewObject);
//            uppercasedEmployeesNewEmptyList.add(employeeConstructorStringParameter.ownToUppercaseMethod());
//            ez már az Employee osztályban hozza létre az új objektumot, nagybetűsítve
        }
        return uppercasedEmployeesNewEmptyList;
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("John Doe"),
                new Employee("Jack Doe"),
                new Employee("Jane Doe"));

        List<Employee> result = new EmployeeTransformOperations().
                transformToUppercased(employees);

        System.out.println(employees);
        System.out.println(result);
    }
}
