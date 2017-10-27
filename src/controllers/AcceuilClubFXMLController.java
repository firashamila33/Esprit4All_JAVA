/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.Evenement;
import services.EvenementService;

/**
 * FXML Controller class
 *
 * @author majdi
 */
public class AcceuilClubFXMLController implements Initializable {

    @FXML
    private FlowPane flowpane_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EvenementService es = new EvenementService();
        for (int i = 1; i < 7; i++) {
            ImageView im = new ImageView(new Image("ressources/USERGROUPS.png"));
            ImageView m = new ImageView(new Image("ressources/AAA.jpg"));
           // m.setImage(new Image("http://localhost/www/Esprit4All/uploads/img_event/" + es.getById(i).getPath_img()));
            Label l = new Label();
            VBox vb = new VBox();
            HBox hb = new HBox();

            l.setText(es.getById(i).getLiblle());
            l.setMinWidth(350);
            vb.getChildren().add(m);
            hb.getChildren().addAll(im, l);
            vb.getChildren().add(hb);

            l.setMinWidth(350);
            m.setFitWidth(400);
            m.setFitHeight(180);
            im.setFitWidth(20);
            im.setFitHeight(20);

            m.setStyle("-fx-effect : dropshadow(gaussian, rgb(0.15, 0.15, 0.15, 0.15), 6.0, 0.7, 0.0,1.5) ;\n");
            l.setStyle("-fx-padding: 10px;\n "
                    + "-fx-font-family : Arial , BOLD;\n"
                    + "-fx-font-weight :  bold;\n"
                    + "-fx-border-width: 0 0 2 0 ;"
                    + "-fx-border-color: #ff2e44 ;");
            vb.setStyle("-fx-padding: 10px;\n");
            hb.setStyle("-fx-padding: 10px 0px 0px 0px;\n");

            flowpane_id.getChildren().add(vb);
        }
    }

}
