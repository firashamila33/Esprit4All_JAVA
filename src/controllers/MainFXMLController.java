/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.ClubService;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class MainFXMLController implements Initializable {

    AnchorPane acceuil, annonce, covoiturage, objetPerdus, revision, restauration, vieSocial, profile, profileClub;
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
    JFXPopup popup = new JFXPopup();
    ClubService cs = new ClubService();
    VBox box = new VBox();
    static AnchorPane p;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p = container;

        
        
        JFXButton Logout = new JFXButton("Logout");
        Logout.setPrefSize(120, 50);
        JFXButton Profil = new JFXButton("Profile");
        Profil.setPrefSize(120, 50);
        JFXButton Club = new JFXButton("Club");
        Club.setPrefSize(120, 50);
        Club.setOnAction(event1 -> {
            try {
                profileClub = FXMLLoader.load(getClass().getResource("/gui/MainClubFXML.fxml"));
                setNode(profileClub);
                changeStyle(profile_btn);
                popup.hide();
            } catch (IOException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Logout.setOnAction(event -> {
            popup.hide();
            UserService.userStatic = null;
            Stage stage = (Stage) profile_btn.getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);

            stage.show();

        });
        

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

    static void setNode(Node node) {

        p.getChildren().clear();
        p.getChildren().add((Node) node);
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
    private void goToAnnonce(ActionEvent event) throws IOException {
        annonce = FXMLLoader.load(getClass().getResource("/gui/FXMLAnnonceColocationMenu.fxml"));
        setNode(this.annonce);
        changeStyle(annonce_btn);
    }

    @FXML
    private void goToCovoitureage(ActionEvent event) throws IOException {
        covoiturage = FXMLLoader.load(getClass().getResource("/gui/MainCovoiturageFXML.fxml"));
        setNode(covoiturage);
        changeStyle(covoiturage_btn);
    }

    @FXML
    private void goToObjetPerdu(ActionEvent event) throws IOException {
        objetPerdus = FXMLLoader.load(getClass().getResource("/gui/FXMLAnnonceObjetPerduMenu.fxml"));
        changeStyle(objetPerdu_btn);
        setNode(objetPerdus);
    }

    @FXML
    private void goToRevision(ActionEvent event) throws IOException {
        revision = FXMLLoader.load(getClass().getResource("/gui/RevisionMainFXML.fxml"));
        changeStyle(revision_btn);
        setNode(revision);
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
