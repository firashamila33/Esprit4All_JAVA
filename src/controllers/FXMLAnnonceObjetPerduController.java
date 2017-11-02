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
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import models.AnnonceObjetPerdu;

/**
 * FXML Controller class
 *
 * @author kadhem
 */
public class FXMLAnnonceObjetPerduController implements Initializable {

    @FXML
    private Label ajouteLeValue;
    @FXML
    private TextArea descriptionValue;
    @FXML
    private Label perduLe;
    @FXML
    private Label perduLeValue;
    @FXML
    private Label lieu;
    @FXML
    private Label lieuValue;
    private FXMLAnnonceObjetPerduMenuController menu;
    private AnnonceObjetPerdu annonce;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void init(AnnonceObjetPerdu a, FXMLAnnonceObjetPerduMenuController menu) {
        this.menu = menu;
        descriptionValue.setText(a.getObjetDescription());
        lieuValue.setText(a.getLossLocation());
        perduLeValue.setText(a.getLossDate().toString());

        ajouteLeValue.setText(a.getCreationDate().toString());
        annonce = a;

    }

    public AnnonceObjetPerdu getAnnonce() {
        return annonce;
    }

    @FXML
    private void onWidgetClicked(MouseEvent event) {
        if (event.getClickCount() > 1) {
            menu.onAnnonceDoubleClick(this);
        } else {
            menu.onAnnonceClick(this);
        }
    }

  

}
