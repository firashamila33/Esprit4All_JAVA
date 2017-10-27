/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author majdi
 */
public class EvenementFXMLController implements Initializable {

    @FXML
    private ImageView back_id;
    @FXML
    private AnchorPane anchorPanrEV_id;
    AnchorPane club;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void backToClub(MouseEvent event) {
        try {
            club = FXMLLoader.load(getClass().getResource("/gui/ClubFXML.fxml"));
            anchorPanrEV_id.getChildren().clear();
            anchorPanrEV_id.getChildren().add(club);
        } catch (Exception e) {

            System.out.println("interface introuvable");
        }

    }
}
