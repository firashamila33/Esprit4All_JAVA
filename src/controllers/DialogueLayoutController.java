/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import models.Covoiturage;
import models.HasCovoiturage;
import models.Profil;
import models.User;
import services.CovoiturageService;
import services.HasCovoiturageService;
import services.ProfilService;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author YACINE
 */
public class DialogueLayoutController implements Initializable {

    @FXML
    private Text type;
    @FXML
    private Text prix;
    @FXML
    private Text depart;
    @FXML
    private Text arrive;
    @FXML
    private Text nbrePlace;
    @FXML
    private Text hDepart;
    @FXML
    private Label description;
    @FXML
    private Text name;
    @FXML
    private Text tel;
    @FXML
    private JFXButton subscribe;
    @FXML
    private AnchorPane covoiturage;
    private int id;
    @FXML
    private JFXDialogLayout dialogLayoutMessage;
    @FXML
    private Label labelDialog;
    private JFXDialog dialog;
    @FXML
    private StackPane paneMessage;
    private boolean messageTest;

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

    public void afficherDialogue(int i) {
        UserService userService = new UserService();
        User user = userService.getUserById(i);
        ProfilService profilService = new ProfilService();
        Profil profil = profilService.getByUserId(i);
        CovoiturageService covoiturageService = new CovoiturageService();
        Covoiturage covoiturageA = covoiturageService.getByUserId(i);
        type.setText(covoiturageA.getType());
        prix.setText(Double.toString(covoiturageA.getPrix()));
        depart.setText(covoiturageA.getDepart());
        arrive.setText(covoiturageA.getArrivé());
        nbrePlace.setText(Integer.toString(covoiturageA.getNbrePlace()));
        hDepart.setText(covoiturageA.getHeureDépart());
        description.setText(covoiturageA.getDescription());
        name.setText(user.getPrenom() + " " + user.getNom());
        tel.setText(profil.getTel());
    }

    @FXML
    private void ajouterUser(ActionEvent event) {
        int nbrPlace = Integer.parseInt(nbrePlace.getText());
        if (nbrPlace != 0) {
            --nbrPlace;
            UserService userService = new UserService();
            User user = userService.getUserById(id);
            CovoiturageService covoiturageService = new CovoiturageService();
            Covoiturage covoiturage1 = covoiturageService.getByUserId(id);
            covoiturage1.setNbrePlace(nbrPlace);
            covoiturageService.update(covoiturage1);
            HasCovoiturageService hasCovoiturageService = new HasCovoiturageService();
            HasCovoiturage hasCovoiturage = new HasCovoiturage(covoiturage1, user);
            hasCovoiturageService.add(hasCovoiturage);
            nbrePlace.setText(Integer.toString(nbrPlace));
        } else if (nbrPlace == 0) {
            messageTest = true;
            showDialog();
        }
    }

    private void showDialog() {
        dialog = new JFXDialog(paneMessage, dialogLayoutMessage, JFXDialog.DialogTransition.CENTER);
        dialog.setOverlayClose(true);
        dialogLayoutMessage.setVisible(true);
        if (messageTest == true) {
            labelDialog.setText("nombre de place saturé");
        }
        dialog.setOnDialogClosed(event -> messageTest = false);
        dialog.show();
    }

}
