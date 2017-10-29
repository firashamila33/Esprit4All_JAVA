/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import models.Club;
import models.Evenement;
import services.ClubService;
import services.EvenementService;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class ListEventClubFXMLController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private JFXListView<Evenement> list_even;
    public ObservableList<Evenement> evenements;
    EvenementService es = new EvenementService();
    Club club;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        club = new ClubService().getClubByUser(UserService.userStatic.getId());
        evenements = FXCollections.observableArrayList(es.getByClub(club.getId()));
        list_even.setItems(evenements);
        list_even.setCellFactory(evenementListView -> new RowEventFXMLController());
    }

}
