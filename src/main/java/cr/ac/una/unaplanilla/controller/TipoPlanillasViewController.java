/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaplanilla.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class TipoPlanillasViewController extends Controller implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private TabPane tbpTipoPlanilla;
    @FXML
    private Tab tbpTipoPlanillas;
    @FXML
    private JFXTextField txtId;
    @FXML
    private JFXCheckBox chkActivo;
    @FXML
    private JFXTextField txtCodigo;
    @FXML
    private JFXTextField txtDescripcion;
    @FXML
    private JFXTextField txtPlanillasMes;
    @FXML
    private Tab tbpInclusionEmpleados;
    @FXML
    private JFXTextField txtIdEmpleado;
    @FXML
    private JFXTextField txtNombreEmpleado;
    @FXML
    private JFXButton btnAgregar;
    @FXML
    private TableView<?> tbvEmpleados;
    @FXML
    private TableColumn<?, ?> tbcCodigo;
    @FXML
    private TableColumn<?, ?> tbcNombre;
    @FXML
    private TableColumn<?, ?> tbcEliminar;
    @FXML
    private JFXButton btnNuevo;
    @FXML
    private JFXButton btnBuscar;
    @FXML
    private JFXButton btnEliminar;
    @FXML
    private JFXButton btnGuardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onKeyPressedTxtId(KeyEvent event) {
    }

    @FXML
    private void onKeyPressedTxtIdEmpleado(KeyEvent event) {
    }

    @FXML
    private void agregarEmpleado(ActionEvent event) {
    }

    @FXML
    private void selectionChangeTabEmp(Event event) {
    }

    @FXML
    private void onActionBtnNuevo(ActionEvent event) {
    }

    @FXML
    private void onActionBtnBuscar(ActionEvent event) {
    }

    @FXML
    private void onActionBtnEliminar(ActionEvent event) {
    }

    @FXML
    private void onActionBtnGuardar(ActionEvent event) {
    }

    @Override
    public void initialize() {
        
    }
    
}
