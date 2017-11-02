/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import models.Club;
import models.Evenement;
import services.ClubService;
import services.EvenementService;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class ListEventClubFXMLController implements Initializable {
    
    @FXML
    private StackPane anchor;
    @FXML
    private JFXListView<Evenement> list_even;
    public ObservableList<Evenement> evenements;
    EvenementService es = new EvenementService();
    Club club;
    @FXML
    private JFXDialogLayout addDialogLayout;
    @FXML
    private JFXTextField libelle_tf;
    @FXML
    private JFXTextArea Description_tf;
    @FXML
    private JFXTextField img_path_tf;
    @FXML
    private JFXButton parcourir_img;
    @FXML
    private JFXButton add_btn;
    @FXML
    private JFXComboBox<String> Type;
    @FXML
    private Label formLibelle_lbl;
    @FXML
    private JFXDatePicker date_tf;
    private JFXDialog dialog;
    private String imgPath;
    @FXML
    private AnchorPane p;
    @FXML
    private JFXButton add_btn_layout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Type.getItems().addAll("Privé", "Public");
        club = new ClubService().getClubByUser(UserService.userStatic.getId());
        evenements = FXCollections.observableArrayList(es.getByClub(club.getId()));
        list_even.setItems(evenements);
        list_even.setCellFactory(evenementListView -> new RowEventFXMLController());
    }
    
    @FXML
    private void parcourir_img(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        fileChooser.getExtensionFilters().add(extFilterJPG);
        fileChooser.setTitle("Choisir une image");
        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            setImgPath();
            img_path_tf.setText(file.getName());
        }
    }
    
    @FXML
    private void addAction(ActionEvent event) {
        
        LocalDate date = date_tf.getValue();
        Date dateL = java.sql.Date.valueOf(date);
        Evenement evenz = new Evenement(libelle_tf.getText(), Type.getSelectionModel().getSelectedItem(), Description_tf.getText(), dateL, imgPath,club);
        es.add(evenz);
        displayAll();
        
        cleanTf();
        dialog.close();
    }
    
    private void cleanTf() {
        libelle_tf.clear();
        Description_tf.clear();
        img_path_tf.clear();
        
    }
    
    private void fillTf(Evenement c) {
        
        libelle_tf.setText(c.getLiblle());
        Description_tf.setText(c.getDescription());
        img_path_tf.setText(c.getPath_img());
        Type.getSelectionModel().select(c.getType());
        
    }
    
    private void showDialog() {
        dialog = new JFXDialog(anchor, addDialogLayout, JFXDialog.DialogTransition.CENTER);
        dialog.setOverlayClose(true);
        addDialogLayout.setVisible(true);
        dialog.setOnDialogClosed(event -> {
            cleanTf();   
        });
        dialog.show();
    }
    
    public void setImgPath() {
        imgPath = System.currentTimeMillis() + ".jpg";
    }
    
    void displayAll() {
        club = new ClubService().getClubByUser(UserService.userStatic.getId());
        evenements = FXCollections.observableArrayList(es.getByClub(club.getId()));
        list_even.setItems(evenements);
        list_even.setCellFactory(evenementListView -> new RowEventFXMLController());
    }
    
    @FXML
    private void showAddFormAction(ActionEvent event) {
        showDialog();
    }
}
