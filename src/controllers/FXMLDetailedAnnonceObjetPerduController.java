/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.AnnonceObjetPerdu;
import models.User;
import services.AnnonceObjetPerduService;

/**
 * FXML Controller class
 *
 * @author kadhem
 */
public class FXMLDetailedAnnonceObjetPerduController implements Initializable {

    private Label ajouteLeValue;
    @FXML
    private TextArea descriptionValue;
    @FXML
    private Label perduLe;
    @FXML
    private TextField perduLeValue;
    @FXML
    private Label lieu;
    @FXML
    private TextField lieuValue;
    private FXMLAnnonceObjetPerduMenuController menu;
    private String mode;
    AnnonceObjetPerdu annonce;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initViewMode(AnnonceObjetPerdu a, FXMLAnnonceObjetPerduMenuController menu) {
        this.menu = menu;
        mode = "view";
        lieuValue.setText(a.getLossLocation());
        perduLeValue.setText(a.getLossLocation());
        descriptionValue.setText(a.getObjetDescription());
        //ajouteLeValue.setText(a.getCreationDate().toString());

        descriptionValue.setEditable(false);
        perduLeValue.setEditable(false);
        lieuValue.setEditable(false);
        this.annonce = a;
    }

    public void initAddMode(FXMLAnnonceObjetPerduMenuController menu) {
        this.menu = menu;
        mode = "add";

    }

    public void initUpdateMode(AnnonceObjetPerdu a, FXMLAnnonceObjetPerduMenuController menu) {
        this.menu = menu;
        mode = "update";
        lieuValue.setText(a.getLossLocation());
        perduLeValue.setText(a.getLossDate().toString());

        descriptionValue.setText(a.getObjetDescription());
        //ajouteLeValue.setText(a.getCreationDate().toString());

        this.annonce = a;
    }

    @FXML
    private void onOkAction(ActionEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        switch (mode) {
            case "view":
                onRetourAction(null);
                break;
            case "add": {
                try {

                    AnnonceObjetPerduService service = new AnnonceObjetPerduService();
                    AnnonceObjetPerdu a = new AnnonceObjetPerdu(
                            descriptionValue.getText(),
                            new Date(dateFormat.parse(perduLeValue.getText()).getTime()),
                            lieuValue.getText(), menu.getCurrentUser(),
                            new Date(new java.util.Date().getTime()),
                            new Date(1514764800));
                    service.add(a);
                    annonce = a;
                    onRetourAction(null);
                    break;
                } catch (ParseException ex) {
                    Logger.getLogger(FXMLDetailedAnnonceObjetPerduController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case "update": {
            try {
                AnnonceObjetPerduService service = new AnnonceObjetPerduService();
                AnnonceObjetPerdu a = new AnnonceObjetPerdu(
                        descriptionValue.getText(),
                        new Date(dateFormat.parse(perduLeValue.getText()).getTime()),
                        lieuValue.getText(), menu.getCurrentUser(),
                        new Date(new java.util.Date().getTime()),
                        new Date(1514764800));
                a.setId(annonce.getId());
                service.update(a);
                onRetourAction(null);
                break;
            } catch (ParseException ex) {
                Logger.getLogger(FXMLDetailedAnnonceObjetPerduController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            default:
                break;
        }
    }

    @FXML
    private void onRetourAction(ActionEvent event) {
        menu.onDetailedMenuOkClick();
    }

}
