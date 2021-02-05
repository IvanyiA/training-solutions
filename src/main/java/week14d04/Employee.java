package week14d04;

public class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Employee ownToUppercaseMethod(){
        return new Employee(name.toUpperCase());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
