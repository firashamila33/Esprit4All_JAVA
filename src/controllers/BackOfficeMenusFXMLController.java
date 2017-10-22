/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import models.Menu;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class BackOfficeMenusFXMLController implements Initializable {

    @FXML
    private StackPane tablePane;
    @FXML
    private JFXTextField recherche_tf;
    @FXML
    private TableView<Menu> menus_table;
    @FXML
    private TableColumn<Menu, ?> col_logo;
    @FXML
    private TableColumn<Menu, ?> col_libelle;
    @FXML
    private TableColumn<Menu, ?> col_prix;
    @FXML
    private TableColumn<Menu, ?> col_type;
    @FXML
    private TableColumn<Menu, ?> col_endroit;
    @FXML
    private TableColumn<Menu, ?> col_disponibilite;
    @FXML
    private TableColumn<Menu, ?> col_quantite;
    @FXML
    private TableColumn<Type, Void> col_option;
    @FXML
    private JFXButton add_btn_layout;
    @FXML
    private JFXDialogLayout addDialogLayout;
    @FXML
    private JFXTextField libelle_tf;
    @FXML
    private JFXTextField logo_path_tf;
    @FXML
    private JFXButton add_btn;
    @FXML
    private JFXTextField quantite_tf;
    @FXML
    private JFXTextField endroit_tf;
    @FXML
    private JFXTextField type_tf;
    @FXML
    private JFXTextField prix_tf;
    @FXML
    private JFXCheckBox disponibilite_cb;
    /**
     * Attribue
     */
    JFXDialog dialog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setLabelFlat();
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
        quantite_tf.setLabelFloat(true);
        endroit_tf.setLabelFloat(true);
        type_tf.setLabelFloat(true);
        prix_tf.setLabelFloat(true);
    }

}
