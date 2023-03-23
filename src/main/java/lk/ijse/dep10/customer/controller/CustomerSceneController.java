package lk.ijse.dep10.customer.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.ijse.dep10.customer.model.Customer;

public class CustomerSceneController {
     public Button btnDelete;
     public Button btnNew;
     public Button btnSave;
     public TableView<Customer> tblCustomers;
     public TextField txtAddress;
     public TextField txtId;
     public TextField txtName;

    public void initialize() {
        loadCustomers();

        tblCustomers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

    }

    private void loadCustomers() {

    }

    public void btnDeleteOnAction(ActionEvent event) {

    }

     
     public void btnNewOnAction(ActionEvent event) {
        generateId();
         txtName.clear();
        txtAddress.clear();
        txtName.requestFocus();
    }

    private void generateId() {
        if (tblCustomers.getItems().isEmpty()) {
            txtId.setText("C001");
        } else {
            String lastId = tblCustomers.getItems().get(tblCustomers.getItems().size() - 1).getId();
            String newId = String.format("C03%s", (Integer.parseInt(lastId.substring(3)) + 1));
            txtId.setText(newId);
        }
    }


    public void btnSaveOnAction(ActionEvent event) {

    }

     
     public void tblCustomersOnKeyRelease(KeyEvent event) {

    }

}
