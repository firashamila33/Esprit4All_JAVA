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
import com.jfoenix.controls.JFXTextField;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import models.Club;
import models.Membre;
import models.User;
import services.ClubService;
import services.MembreService;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author majdi
 */
public class InfoClubMembreFXMLController implements Initializable {

    @FXML
    private TableView<Club> membre_table;
    @FXML
    private TableColumn<Club, User> col_membre;
    @FXML
    private TableColumn<Club, String> col_role;
    @FXML
    private TableColumn<Type, Void> col_option;
    @FXML
    private Label Name_lbl;
    @FXML
    private Label Email_lbl;
    @FXML
    private Label tel_lbl;
    @FXML
    private Label ourstory_lbl;
    @FXML
    private Label aboutus_lbl;
    @FXML
    private AnchorPane responsable_label;
    @FXML
    private AnchorPane fabPane;
    @FXML
    private Label fabEdit;
    @FXML
    private JFXButton showAdd;
    @FXML
    private JFXDialogLayout addDialogLayout;
    @FXML
    private JFXTextField role;
    @FXML
    private JFXButton add_btn;
    @FXML
    private JFXComboBox<User> membre;
    @FXML
    private Label formLibelle_lbl;

    List<User> listEtudiant = new ArrayList<>();
    UserService userService = new UserService();
    MembreService membreService = new MembreService();

    List<Membre> listMembre = new ArrayList<>();
    private JFXDialog dialog;
    @FXML
    private StackPane pane;

    Club club;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        club = new ClubService().getClubByUser(UserService.userStatic.getId());
        displayAll();
    }

    @FXML
    private void addAction(ActionEvent event) {
        membreService.add(new Membre(club, membre.getValue(), role.getText()));
        displayAll();
        dialog.close();
    }

    @FXML
    private void retreiveuser(KeyEvent event) {
    }

    void displayAll() {
        listEtudiant = userService.getAllStudent();
        listMembre = membreService.getByClub(club);
        membre.getItems().addAll(listEtudiant);
        ObservableList list = FXCollections.observableArrayList(listMembre);
        col_membre.setCellValueFactory(new PropertyValueFactory<>("user"));
        col_role.setCellValueFactory(new PropertyValueFactory<>("role"));
        col_option.setCellFactory((TableColumn<Type, Void> param) -> {
            return new TableCell<Type, Void>() {
                application.Button delete = new application.Button();

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                    delete.setGraphic(new ImageView("ressources/Delete-24.png"));
                    delete.setStyle("-fx-background-color: transparent;");
                    Membre membre = (Membre) getTableRow().getItem();
                    delete.setOnAction(event -> {
                        membreService.delete(membre);
                        displayAll();
                    });
                    HBox hBox = new HBox();
                    hBox.setAlignment(Pos.CENTER);
                    hBox.getChildren().add(delete);
                    final Node graphic1 = (empty) ? null : hBox;
                    setGraphic(graphic1);
                }
            };
        });
        membre_table.setItems(list);
    }

    @FXML
    private void showAddDialog(ActionEvent event) {
        showDialog();
    }

    private void showDialog() {
        dialog = new JFXDialog(pane, addDialogLayout, JFXDialog.DialogTransition.CENTER);
        dialog.setOverlayClose(true);
        addDialogLayout.setVisible(true);
        dialog.show();
    }

}
