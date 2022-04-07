/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaplanilla.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class BuscarViewController extends Controller implements Initializable {

    @FXML
    private JFXButton btnFiltrar;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXButton btnAceptar;
    @FXML
    private AnchorPane root;
    
    private JFXTextField txt;
    private Label label;
    private TableView<?> tableView;
    private TableColumn tableColum;
    private TableColumn tableColum1;
    private TableColumn tableColum2;
    @FXML
    private BorderPane rootBorderPane;
    @FXML
    private VBox rootScrollPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        InicioBuscar();
    }

    private void InicioBuscar(){
       txt = new JFXTextField();
       label = new Label();
       tableView = new TableView<>();
       rootScrollPane = new VBox();
       tableColum = new TableColumn("Cedula");
       tableColum1 = new TableColumn("Nombre");
       tableColum2 = new TableColumn("Apellido");
       tableView.getColumns().addAll(tableColum,tableColum1,tableColum2);
       rootBorderPane.setCenter(tableView);
       rootScrollPane.setSpacing(30);
       rootScrollPane.getChildren().add(txt);
       
       
       
    }

    @FXML
    private void OnActionBtnCancelar(ActionEvent event) {
        ((Stage) btnCancelar.getScene().getWindow()).close();

    }

    @Override
    public void initialize() {
        
    }

    @FXML
    private void OnActionBtnAceptar(ActionEvent event) {
        
    }
    
}
