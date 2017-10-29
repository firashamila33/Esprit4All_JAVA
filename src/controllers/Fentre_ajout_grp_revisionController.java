/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import models.Revision;
import models.User;
import models.utilisateur_has_revision;
import services.RevisionService;
import services.Sutilisateur_has_revision;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Fentre_ajout_grp_revisionController implements Initializable {

    @FXML
    private TextField Ajoutgrp_userid;
    @FXML
    private TextField Ajoutgrp_type;
    @FXML
    private TextField Ajoutgrp_nbrmax;
    @FXML
    private TextField Ajoutgrp_description;
    @FXML
    private DatePicker Ajoutgrp_heurfin;
    @FXML
    private DatePicker Ajoutgrp_heurdepart;
    @FXML
    private TextField Ajoutgrp_matiere;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ajouter_grp(ActionEvent event) throws ParseException {
        User u= new User(1);
        RevisionService rs = new RevisionService();
        String y = Ajoutgrp_matiere.getText();
        Date date1 = new Date(Ajoutgrp_heurdepart.getValue().toEpochDay());

        String v = Ajoutgrp_description.getText();
           int w=parseInt(Ajoutgrp_nbrmax.getText());
        
        String r = (Ajoutgrp_type.getText());
        Date date2 = new Date(Ajoutgrp_heurfin.getValue().toEpochDay());

        Revision E = new Revision(u, y, date1, v, w, r, date2);
        
     
        rs.add(E);
        
       
    
  Ajoutgrp_type.clear();
   Ajoutgrp_nbrmax.clear();
 Ajoutgrp_description.clear();
     Ajoutgrp_matiere.clear();
   

    }

}
