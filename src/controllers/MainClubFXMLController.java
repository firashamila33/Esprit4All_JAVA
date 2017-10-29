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
public class MainClubFXMLController implements Initializable {

    @FXML
    private AnchorPane container;

    @FXML
    private JFXButton infoClub_btn;
    @FXML
    private JFXButton eventClub_btn;
    JFXButton currentselectedButton;
    AnchorPane infoClub, eventClub;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            infoClub = FXMLLoader.load(getClass().getResource("/gui/InfoClubMembreFXML.fxml"));
            infoClub_btn.setStyle("  -fx-border-width: 0 4 0 0;\n"
                    + "    -fx-border-color:  #ff2e44;");
            currentselectedButton=infoClub_btn;
        } catch (IOException ex) {
            Logger.getLogger(MainClubFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setNode(infoClub);
    }

    @FXML
    private void goToInfoClub(ActionEvent event) throws IOException {
        infoClub = FXMLLoader.load(getClass().getResource("/gui/InfoClubMembreFXML.fxml"));
        changeStyle(infoClub_btn);
        setNode(infoClub);

    }

    @FXML
    private void GoToEvenement(ActionEvent event) throws IOException {
        eventClub = FXMLLoader.load(getClass().getResource("/gui/ListEventClubFXML.fxml"));
        changeStyle(eventClub_btn);
        setNode(eventClub);

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

    private void changeStyle(JFXButton button) {

        button.setStyle("  -fx-border-width: 0 4 0 0;\n"
                + "    -fx-border-color:  #ff2e44;");
        currentselectedButton.setStyle(".rev-nav-button:hover{\n"
                + "    -fx-border-width: 0 4 0 0;\n"
                + "    -fx-border-color:  #ff2e44;\n"
                + "}\n"
                + ".rev-nav-button{\n"
                + "    -fx-border-width: 0 0 0 0;\n"
                + "}");

        currentselectedButton = button;

    }
}
