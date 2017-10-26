/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import models.Revision;
import services.RevisionService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author asus
 */
public class ListRevisionFXMLController implements Initializable {

    @FXML
    private ListView<Revision> revision_lv;
    private ObservableList<Revision> revision;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      RevisionService es = new RevisionService();
        //System.out.println(es.getAll().toString());
       revision = FXCollections.observableArrayList();
       revision.addAll(es.getAll());
        revision_lv.setItems(revision);
       revision_lv.setCellFactory(revisionListView -> new Row_RevisionController());
       
    
}

}
