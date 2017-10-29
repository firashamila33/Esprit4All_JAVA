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
import javafx.scene.layout.StackPane;
import models.Club;
import services.ClubService;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class ListClubFXMLController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private JFXListView<Club> list_even_club;
    public ObservableList<Club> clubs;
    ClubService cs = new ClubService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //lister les clubs 
        clubs = FXCollections.observableArrayList(cs.getAll());
        list_even_club.setItems(clubs);
        list_even_club.setCellFactory(clubListView -> new RowClubFXMLController());
    }

}
