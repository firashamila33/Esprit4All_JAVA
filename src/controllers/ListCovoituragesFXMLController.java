/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import models.Covoiturage;
import services.CovoiturageService;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class ListCovoituragesFXMLController implements Initializable {

    private JFXDialog dialog;

    @FXML
    private JFXListView<Covoiturage> listcovoiturage_lv;
    @FXML
    private JFXDatePicker date_tf;
    private JFXTimePicker time_tf = new JFXTimePicker();

    CovoiturageService covoiturageService = new CovoiturageService();
    public ObservableList<Covoiturage> covoiturages;
    @FXML
    private StackPane anchor;

    @FXML
    private HBox filter_hb;

    List<Covoiturage> listCovoiturages = new ArrayList<>();

    @FXML
    private JFXTextField typeAnnonce;
    @FXML
    private HBox datetimeAnnance;

    private JFXTimePicker timeAnnaonce = new JFXTimePicker();

    @FXML
    private JFXDatePicker heureAnnonce;
    @FXML
    private JFXTextField departAnnonce;
    @FXML
    private JFXTextField arriveAnnonce;
    @FXML
    private JFXRadioButton radio1Annonce;
    @FXML
    private ToggleGroup nbrePlace1;
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
    private JFXButton add;
    @FXML
    private AnchorPane window71;
    static int place;
    @FXML
    private JFXDialogLayout addDialogLayout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        filter_hb.getChildren().add(time_tf);
        timeAnnaonce.setPrefHeight(50.0);
        datetimeAnnance.getChildren().add(timeAnnaonce);

        date_tf.setDefaultColor(Color.valueOf("#ff2e44"));
        time_tf.setIs24HourView(true);
        time_tf.setDefaultColor(Color.valueOf("#ff2e44"));
        displayAll();
    }

    @FXML
    private void ShowDialog(ActionEvent event) {

        ShowAddDialog();

    }

    private void ShowAddDialog() {
        heureAnnonce.setDefaultColor(Color.valueOf("#ff2e44"));
        timeAnnaonce.setIs24HourView(true);
        timeAnnaonce.setDefaultColor(Color.valueOf("#ff2e44"));
        dialog = new JFXDialog(anchor, addDialogLayout, JFXDialog.DialogTransition.CENTER);
        dialog.setOverlayClose(true);
        addDialogLayout.setVisible(true);
        dialog.show();

    }
    @FXML
    private void RadioBox(ActionEvent event) {
        String nbrePlaceV = "";
        if (radio1Annonce.isSelected()) {
            nbrePlaceV = radio1Annonce.getText();
        }
        if (radio2Annonce.isSelected()) {
            nbrePlaceV = radio2Annonce.getText();
        }
        if (radio3Annonce.isSelected()) {
            nbrePlaceV = radio3Annonce.getText();
        }
        if (radio4Annonce.isSelected()) {
            nbrePlaceV = radio4Annonce.getText();
        }
        System.out.println(nbrePlace1+"sss");
        place = Integer.parseInt(nbrePlaceV);
    }

    public void displayAll() {
        listCovoiturages = covoiturageService.getAll();
        covoiturages = FXCollections.observableArrayList(listCovoiturages);

        listcovoiturage_lv.setItems(covoiturages);

        listcovoiturage_lv.setCellFactory(covoiturageListView -> new RowCovoiturageController(anchor));
    }

    @FXML
    private void Ajouter(ActionEvent event) {
        
        System.out.println(place);
        String date = heureAnnonce.getValue() + " " + timeAnnaonce.getValue();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date startDate = null;
        try {
            startDate = df.parse(date);
            String newDateString = df.format(startDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Covoiturage covoiturage = new Covoiturage(UserService.userStatic, Double.parseDouble(prixAnnonce.getText()), departAnnonce.getText(), arriveAnnonce.getText(), descriptionAnnonce.getText(), place, new java.sql.Date(startDate.getTime()),typeAnnonce.getText());
        covoiturageService.add(covoiturage);
        displayAll();
        dialog.close();
    }
}
