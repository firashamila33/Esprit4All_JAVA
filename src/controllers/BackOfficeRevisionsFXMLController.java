/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXTextField;
import interfaces.IServiceRevision;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.URL;
import java.sql.Date;
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
import models.Revision;
import models.User;
import services.RevisionService;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class BackOfficeRevisionsFXMLController implements Initializable {

    @FXML
    private StackPane tablePane;
    @FXML
    private JFXTextField recherche_tf;
    @FXML
    private TableView<Revision> revisions_table;
    @FXML
    private TableColumn<Revision, User> col_user;
    @FXML
    private TableColumn<Revision, String> col_description;
    @FXML
    private TableColumn<Revision, String> col_matiere;
    @FXML
    private TableColumn<Revision, Date> col_dateDebut;
    @FXML
    private TableColumn<Revision, Date> col_dateFin;
    @FXML
    private TableColumn<Revision, Integer> col_nbrmax;
    @FXML
    private TableColumn<Revision, String> col_type;
    @FXML
    private TableColumn<Type, Void> col_option;

    IServiceRevision serviceRevision;
    List<Revision> listRevisions = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        displayAll();
        recherche_tf.setOnKeyPressed((KeyEvent event) -> {
            recherche_tf.textProperty().addListener((observable, oldValue, newValue) -> {
                revisions_table.setItems(FXCollections.observableArrayList(listRevisions.stream().filter(revisions -> revisions.getMatiere().toLowerCase().contains(newValue)).collect(Collectors.toList())));

            });
        });
    }

    private void displayAll() {
         serviceRevision = new RevisionService();
        listRevisions = serviceRevision.getAll();
        ObservableList list = FXCollections.observableArrayList();
        listRevisions.stream().forEach((club) -> {
            list.add(club);
        });
        col_user.setCellValueFactory(new PropertyValueFactory<>("User"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("type"));

        col_dateDebut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        col_dateFin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));

        col_nbrmax.setCellValueFactory(new PropertyValueFactory<>("nbrmax"));
        col_matiere.setCellValueFactory(new PropertyValueFactory<>("matiere"));

        col_option.setCellFactory((TableColumn<Type, Void> param) -> {

            return new TableCell<Type, Void>() {
                application.Button delete = new application.Button();

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                    delete.setGraphic(new ImageView("ressources/Delete-24.png"));
                    delete.setStyle("-fx-background-color: transparent;");

                    Revision revision = (Revision) getTableRow().getItem();

                    delete.setOnAction(event -> {
                        serviceRevision.delete(revision.getId());
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
        revisions_table.setItems(list);
    }
}
