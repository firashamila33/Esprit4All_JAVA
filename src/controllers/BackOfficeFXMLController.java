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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.UserService;

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
    private JFXButton nav_info_club;
    @FXML
    private JFXButton nav_orders;
    @FXML
    private JFXButton nav_recettes;
    @FXML
    private JFXButton nav_Professeur;
    @FXML
    private JFXButton nav_utilisateur;
    @FXML
    private AnchorPane holderPane;

    JFXButton currentselectedButton;

    AnchorPane clubs, events, docs, menus, revisions, objetPerdus, orders, recette, professeur, utilisateur;
    @FXML
    private JFXButton deconnexion;
    @FXML
    private Label User;
    @FXML
    private Label Role;
    @FXML
    private VBox menu_bar;

    Stage stage;
    Parent root;
    @FXML
    private JFXButton exit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User.setText(UserService.userStatic.getUsername());

        if (UserService.userStatic.getRole().equals("ROLE_ADMIN")) {
            Role.setText("Administrateur");
            menu_bar.getChildren().remove(nav_menu);
            menu_bar.getChildren().remove(nav_orders);
            menu_bar.getChildren().remove(nav_info_club);
            menu_bar.getChildren().remove(nav_recettes);
        }
        if (UserService.userStatic.getRole().equals("ROLE_RESPONSABLE")) {
            Role.setText("Responsable Buvette");
            menu_bar.getChildren().remove(nav_clubs);
            menu_bar.getChildren().remove(nav_docs);
            menu_bar.getChildren().remove(nav_revisions);
            menu_bar.getChildren().remove(nav_objetPerdus);
            menu_bar.getChildren().remove(nav_events);
            menu_bar.getChildren().remove(nav_info_club);
            menu_bar.getChildren().remove(nav_Professeur);
            menu_bar.getChildren().remove(nav_utilisateur);

        }

        try {
            if (UserService.userStatic.getRole().equals("ROLE_ADMIN")) {
                clubs = FXMLLoader.load(getClass().getResource("/gui/BackOfficeClubFXML.fxml"));
                setNode(clubs);
                currentselectedButton = nav_clubs;
                nav_clubs.setStyle(" -fx-background-color: #ffffff;\n"
                        + "    -fx-text-fill: #000000;");
            }
            if (UserService.userStatic.getRole().equals("ROLE_RESPONSABLE")) {
                menus = FXMLLoader.load(getClass().getResource("/gui/BackOfficeMenusFXML.fxml"));

                setNode(menus);
                currentselectedButton = nav_menu;
                nav_clubs.setStyle(" -fx-background-color: #ffffff;\n"
                        + "    -fx-text-fill: #000000;");
            }

        } catch (IOException ex) {
            Logger.getLogger(BackOfficeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void goToClubs(ActionEvent event) throws IOException {
        clubs = FXMLLoader.load(getClass().getResource("/gui/BackOfficeClubFXML.fxml"));
        changeStyle(nav_clubs);
        setNode(clubs);

    }

    @FXML
    private void goToEvents(ActionEvent event) throws IOException {
        events = FXMLLoader.load(getClass().getResource("/gui/BackOfficeEventFXML.fxml"));
        changeStyle(nav_events);
        setNode(events);

    }

    @FXML
    private void goToDocs(ActionEvent event) throws IOException {

        docs = FXMLLoader.load(getClass().getResource("/gui/BackOfficeDocsFXML.fxml"));
        changeStyle(nav_docs);
        setNode(docs);

    }

    @FXML
    private void goToMenu(ActionEvent event) throws IOException {
        menus = FXMLLoader.load(getClass().getResource("/gui/BackOfficeMenusFXML.fxml"));
        changeStyle(nav_menu);
        setNode(menus);

    }

    @FXML
    private void goToRevisions(ActionEvent event) throws IOException {
        revisions = FXMLLoader.load(getClass().getResource("/gui/BackOfficeRevisionsFXML.fxml"));
        changeStyle(nav_revisions);
        setNode(revisions);

    }

    @FXML
    private void goToObjetPerdus(ActionEvent event) throws IOException {
        objetPerdus = FXMLLoader.load(getClass().getResource("/gui/BackOfficeObjetPerdusFXML.fxml"));
        changeStyle(nav_objetPerdus);
        setNode(objetPerdus);

    }

    @FXML
    private void goToOrders(ActionEvent event) throws IOException {
        orders = FXMLLoader.load(getClass().getResource("/gui/BackOfficeMenuOrderFXML.fxml"));
        changeStyle(nav_orders);
        setNode(orders);

    }

    @FXML
    private void goToRecette(ActionEvent event) throws IOException {
        changeStyle(nav_recettes);
        setNode(clubs);

    }

    @FXML
    private void goToProfesseur(ActionEvent event) throws IOException {
        professeur = FXMLLoader.load(getClass().getResource("/gui/BackOfficeProfesseurFXML.fxml"));
        changeStyle(nav_Professeur);
        setNode(professeur);
    }

    @FXML
    private void goToUtilisateur(ActionEvent event) throws IOException {
        utilisateur = FXMLLoader.load(getClass().getResource("/gui/BackOfficeUtilisateurFXML.fxml"));
        changeStyle(nav_utilisateur);
        setNode(utilisateur);
    }

    @FXML
    private void Deconnexion(ActionEvent event) throws IOException {
        UserService.userStatic = null;
        stage = (Stage) deconnexion.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();

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

    @FXML
    private void Exit(ActionEvent event) {
        Platform.exit();
    }

}
