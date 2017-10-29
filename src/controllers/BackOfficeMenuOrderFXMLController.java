/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import models.Commande;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class BackOfficeMenuOrderFXMLController implements Initializable {

    @FXML
    private TableView<Commande> membre_table;
    @FXML
    private TableColumn<?, ?> col_prix;
    @FXML
    private TableColumn<?, ?> col_confirmation;
    @FXML
    private AnchorPane responsable_label;
    @FXML
    private ListView<?> ligneCommande_lv;
    @FXML
    private Label prix_lb;
    @FXML
    private TableColumn<?, ?> col_ref;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
