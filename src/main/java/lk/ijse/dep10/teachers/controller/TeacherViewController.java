package lk.ijse.dep10.teachers.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TeacherViewController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNewTeacher;

    @FXML
    private Button btnSave;

    @FXML
    private Label lblHeading;

    @FXML
    private TableView<?> tblTeachers;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    public void initialize() {
        tblTeachers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblTeachers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblTeachers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnNewTeacherOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

}
