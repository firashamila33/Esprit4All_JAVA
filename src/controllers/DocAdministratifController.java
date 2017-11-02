/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.SendMail.send;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import models.DocumentAdministratif;
import services.DocumentAdministratifService;
import services.UserService;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import models.User;

public class DocAdministratifController implements Initializable {

    @FXML
    private ImageView relever;
    @FXML
    private ImageView attestation;
    DocumentAdministratif da = null;
    @FXML
    private Button select_doc1;
    public static String to;
    public static String sub;
    public static String msg;
    public static String user;
    public static String pass;

    UserService us = new UserService();
    @FXML
    private Button select_doc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void relever(MouseEvent event) {
        /* DocumentAdministratifService d= new DocumentAdministratifService();
        UserService us = new UserService();
        
      
      da = new DocumentAdministratif(us.userStatic,"relever de note","1", true);
    
         */
    }

    @FXML
    private void attestation(MouseEvent event) {
        /*    DocumentAdministratifService d= new DocumentAdministratifService();

             da = new DocumentAdministratif(us.userStatic,"attestation","1", true);*/

    }

    

    @FXML
    private void envoi_demande2(ActionEvent event) {
        DocumentAdministratifService d = new DocumentAdministratifService();
  UserService us = new UserService();
        da = new DocumentAdministratif(us.userStatic, "attestation", "1", true);
        d.add(da);

        to = "yacine.farhat@esprit.tn";
        sub = "Demande de confirmation de document administratif";
        msg = "l'eleve a envoyer la demande d'obtention de releever de note lerci de confirmer ";
        user = "ilyes.elb@gmail.com";
        pass = "xxxtentacion";
   controllers.SendMail s = null;
        s.send(to, sub, msg, user, pass);    }

    @FXML
    private void envoi_demande(ActionEvent event) {
         DocumentAdministratifService d = new DocumentAdministratifService();
UserService us = new UserService();
        da = new DocumentAdministratif(us.userStatic, "relever de note", "1", true);

        d.add(da);

        to = "yacine.farhat@esprit.tn";
        sub = "Demande de confirmation de document administratif";
        msg = "l'eleveaved 'lID a envoyer la demande d'obtention de releever de note lerci de confirmer ";
        user = "ilyes.elb@gmail.com";
                pass="xxxtentacion";
        controllers.SendMail s = null;
        s.send(to, sub, msg, user, pass);
    }

}
