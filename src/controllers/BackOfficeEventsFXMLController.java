/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import interfaces.IEvenementService;
import java.io.File;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import models.Club;
import models.Evenement;
import services.EvenementService;
import utils.URLimages;

/**
 * FXML Controller class
 *
 * @author majdi
 */
public class BackOfficeEventsFXMLController implements Initializable {

    @FXML
    private JFXTextField recherche_tf;
    @FXML
    private StackPane tablePane;
    @FXML
    private TableView<Evenement> events_table;
    @FXML
    private TableColumn<Evenement, String> col_img;
    @FXML
    private TableColumn<Evenement, String> col_libelle;
    @FXML
    private TableColumn<Evenement, String> col_type;
    @FXML
    private TableColumn<Evenement, String> col_description;
    @FXML
    private TableColumn<Evenement, Date> col_date;
    @FXML
    private TableColumn<Type, Void> col_option;

    @FXML
    private JFXButton add_btn_layout;
    @FXML
    private JFXDialogLayout addDialogLayout;

    @FXML
    private JFXTextField libelle_tf;
    @FXML
    private JFXTextArea Description_tf;
    @FXML
    private JFXButton parcourir_img;
    @FXML
    private JFXComboBox<String> Type;
    @FXML
    private DatePicker date_tf;

    @FXML
    private JFXButton add_btn;

    @FXML
    private Label formLibelle_lbl;

    @FXML
    private JFXTextField img_path_tf;

    private JFXDialog dialog;
    private IEvenementService evenementService;

    private Boolean updateTest = false;
    private Evenement eventTest;
    
    private List<Evenement> eventsList = new ArrayList<>();
    private String imgPath = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        displayAll();
        recherche_tf.setOnKeyPressed((KeyEvent event) -> {
            recherche_tf.textProperty().addListener((observable, oldValue, newValue) -> {
                events_table.setItems(FXCollections.observableArrayList(eventsList.stream().filter(evenement -> evenement.getLiblle().toLowerCase().contains(newValue)|| evenement.getDescription().contains(newValue)).collect(Collectors.toList())));

            });
        });
    }

    /**
     * Methode qui permet d'afficher le formulaire d'ajout ou de modification
     */
    @FXML
    private void showAddFormAction(ActionEvent event) {
        dialog = new JFXDialog(tablePane, addDialogLayout, JFXDialog.DialogTransition.CENTER);
        dialog.setOverlayClose(true);
        addDialogLayout.setVisible(true);
        dialog.show();
    }

    /**
     * Methode qui permet de ajouter dans la base de donnée
     */
    @FXML
    private void addAction(ActionEvent event) {
        if (updateTest == true) {
            LocalDate date = date_tf.getValue();
            Date dateL = java.sql.Date.valueOf(date);
            eventTest = new Evenement(eventTest.getId(), libelle_tf.getText(), Type.getSelectionModel().getSelectedItem(), Description_tf.getText(), dateL, img_path_tf.getText());
            evenementService.update(eventTest);
            displayAll();
            updateTest = false;

        } else {
            LocalDate date = date_tf.getValue();
            Date dateL = java.sql.Date.valueOf(date);
            eventTest = new Evenement(libelle_tf.getText(), Type.getSelectionModel().getSelectedItem(), Description_tf.getText(), dateL, imgPath);
            evenementService.add(eventTest);
            displayAll();
        }
        cleanTf();
        dialog.close();
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

    private void displayAll() {
        evenementService = new EvenementService();
        eventsList = evenementService.getAll();
        Type.getItems().addAll("Privé", "Public");
        ObservableList list = FXCollections.observableArrayList();
        evenementService.getAll().stream().forEach((club) -> {
            list.add(club);
        });
        col_libelle.setCellValueFactory(new PropertyValueFactory<>("liblle"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        col_img.setCellValueFactory(new PropertyValueFactory<>("path_img"));
        col_img.setCellFactory((TableColumn<Evenement, String> param) -> {

            return new TableCell<Evenement, String>() {

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    }
                    if (item != null) {
                        final VBox vbox = new VBox();
                        ImageView imageView = new ImageView(new Image(URLimages.LogoClubs + item));
                        imageView.setFitHeight(100);
                        imageView.setFitWidth(100);
                        vbox.getChildren().add(imageView);
                        vbox.setMaxSize(100, 100);
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

                        setGraphic(vbox);
                    }
                }
            };
        });
        col_option.setCellFactory((TableColumn<Type, Void> param) -> {

            return new TableCell<Type, Void>() {
                application.Button update = new application.Button();
                application.Button delete = new application.Button();

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                    update.setGraphic(new ImageView("ressources/icons8-Edit-24-2.png"));
                    update.setStyle("-fx-background-color: transparent;");
                    delete.setGraphic(new ImageView("ressources/Delete-24.png"));
                    delete.setStyle("-fx-background-color: transparent;");

                    Evenement evenement = (Evenement) getTableRow().getItem();

                    delete.setOnAction(event -> {
                        evenementService.delete(evenement.getId());
                        displayAll();

                    });
                    update.setOnAction(event -> {
                        updateTest = true;
                        eventTest = evenement;
                        fillTf(eventTest);

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

        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        col_img.setCellValueFactory(new PropertyValueFactory<>("path_img"));

        events_table.setItems(list);
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
        dialog = new JFXDialog(tablePane, addDialogLayout, JFXDialog.DialogTransition.CENTER);
        dialog.setOverlayClose(true);
        addDialogLayout.setVisible(true);
        if (updateTest == true) {
            add_btn.setText("Modifier");
            formLibelle_lbl.setText("Modifier Evenement");
        } else {
            add_btn.setText("Ajouter");
            formLibelle_lbl.setText("Ajouter Evenement");
        }
        dialog.setOnDialogClosed(event -> {
            cleanTf();
            updateTest = false;
        });
        dialog.show();
    }

    public void setImgPath() {
        imgPath = System.currentTimeMillis() + ".jpg";
    }

}
