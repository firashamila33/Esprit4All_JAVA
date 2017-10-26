/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import models.Club;
import models.Evenement;
import models.User;

/**
 * FXML Controller class
 *
 * @author majdi
 */
public class Club_EvenementFXMLController implements Initializable {

    @FXML
    private JFXListView< Evenement> list_even;
    public ObservableList<Evenement> evenements;

    public Club_EvenementFXMLController() {
        evenements = FXCollections.observableArrayList();

        evenements.addAll(new Evenement("amak", "1", "ali", null, "ressources.images.jpg", new Club(16)),
                new Evenement("Quiz", "1", "aureh", null, "ressources.images.jpg", new Club(16)));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list_even.setItems(evenements);
        list_even.setCellFactory(evenementListView -> new RowEventFXMLController());
    }
}
