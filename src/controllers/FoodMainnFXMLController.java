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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import models.Commande;
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
    private JFXButton sub_menu_btn_1;
    @FXML
    private JFXButton sub_menu_btn_2;
    @FXML
    private JFXButton sub_menu_btn_3;
    @FXML
    private JFXButton sub_menu_btn_4;
    @FXML
    private MenuButton sub_menu_but;
    @FXML
    private Label price_commande;
    @FXML
    private Label id_commande;
    public JFXListView<LigneCommande> listView_commandes;
    private ObservableList<LigneCommande> ligne_commande;
    @FXML
    private JFXButton Fast_food_button;
    @FXML
    private Label first_sub_meal_label;
    @FXML
    private Label first_sub_meal_price;
    @FXML
    private Label third_sub_meal_price;
    @FXML
    private Label third_sub_meal_label;
    @FXML
    private Label snd_sub_meal_label;
    @FXML
    private Label snd_sub_meal_price;
    @FXML
    private ImageView sub_menu_img1;
    @FXML
    private ImageView sub_menu_img3;
    @FXML
    private ImageView sub_menu_img2;

//    private ActionEvent e;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        //initialising orders interface to work on and getting the order of the user
        ILigneCommandeService Ligne_repas = new LigneCommandeService();
        ICommandeService ICommande = new CommandeService();
        Commande commande = ICommande.getById(5);
        
        //setting my_order total price and Referance 
        id_commande.setText(String.valueOf(commande.getId()));
        price_commande.setText(String.valueOf(commande.getPrix()) + " DT");
        
        //making an instance of menus list to render it into listview rows
        ligne_commande = FXCollections.observableArrayList(Ligne_repas.getByCommande(5));
        listView_commandes.setItems(ligne_commande);
        listView_commandes.setCellFactory(LigneCommandesListVIrs -> new FoodMyOrderRowListController());
        
        //Disabling meals Images Display
        sub_menu_img1.setVisible(false);
        sub_menu_img2.setVisible(false);
        sub_menu_img3.setVisible(false);
        
        //Get sub_menu butttons to empty labels
        first_sub_meal_label.setText(" ");
        first_sub_meal_price.setText(" ");
        snd_sub_meal_label.setText(" ");
        snd_sub_meal_price.setText(" ");
        third_sub_meal_label.setText(" ");
        third_sub_meal_price.setText(" ");
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
        SetSubMenuButton("Fast_Food");

    }

    @FXML
    private void GoToSnack(MouseEvent event) {
        menu_layout.setVisible(false);
        sub_menu_layout.setVisible(true);
        favorits_layout.setVisible(false);
        my_order_layout.setVisible(false);
        SetSubMenuButton("Snack");
    }

    private void SetSubMenuButton(String s) {

        sub_menu_btn_1.setText(" ");
        sub_menu_btn_2.setText(" ");
        sub_menu_btn_3.setText(" ");
        sub_menu_btn_4.setText(" ");

        IMenuService menu = new MenuService();
        List<String> list_sub_category = new ArrayList<>(menu.GetSubCategoriesbyCategory().get(s));

        int l = list_sub_category.size();
        

        if (l >= 1) {
            sub_menu_btn_1.setText(list_sub_category.get(0));
        }

        if (l >= 2) {
            sub_menu_btn_2.setText(list_sub_category.get(1));
        }

        if (l >= 3) {
            sub_menu_btn_3.setText(list_sub_category.get(2));
        }

        if (l >= 4) {
            sub_menu_btn_4.setText(list_sub_category.get(3));
        }

    }

    @FXML
    private void click_sub_men_but(ActionEvent event) {
        //initializing photos to empty
        sub_menu_img1.setVisible(true);
        sub_menu_img2.setVisible(true);
        sub_menu_img3.setVisible(true);
        
        IMenuService menu = new MenuService();
        List<Menu> sub_categ = new ArrayList<>();
        
        //getting the label of the clicked button
        String source2 = event.getSource().toString();
        String[] evnt_parts = source2.split("=");
        String[] evnt_parts1 = evnt_parts[1].split(",");
        
        //getting the meals of the sub_menu button clicked
        if (evnt_parts1[0].equals("sub_menu_btn_1")) {
            sub_categ = menu.GetMealsFromSubMenuFilter(sub_menu_btn_1.getText());
        }
        if (evnt_parts1[0].equals("sub_menu_btn_2")) {
            sub_categ = menu.GetMealsFromSubMenuFilter(sub_menu_btn_2.getText());
        }
        if (evnt_parts1[0].equals("sub_menu_btn_3")) {
            sub_categ = menu.GetMealsFromSubMenuFilter(sub_menu_btn_3.getText());
        }
        if (evnt_parts1[0].equals("sub_menu_btn_4")) {
            sub_categ = menu.GetMealsFromSubMenuFilter(sub_menu_btn_4.getText());
        }
        
        int l = sub_categ.size();
        
        
        //Setting three meals containers to their values and photos
        if (l >= 1) {
            first_sub_meal_label.setText(sub_categ.get(0).getLibelle());
            first_sub_meal_price.setText(String.valueOf(sub_categ.get(0).getPrix()) + " DT");
        }
        if (l >= 2) {
            snd_sub_meal_label.setText(sub_categ.get(1).getLibelle());
            snd_sub_meal_price.setText(String.valueOf(sub_categ.get(1).getPrix()) + " DT");
        }
        if (l >= 3) {
            third_sub_meal_label.setText(sub_categ.get(2).getLibelle());
            third_sub_meal_price.setText(String.valueOf(sub_categ.get(2).getPrix()) + " DT");
        }

        //dealing with cases where there are no meals , or not enought meals to display
        if (l == 0) {
            sub_menu_img1.setVisible(false);
            sub_menu_img2.setVisible(false);
            sub_menu_img3.setVisible(false);
            first_sub_meal_label.setText(" ");
            first_sub_meal_price.setText(" ");
            snd_sub_meal_label.setText(" ");
            snd_sub_meal_price.setText(" ");
            third_sub_meal_label.setText(" ");
            third_sub_meal_price.setText(" ");
        }
        if (l == 1) {
            sub_menu_img2.setVisible(false);
            sub_menu_img3.setVisible(false);
            snd_sub_meal_label.setText(" ");
            snd_sub_meal_price.setText(" ");
            third_sub_meal_label.setText(" ");
            third_sub_meal_price.setText(" ");
        }
        if (l == 2) {

            sub_menu_img3.setVisible(false);
            third_sub_meal_label.setText(" ");
            third_sub_meal_price.setText(" ");
            sub_menu_img3.setVisible(false);
        }

    }

    @FXML
    private void next_part_sub_menu(MouseEvent event) {
            
    }
    
    @FXML
    private void prev_part_sub_menu(MouseEvent event) {
    }
    
    
    private List<Menu> ThreeMealsToShow(List<Menu> meals, boolean action,Integer position ){
        
        List<Menu> meals_to_show = new ArrayList<>();
        
        return meals_to_show;
    
    }

}
