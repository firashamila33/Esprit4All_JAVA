/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import org.controlsfx.control.Rating;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Revision;
import models.User;
import models.note_revision;
import models.utilisateur_has_revision;
import org.controlsfx.control.Rating;
import services.NoteRevision;
import services.RevisionService;
import services.Sutilisateur_accept_revision;
import services.Sutilisateur_has_revision;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Fenetre_groupe_revisionController implements Initializable {

    @FXML
    private AnchorPane topbar;
    @FXML
    private AnchorPane Chat;
    @FXML
    private AnchorPane compteRendu;
    @FXML
    private Button modifrevision;
    @FXML
    private ImageView setting_grp_rev;
    @FXML
    private ImageView quitter_grp_rev;
    @FXML
    private AnchorPane modification;
    @FXML
    private Label heurdebut_label;
    @FXML
    private Label heur_fin_label;
    @FXML
    private Label nbr_grp;
    @FXML
    private Label nbrmaw_grp;
    @FXML
    private Label descritpion;
    @FXML
    private Label matiere;
    @FXML
    private TextField modifgrp_userid;
    @FXML
    private TextField modifgrp_type;
    @FXML
    private TextField modifgrp_nbrmax;
    @FXML
    private TextField modifgrp_description;
    @FXML
    private TextField modifgrp_matiere;
    @FXML
    private DatePicker modifgrp_heurdepart;
    @FXML
    private DatePicker modifgrp_heurfin;
    @FXML
    private AnchorPane modiff;
    @FXML
    private Button supp_annonce;
    @FXML
    private Button description_rev;
       @FXML
      
    private Button        set_modif;
       @FXML
     private  Button quitter;
      @FXML
      private AnchorPane revision_fenetre;
    @FXML
    private Rating rate_mentor;
    @FXML
    private Button set_rate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void modif_grp_revis(ActionEvent event) {
      User u = new User(1);
modification.setVisible(true);
            modiff.setVisible(true);
            Chat.setVisible(false);
            compteRendu.setVisible(false);
        if (u.getId() == 1) {
            set_modif.setVisible(true);}
         else 
            
        {             set_modif.setVisible(true);

        }
            RevisionService rs = new RevisionService();
            Revision r = rs.getById(u.getId());
            modifgrp_userid.setText(String.valueOf(u.getId()));

            modifgrp_type.setText(r.getType());

            modifgrp_nbrmax.setText(String.valueOf(r.getNbrmax()));

            modifgrp_description.setText(r.getDescription());

            modifgrp_matiere.setText(r.getMatiere());
            

        
        
    }

    @FXML
    private void modifier_grp(ActionEvent event) {
       
        User u = new User(1);
         RevisionService rs = new RevisionService();
            Revision r = rs.getById(u.getId());
     

        String y = modifgrp_matiere.getText();
        Date date1 = new Date(modifgrp_heurdepart.getValue().toEpochDay());

        String v = modifgrp_description.getText();
        int w = parseInt(modifgrp_nbrmax.getText());

        String ty = modifgrp_type.getText();
        Date date2 = new Date(modifgrp_heurfin.getValue().toEpochDay());
      
        r.setUser(u);
        r.setMatiere(y);
        r.setNbrmax(w);
        r.setDate_debut(date1);
      
        
        r.setDescription(v);
        r.setType(ty);
         r.setDate_fin(date2);
        rs.update(r);
        modifgrp_description.clear();
        modifgrp_nbrmax.clear();
       modifgrp_matiere.clear();
        modifgrp_type.clear();
         
    }

    @FXML
    private void supprimer_annoce(ActionEvent event) {
        User u = new User(1);
        if (u.getId()==1)
        {
      supp_annonce.setVisible(true);

        }else
        {supp_annonce.setVisible(false);}
         
   RevisionService rs = new RevisionService();
   Revision r = rs.getById(u.getId());
           utilisateur_has_revision s = new utilisateur_has_revision(r, u);
           Sutilisateur_has_revision ss= new Sutilisateur_has_revision();
           ss.delete(u.getId());

 rs.delete(u.getId()); 
            System.out.println("controllers.Fenetre_groupe_revisionController.supprimer_annoce()");
            
                Stage stage = (Stage) quitter.getScene().getWindow();
                
    // do what you have to do
    stage.close();  
    }

 
 
  
    

    @FXML
    private void boutton_descrip(ActionEvent event) {
       
        RevisionService rs = new RevisionService();
     
      Revision  r= rs.getById(UserService.userStatic.getId());
        System.out.println(r);
     nbrmaw_grp.setText(String.valueOf(r.getNbrmax()));
        matiere.setText(r.getMatiere());
        descritpion.setText(r.getDescription());
        
        modification.setVisible(false);
          Chat.setVisible(false);
            compteRendu.setVisible(true);
            
    }

   
    
     @FXML
    private void quiter(ActionEvent event) throws IOException {
Stage stage = (Stage) quitter.getScene().getWindow();
    // do what you have to do
    stage.close();  
    UserService us = new  UserService();
    RevisionService rs = new RevisionService();
    Revision r = rs.getById(us.userStatic.getId());
    r.setNbrmax(r.getNbrmax()+1);
    
    }
    

    @FXML
    private void rating(ActionEvent event) {
       float rate = (float) rate_mentor.getRating();
        System.out.println(rate);
        User u = new User(1);
     UserService us = new UserService();
     RevisionService rs = new RevisionService();
    
     Revision r = rs.getById(u.getId());
     
     
       
       note_revision nr = new note_revision(r, u, rate);
        NoteRevision no = new NoteRevision();
        no.add(nr);
    }
}
    
  
        
    
    
    
    


