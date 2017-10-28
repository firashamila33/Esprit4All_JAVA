/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import models.Evenement;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class BackOfficeEventsFXMLController implements Initializable {

    @FXML
    private StackPane tablePane;
    @FXML
    private JFXTextField recherche_tf;

    @FXML
    private TableView<Evenement> event_table;
    @FXML
    private TableColumn<Evenement, ?> col_date;
    @FXML
    private TableColumn<Evenement, ?> col_libelle;
    @FXML
    private TableColumn<Evenement, ?> col_description;
    @FXML
    private TableColumn<Evenement, ?> col_logo;
    @FXML
    private TableColumn<Evenement, ?> col_couverture;
    @FXML
    private TableColumn<Type, Void> col_option;

    /**
     * Form FXML Attribue
     */
    @FXML
    private JFXButton add_btn_layout;
    @FXML
    private JFXButton add_btn;
    @FXML
    private JFXTextField libelle_tf;
    @FXML
    private JFXTextField Description_tf;
    @FXML
    private JFXTextField logo_path_tf;
    @FXML
    private JFXTextField couverture_path_tf;
    @FXML
    private DatePicker date_tf;

    @FXML
    private JFXDialogLayout addDialogLayout;

    /**
     * Attribue
     */
    JFXDialog dialog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        libelle_tf.setLabelFloat(true);
        logo_path_tf.setLabelFloat(true);
        couverture_path_tf.setLabelFloat(true);
        Description_tf.setLabelFloat(false);
        recherche_tf.setLabelFloat(true);

    }

    /**
     * Methode qui permet d'afficher le formulaire d'ajout ou de modification
     */
    @FXML
    private void showAddFormAction(ActionEvent event) {
        dialog = new JFXDialog(tablePane, addDialogLayout, JFXDialog.DialogTransition.CENTER);
        dialog.setOverlayClose(true);
        addDialogLayout.setVisible(true);
        dialog.show();
    }

    /**
     * Methode qui permet de ajouter dans la base de donnée
     */
    @FXML
    private void addAction(ActionEvent event) {
        dialog.close();
    }

    private void setLabelFlat() {
        libelle_tf.setLabelFloat(true);
        logo_path_tf.setLabelFloat(true);
        couverture_path_tf.setLabelFloat(true);
        Description_tf.setLabelFloat(false);
        recherche_tf.setLabelFloat(true);
    }
}
