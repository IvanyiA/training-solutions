package architecture;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoTest {

    private EmployeeDao employeeDao;

    @BeforeEach
    public void init() {
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

        flyway.clean();
        flyway.migrate();

        employeeDao = new EmployeeDao(dataSource);

        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
        ) {

            statement.execute("delete from employees");

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot empty", se);
        }
    }

    @Test
   public void testinsert() {
        employeeDao.createEmployee("John Doe");
        employeeDao.createEmployee("Jane Doe");
        employeeDao.createEmployee("Jack Doe");
        assertEquals(Arrays.asList("Jack Doe", "Jane Doe", "John Doe"), employeeDao.listEmployeeNames());
    }

    @Test
    public void testInsertOne() {
        employeeDao.createEmployee("John Doe");
        assertEquals(Arrays.asList("John Doe"),employeeDao.listEmployeeNames());
    }
}