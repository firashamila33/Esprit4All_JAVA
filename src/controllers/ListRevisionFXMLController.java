/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author asus
 */
public class ListRevisionFXMLController implements Initializable {

    @FXML
    private ListView<Revision> revision_lv;
    private ObservableList<Revision> revision;
    @FXML
    private Button creer_fentre;

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

    @FXML
    private void ajout_grp_rev(ActionEvent event) {
        try{
                    FXMLLoader fXMLLoader=new FXMLLoader(getClass().getResource("/gui/fentre_ajout_grp_revision.fxml"));
                    Parent root=(Parent) fXMLLoader.load();
                 
                   
                       
                    
                    
                    Stage stage=new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                }catch(IOException e){
                    e.printStackTrace();
                }
                
        
       
       
        
    }
    

}
   


