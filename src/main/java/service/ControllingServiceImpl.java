package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllingServiceImpl implements DbRequestService {

    private static final String QUERY = "SELECT DISTINCT Departments.department_name " +
            "FROM Job_history " +
            "INNER JOIN Departments ON Job_history.department_id = Departments.department_id " +
            "INNER JOIN Employees ON Job_history.employee_id = Employees.employee_id " +
            "INNER JOIN Jobs ON Job_history.job_id = Jobs.job_id " +
            "WHERE (Employees.last_name = 'Kowalski' OR Employees.last_name = 'Nowak') " +
            "AND Employees.max_salaru < Jobs.max_salary - (Jobs.max_salary * 25 / 100) " +
            "ORDER BY Departments.department_name ASC;";

    @Override
    public void getDataRequest(Statement statement) throws SQLException {

        ResultSet resultSet = statement.executeQuery(QUERY);
        while (resultSet.next()) {
            String departmentName = resultSet.getString("department_name");
            System.out.println(departmentName);
        }
    }
}
