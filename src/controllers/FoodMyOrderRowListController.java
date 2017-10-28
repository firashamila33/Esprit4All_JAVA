/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import interfaces.IMenuService;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import models.LigneCommande;
import models.Menu;
import services.MenuService;

/**
 * FXML Controller class
 *
 * @author plazma33
 */
public class FoodMyOrderRowListController extends ListCell<LigneCommande>{

    @FXML
    private Label type_row_commande;
    @FXML
    private Label name_row_commande;
    @FXML
    private Label price_row_commande;
    
    @FXML
    private Label quantity;
    
    private FXMLLoader mLLoader;
    @FXML
    private AnchorPane row;

    /**
     * Initializes the controller class.
     * @param lignecommande
     * @param empty
     */
    @Override
    protected void updateItem(LigneCommande ligne_commande,boolean empty ) {
        super.updateItem(ligne_commande, empty);
        if (empty || ligne_commande == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/gui/FoodMyOrderRowList.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            IMenuService menu =new MenuService();
            Menu repas ;
            repas=menu.getById(ligne_commande.getMenu_id());
            quantity.setText(String.valueOf(ligne_commande.getQuantite()));
            price_row_commande.setText(String.valueOf(repas.getPrix()+" DT"));
            name_row_commande.setText(repas.getLibelle());
            type_row_commande.setText(repas.getType());
            
            
            setText(null);
            setGraphic(row);
        }
    }    

    
    
}
