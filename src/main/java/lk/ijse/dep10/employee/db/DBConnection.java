package lk.ijse.dep10.employee.db;

import javafx.scene.control.Alert;

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
        Properties configurations = new Properties();
        File configFile = new File("application.properties");
        try {
            FileReader fr = new FileReader(configFile);
            configurations.load(fr);
            fr.close();

            String host = configurations.getProperty("dep10.gp2.db.host", "localhost");
            String port = configurations.getProperty("dep10.gp2.db.root", "3306");
            String database = configurations.getProperty("dep10.gp2.db.name", "dep10_student");
            String username = configurations.getProperty("dep10.gp2.db.username", "root");
            String password = configurations.getProperty("dep10.gp2.db.password", "");

            String queryString ="createDatabaseIfNotExist=true&allowMultiQueries=true";
            String url = String.format("jdbc:mysql://%s:%s/%s?%s", host, port, database, queryString);
            System.out.println(url);

            connection = DriverManager.getConnection(url, username, password);

        } catch (FileNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,"Failed to find the file").showAndWait();
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR,"Failed to read the configuration").showAndWait();
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,"Failed to established the database").showAndWait();
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public static DBConnection getDbConnection() {
        return (dbConnection==null)? dbConnection=new DBConnection():dbConnection;
    }
}
