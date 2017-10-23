/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Club;
import models.User;

/**
 * FXML Controller class
 *
 * @author majdi
 */
public class ClubBackController implements Initializable {

    @FXML
    private TableView<Club> tab_club;
    @FXML
    private TableColumn<Club, String> libelle;
    @FXML
    private TableColumn<Club, String> description;
    @FXML
    private TableColumn<Club, String> path_img;
    @FXML
    private TableColumn<Club, Integer> user_id;

    @FXML
    private Button btn_aff_club;
    @FXML
    private Button btn_mod_club;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        libelle.setCellValueFactory(new PropertyValueFactory<Club, String>("libelle"));
        description.setCellValueFactory(new PropertyValueFactory<Club, String>("description"));
        path_img.setCellValueFactory(new PropertyValueFactory<Club, String>("path_img"));
        user_id.setCellValueFactory(new PropertyValueFactory<Club, Integer>("user_id"));

        tab_club.setItems(getClub());

    }

    public ObservableList<Club> getClub() {

        ObservableList<Club> clubs = FXCollections.observableArrayList();
        //clubs.add(new Club("Microsoft", "Windows", "aaa", new User(1)));

        return clubs;
    }

}
