/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.Club;
import models.Evenement;
import models.Profil;
import models.User;
import services.ClubService;
import services.EvenementService;

/**
 * FXML Controller class
 *
 * @author majdi
 */
public class ClubFXMLController implements Initializable {

    public ObservableList<Profil> profils;
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
    @FXML
    private ImageView img_event_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClubFXMLController() {
        profils = FXCollections.observableArrayList();
        profils.addAll(new Profil(new User(), "", "", "", "icons8_User_96px_1", "", "", "", "", "", ""),
                new Profil(new User(), "", "", "", "icons8_User_96px_1", "", "", "", "", "", ""),
                new Profil(new User(), "", "", "", "icons8_User_96px_1", "", "", "", "", "", ""),
                new Profil(new User(), "", "", "", "icons8_User_96px_1", "", "", "", "", "", ""),
                new Profil(new User(), "", "", "", "icons8_User_96px_1", "", "", "", "", "", ""),
                new Profil(new User(), "", "", "", "icons8_User_96px_1", "", "", "", "", "", ""),
                new Profil(new User(), "", "", "", "icons8_User_96px_1", "", "", "", "", "", ""));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        ProfilService ps = new ProfilService();
//        profils = FXCollections.observableArrayList(ps.getAll());

        lit_view_membre.setItems(profils);
        lit_view_membre.setCellFactory(evenementListView -> new MembreFXMLController());
    }

    @FXML
    private void GoToEvenement(MouseEvent event) {
        try {

            eventclub = FXMLLoader.load(getClass().getResource("/gui/EvenementFXML.fxml"));
            anchorPane_id.getChildren().clear();
            anchorPane_id.getChildren().add(eventclub);
        } catch (Exception e) {
            System.out.println("Can load new window");
        }
    }

    public void display() {
        EvenementService es = new EvenementService();
        ClubService cs = new ClubService();

        Club c = cs.getById(id);
        List<Evenement> list = es.getByGroupe(id);

        path_img_id.setImage(new Image("http://localhost/www/Esprit4All/uploads/img_club/path_img/" + c.getPath_img()));
        path_couverture_id.setImage(new Image("http://localhost/www/Esprit4All/uploads/img_club/path_couvert/" + c.getPath_couverture()));
        libelle_clib_id.setText(c.getLibelle());
        System.out.println(list.get(list.size()-1).getPath_img());
        img_event_id.setImage(new Image("http://localhost/www/Esprit4All/uploads/img_event/" + list.get(list.size()-1).getPath_img()));

    }

    @FXML
    private void GoToEvenementDeClub(ActionEvent event) {
    }
}
