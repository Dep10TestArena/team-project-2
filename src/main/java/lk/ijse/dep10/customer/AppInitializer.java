package lk.ijse.dep10.customer;

import com.sun.javafx.scene.control.skin.FXVK;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.dep10.customer.db.DBConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                if (DBConnection.getInstance() != null &&
                        !DBConnection.getInstance().getConnection().isClosed()) {
                    System.out.println("Database connection is about to close");
                    DBConnection.getInstance().getConnection().close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }));
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        generateTables();
        primaryStage.setScene(new Scene(
                new FXMLLoader(getClass().getResource("/view/CustomerScene.fxml")).load()
        ));
        primaryStage.setTitle("Manage Customer");
        primaryStage.centerOnScreen();
//        primaryStage.setMaximized(true);
        primaryStage.show();
        System.out.println(DBConnection.getInstance().getConnection());
    }

    private void generateTables() {
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SHOW TABLES");
            if (!rst.next()) {
                stm.execute(readSchema());
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private String readSchema() {
        InputStream is = getClass().getResourceAsStream("/schema.sql");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))){
            String line;
            StringBuilder dbScriptBuilder = new StringBuilder();

            while ((line = br.readLine()) != null) {
                dbScriptBuilder.append(line);
            }
            System.out.println(dbScriptBuilder);
            return dbScriptBuilder.toString();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
