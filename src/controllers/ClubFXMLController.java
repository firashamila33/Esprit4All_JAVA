/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Club;
import models.Evenement;
import models.Membre;
import models.Profil;
import services.ClubService;
import services.EvenementService;
import services.MembreService;
import services.ProfilService;
import utils.URLimages;

/**
 * FXML Controller class
 *
 * @author majdi
 */
public class ClubFXMLController implements Initializable {

    public ObservableList<Profil> profils;
    List<Membre> membres = new ArrayList<>();
    AnchorPane eventclub;
    private int id;
    @FXML
    private AnchorPane anchorPane_id;
    @FXML
    private ScrollPane scrollpane_verticale_id;
    @FXML
    private Pane list_membre;
    @FXML
    private JFXListView<Profil> lit_view_membre;
    @FXML
    private JFXButton btn_evenement_id;
    @FXML
    private ImageView path_couverture_id;
    @FXML
    private Label libelle_clib_id;
    @FXML
    private ImageView path_img_id;
    private ImageView img_event_id;
    @FXML
    private Text NotreHistoire;
    @FXML
    private Text apropos;
    @FXML
    private Pane goTolastEvent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClubFXMLController() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public void display() {
        EvenementService es = new EvenementService();
        ClubService cs = new ClubService();

        Club c = cs.getById(id);
        System.out.println(id+"saaadsqdqds");
        List<Evenement> list = es.getByClub(id);
        Evenement dernier_event;
        dernier_event = list.get(list.size() - 1);
        libelle_clib_id.setText(c.getLibelle());
        path_img_id.setImage(new Image(URLimages.LogoClubs + c.getPath_img()));
        path_couverture_id.setImage(new Image(URLimages.CouverturesClubs + c.getPath_couverture()));
        //img_event_id.setImage(new Image(URLimages.imagesEvents + dernier_event.getPath_img()));
        NotreHistoire.setText(c.getNotreHistoire());
        apropos.setText(c.getApropos());

        profils = FXCollections.observableArrayList();

        ProfilService profilService = new ProfilService();
        MembreService membreService = new MembreService();

        membres = membreService.getByClub(c);
        for (Membre membre : membres) {
            profils.add(profilService.getByUserId(membre.getUser().getId()));
        }
        System.out.println(profils);
        lit_view_membre.setItems(profils);
        lit_view_membre.setCellFactory(evenementListView -> new MembreFXMLController());
        goTolastEvent.setOnMouseClicked(event->{
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/gui/EvenementCFXML.fxml"));
            AnchorPane p;
            try {
                p = (AnchorPane) fXMLLoader.load();
                EvenementCFXMLController controller = fXMLLoader.<EvenementCFXMLController>getController();
                controller.setId(dernier_event.getId());
                controller.setIdClub(id);
                controller.display();
                MainFXMLController.setNode(p);
            } catch (IOException ex) {
                Logger.getLogger(ClubFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    private void GoToEvenement(ActionEvent event) {
        


    }

    @FXML
    private void backTo(ActionEvent event) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/gui/MainVieSocialFXML.fxml"));
            AnchorPane p = (AnchorPane) fXMLLoader.load();
            MainFXMLController.setNode(p);
        } catch (Exception e) {

            System.out.println("interface introuvable");
        }
    }

    @FXML
    private void GoToEvenementDeClub(ActionEvent event) {

    }


}
