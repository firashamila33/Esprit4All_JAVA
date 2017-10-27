/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXTextField;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import models.AnnonceObjetPerdu;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class BackOfficeObjetPerdusFXMLController implements Initializable {

    @FXML
    private StackPane tablePane;
    @FXML
    private JFXTextField recherche_tf;
    @FXML
    private TableView<AnnonceObjetPerdu> objetPerdus_table;
    @FXML
    private TableColumn<AnnonceObjetPerdu, ?> col_description;
    @FXML
    private TableColumn<AnnonceObjetPerdu, ?> col_date;
    @FXML
    private TableColumn<AnnonceObjetPerdu, ?> col_location;
    @FXML
    private TableColumn<Type, Void> col_option;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
