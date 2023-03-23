package lk.ijse.dep10.employee1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.dep10.employee1.db.DBConnection;

import java.io.IOException;
import java.sql.SQLException;

public class AppInitializer extends Application {

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                if (DBConnection.getDbConnection().getConnection() != null &&
                        !DBConnection.getDbConnection().getConnection().isClosed()) {
                    System.out.println("Database connection is about to close");
                    DBConnection.getDbConnection().getConnection().close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }));
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(new FXMLLoader(getClass().getResource("/view/EmployeeView.fxml")).load()));

        primaryStage.setTitle("Employee View");
        primaryStage.centerOnScreen();
        primaryStage.show();

        generateTables();

    }

    private void generateTables() {


    }


}
