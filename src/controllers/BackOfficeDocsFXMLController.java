/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import models.DocumentAdministratif;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class BackOfficeDocsFXMLController implements Initializable {

    @FXML
    private StackPane tablePane;
    @FXML
    private JFXTextField recherche_tf;
    @FXML
    private TableView<DocumentAdministratif> docs_table;
    @FXML
    private TableColumn<DocumentAdministratif, ?> col_type;
    @FXML
    private TableColumn<DocumentAdministratif, ?> col_quantite;
    @FXML
    private TableColumn<DocumentAdministratif, ?> col_confirmation;
    @FXML
    private TableColumn<DocumentAdministratif, ?> col_etudiant;
    @FXML
    private TableColumn<DocumentAdministratif, ?> col_option;

   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
