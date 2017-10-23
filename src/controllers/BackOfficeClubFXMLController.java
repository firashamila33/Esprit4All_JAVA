/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import interfaces.IClubService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import models.Club;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import models.User;
import services.ClubService;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class BackOfficeClubFXMLController implements Initializable {

    /**
     * FXML Composant Declaration
     */
    @FXML
    private StackPane tablePane;
    @FXML
    private TableView<Club> clubs_table;
    @FXML
    private TableColumn<Club, String> col_libelle;
    @FXML
    private TableColumn<Club, String> col_description;
    @FXML
    private TableColumn<Club, String> col_logo;
    @FXML
    private TableColumn<Club, String> col_couverture;
    @FXML
    private TableColumn<Type, Void> col_option;
    @FXML
    private JFXDialogLayout addDialogLayout;
    @FXML
    private JFXTextField libelle_tf;
    @FXML
    private JFXTextField Description_tf;
    @FXML
    private JFXTextField logo_path_tf;
    @FXML
    private JFXTextField couverture_path_tf;
    @FXML
    private JFXButton add_btn_layout;
    @FXML
    private JFXButton add_btn;
    @FXML
    private JFXTextField recherche_tf;
    @FXML
    private Label formLibelle_lbl;
    /**
     * Attribue
     */
    JFXDialog dialog;
    IClubService clubService;
    Boolean updateTest = false;
    Club clubTest;
    List<Club> clubsList = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clubService = new ClubService();
        clubsList = clubService.getAll();
        setLabelFlat();
        displayAll();
        
        recherche_tf.setOnKeyPressed((KeyEvent event) -> {
            recherche_tf.textProperty().addListener((observable, oldValue, newValue) -> {
                clubs_table.setItems(FXCollections.observableArrayList(clubsList.stream().filter(club -> club.getLibelle().contains(newValue)||club.getDescription().contains(newValue)).collect(Collectors.toList())));
                
            });
        });
    }

    /**
     * Methode qui permet d'afficher le formulaire d'ajout ou de modification
     */
    @FXML
    private void showAddFormAction(ActionEvent event) {
        showDialog();
    }

    /**
     * Methode qui permet de ajouter dans la base de donnée
     */
    @FXML
    private void addAction(ActionEvent event) {
        
        if (updateTest == true) {
            clubTest = new Club(clubTest.getId(), libelle_tf.getText(), Description_tf.getText(), logo_path_tf.getText(), couverture_path_tf.getText(), new User(1));
            clubService.update(clubTest);
            displayAll();
            updateTest = false;
            
        } else {
            clubTest = new Club(libelle_tf.getText(), Description_tf.getText(), logo_path_tf.getText(), couverture_path_tf.getText(), new User(1));
            clubService.add(clubTest);
            displayAll();
        }
        cleanTf();
        dialog.close();
    }
    
    private void setLabelFlat() {
        libelle_tf.setLabelFloat(true);
        logo_path_tf.setLabelFloat(true);
        couverture_path_tf.setLabelFloat(true);
        Description_tf.setLabelFloat(false);
    }
    
    private void cleanTf() {
        libelle_tf.clear();
        Description_tf.clear();
        couverture_path_tf.clear();
        logo_path_tf.clear();
        
    }
    
    private void fillTf(Club c) {
        System.out.println(c.toString());
        libelle_tf.setText(c.getLibelle());
        Description_tf.setText(c.getDescription());
        logo_path_tf.setText(c.getPath_img());
        couverture_path_tf.setText(c.getPath_couverture());
    }
    
    private void displayAll() {
        ObservableList list = FXCollections.observableArrayList();
        clubService.getAll().stream().forEach((club) -> {
            list.add(club);
        });
        col_libelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_logo.setCellValueFactory(new PropertyValueFactory<>("path_img"));
        col_couverture.setCellValueFactory(new PropertyValueFactory<>("path_couverture"));
        col_option.setCellFactory((TableColumn<Type, Void> param) -> {
            
            return new TableCell<Type, Void>() {
                application.Button update = new application.Button();
                application.Button delete = new application.Button();
                
                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                    update.setGraphic(new ImageView("ressources/Updates-24.png"));
                    update.setStyle("-fx-background-color: transparent;");
                    delete.setGraphic(new ImageView("ressources/Delete-24.png"));
                    delete.setStyle("-fx-background-color: transparent;");
                    
                    Club club = (Club) getTableRow().getItem();
                    
                    delete.setOnAction(event -> {
                        clubService.delete(club.getId());
                        displayAll();
                        
                    });
                    update.setOnAction(event -> {
                        updateTest = true;
                        clubTest = club;
                        fillTf(clubTest);
                        
                        showDialog();
                    });
                    HBox hBox = new HBox();
                    hBox.setAlignment(Pos.CENTER);
                    hBox.getChildren().addAll(update, delete);
                    final Node graphic1 = (empty) ? null : hBox;
                    setGraphic(graphic1);
                }
            };
        });
        clubs_table.setItems(list);
    }
    
    private void showDialog() {
        dialog = new JFXDialog(tablePane, addDialogLayout, JFXDialog.DialogTransition.CENTER);
        dialog.setOverlayClose(true);
        addDialogLayout.setVisible(true);
        if (updateTest == true) {
            add_btn.setText("Modifier");
            formLibelle_lbl.setText("Modifier Club");
        } else {
            add_btn.setText("Ajouter");
            formLibelle_lbl.setText("Ajouter Club");
        }
        dialog.show();
    }
    
}
