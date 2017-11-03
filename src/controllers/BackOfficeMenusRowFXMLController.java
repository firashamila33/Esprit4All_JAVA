/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import interfaces.ILigneCommandeService;
import interfaces.IMenuService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import models.LigneCommande;
import models.Menu;
import services.LigneCommandeService;
import services.MenuService;

/**
 * FXML Controller class
 *
 * @author plazma33
 */
public class BackOfficeMenusRowFXMLController extends ListCell<LigneCommande> {

    @FXML
    private ImageView meal_image;
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
     */
    //@Override
    @Override
    protected void updateItem(LigneCommande ligne_commande, boolean empty) {
        super.updateItem(ligne_commande, empty);
        if (empty || ligne_commande == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/gui/BackOfficeMenusRowFXML.fxml"));
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
            
        }
        

    }
}
