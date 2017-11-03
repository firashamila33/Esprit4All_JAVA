/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import interfaces.ICommandeService;
import interfaces.ILigneCommandeService;
import interfaces.IMenuService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import models.LigneCommande;
import models.Menu;
import services.CommandeService;
import services.LigneCommandeService;
import services.MenuService;

/**
 * FXML Controller class
 *
 * @author plazma33
 */
public class FoodMyOrderRowListController extends ListCell<LigneCommande> {

    @FXML
    private Label type_row_commande;
    @FXML
    private Label name_row_commande;
    @FXML
    private Label price_row_commande;
    @FXML
    private ImageView meal_image;
    @FXML
    private Label quantity;

    private FXMLLoader mLLoader;
    @FXML
    private AnchorPane row;

    private double total_price;
    @FXML
    private Label price_commande;
    @FXML
    private JFXButton delete_btn;
    @FXML
    private JFXButton substruct_btn;
    @FXML
    private JFXButton add_btn;

    /**
     * Initializes the controller class.
     *
     * @param lignecommande
     * @param empty
     */
    @Override
    protected void updateItem(LigneCommande ligne_commande, boolean empty) {
        super.updateItem(ligne_commande, empty);
        if (empty || ligne_commande == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/gui/FoodMyOrderRowList1.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            IMenuService menu = new MenuService();
            ILigneCommandeService Ligne = new LigneCommandeService();
            Menu repas;
            repas = menu.getById(ligne_commande.getMenu_id());

            //quantity.setText(String.valueOf(ligne_commande.getQuantite()));
            price_row_commande.setText(String.valueOf(repas.getPrix() + " DT"));
            name_row_commande.setText(repas.getLibelle());
            type_row_commande.setText(repas.getType());
            meal_image.setImage(new Image("http://localhost:90//www/Esprit4All/uploads/" + String.valueOf(repas.getPath_img())));
            quantity.setText(String.valueOf(Ligne.TestExist(ligne_commande)));
            setText(null);
            setGraphic(row);
            
            
            int i = 0;
            add_btn.setOnAction(event -> {
                ligne_commande.setQuantite(1);
                Ligne.add(ligne_commande);
                quantity.setText(String.valueOf(String.valueOf(Ligne.TestExist(ligne_commande))));
                price_row_commande.setText(String.valueOf(repas.getPrix() + " DT"));
                ICommandeService comm_tool = new CommandeService();
                FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/gui/FoodMainnFXML.fxml"));
                try {
                    Parent root = (Parent) fXMLLoader.load();
                    FoodMainnFXMLController dialogueLayoutController = fXMLLoader.<FoodMainnFXMLController>getController();
                    dialogueLayoutController.AddQuantity();
                    //dialogueLayoutController.SetTotaPriceLabel(5.0);

                } catch (IOException ex) {
                    Logger.getLogger(FoodMyOrderRowListController.class.getName()).log(Level.SEVERE, null, ex);
                }

                
                

            });

            substruct_btn.setOnAction(event -> {
                if (Ligne.TestExist(ligne_commande) >= 1) {

                    LigneCommande l = new LigneCommande(ligne_commande.getCommande_id(), ligne_commande.getMenu_id(), Ligne.TestExist(ligne_commande) - 1);
                    Ligne.update(ligne_commande);
                    quantity.setText(String.valueOf(String.valueOf(Ligne.TestExist(ligne_commande))));
                    try {
                        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/gui/FoodMainnFXML.fxml"));
                        Parent root = (Parent) fXMLLoader.load();
                        FoodMainnFXMLController dialogueLayoutController = fXMLLoader.<FoodMainnFXMLController>getController();
                        dialogueLayoutController.substructQuantity();

                    } catch (IOException ex) {
                        Logger.getLogger(FoodMyOrderRowListController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            });

            delete_btn.setOnAction(event -> {

                try {
                    FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/gui/FoodMainnFXML.fxml"));
                    Parent root = (Parent) fXMLLoader.load();
                    FoodMainnFXMLController dialogueLayoutController = fXMLLoader.<FoodMainnFXMLController>getController();
                    dialogueLayoutController.delete_row_list(ligne_commande);

//                    getListView().getItems().remove(l);
//                    getListView().refresh();
                    quantity.setText("0");

                } catch (IOException ex) {
                    Logger.getLogger(FoodMyOrderRowListController.class.getName()).log(Level.SEVERE, null, ex);
                }

            });

        }

    }

    @FXML
    private void delete_row(ActionEvent event) {

    }

    @FXML
    private void sustruct_quantity(ActionEvent event) {
    }

    @FXML
    private void add_quantity(ActionEvent event) {
    }

    public void Set_quantite(Integer i) {
        quantity.setText(String.valueOf(i));
    }

}
