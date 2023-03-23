package lk.ijse.dep10.teachers.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static DBConnection dbConnection;
    private final Connection connection;



    private DBConnection() {
        File file = new File("application.properties");
        try {
            FileReader fileReader = new FileReader(file);
            Properties properties = new Properties();
            properties.load(fileReader);
            fileReader.close();

            String host = properties.getProperty("mysql.host", "localhost");
            String port = properties.getProperty("mysql.port", "3306");
            String database = properties.getProperty("mysql.database", "dep10_git");
            String username = properties.getProperty("mysql.username", "root");
            String password = properties.getProperty("mysql.password", "AnKar220#");

            String url = "jdbc:mysql://" + host + ":" + port + "/" + database
                    + "createDatabaseIfNotExist=true";

            connection = DriverManager.getConnection(url, username, password);


        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DBConnection getInstance() {
        return (dbConnection==null)? dbConnection = new DBConnection():dbConnection;
    }

    public Connection getConnection() {return connection;}
}
