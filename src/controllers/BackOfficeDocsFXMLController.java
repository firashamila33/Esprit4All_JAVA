/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import interfaces.IServiceDocumentAdministratif;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import models.DocumentAdministratif;
import models.User;
import services.DocumentAdministratifService;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class BackOfficeDocsFXMLController implements Initializable {
    
    @FXML
    private JFXTextField recherche_tf;
    @FXML
    private StackPane tablePane;
    @FXML
    private TableView<DocumentAdministratif> docs_table;
    @FXML
    private TableColumn<DocumentAdministratif, User> col_etudiant;
    @FXML
    private TableColumn<DocumentAdministratif, String> col_type;
    @FXML
    private TableColumn<DocumentAdministratif, Integer> col_quantite;
    @FXML
    private TableColumn<DocumentAdministratif, Boolean> col_confirmation;
    
    private IServiceDocumentAdministratif serviceDocumentAdministratif;
    private List<DocumentAdministratif> documentAdministratifList = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        serviceDocumentAdministratif = new DocumentAdministratifService();
        documentAdministratifList = serviceDocumentAdministratif.getAll();
        displayAll();
        recherche_tf.setOnKeyPressed((KeyEvent event) -> {
            recherche_tf.textProperty().addListener((observable, oldValue, newValue) -> {
                docs_table.setItems(FXCollections.observableArrayList(documentAdministratifList.stream().filter(document -> document.getType().toLowerCase().contains(newValue)).collect(Collectors.toList())));
                
            });
        });
        
    }
    
    private void displayAll() {
        serviceDocumentAdministratif = new DocumentAdministratifService();
        documentAdministratifList = serviceDocumentAdministratif.getAll();
        ObservableList list = FXCollections.observableArrayList();
        documentAdministratifList.stream().forEach((club) -> {
            list.add(club);
        });
        col_etudiant.setCellValueFactory(new PropertyValueFactory<>("User"));
        col_quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        col_confirmation.setCellValueFactory(new PropertyValueFactory<>("confirmation"));
        col_confirmation.setCellFactory((TableColumn<DocumentAdministratif, Boolean> param) -> {
            
            return new TableCell<DocumentAdministratif, Boolean>() {
                
                @Override
                protected void updateItem(Boolean item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    }
                    if (item != null) {
                        final VBox vbox = new VBox();
                        
                        JFXCheckBox confimation = new JFXCheckBox("Confirmé");
                        if (item == true) {
                            confimation.setSelected(true);
                            confimation.setDisable(true);
                        } else {
                            confimation.setSelected(false);
                            
                        }
                        confimation.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                            DocumentAdministratif documentAdministratif = (DocumentAdministratif)getTableRow().getItem();
                            documentAdministratif.setConfirmation(true);
                            serviceDocumentAdministratif.update(documentAdministratif);
                            
                            //TO DO code email
                            confimation.setDisable(true);
                        });
                        vbox.getChildren().add(confimation);
                        vbox.setMaxSize(100, 100);
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        
                        setGraphic(vbox);
                    }
                }
            };
        });
        docs_table.setItems(list);
    }
}
