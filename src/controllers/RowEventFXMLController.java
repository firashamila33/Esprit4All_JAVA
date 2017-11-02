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
import models.Evenement;
import utils.URLimages;

/**
 * FXML Controller class
 *
 * @author majdi
 */
public class RowEventFXMLController extends ListCell<Evenement> {

    @FXML
    private AnchorPane row;
    @FXML
    private ImageView img_evnt_id;
    @FXML
    private Label lib_event_id;
    @FXML
    private Label date_event_id;
    @FXML
    private Label type_event_id;
    @FXML
    private ImageView img_club_id;
    @FXML
    private Text desc_event_id;
    AnchorPane eventclub;
    /**
     * Initializes the controller class.
     */
    private FXMLLoader mLLoader;

    protected void updateItem(Evenement evenements, boolean empty) {
        super.updateItem(evenements, empty);

        if (empty || evenements == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/gui/RowEventFXML.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            lib_event_id.setText(evenements.getLiblle());
            img_evnt_id.setImage(new Image(URLimages.imagesEvents + evenements.getPath_img()));
            System.out.println(evenements.getClub().getPath_img());
            img_club_id.setImage(new Image(URLimages.LogoClubs + evenements.getClub().getPath_img()));

            date_event_id.setText(String.valueOf(evenements.getDate()));
            desc_event_id.setText(evenements.getDescription());
            type_event_id.setText(evenements.getType());
            setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    //To change body of generated methods, choose Tools | Templates.
                    try {

//                        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/gui/EvenementFXML.fxml"));
//                        Parent root = (Parent) fXMLLoader.load();
//                        EvenementFXMLController controller = fXMLLoader.<EvenementFXMLController>getController();
//                        controller.setId(evenements.getId());
//                        controller.display();
//                        Stage stage = new Stage();
//                        stage.setScene(new Scene(root));
//                        stage.show();
                        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/gui/EvenementAFXML.fxml"));
                        AnchorPane p = (AnchorPane) fXMLLoader.load();
                        EvenementAFXMLController controller = fXMLLoader.<EvenementAFXMLController>getController();
                        controller.setId(evenements.getId());
                        controller.display();
                        MainFXMLController.setNode(p);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            );
            setText(null);
            setGraphic(row);
        }

    }
}
