/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import services.CovoiturageService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import models.Covoiturage;
import models.User;
import services.CovoiturageService;
import static services.UserService.userStatic;
import utils.BCrypt;
import interfaces.ICovoiturageService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.HasCovoiturage;
import services.HasCovoiturageService;
import services.UserService;

/**
 *
 * @author YACINE
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private AnchorPane window1;
    @FXML
    private AnchorPane window2;
    @FXML
    private AnchorPane window3;
    @FXML
    private AnchorPane window4;
    @FXML
    private AnchorPane window5;
    @FXML
    private AnchorPane window7;
    @FXML
    private AnchorPane window8;
    @FXML
    private AnchorPane window9;
    @FXML
    private AnchorPane window10;
    @FXML
    private JFXButton button1;
    @FXML
    private JFXButton button2;
    @FXML
    private JFXButton button3;
    @FXML
    private JFXRadioButton radio1;
    @FXML
    private JFXRadioButton radio2;
    @FXML
    private JFXRadioButton radio3;
    @FXML
    private JFXRadioButton radio4;
    @FXML
    private JFXButton button5;
    @FXML
    private JFXButton button6;
    @FXML
    private JFXTextField type;
    @FXML
    private JFXTextField heure;
    @FXML
    private JFXTextField depart;
    @FXML
    private JFXTextField arrive;
    @FXML
    private JFXTextField prix;
    @FXML
    private JFXTextArea description;
    @FXML
    private ToggleGroup nbrePlace;
    @FXML
    private JFXButton ajout;
    int place;
    @FXML
    private JFXListView<Covoiturage> listViewCovoiturage;
    public ObservableList<Covoiturage> covoiturages;
    @FXML
    private JFXListView<HasCovoiturage> listViewHasCovoiturage;
    public ObservableList<HasCovoiturage> hasCovoiturages;
    @FXML
    private AnchorPane consulter;
    @FXML
    private JFXButton btnConsulter;
    @FXML
    private JFXButton button31;
    @FXML
    private AnchorPane annonce;
    @FXML
    private JFXButton returnA;
    @FXML
    private AnchorPane window61;
    @FXML
    private AnchorPane window71;
    @FXML
    private ToggleGroup nbrePlace1;
    @FXML
    private JFXButton modifier;
    @FXML
    private JFXButton supprimer;
    @FXML
    private JFXButton add;
    @FXML
    private JFXTextField typeAnnonce;
    @FXML
    private JFXTextField heureAnnonce;
    @FXML
    private JFXTextField departAnnonce;
    @FXML
    private JFXTextField arriveAnnonce;
    @FXML
    private JFXRadioButton radio1Annonce;
    @FXML
    private JFXRadioButton radio2Annonce;
    @FXML
    private JFXRadioButton radio3Annonce;
    @FXML
    private JFXRadioButton radio4Annonce;
    @FXML
    private JFXTextField prixAnnonce;
    @FXML
    private JFXTextArea descriptionAnnonce;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == button1) {
            window2.setVisible(false);
            window5.setVisible(true);
        } else if (event.getSource() == button2) {
            window2.setVisible(false);
            window8.setVisible(true);
        } else if (event.getSource() == button3) {
            window2.setVisible(true);
            window5.setVisible(false);
        } else if (event.getSource() == button5) {
            window8.setVisible(false);
            window2.setVisible(true);
        } else if (event.getSource() == button6) {
            window8.setVisible(false);
            window5.setVisible(true);
        } else if (event.getSource() == returnA) {
            window2.setVisible(true);
            annonce.setVisible(false);
        } else if (event.getSource() == btnConsulter) {
            window2.setVisible(false);
            annonce.setVisible(true);
            Covoiturage covoiturage;
            CovoiturageService covoiturageService = new CovoiturageService();
            covoiturage = covoiturageService.getByUserId(2);
            typeAnnonce.setText(covoiturage.getType());
            heureAnnonce.setText(covoiturage.getHeureDépart());
            departAnnonce.setText(covoiturage.getDepart());
            arriveAnnonce.setText(covoiturage.getArrivé());
            prixAnnonce.setText(Double.toString(covoiturage.getPrix()));
            descriptionAnnonce.setText(covoiturage.getDescription());

            if (Integer.toString(covoiturage.getNbrePlace()).equals(radio1Annonce.getText())) {
                radio1Annonce.setSelected(true);
                radio2Annonce.setSelected(false);
                radio3Annonce.setSelected(false);
                radio4Annonce.setSelected(false);
            } else if (radio2Annonce.getText().equals(Integer.toString(covoiturage.getNbrePlace()))) {
                radio1Annonce.setSelected(false);
                radio2Annonce.setSelected(true);
                radio3Annonce.setSelected(false);
                radio4Annonce.setSelected(false);
            } else if (radio3Annonce.getText().equals(Integer.toString(covoiturage.getNbrePlace()))) {
                radio1Annonce.setSelected(false);
                radio2Annonce.setSelected(false);
                radio3Annonce.setSelected(true);
                radio4Annonce.setSelected(false);
            } else if (radio4Annonce.getText().equals(Integer.toString(covoiturage.getNbrePlace()))) {
                radio1Annonce.setSelected(false);
                radio2Annonce.setSelected(false);
                radio3Annonce.setSelected(false);
                radio4Annonce.setSelected(true);
            }
            HasCovoiturageService hasCovoiturageService = new HasCovoiturageService();
            hasCovoiturages = FXCollections.observableArrayList(hasCovoiturageService.getAll());
            listViewHasCovoiturage.setItems(hasCovoiturages);
            listViewHasCovoiturage.setCellFactory(hasCovoiturageListView -> new RowParticipantController());

        }
        if (event.getSource() == modifier) {
            typeAnnonce.setDisable(false);
            heureAnnonce.setDisable(false);
            departAnnonce.setDisable(false);
            arriveAnnonce.setDisable(false);
            radio1Annonce.setDisable(false);
            radio2Annonce.setDisable(false);
            radio3Annonce.setDisable(false);
            radio4Annonce.setDisable(false);
            prixAnnonce.setDisable(false);
            descriptionAnnonce.setDisable(false);
            modifier.setVisible(false);
            supprimer.setVisible(false);
            add.setVisible(true);
        } else if (event.getSource() == add) {
            modifier.setVisible(true);
            supprimer.setVisible(true);
            add.setVisible(false);
            typeAnnonce.setDisable(true);
            heureAnnonce.setDisable(true);
            departAnnonce.setDisable(true);
            arriveAnnonce.setDisable(true);
            radio1Annonce.setDisable(true);
            radio2Annonce.setDisable(true);
            radio3Annonce.setDisable(true);
            radio4Annonce.setDisable(true);
            prixAnnonce.setDisable(true);
            descriptionAnnonce.setDisable(true);
            CovoiturageService covoiturageService = new CovoiturageService();
            UserService userService = new UserService();
            int nbr = 0;
            if (radio1Annonce.isSelected()) {
                nbr = Integer.parseInt(radio1Annonce.getText());
            } else if (radio2Annonce.isSelected()) {
                nbr = Integer.parseInt(radio2Annonce.getText());
            } else if (radio3Annonce.isSelected()) {
                nbr = Integer.parseInt(radio3Annonce.getText());
            } else if (radio4Annonce.isSelected()) {
                nbr = Integer.parseInt(radio4Annonce.getText());
            }
            Covoiturage covoiturage = new Covoiturage(2, userService.getUserById(2), typeAnnonce.getText(), Double.parseDouble(prixAnnonce.getText()), departAnnonce.getText(), arriveAnnonce.getText(), descriptionAnnonce.getText(), nbr, heureAnnonce.getText());
            covoiturageService.update(covoiturage);
        } else if (event.getSource() == supprimer) {
            CovoiturageService covoiturageService = new CovoiturageService();
            covoiturageService.delete(11);
            modifier.setText("");
            supprimer.setText("");
            add.setText("");
            typeAnnonce.setText("");
            heureAnnonce.setText("");
            departAnnonce.setText("");
            arriveAnnonce.setText("");
            prixAnnonce.setText("");
            descriptionAnnonce.setText("");
            if (radio1Annonce.isSelected()) {
                radio1Annonce.setSelected(false);
            } else if (radio2Annonce.isSelected()) {
                radio2Annonce.setSelected(false);
            } else if (radio3Annonce.isSelected()) {
                radio3Annonce.setSelected(false);
            } else if (radio4Annonce.isSelected()) {
                radio4Annonce.setSelected(false);
            }
            annonce.setVisible(false);
            window5.setVisible(true);
        }
        String typeV = type.getText();
        String heureV = heure.getText();
        String departV = depart.getText();
        String arriveV = arrive.getText();
        String prixString = prix.getText();
        double prixV = Double.parseDouble(prixString);
        String descriptionV = description.getText();
        String originalPassword = "azerty";
        String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
        User u = new User(2, "yacine", "yacine.farhat@esprit.tn", 1, generatedSecuredPasswordHash, "farhat", "yacine", null, "12345678", "cité olympique");
        Covoiturage covoiturage = new Covoiturage(u, typeV, prixV, departV, arriveV, descriptionV, place, heureV);
        System.out.println(covoiturage);
        CovoiturageService covoiturageService = new CovoiturageService();
        covoiturageService.add(covoiturage);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CovoiturageService covoiturageService = new CovoiturageService();
        covoiturages = FXCollections.observableArrayList(covoiturageService.getAll());
        listViewCovoiturage.setItems(covoiturages);
        listViewCovoiturage.setCellFactory(covoiturageListView -> new RowCovoiturageController());
        ///////
        HasCovoiturageService hasCovoiturageService = new HasCovoiturageService();
        hasCovoiturages = FXCollections.observableArrayList(hasCovoiturageService.getAll());
        listViewHasCovoiturage.setItems(hasCovoiturages);
        listViewHasCovoiturage.setCellFactory(hasCovoiturageListView -> new RowParticipantController());
    }

    @FXML
    private void Ajouter(ActionEvent event) {
        String nbrePlaceV = "";
        if (radio1.isSelected()) {
            nbrePlaceV = radio1.getText();
        }
        if (radio2.isSelected()) {
            nbrePlaceV = radio2.getText();
        }
        if (radio3.isSelected()) {
            nbrePlaceV = radio3.getText();
        }
        if (radio4.isSelected()) {
            nbrePlaceV = radio4.getText();
        }
        place = Integer.parseInt(nbrePlaceV);
    }
}
