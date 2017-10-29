/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import application.Button;
import com.jfoenix.controls.JFXTextField;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import models.User;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class BackOfficeUtilisateurFXMLController implements Initializable {

    @FXML
    private JFXTextField recherche_tf;
    @FXML
    private StackPane tablePane;
    @FXML
    private TableView<User> stydent_table;
    @FXML
    private TableColumn<User, String> col_nom;
    @FXML
    private TableColumn<User, String> col_prenom;
    @FXML
    private TableColumn<User, String> col_email;
    @FXML
    private TableColumn<Type, Void> col_option;

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
                stydent_table.setItems(FXCollections.observableArrayList(usersList.stream().filter(user -> user.getNom().toLowerCase().contains(newValue) || user.getPrenom().contains(newValue)).collect(Collectors.toList())));
            });
        });

    }

    private void displayAll() {
         userService = new UserService();
        usersList = userService.getAllStudent();
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
                Button enable_disable = new Button();

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty); 
                        if(empty){
                            setText(null);
                            setGraphic(null);
                        }
                        else{delete.setGraphic(new ImageView("ressources/Delete-24.png"));
                    delete.setStyle("-fx-background-color: transparent;");

                    User user = (User) getTableRow().getItem();

                    delete.setOnAction(event -> {
                        userService.delete(user.getId());
                        displayAll();

                    });

                    if (user.getEnabled() == 1) {
                        enable_disable.setGraphic(new ImageView("ressources/Visible.png"));
                        enable_disable.setStyle("-fx-background-color: transparent;");
                    } else {
                        enable_disable.setGraphic(new ImageView("ressources/Invisible.png"));
                        enable_disable.setStyle("-fx-background-color: transparent;");
                    }

                    enable_disable.setOnAction(event -> {
                        if (user.getEnabled() == 1) {
                            userService.disable(user);
                            enable_disable.setGraphic(new ImageView("ressources/Invisible.png"));
                            enable_disable.setStyle("-fx-background-color: transparent;");
                        } else {
                            userService.enable(user);
                            enable_disable.setGraphic(new ImageView("ressources/Visible.png"));
                            enable_disable.setStyle("-fx-background-color: transparent;");
                        }
                    });

                    HBox hBox = new HBox();
                    hBox.setAlignment(Pos.CENTER);
                    hBox.getChildren().addAll(delete, enable_disable);
                    final Node graphic1 = hBox;
                    setGraphic(graphic1);}
                    
                }
            };
        });
        stydent_table.setItems(list);
    }

}
