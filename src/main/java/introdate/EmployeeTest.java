package introdate;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee alkalmazott = new Employee(1968, 6, 18, "Tóth Ildikó");
        System.out.println(alkalmazott.getName());
        System.out.println(alkalmazott.getDateOfBirth());
        System.out.println(alkalmazott.getBeginEmployment());
    }
}