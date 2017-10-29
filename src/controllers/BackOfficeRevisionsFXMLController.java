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
import models.Revision;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class BackOfficeRevisionsFXMLController implements Initializable {

    @FXML
    private StackPane tablePane;
    @FXML
    private JFXTextField recherche_tf;
    @FXML
    private TableView<Revision> revisions_table;
    @FXML
    private TableColumn<Revision, ?> col_user;
    @FXML
    private TableColumn<Revision, ?> col_description;
    @FXML
    private TableColumn<Revision, ?> col_matiere;
    @FXML
    private TableColumn<Revision, ?> col_dateDebut;
    @FXML
    private TableColumn<Revision, ?> col_nbrmax;
    @FXML
    private TableColumn<Revision, ?> col_type;
    @FXML
    private TableColumn<Type, Void> col_option;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setLabelFlat();
    }    
     private void setLabelFlat() {
        recherche_tf.setLabelFloat(true);
        
    }

}
