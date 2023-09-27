import config.JDBCConnectionConfig;
import service.BookKeepingServiceImpl;
import service.ControllingServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AssecoTestApplication {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(JDBCConnectionConfig.URL, JDBCConnectionConfig.user, JDBCConnectionConfig.password);
            Statement statement = connection.createStatement();

            BookKeepingServiceImpl bookKeeping = new BookKeepingServiceImpl();
            bookKeeping.getDataRequest(statement);

            ControllingServiceImpl controlling = new ControllingServiceImpl();
            controlling.getDataRequest(statement);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
