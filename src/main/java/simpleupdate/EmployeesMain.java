package simpleupdate;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.util.Random;

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

        for (int i = 0; i < 100; i++)
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement =
                         connection.prepareStatement("INSERT INTO employees(emp_name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, "John Doe");
                statement.executeUpdate();

            } catch (SQLException se) {
                throw new IllegalStateException("Cannot insert", se);

            }

        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select id, emp_name from employees")
        ) {
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                System.out.println(id);
                String name = resultSet.getString("emp_name");
                System.out.println(name);
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);

        }

    }

}
