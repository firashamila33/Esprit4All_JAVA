/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import models.Evenement;
import services.EvenementService;

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
    
    private int id;
    @FXML
    private ImageView path_img_event_id;
    @FXML
    private JFXButton btn_commentaire_id;
    @FXML
    private ImageView path_img_club_id;
    @FXML
    private Label desc_id;
    @FXML
    private Label libel_event_id;
    @FXML
    private Label type_id;
    @FXML
    private Label date_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

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
    public void display()
    {
         EvenementService es = new EvenementService();
        Evenement e = es.getById(id);
        System.out.println(e);
   
       path_img_event_id.setImage(new Image("http://localhost/www/Esprit4All/uploads/img_event/" + e.getPath_img()));
       path_img_club_id.setImage(new Image("http://localhost/www/Esprit4All/uploads/img_club/path_img/"+e.getClub().getPath_img()));
        desc_id.setText(e.getDescription());
        libel_event_id.setText(e.getLiblle());
        type_id.setText(e.getType());
        date_id.setText(String.valueOf(e.getDate()));
    }
}
