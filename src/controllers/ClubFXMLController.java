/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author majdi
 */
public class ClubFXMLController implements Initializable {

    @FXML
    private Pane img_event_id;

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane anchorPane_id;

    AnchorPane eventclub;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void GoToEvenement(MouseEvent event) {
        try {

            eventclub = FXMLLoader.load(getClass().getResource("/gui/EvenementFXML.fxml"));
            anchorPane_id.getChildren().clear();
            anchorPane_id.getChildren().add(eventclub);
        } catch (Exception e) {
            System.out.println("Can load new window");
        }
    }
}
