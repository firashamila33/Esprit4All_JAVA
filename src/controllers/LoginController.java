/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import services.UserService;
import java.time.LocalDate;
import models.User;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.BCrypt;

/**
 *
 * @author YACINE
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane window1;
    @FXML
    private AnchorPane window2;
    @FXML
    private AnchorPane winodw3;
    @FXML
    private JFXButton button1;
    @FXML
    private JFXButton button2;
    @FXML
    private AnchorPane winodw4;

    @FXML
    private DatePicker date;
    @FXML
    private AnchorPane window5;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField adresseMail;
    @FXML
    private JFXTextField mdp;
    @FXML
    private JFXTextField pseudonyme;
    @FXML
    private JFXTextField cin;
    @FXML
    private JFXTextField adresse;
    @FXML
    private JFXButton register;
    @FXML
    private JFXTextField usernameLogin;
    @FXML
    private JFXButton login;
    @FXML
    private Text champ;
    @FXML
    private JFXPasswordField mdpLogin;
    static int controle = 0;
     Stage stage;
    Parent root;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == button1) {
            window5.setVisible(true);
            winodw4.setVisible(false);
        } else if (event.getSource() == button2) {
            winodw4.setVisible(true);
            window5.setVisible(false);
        }
    }

   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }

    @FXML
    private void register(ActionEvent event) {
        String username = pseudonyme.getText();
        String email = adresseMail.getText();
        int enabled = 1;
        String password = mdp.getText();
        String generatedSecuredPasswordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        String nomUser = nom.getText();
        String prenomUser = prenom.getText();
        LocalDate dateNaissance = date.getValue();
        Date dateL = java.sql.Date.valueOf(dateNaissance);
        String cartIdentite = cin.getText();
        String adress = adresse.getText();
        User u = new User(username, email, enabled, generatedSecuredPasswordHash, nomUser, prenomUser, dateL, cartIdentite, adress);
        UserService userService = new UserService();
        if (!userService.chercherUsername(username)) {
            if (!userService.chercherEmail(email)) {
                if (!userService.chercherCIN(cartIdentite)) {
                    userService.register(u);
                    window5.setVisible(true);
                    winodw4.setVisible(false);
                    usernameLogin.setText(pseudonyme.getText());
                } else {
                    cin.setStyle("-fx-background-color:#ff2e44");
                }
            } else {
                adresseMail.setStyle("-fx-background-color:#ff2e44");
            }
        } else {
            pseudonyme.setStyle("-fx-background-color:#ff2e44");
        }
    }

    @FXML
    private void login(ActionEvent event) throws IOException {
        String usernameL = usernameLogin.getText();
        String motDePasseL = mdpLogin.getText();

        UserService userService = new UserService();
        boolean message = userService.Login(usernameL, motDePasseL);
        if ((!message) && (controle < 2)) {
            champ.setText("Pseudonyme ou mot de passe incorrect");
            usernameLogin.setStyle("-fx-background-color:#ff2e44");
            mdpLogin.setStyle("-fx-background-color:#ff2e44");
            usernameLogin.setText("");
            mdpLogin.setText("");
            controle++;
        } else if ((controle == 2) && (!message)) {
            usernameLogin.setDisable(true);
            mdpLogin.setDisable(true);
            champ.setText("Pseudonyme ou mot de passe incorrect");
        } else {
            champ.setText("Bienvenu");
            Redirection();
        }

    }

    @FXML
    private void change(KeyEvent event) {
        pseudonyme.setStyle("-fx-background-color:white");
        cin.setStyle("-fx-background-color:white");
        adresseMail.setStyle("-fx-background-color:white");
        usernameLogin.setStyle("-fx-background-color:white");
        mdpLogin.setStyle("-fx-background-color:white");
    }

    public void Redirection() throws IOException {
        stage = (Stage) login.getScene().getWindow();
        if (UserService.userStatic.getRole().equals("ROLE_ETUDIANT")||UserService.userStatic.getRole().equals("ROLE_PROFESSEUR")) {
            root = FXMLLoader.load(getClass().getResource("/gui/AcceuilFXML.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();
        }
        else
        {
            root = FXMLLoader.load(getClass().getResource("/gui/BackOfficeFXML.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();
        }

    }
}
