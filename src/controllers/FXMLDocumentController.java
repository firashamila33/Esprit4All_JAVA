/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import models.Covoiturage;
import models.User;
import services.CovoiturageService;
import static services.UserService.userStatic;
import utils.BCrypt;

/**
 *
 * @author YACINE
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private AnchorPane window1;
    @FXML
    private AnchorPane window2;
    @FXML
    private AnchorPane window3;
    @FXML
    private AnchorPane window4;
    @FXML
    private AnchorPane window5;
    @FXML
    private AnchorPane window6;
    @FXML
    private AnchorPane window7;
    @FXML
    private AnchorPane window8;
    @FXML
    private AnchorPane window9;
    @FXML
    private AnchorPane window10;
    @FXML
    private JFXButton button1;
    @FXML
    private JFXButton button2;
    @FXML
    private JFXButton button3;
    @FXML
    private JFXRadioButton radio1;
    @FXML
    private JFXRadioButton radio2;
    @FXML
    private JFXRadioButton radio3;
    @FXML
    private JFXRadioButton radio4;
    @FXML
    private JFXButton button5;
    @FXML
    private JFXButton button6;
    @FXML
    private JFXTextField type;
    @FXML
    private JFXTextField heure;
    @FXML
    private JFXTextField depart;
    @FXML
    private JFXTextField arrive;
    @FXML
    private JFXTextField prix;
    @FXML
    private JFXTextArea description;
    @FXML
    private ToggleGroup nbrePlace;
    @FXML
    private JFXButton ajout;
    int place;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == button1) {
            window2.setVisible(false);
            window5.setVisible(true);
        } else if (event.getSource() == button2) {
            window2.setVisible(false);
            window8.setVisible(true);
        } else if (event.getSource() == button3) {
            window2.setVisible(true);
            window5.setVisible(false);
        } else if (event.getSource() == button5) {
            window8.setVisible(false);
            window2.setVisible(true);
        } else if (event.getSource() == button6) {
            window8.setVisible(false);
            window5.setVisible(true);
        }
        String typeV = type.getText();
        String heureV = heure.getText();
        String departV = depart.getText();
        String arriveV = arrive.getText();
        String prixString = prix.getText();
        double prixV = Double.parseDouble(prixString);
        String descriptionV = description.getText();
        String originalPassword = "azerty";
        String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
        User u = new User(2, "yacine", "yacine.farhat@esprit.tn", 1, generatedSecuredPasswordHash, "farhat", "yacine", null, "12345678", "cité olympique");
        Covoiturage covoiturage = new Covoiturage(u, typeV, prixV, departV, arriveV, descriptionV, place, heureV);
        System.out.println(covoiturage);
        CovoiturageService covoiturageService = new CovoiturageService();
        covoiturageService.add(covoiturage);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Ajouter(ActionEvent event) {
        String nbrePlaceV = "";
        if (radio1.isSelected()) {
            nbrePlaceV = radio1.getText();
        }
        if (radio2.isSelected()) {
            nbrePlaceV = radio2.getText();
        }
        if (radio3.isSelected()) {
            nbrePlaceV = radio3.getText();
        }
        if (radio4.isSelected()) {
            nbrePlaceV = radio4.getText();
        }
        place = Integer.parseInt(nbrePlaceV);
    }
}
