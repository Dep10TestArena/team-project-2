package lk.ijse.dep10.student.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.ijse.dep10.student.db.DBConnection;
import lk.ijse.dep10.student.model.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentFormController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnSave;

    @FXML
    private TableView<Student> tblStudents;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    public void initialize(){

        tblStudents.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblStudents.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStudents.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        loadAllStudent();
    }

    private void loadAllStudent(){
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Student";
            ResultSet resultSet = statement.executeQuery(sql);

            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM Student WHERE id=?");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");

                ArrayList<String> studentList = new ArrayList<>();

                preparedStatement.setInt(1,id);
                ResultSet resultSet1 = preparedStatement.executeQuery();
//                while (resultSet1.next()) {
//                    String contact = resultSet1.getString("name");
//                    contactList.add(contact);
//                }
                Student student = new Student(id, name, address);
                tblStudents.getItems().add(student);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "failed to connect to the database customer").showAndWait();
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnNewOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void tblStudentsOnKeyReleased(KeyEvent event) {

    }

}
