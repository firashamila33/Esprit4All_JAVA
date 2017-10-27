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
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import models.Club;
import models.Evenement;

/**
 * FXML Controller class
 *
 * @author majdi
 */
public class RowClubFXMLController extends ListCell<Club> {

    @FXML
    private AnchorPane row;
    @FXML
    private ImageView path_img_id;
    @FXML
    private Label libelle_club_id;
    @FXML
    private Label decription_club_id;

    /**
     * Initializes the controller class.
     */
    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(Club clubs, boolean empty) {
        super.updateItem(clubs, empty);

        if (empty || clubs == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/gui/RowClubFXML.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            libelle_club_id.setText(clubs.getLibelle());
            decription_club_id.setText(clubs.getDescription());
            

            // img_club_id.setImage(new Image(evenements.getPath_img()));
            setText(null);
            setGraphic(row);
        }

    }
}
