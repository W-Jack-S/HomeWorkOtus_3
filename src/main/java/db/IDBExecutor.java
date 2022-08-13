package db;

import java.sql.SQLException;

public interface IDBExecutor {
    void execute(String query) throws SQLException;

}
