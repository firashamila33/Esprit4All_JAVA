/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import models.Revision;
import models.User;
import services.RevisionService;
import services.UserService;

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
    private ListView<Revision> list_topetu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        RevisionService es = new RevisionService();
//        UserService x = new UserService();
//
//        /* //System.out.println(es.getAll().toString());
//        /*   mentor_prof = FXCollections.observableArrayList(es.getAll());
//        mentor_etu = FXCollections.observableArrayList(es.getAll());
//        listtopprof.setItems(mentor_prof);
//        listtopprof.setCellFactory(e-> new Row_TopRated_MentorController());
//        list_topetu.setItems(mentor_etu);
//        list_topetu.setCellFactory(f-> new Row_TopRated_MentorController());*/
//        List<User> w = x.getAll();
//        for (User u : w) {
//            if (u.getRole().equals("ROLE_ETUDIANT")) {
//                mentor_etu = FXCollections.observableArrayList(es.getAll());
//                list_topetu.setItems(mentor_etu);
//                list_topetu.setCellFactory(f -> new Row_TopRated_MentorController());
//            } else {
//              mentor_prof = FXCollections.observableArrayList(es.getAll());
//              listtopprof.setItems(mentor_prof);
//        listtopprof.setCellFactory(e -> new Row_TopRated_MentorController());
//            }
//
//        }
    }
}
