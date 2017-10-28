/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.lang.ProcessBuilder.Redirect.Type;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import models.Club;

/**
 * FXML Controller class
 *
 * @author majdi
 */
public class BackOfficeInfoClubMembreFXMLController implements Initializable {

    @FXML
    private TableView<Club> membre_table;
    @FXML
    private TableColumn<Club, ?> col_membre;
    @FXML
    private TableColumn<Club, ?> col_role;
    @FXML
    private TableColumn<Type, Void> col_option;
    @FXML
    private Label Name_lbl;
    @FXML
    private Label Email_lbl;
    @FXML
    private Label tel_lbl;
    @FXML
    private Label ourstory_lbl;
    @FXML
    private Label aboutus_lbl;
    @FXML
    private AnchorPane responsable_label;
    @FXML
    private AnchorPane fabPane;
    @FXML
    private Label fabEdit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
