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
public class BackOfficeFXMLController implements Initializable {

    @FXML
    private JFXButton nav_clubs;
    @FXML
    private JFXButton nav_events;
    @FXML
    private JFXButton nav_docs;
    @FXML
    private JFXButton nav_menu;
    @FXML
    private JFXButton nav_revisions;
    @FXML
    private JFXButton nav_objetPerdus;
    @FXML
    private JFXButton nav_info_club;
    @FXML
    private JFXButton nav_orders;
    @FXML
    private JFXButton nav_recettes;
    @FXML
    private AnchorPane holderPane;

    JFXButton currentselectedButton;

    AnchorPane clubs, events, docs, menus, revisions, objetPerdus, info_club, orders, recette;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            clubs = FXMLLoader.load(getClass().getResource("/gui/BackOfficeClubFXML.fxml"));
            events = FXMLLoader.load(getClass().getResource("/gui/BackOfficeEventFXML.fxml"));
            docs = FXMLLoader.load(getClass().getResource("/gui/BackOfficeDocsFXML.fxml"));
            menus= FXMLLoader.load(getClass().getResource("/gui/BackOfficeMenusFXML.fxml"));
            revisions=FXMLLoader.load(getClass().getResource("/gui/BackOfficeRevisionsFXML.fxml"));
            objetPerdus=FXMLLoader.load(getClass().getResource("/gui/BackOfficeObjetPerdusFXML.fxml"));
            info_club = FXMLLoader.load(getClass().getResource("/gui/BackOfficeInfoClubMembreFXML.fxml"));
            
            
            
            setNode(clubs);
            currentselectedButton = nav_clubs;
            nav_clubs.setStyle(" -fx-background-color: #ffffff;\n"
                    + "    -fx-text-fill: #000000;");
        } catch (IOException ex) {
            Logger.getLogger(BackOfficeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void goToClubs(ActionEvent event) {
        changeStyle(nav_clubs);
        setNode(clubs);

    }

    @FXML
    private void goToEvents(ActionEvent event) {
        changeStyle(nav_events);
        setNode(events);

    }

    @FXML
    private void goToDocs(ActionEvent event) {
        changeStyle(nav_docs);
        setNode(docs);

    }

    @FXML
    private void goToMenu(ActionEvent event) {
        changeStyle(nav_menu);
        setNode(menus);

    }

    @FXML
    private void goToRevisions(ActionEvent event) {
        changeStyle(nav_revisions);
        setNode(revisions);

    }

    @FXML
    private void goToObjetPerdus(ActionEvent event) {
        changeStyle(nav_objetPerdus);
        setNode(objetPerdus);

    }

    @FXML
    private void goToInfoClub(ActionEvent event) {
        changeStyle(nav_info_club);
        setNode(info_club);

    }

    @FXML
    private void goToOrders(ActionEvent event) {
        changeStyle(nav_orders);
        setNode(clubs);

    }

    @FXML
    private void goToRecette(ActionEvent event) {
        changeStyle(nav_recettes);
        setNode(clubs);

    }

    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    private void changeStyle(JFXButton button) {

        button.setStyle(" -fx-background-color: #ffffff;\n"
                + "    -fx-text-fill: #000000;");
        currentselectedButton.setStyle("-fx-border-color:#CDCDCD;\n"
                + "    -fx-border-width:0 0 1 0;\n"
                + "    -fx-text-fill: #ffffff;");

        currentselectedButton = button;

    }
}
