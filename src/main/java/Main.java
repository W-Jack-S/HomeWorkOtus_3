import db.IDBExecutor;
import db.PostgreSQL;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        IDBExecutor idbExecutor = new PostgreSQL();
        idbExecutor.execute("select * from student");
    }
}
