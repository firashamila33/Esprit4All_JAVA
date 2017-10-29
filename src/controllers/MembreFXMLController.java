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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Profil;

/**
 * FXML Controller class
 *
 * @author majdi
 */
public class MembreFXMLController extends ListCell<Profil> {

    @FXML
    private StackPane anchorpane_membre_id;
    @FXML
    private ImageView img_membre_id;
    @FXML
    private Label nom_membre_id;

    JFXDialog dialog;
    /**
     * Initializes the controller class.
     */

    private FXMLLoader mLLoader;
    private Stage stage;

    @Override
    protected void updateItem(Profil p, boolean empty) {
        super.updateItem(p, empty);

        if (empty || p == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/gui/MembreFXML.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            //img_membre_id.setImage(new Image("http://localhost/www/Esprit4All/uploads/img_profil/path_img/"+p.getPathImg(), 500 ,500 ,true,true));
            nom_membre_id.setText("Majdi Rabie");

            setOnMouseEntered(event -> {
              
                VBox vb = new VBox();
                vb.setStyle("-fx-alignment: CENTER;\n" + "-fx-padding: 5px;\n");
                JFXButton btn1 = new JFXButton("Voir Profil");
                vb.getChildren().add(btn1);
                btn1.setStyle("-fx-margin: 5px;\n");
                FlowPane fp = new FlowPane();

                JFXButton Facebook = new JFXButton();
                ImageView imgfb = new ImageView("/ressources/Facebook.png");
                imgfb.setFitWidth(20);
                imgfb.setFitHeight(20);
                Facebook.setGraphic(imgfb);

                JFXButton Linkedin = new JFXButton();
                ImageView imglk = new ImageView("/ressources/icons8_LinkedIn_48px.png");
                imglk.setFitWidth(20);
                imglk.setFitHeight(20);
                Linkedin.setGraphic(imglk);

                JFXButton Gougle = new JFXButton();
                ImageView imgG = new ImageView("/ressources/icons8_Google_Plus_48px.png");
                imgG.setFitWidth(20);
                imgG.setFitHeight(20);
                Gougle.setGraphic(imgG);

                JFXButton CV = new JFXButton();
                ImageView imgcv = new ImageView("/ressources/icons8_CV_48px_1.png");
                imgcv.setFitWidth(20);
                imgcv.setFitHeight(20);
                CV.setGraphic(imgcv);

                fp.getChildren().addAll(Facebook, Linkedin, Gougle, CV);
                vb.getChildren().add(fp);
                fp.setStyle("-fx-padding: 5px;\n");
                
                JFXDialogLayout dialogLayout = new JFXDialogLayout();
                dialogLayout.setStyle("-fx-padding: 5px 10px 10px 5px;\n ");
                dialogLayout.getChildren().add(vb);
                dialog = new JFXDialog(anchorpane_membre_id, dialogLayout, JFXDialog.DialogTransition.TOP);
                dialog.show();

            });

            setOnMouseExited(event -> {

                dialog.close();

            });

            setText(null);
            setGraphic(anchorpane_membre_id);
        }

    }

}
