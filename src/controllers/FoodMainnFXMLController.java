/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.util.List;
import javafx.scene.control.ListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.Initializable;
import javafx.util.Callback;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import models.LigneCommande;

/**
 * FXML Controller class
 *
 * @author plazma33
 */
public class FoodMainnFXMLController implements Initializable {

    @FXML
    private JFXButton menu_btn;
    @FXML
    private JFXButton current_order_btn;
    @FXML
    private JFXButton my_favorites_btn;
    @FXML
    private AnchorPane sub_menu_layout;
    @FXML
    private AnchorPane menu_layout;
    @FXML
    private AnchorPane favorits_layout;
    @FXML
    private AnchorPane my_order_layout;
    
    public JFXListView<LigneCommande> listView_commandes;
    
    private ObservableList<LigneCommande> LigneCommandeObservableList;
    

    public FoodMainnFXMLController() {
        LigneCommandeObservableList = FXCollections.observableArrayList();
        
        LigneCommandeObservableList.addAll(                
                new LigneCommande(14,4,12),
                new LigneCommande(14,3,4),
                new LigneCommande(14,2,2),
                new LigneCommande(14,7,1),
                new LigneCommande(14,7,9)
        );
    }
      
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView_commandes.setItems(LigneCommandeObservableList);
        listView_commandes.setCellFactory(LigneCommandesListVIrs -> new FoodMyOrderRowListController());
        
        
    }    

    @FXML
    private void goToMenu(ActionEvent event) {
        menu_layout.setVisible(true);
        sub_menu_layout.setVisible(false);
        favorits_layout.setVisible(false);
        my_order_layout.setVisible(false);
        
    }

    @FXML
    private void goToCurrentOrder(ActionEvent event) {
        menu_layout.setVisible(false);
        sub_menu_layout.setVisible(false);
        favorits_layout.setVisible(false);
        my_order_layout.setVisible(true);
    }

    @FXML
    private void goToFavorites(ActionEvent event) {
        menu_layout.setVisible(false);
        sub_menu_layout.setVisible(false);
        favorits_layout.setVisible(true);
        my_order_layout.setVisible(false);
    }

    @FXML
    private void GoToFastFood(MouseEvent event) {
        menu_layout.setVisible(false);
        sub_menu_layout.setVisible(true);
        favorits_layout.setVisible(false);
        my_order_layout.setVisible(false);
    }
    
    
    
}
