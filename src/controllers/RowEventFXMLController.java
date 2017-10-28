/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Club;
import models.Evenement;
import services.ClubService;

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
    private Label desc_event_id;
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
            img_evnt_id.setImage(new Image("http://localhost/www/Esprit4All/uploads/img_event/" + evenements.getPath_img()));
            img_club_id.setImage(new Image("http://localhost/www/Esprit4All/uploads/img_club/path_img/" + evenements.getClub().getPath_img()));

            date_event_id.setText(String.valueOf(evenements.getDate()));
            desc_event_id.setText(evenements.getDescription());
            type_event_id.setText(evenements.getType());
            setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    //To change body of generated methods, choose Tools | Templates.
                    try {

                        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/gui/EvenementFXML.fxml"));
                        Parent root = (Parent) fXMLLoader.load();
                        EvenementFXMLController controller = fXMLLoader.<EvenementFXMLController>getController();
                        controller.setId(evenements.getId());
                        controller.display();
                        

                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();

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
