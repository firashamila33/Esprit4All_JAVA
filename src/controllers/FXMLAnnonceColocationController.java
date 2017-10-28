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
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import models.AnnonceCoLocation;

/**
 * FXML Controller class
 *
 * @author kadhem
 */
public class FXMLAnnonceColocationController implements Initializable {

    @FXML
    private TextArea locatairesValue;
    @FXML
    private Label dimensionsValue;
    @FXML
    private Label loyerValue;
    @FXML
    private TextArea descriptionValue;
    @FXML
    private Label ajouteLeValue;
    private FXMLAnnonceColocationMenuController menu;
    private AnnonceCoLocation annonce;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void init(AnnonceCoLocation a,FXMLAnnonceColocationMenuController menu) {
        this.menu = menu;
        descriptionValue.setText(a.getDescription());
        loyerValue.setText(((Float) a.getLoyer()).toString());
        dimensionsValue.setText(a.getDimensions());
        ajouteLeValue.setText(a.getCreationDate().toString());
        annonce = a;

    }

    public AnnonceCoLocation getAnnonce() {
        return annonce;
    }
    

    @FXML
    private void onWidgetClicked(MouseEvent event) {
        if (event.getClickCount() > 1) {
            menu.onAnnonceDoubleClick(this);
        }
        else{
            menu.onAnnonceClick(this);
        }
    }

}
