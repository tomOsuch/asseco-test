package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookKeepingServiceImpl implements DbRequestService {

    private static final String QUERY = "SELECT Employees.last_name " +
            "FROM Job_history " +
            "INNER JOIN(SELECT * FROM Employees) Employees ON Job_history.employee_id = Employees.employee_id " +
            "INNER JOIN Departments ON Job_history.department_id = Departments.department_id " +
            "WHERE Departments.department_name = 'DRK' " +
            "GROUP BY Employees.last_name, Employees.first_name " +
            "ORDER BY Employees.last_name ASC, Employees.first_name ASC;";

    @Override
    public void getDataRequest(Statement statement) throws SQLException {

        ResultSet resultSet = statement.executeQuery(QUERY);
        while (resultSet.next()) {
            String lastName = resultSet.getString("last_name");
            System.out.println(lastName);
        }
    }
}
