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
import models.Revision;
import services.RevisionService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class TopRatedMentorsFXMLController implements Initializable {

    @FXML
    private AnchorPane top_etudiant;
    @FXML
    private AnchorPane top_prof;
      private ObservableList<Revision> mentor_prof;
        private ObservableList<Revision> mentor_etu;
@FXML
    private ListView<Revision> listtopprof;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //System.out.println(es.getAll().toString());
       mentor_prof = FXCollections.observableArrayList();
       mentor_prof.addAll(es.getAll());
        listtopprof.setItems(mentor_prof);
    listtopprof.setCellFactory(revisionListView -> new Row_TopRated_MentorController());
           }    
    
}
