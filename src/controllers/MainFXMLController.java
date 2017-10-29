/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class MainFXMLController implements Initializable {

    AnchorPane acceuil, annonce, covoiturage, objetPerdus, revision, restauration, vieSocial, profile;
    @FXML
    private JFXButton acceuil_btn;
    @FXML
    private JFXButton annonce_btn;
    @FXML
    private JFXButton covoiturage_btn;
    @FXML
    private JFXButton objetPerdu_btn;
    @FXML
    private JFXButton revision_btn;
    @FXML
    private JFXButton restauration_btn;
    @FXML
    private JFXButton vieSocial_btn;
    @FXML
    private JFXButton profile_btn;

    JFXButton currentselectedButton;

    @FXML
    private AnchorPane container;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            acceuil = FXMLLoader.load(getClass().getResource("/gui/AcceuilFXML.fxml"));
            currentselectedButton = acceuil_btn;
            acceuil_btn.setStyle("-fx-border-width: 0 0 4 0;\n"
                    + "    -fx-border-color:  #ff2e44;");
            setNode(acceuil);
        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setNode(Node node) {
        container.getChildren().clear();
        container.getChildren().add((Node) node);
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();

    }

    @FXML
    private void goToAcceuil(ActionEvent event) throws IOException {
        acceuil = FXMLLoader.load(getClass().getResource("/gui/AcceuilFXML.fxml"));

        setNode(acceuil);
        changeStyle(acceuil_btn);
    }

    @FXML
    private void goToAnnonce(ActionEvent event) {
        changeStyle(annonce_btn);
    }

    @FXML
    private void goToCovoitureage(ActionEvent event) throws IOException {
        covoiturage = FXMLLoader.load(getClass().getResource("/gui/MainCovoiturageFXML.fxml"));
        setNode(covoiturage);
        changeStyle(covoiturage_btn);
    }

    @FXML
    private void goToObjetPerdu(ActionEvent event) {
        changeStyle(objetPerdu_btn);
    }

    @FXML
    private void goToRevision(ActionEvent event) {
        changeStyle(revision_btn);
    }

    @FXML
    private void goToRestauration(ActionEvent event) throws IOException {

        restauration = FXMLLoader.load(getClass().getResource("/gui/FoodMainnFXML.fxml"));
        changeStyle(restauration_btn);
        setNode(restauration);

    }

    @FXML
    private void goToVieSocial(ActionEvent event) throws IOException {
        covoiturage = FXMLLoader.load(getClass().getResource("/gui/MainVieSocialFXML.fxml"));
        setNode(covoiturage);
        changeStyle(vieSocial_btn);
    }

    @FXML
    private void goToProfile(ActionEvent event) {
        changeStyle(profile_btn);
    }

    private void changeStyle(JFXButton button) {

        button.setStyle(" -fx-border-width: 0 0 4 0;\n"
                + "    -fx-border-color:  #ff2e44;");
        currentselectedButton.setStyle("-fx-border-width:  0 0 4 0;\n"
                + "    -fx-border-color:  #ffffff;"
                + ".main-nav-button:hover{\n"
                + "    -fx-border-width: 0 0 4 0;\n"
                + "    -fx-border-color:  #ff2e44;\n"
                + "}\n");

        currentselectedButton = button;

    }
}
