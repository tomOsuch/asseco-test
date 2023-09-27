package service;

import java.sql.SQLException;
import java.sql.Statement;

public interface DbRequestService {

    void getDataRequest(Statement statement) throws SQLException;
}
