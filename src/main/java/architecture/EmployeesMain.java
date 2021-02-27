package architecture;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class EmployeesMain {

    public static void main(String[] args) {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?userUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot create data source", se);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();

//        Flyway flyway1 = Flyway.configure().locations("db/migration/db1")dataSource(dataSource1).load();  táblák elkülönített létrehozásához
//        Flyway flyway2 = Flyway.configure().locations("db/migration/db2")dataSource(dataSource2).load();  1 datasource 1 könyvtár, és abból mindet végrehajt

        flyway.clean();

//        try (
//                Connection connection = dataSource.getConnection();
//                Statement statement = connection.createStatement();
//        ) {
//            statement.execute("delete from employees");
//        } catch (SQLException se) {
//            throw new IllegalStateException("Cannot empty");
//        }

        flyway.migrate();

        EmployeeDao employeeDao = new EmployeeDao(dataSource);

        employeeDao.createEmployee("Jane Doe");

        List<String> names = employeeDao.listEmployeeNames();
        System.out.println(names);

        String name = employeeDao.findEmployeeNameById(1L);
        System.out.println(name);
    }

}
