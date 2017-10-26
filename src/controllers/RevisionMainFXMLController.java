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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class RevisionMainFXMLController implements Initializable {

    @FXML
    private AnchorPane Container;

    AnchorPane listRevision, topRated;
    @FXML
    private JFXButton retour_btn;
    @FXML
    private JFXButton listRevision_btn;
    @FXML
    private JFXButton topRated_btn;

    JFXButton currentButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            listRevision = FXMLLoader.load(getClass().getResource("/gui/ListRevisionFXML.fxml"));
            topRated = FXMLLoader.load(getClass().getResource("/gui/TopRatedMentorsFXML.fxml"));

        } catch (IOException ex) {
            Logger.getLogger(RevisionMainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        listRevision_btn.setStyle(" -fx-border-width: 0 4 0 0;\n"
                + "    -fx-border-color:  #ff2e44;"
                + "-fx-background-radius:0;");
        currentButton = listRevision_btn;
        setNode(listRevision);
    }

    @FXML
    private void goToListRevision(ActionEvent event) {
        setNode(listRevision);
        changeStyle(listRevision_btn);
        
    }

    @FXML
    private void goToTopRated(ActionEvent event) {
        setNode(topRated);
        changeStyle(topRated_btn);
    }

    private void setNode(Node node) {
        Container.getChildren().clear();
        Container.getChildren().add((Node) node);
    }

    private void changeStyle(JFXButton button) {

        button.setStyle(" -fx-border-width: 0 4 0 0;\n"
                + "    -fx-border-color:  #ff2e44;"
                + "-fx-background-radius:0;");
        currentButton.setStyle("-fx-border-width: 0 0 0 0;"
                + "-fx-background-radius:0;");

        currentButton = button;

    }

}
