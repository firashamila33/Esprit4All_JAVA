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
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class MainCovoiturageFXMLController implements Initializable {

    @FXML
    private JFXButton listCovoiturage_btn;
    @FXML
    private JFXButton mesCovoiturage_btn;
    @FXML
    private AnchorPane container;

    JFXButton currentselectedButton;

    StackPane listeCovoiturage, mesCovoituarge;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            listeCovoiturage = FXMLLoader.load(getClass().getResource("/gui/ListCovoituragesFXML.fxml"));
            setNode(listeCovoiturage);
            currentselectedButton = listCovoiturage_btn;
            listCovoiturage_btn.setStyle(" -fx-border-width: 0 4 0 0;\n"
                    + "    -fx-border-color:  #ff2e44;");
        } catch (IOException ex) {
            Logger.getLogger(MainCovoiturageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setNode(Node node) {
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
    private void goToListCovoiturage(ActionEvent event) throws IOException {
        listeCovoiturage = FXMLLoader.load(getClass().getResource("/gui/ListCovoituragesFXML.fxml"));
        setNode(listeCovoiturage);
        changeStyle(listCovoiturage_btn);
    }

    @FXML
    private void GoToMesCovoiturage(ActionEvent event) throws IOException {
         mesCovoituarge = FXMLLoader.load(getClass().getResource("/gui/MesCovoituragesFXML.fxml"));
        setNode(mesCovoituarge);
        changeStyle(mesCovoiturage_btn);
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
