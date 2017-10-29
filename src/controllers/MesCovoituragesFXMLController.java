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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class MesCovoituragesFXMLController implements Initializable {

    @FXML
    private StackPane anchor;
    @FXML
    private JFXListView<Covoiturage> listcovoiturage_lv;
    @FXML
    private HBox filter_hb;
    @FXML
    private JFXDatePicker date_tf;
    
    
    int place;
    
    private JFXTimePicker time_tf = new JFXTimePicker();
    List<Covoiturage> listCovoiturages = new ArrayList<>();
    CovoiturageService covoiturageService = new CovoiturageService();
    public ObservableList<Covoiturage> covoiturages;
    private JFXDialog dialog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filter_hb.getChildren().add(time_tf);
        date_tf.setDefaultColor(Color.valueOf("#ff2e44"));
        time_tf.setIs24HourView(true);
        time_tf.setDefaultColor(Color.valueOf("#ff2e44"));
        displayAll();
    }

    public void displayAll() {
        listCovoiturages = covoiturageService.getByUserId(UserService.userStatic.getId());
        covoiturages = FXCollections.observableArrayList(listCovoiturages);
        listcovoiturage_lv.setItems(covoiturages);
        listcovoiturage_lv.setCellFactory(covoiturageListView -> new RowMesCovoiturageController(anchor));
    }

}
