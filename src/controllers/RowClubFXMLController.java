/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Club;
import utils.URLimages;

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
    private Text decription_club_id;

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
            path_img_id.setImage(new Image(URLimages.LogoClubs + clubs.getPath_img(), 500, 500, true, true));

            setOnMouseClicked((MouseEvent event) -> {
                //To change body of generated methods, choose Tools | Templates.
                try {

                    FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/gui/ClubFXML.fxml"));
                    AnchorPane p = (AnchorPane) fXMLLoader.load();
                    ClubFXMLController controller = fXMLLoader.<ClubFXMLController>getController();
                    controller.setId(clubs.getId());
                    controller.display();
                    MainFXMLController.setNode(p);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            setText(null);
            setGraphic(row);
        }

    }
}
