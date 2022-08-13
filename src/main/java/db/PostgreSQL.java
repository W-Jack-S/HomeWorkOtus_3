package db;

import conf_readers.IConfReaders;
import conf_readers.PropertiesReader;

import java.sql.*;
import java.util.Map;

public class PostgreSQL implements IDBExecutor {

    private IConfReaders confReader = new PropertiesReader();

    @Override
    public void execute(String query) throws SQLException {
        Connection connection = null;
        Statement statement = null;

        Map<String, String> confData = confReader.read();

        try {
            //Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    String.format("%s/%s", confData.get("url"), confData.get("db_name")),
                    confData.get("username"),
                    confData.get("password"));

            statement = connection.createStatement();

            statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}