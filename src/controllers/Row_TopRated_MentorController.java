/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import models.Revision;
import models.User;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Row_TopRated_MentorController extends ListCell<User>  {

    @FXML
    private AnchorPane top_rated;
    @FXML
    private Button afficher_mentorProfil;
    @FXML
    private Label LabelNomMentor1LabelNomMentor;
    @FXML
    private ImageView photo_mentor1;
 private FXMLLoader mLLoader;
        JFXButton currentButton;
    private AnchorPane TopMentorinfo;
    @FXML
    private ImageView topMentorinfo;

   @Override
    protected void updateItem(User user, boolean empty) {
        
        super.updateItem(user, empty);

        if (empty || user == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/gui/Row_TopRated_MentorController.fxml"));
                mLLoader.setController(this);
 
                
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            
           setText(null);
            setGraphic(top_rated);
            }

        }

    }

}