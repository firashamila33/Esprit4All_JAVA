/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Covoiturage;
import models.Evenement;
import services.EvenementService;
import utils.URLimages;

/**
 * FXML Controller class
 *
 * @author majdi
 */
public class AcceuilClubFXMLController implements Initializable {

    @FXML
    private FlowPane flowpane_id;
    JFXDialog dialog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EvenementService es = new EvenementService();
        List<Evenement> evenements = es.getAll();
        System.out.println(evenements.toString());

        for (int i = 0; i < evenements.size(); i++) {
            if (i == 6) {
                break;
            } else {
                Evenement e;
                e = evenements.get(i);
                ImageView im = new ImageView(new Image("ressources/USERGROUPS.png"));
                ImageView m = new ImageView(new Image("ressources/AAA.jpg"));
                System.out.println(URLimages.imagesEvents + e.getPath_img());
                m.setImage(new Image(URLimages.imagesEvents + e.getPath_img()));
                Label l = new Label();
                VBox vb = new VBox();
                HBox hb = new HBox();

                l.setText(e.getLiblle());
                l.setMinWidth(320);
                vb.getChildren().add(m);
                hb.getChildren().addAll(im, l);
                vb.getChildren().add(hb);

                l.setMinWidth(320);
                m.setFitWidth(385);
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
                vb.setOnMouseClicked((MouseEvent event) -> {
                    try {

                      
                        
                        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/gui/EvenementFXML.fxml"));
                        AnchorPane p= (AnchorPane)fXMLLoader.load();
                        EvenementFXMLController controller = fXMLLoader.<EvenementFXMLController>getController();
                        controller.setId(e.getId());
                        controller.display();
                        MainFXMLController.setNode(p);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                });
            }
        }
    }

}
