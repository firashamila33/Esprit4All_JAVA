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
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import models.Evenement;
import services.ClubService;
import services.EvenementService;

/**
 * FXML Controller class
 *
 * @author majdi
 */
public class ListEvenementDeClubFXMLController implements Initializable {

    @FXML
    private AnchorPane acco_event_id;
    @FXML
    private ListView<Evenement> list_id_event;
    ObservableList<Evenement> event;
    int id;

    /**
     * Initializes the controller class.
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        EvenementService es = new EvenementService();

        //lester les evenements
        event = FXCollections.observableArrayList(es.getByClub(id));
        list_id_event.setItems(event);
        list_id_event.setCellFactory(evenementListView -> new RowEventFXMLController());
    }

}
