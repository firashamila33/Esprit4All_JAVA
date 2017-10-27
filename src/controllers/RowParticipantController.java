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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import models.HasCovoiturage;
import models.User;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author YACINE
 */
public class RowParticipantController extends ListCell<HasCovoiturage> {

    @FXML
    private JFXButton btnProfil;
    @FXML
    private Text nameUser;
    @FXML
    private AnchorPane rowProfil;
    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(HasCovoiturage hasCovoiturage, boolean empty) {
        super.updateItem(hasCovoiturage, empty);
        if (empty || hasCovoiturage == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/gui/RowParticipant.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            UserService userService = new UserService();
            User user =userService.getUserById(hasCovoiturage.getU().getId());
            nameUser.setText(user.getPrenom() + " " + user.getNom());
            setText(null);
            setGraphic(rowProfil);
        }
    }

    @FXML
    private void Open(ActionEvent event) {
        
        
    }
}
