/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
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
import models.DocumentAdministratif;
import models.Menu;
import services.MenuService;
import utils.URLimages;

/**
 * FXML Controller class
 *
 * @author plazma33
 */
public class BackOfficeMenusFXMLController implements Initializable {

    @FXML
    private StackPane tablePane;
    @FXML
    private JFXTextField recherche_tf;
    @FXML
    private TableView<Menu> menus_table;
    @FXML
    private TableColumn<Menu, String> col_logo;
    @FXML
    private TableColumn<Menu, String> col_libelle;
    @FXML
    private TableColumn<Menu, Float> col_prix;
    @FXML
    private TableColumn<Menu, String> col_endroit;
    @FXML
    private TableColumn<Menu, Integer> col_disponibilite;
    @FXML
    private TableColumn<Menu, Integer> col_quantite;
    @FXML
    private TableColumn<Menu, String> col_Categorie;
    @FXML
    private TableColumn<Menu, String> col_sous_categorie;
    @FXML
    private TableColumn<Type, Void> col_option;
    @FXML
    private JFXButton add_btn_layout;
    @FXML
    private JFXDialogLayout addDialogLayout;
    @FXML
    private JFXTextField libelle_tf;
    @FXML
    private JFXTextField logo_path_tf;
    @FXML
    private JFXButton add_btn;
    @FXML
    private JFXTextField quantite_tf;
    @FXML
    private JFXComboBox<String> endroit_tf;
    @FXML
    private JFXTextField prix_tf;
    @FXML
    private JFXCheckBox disponibilite_cb;
    /**
     * Attribue
     */
    JFXDialog dialog;
    @FXML
    private JFXComboBox<String> Categorie_tf;
    @FXML
    private JFXTextField sous_Categorie_tf;

    MenuService menuService;
    List<Menu> listMenu = new ArrayList<>();
    private File logo;
    private String logoPath = "";
    private Boolean updateTest = false;
    private Menu menuTest;
    @FXML
    private Label formLibelle_lbl;

    public BackOfficeMenusFXMLController() {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        displayAll();
        recherche_tf.setOnKeyPressed((KeyEvent event) -> {
            recherche_tf.textProperty().addListener((observable, oldValue, newValue) -> {
                menus_table.setItems(FXCollections.observableArrayList(listMenu.stream().filter(menu -> menu.getLibelle().toLowerCase().contains(newValue)).collect(Collectors.toList())));
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
            int despo = 0;
            if (disponibilite_cb.isSelected()) {
                despo = 1;
            }

            menuTest = new Menu(menuTest.getId(), libelle_tf.getText(), Categorie_tf.getSelectionModel().getSelectedItem(), sous_Categorie_tf.getText(), endroit_tf.getSelectionModel().getSelectedItem(), despo, Integer.parseInt(prix_tf.getText()), Double.parseDouble(prix_tf.getText()), logoPath);
            menuService.update(menuTest);
            displayAll();
            updateTest = false;

        } else {
            int despo = 0;
            if (disponibilite_cb.isSelected()) {
                despo = 1;
            }
            menuTest = new Menu(libelle_tf.getText(), Categorie_tf.getSelectionModel().getSelectedItem(), sous_Categorie_tf.getText(), endroit_tf.getSelectionModel().getSelectedItem(), despo, Integer.parseInt(prix_tf.getText()), Double.parseDouble(prix_tf.getText()), logoPath);
            menuService.add(menuTest);
            displayAll();
        }
        cleanTf();
        dialog.close();
    }

    private void displayAll() {
        menuService = new MenuService();
        listMenu = menuService.getAll();
        Categorie_tf.getItems().addAll("Fast_Food", "Snack", "Meal", "Drinks");
        endroit_tf.getItems().addAll("Buvette 1", "Buvette 2", "Buvette 3");
        ObservableList list = FXCollections.observableArrayList();
        listMenu.stream().forEach((menu) -> {
            list.add(menu);
        });
        col_libelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        col_Categorie.setCellValueFactory(new PropertyValueFactory<>("type"));
        col_endroit.setCellValueFactory(new PropertyValueFactory<>("endroit"));
        col_quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        col_sous_categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        col_disponibilite.setCellValueFactory(new PropertyValueFactory<>("disponibilite"));
        col_disponibilite.setCellFactory((TableColumn<Menu, Integer> param) -> {

            return new TableCell<Menu, Integer>() {

                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    }
                    if (item != null) {
                        final VBox vbox = new VBox();

                        JFXCheckBox confimation = new JFXCheckBox("disponible");
                        if (item == 1) {
                            confimation.setSelected(true);

                        } else {
                            confimation.setSelected(false);

                        }

                        vbox.getChildren().add(confimation);
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

                    Menu menu = (Menu) getTableRow().getItem();

                    delete.setOnAction(event -> {
                        menuService.delete(menu.getId());
                        displayAll();

                    });
                    update.setOnAction(event -> {
                        updateTest = true;
                        menuTest = menu;
                        fillTf(menuTest);

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

        col_logo.setCellValueFactory(new PropertyValueFactory<>("path_img"));
        col_logo.setCellFactory((TableColumn<Menu, String> param) -> {

            return new TableCell<Menu, String>() {

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
        menus_table.setItems(list);
    }

    @FXML
    private void parcourir_logo(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");

        fileChooser.getExtensionFilters().add(extFilterJPG);
        fileChooser.setTitle("Choisir une image");
        //Show open file dialog
        logo = fileChooser.showOpenDialog(null);
        if (logo != null) {

            setLogoPath();

            logo_path_tf.setText(logo.getName());
        }
    }

    public void setLogoPath() {
        logoPath = System.currentTimeMillis() + ".jpg";
    }

    private void cleanTf() {
        libelle_tf.clear();
        logo_path_tf.clear();
        prix_tf.clear();
        quantite_tf.clear();
        sous_Categorie_tf.clear();
    }

    private void fillTf(Menu m) {
        libelle_tf.setText(m.getLibelle());
        endroit_tf.getSelectionModel().select(m.getEndroit());
        Categorie_tf.getSelectionModel().select(m.getType());
        if (m.getDisponibilite() == 1) {
            disponibilite_cb.setSelected(true);
        } else {
            disponibilite_cb.setSelected(false);
        }
        logo_path_tf.setText(m.getPath_img());
        prix_tf.setText(String.valueOf(m.getPrix()));
        quantite_tf.setText(String.valueOf(m.getQuantite()));
        sous_Categorie_tf.setText(m.getCategorie());

    }

    private void showDialog() {
        dialog = new JFXDialog(tablePane, addDialogLayout, JFXDialog.DialogTransition.CENTER);
        dialog.setOverlayClose(true);
        addDialogLayout.setVisible(true);
        if (updateTest == true) {
            add_btn.setText("Modifier");
            formLibelle_lbl.setText("Modifier Menu");
        } else {
            add_btn.setText("Ajouter");
            formLibelle_lbl.setText("Ajouter Menu");
        }
        dialog.setOnDialogClosed(event -> {
            cleanTf();
            updateTest = false;
        });
        dialog.show();
    }
}
