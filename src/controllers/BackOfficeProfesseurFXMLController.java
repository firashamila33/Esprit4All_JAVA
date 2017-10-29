/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import models.User;
import services.UserService;
import utils.BCrypt;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class BackOfficeProfesseurFXMLController implements Initializable {

    @FXML
    private JFXTextField recherche_tf;
    @FXML
    private StackPane tablePane;
    @FXML
    private TableView<User> prof_table;
    @FXML
    private TableColumn<User, String> col_nom;
    @FXML
    private TableColumn<User, String> col_prenom;
    @FXML
    private TableColumn<User, String> col_email;
    @FXML
    private TableColumn<Type, Void> col_option;
    @FXML
    private JFXButton add_btn_layout;
    @FXML
    private Label form_lbl;
    @FXML
    private JFXDialogLayout addDialogLayout;
    @FXML
    private GridPane prenom;
    @FXML
    private JFXTextField prenom_tf;
    @FXML
    private JFXTextField nom_tf;
    @FXML
    private JFXTextField email_tf;
    @FXML
    private JFXTextField cin_tf;
    @FXML
    private JFXTextField username_tf;
    @FXML
    private JFXPasswordField pasword_tf;
    @FXML
    private DatePicker date_tf;
    @FXML
    private JFXTextField adress_tf;
    @FXML
    private JFXButton add_btn;

    private JFXDialog dialog;

    private List<User> usersList = new ArrayList<>();
    UserService userService;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        displayAll();
        recherche_tf.setOnKeyPressed((KeyEvent event) -> {
            recherche_tf.textProperty().addListener((observable, oldValue, newValue) -> {
                prof_table.setItems(FXCollections.observableArrayList(usersList.stream().filter(user -> user.getNom().toLowerCase().contains(newValue) || user.getPrenom().contains(newValue)).collect(Collectors.toList())));
            });
        });

    }

    @FXML
    private void showAddFormAction(ActionEvent event) {
        showDialog();
    }

    private void showDialog() {
        dialog = new JFXDialog(tablePane, addDialogLayout, JFXDialog.DialogTransition.CENTER);
        dialog.setOverlayClose(true);
        addDialogLayout.setVisible(true);
        dialog.show();
    }

    private void displayAll() {
        userService = new UserService();
        usersList = userService.getAllProfesseur();
        ObservableList list = FXCollections.observableArrayList();
        usersList.stream().forEach((club) -> {
            list.add(club);
        });
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        col_option.setCellFactory((TableColumn<Type, Void> param) -> {

            return new TableCell<Type, Void>() {
                application.Button delete = new application.Button();

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                    delete.setGraphic(new ImageView("ressources/Delete-24.png"));
                    delete.setStyle("-fx-background-color: transparent;");

                    User user = (User) getTableRow().getItem();

                    delete.setOnAction(event -> {
                        userService.delete(user.getId());
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
        prof_table.setItems(list);
    }

    @FXML
    private void AddAction(ActionEvent event) {
        String username = username_tf.getText();
        String email = email_tf.getText();
        int enabled = 1;
        String password = pasword_tf.getText();
        String generatedSecuredPasswordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        String nomUser = nom_tf.getText();
        String prenomUser = prenom_tf.getText();
        LocalDate dateNaissance = date_tf.getValue();
        Date dateL = java.sql.Date.valueOf(dateNaissance);
        String cartIdentite = cin_tf.getText();
        String adress = adress_tf.getText();
        User u = new User(username, email, enabled, generatedSecuredPasswordHash, nomUser, prenomUser, dateL, cartIdentite, adress,"a:1:{i:0;s:15:\"ROLE_PROFESSEUR\";}");
        
        if (!userService.chercherUsername(username)) {
            if (!userService.chercherEmail(email)) {
                if (!userService.chercherCIN(cartIdentite)) {
                    userService.register(u);
                    dialog.close();
                   
                } else {
                    cin_tf.setStyle("-fx-background-color:#ff2e44");
                }
            } else {
                email_tf.setStyle("-fx-background-color:#ff2e44");
            }
        } else {
            username_tf.setStyle("-fx-background-color:#ff2e44");
        }
    }

}
