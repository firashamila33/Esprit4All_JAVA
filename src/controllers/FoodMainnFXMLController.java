/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import interfaces.ICommandeService;
import interfaces.ILigneCommandeService;
import interfaces.IMenuService;
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
import javafx.scene.control.Label;
import javafx.util.Callback;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import models.Commande;
import models.LigneCommande;
import services.CommandeService;
import services.LigneCommandeService;
import services.MenuService;

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
    
    @FXML
    private Label price_commande;
    
    @FXML
    private Label id_commande;
    
    public JFXListView<LigneCommande> listView_commandes;
    
    private ObservableList<LigneCommande> ligne_commande;
    

//    public FoodMainnFXMLController() {
//        ligne_commande = FXCollections.observableArrayList();
//        
//        
//        
//        ligne_commande.addAll(                
//                new LigneCommande(14,4,12),
//                new LigneCommande(14,3,4),
//                new LigneCommande(14,2,2),
//                new LigneCommande(14,7,1),
//                new LigneCommande(14,7,9)
//        );
//    }
      
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ILigneCommandeService Ligne_repas = new LigneCommandeService();
        ICommandeService ICommande = new CommandeService();
        Commande commande = ICommande.getById(5);
        id_commande.setText(String.valueOf(commande.getId()));
        price_commande.setText(String.valueOf(commande.getPrix())+" DT");
        
        ligne_commande = FXCollections.observableArrayList(Ligne_repas.getByCommande(5));  
        listView_commandes.setItems(ligne_commande);
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
