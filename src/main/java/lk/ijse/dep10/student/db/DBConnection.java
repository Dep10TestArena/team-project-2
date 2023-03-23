package lk.ijse.dep10.student.db;

import java.sql.Connection;

public class DBConnection {
    private static DBConnection dbConnection;
    private final Connection connection;

    public DBConnection() {
    }

    public static DBConnection getInstance(){
        return (dbConnection == null)? dbConnection = new DBConnection : dbConnection;
    }
    public Connection getConnection(){
        return connection;
    }
}
