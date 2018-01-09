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
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.util.List;
import java.util.Map;
import static java.util.Objects.hash;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.util.Callback;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import models.Commande;
import models.LigneCommande;
import models.Menu;
import models.User;
import services.CommandeService;
import services.LigneCommandeService;
import services.MenuService;
import services.UserService;
import static services.UserService.userStatic;

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
    private Label id_commande;

    @FXML
    private JFXButton btn_commander;
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
    //this is the meal that will be passed to the order in case "Commander" Button is clicked
    private Menu meal_ready_for_command;

    private Integer CommandeId = -1;
    private Integer User_id = 0;
    private Map<Menu, Integer> Order_list = new HashMap<>();

    //sub_menu button clicked
    private String clicked_button = null;

    //position of the central displayed meal , this variable 
    //is made to be used in case the arrows are clicked,it includes 
    private int central_meal_position = 1;

    private boolean next_pressed;

    private int the_other_butten_was_clicked = -1;
    @FXML
    private JFXButton Meals_btn;
    @FXML

    private JFXButton Drinks_btn1;

    public double Commande_Price;

    @FXML
    public Label price_commande;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //getting static user
        User u = u = UserService.userStatic;
        User_id = u.getId();
        System.out.println("USER ID ------> " + User_id);
        System.out.println("Commande ID ---------->" + CommandeId);
        //testing if user have an order 
        ICommandeService com_tool = new CommandeService();
        if (com_tool.ReturnLastOrderByUser(User_id) != null) {
            CommandeId = com_tool.ReturnLastOrderByUser(User_id).getId();
        }
        if (CommandeId == -1) {
            System.out.println("Commande ID ---------->" + CommandeId);
            System.out.println("-----------------------I DID NOT FIND A ORDER SO I am going to create one-------------------------------------- ;");
            Commande c = new Commande(new User(User_id), null, 0.0);
            ICommandeService ICom = new CommandeService();
            ICom.add(c);
            CommandeId = com_tool.ReturnLastOrderByUser(User_id).getId();

        }
        //initialising orders interface to work on and getting the order of the user
        ILigneCommandeService Ligne_repas = new LigneCommandeService();
        ICommandeService ICommande = new CommandeService();
        Commande commande = ICommande.getById(CommandeId);

        //setting my_order total price and Referance 
        id_commande.setText(String.valueOf(commande.getId()));
        price_commande.setText(String.valueOf(commande.getPrix()) + " DT");

        ligne_commande = FXCollections.observableArrayList(Ligne_repas.getByCommande(CommandeId));
        listView_commandes.setItems(ligne_commande);
        listView_commandes.setCellFactory(LigneCommandesListVIrs -> new FoodMyOrderRowListController());

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
//        menu_layout.setVisible(false);
//        sub_menu_layout.setVisible(false);
//        favorits_layout.setVisible(true);
//        my_order_layout.setVisible(false);
        menu_layout.setVisible(false);
        sub_menu_layout.setVisible(false);
        favorits_layout.setVisible(false);
        my_order_layout.setVisible(true);
        
        ILigneCommandeService Ligne_repas = new LigneCommandeService();
        ICommandeService com_tool = new CommandeService();
        //inserting new order to database
        Commande c = new Commande(new User(User_id), null, 0.0);
        ICommandeService ICom = new CommandeService();
        ICom.add(c);
        CommandeId = com_tool.ReturnLastOrderByUser(User_id).getId();
        
        //setting labels
        id_commande.setText(String.valueOf(CommandeId));
        //Set TOtal Prise to 0
        price_commande.setText("0 DT");
        
        //initialise listview
        System.out.println("-------------------------------------COMMANDE PRICE Add = " + Commande_Price);
        ligne_commande = FXCollections.observableArrayList(Ligne_repas.getByCommande(CommandeId));
        listView_commandes.setItems(ligne_commande);
        listView_commandes.setCellFactory(LigneCommandesListVIrs -> new FoodMyOrderRowListController());

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

    @FXML
    private void GoToMealsFood(MouseEvent event) {
        menu_layout.setVisible(false);
        sub_menu_layout.setVisible(true);
        favorits_layout.setVisible(false);
        my_order_layout.setVisible(false);
        SetSubMenuButton("meals");
    }

    @FXML
    private void GoToDrinksFood(MouseEvent event) {
        menu_layout.setVisible(false);
        sub_menu_layout.setVisible(true);
        favorits_layout.setVisible(false);
        my_order_layout.setVisible(false);
        SetSubMenuButton("drinks");
    }

    private void SetSubMenuButton(String s) {
        central_meal_position = 1;
        //INITIALISING LABELS
        sub_menu_btn_1.setText(" ");
        sub_menu_btn_2.setText(" ");
        sub_menu_btn_3.setText(" ");
        sub_menu_btn_4.setText(" ");
        first_sub_meal_label.setText(" ");
        first_sub_meal_price.setText(" ");
        snd_sub_meal_label.setText(" ");
        snd_sub_meal_price.setText(" ");
        third_sub_meal_label.setText(" ");
        third_sub_meal_price.setText(" ");

        sub_menu_img1.setVisible(false);
        sub_menu_img2.setVisible(false);
        sub_menu_img3.setVisible(false);
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
        central_meal_position = 1;
        //INITIALISATION
        first_sub_meal_label.setText(" ");
        first_sub_meal_price.setText(" ");
        snd_sub_meal_label.setText(" ");
        snd_sub_meal_price.setText(" ");
        third_sub_meal_label.setText(" ");
        third_sub_meal_price.setText(" ");
        sub_menu_img1.setVisible(false);
        sub_menu_img2.setVisible(false);
        sub_menu_img3.setVisible(false);
        first_sub_meal_label.setText(" ");
        first_sub_meal_price.setText(" ");
        snd_sub_meal_label.setText(" ");
        snd_sub_meal_price.setText(" ");
        third_sub_meal_label.setText(" ");
        third_sub_meal_price.setText(" ");

        IMenuService menu = new MenuService();
        List<Menu> sub_categ = new ArrayList<>();

        //getting the label of the clicked button
        String source2 = event.getSource().toString();
        String[] evnt_parts = source2.split("=");
        String[] evnt_parts1 = evnt_parts[1].split(",");

        clicked_button = evnt_parts1[0];
        //getting the meals of the sub_menu button clicked
        if (clicked_button.equals("sub_menu_btn_1")) {
            sub_categ = menu.GetMealsFromSubMenuFilter(sub_menu_btn_1.getText());
        }
        if (clicked_button.equals("sub_menu_btn_2")) {
            sub_categ = menu.GetMealsFromSubMenuFilter(sub_menu_btn_2.getText());
        }
        if (clicked_button.equals("sub_menu_btn_3")) {
            sub_categ = menu.GetMealsFromSubMenuFilter(sub_menu_btn_3.getText());
        }
        if (clicked_button.equals("sub_menu_btn_4")) {
            sub_categ = menu.GetMealsFromSubMenuFilter(sub_menu_btn_4.getText());
        }

        //Setting three meals containers to their values and photos
        int l = sub_categ.size();
        if (l >= 1) {
            first_sub_meal_label.setText(sub_categ.get(0).getLibelle());
            first_sub_meal_price.setText(String.valueOf(sub_categ.get(0).getPrix()) + " DT");
            sub_menu_img1.setVisible(true);
            sub_menu_img1.setImage(new Image("http://localhost:90//www/Esprit4All/uploads/" + String.valueOf(sub_categ.get(0).getPath_img())));
        }
        if (l >= 2) {
            snd_sub_meal_label.setText(sub_categ.get(1).getLibelle());
            snd_sub_meal_price.setText(String.valueOf(sub_categ.get(1).getPrix()) + " DT");
            sub_menu_img2.setVisible(true);
            sub_menu_img2.setImage(new Image("http://localhost:90//www/Esprit4All/uploads/" + String.valueOf(sub_categ.get(1).getPath_img())));

        }
        if (l >= 3) {
            third_sub_meal_label.setText(sub_categ.get(2).getLibelle());
            third_sub_meal_price.setText(String.valueOf(sub_categ.get(2).getPrix()) + " DT");
            sub_menu_img3.setVisible(true);
            sub_menu_img3.setImage(new Image("http://localhost:90//www/Esprit4All/uploads/" + String.valueOf(sub_categ.get(2).getPath_img())));
        }
        if (sub_categ.get(1) != null) {
            meal_ready_for_command = sub_categ.get(1);
        }

//        //dealing with cases where there are no meals , or not enought meals to display
//        if (l == 0) {
////            sub_menu_img1.setVisible(false);
////            sub_menu_img2.setVisible(false);
////            sub_menu_img3.setVisible(false);
//            first_sub_meal_label.setText(" ");
//            first_sub_meal_price.setText(" ");
//            snd_sub_meal_label.setText(" ");
//            snd_sub_meal_price.setText(" ");
//            third_sub_meal_label.setText(" ");
//            third_sub_meal_price.setText(" ");
//        }
//        if (l == 1) {
////            sub_menu_img2.setVisible(false);
////            sub_menu_img3.setVisible(false);
//            snd_sub_meal_label.setText(" ");
//            snd_sub_meal_price.setText(" ");
//            third_sub_meal_label.setText(" ");
//            third_sub_meal_price.setText(" ");
//        }
//        if (l == 2) {
//            sub_menu_img3.setVisible(true);
//            third_sub_meal_label.setText(" ");
//            third_sub_meal_price.setText(" ");
//            sub_menu_img3.setVisible(true);
//        }
        central_meal_position = 2;

    }

    //this method returns the three meals t show in the main page in case "next" arrow is  clicked 
    @FXML
    private void next_part_sub_menu(ActionEvent event) {

        if (the_other_butten_was_clicked == 0) {

            central_meal_position = central_meal_position + 2;
        }
        the_other_butten_was_clicked = 1;

        IMenuService meals_interface = new MenuService();

        //list containing all the sub_category selected meals
        List<Menu> sub_category_meals = new ArrayList<>();

        //getting the meals of the sub_menu button clicked
        if (clicked_button.equals("sub_menu_btn_1")) {
            sub_category_meals = meals_interface.GetMealsFromSubMenuFilter(sub_menu_btn_1.getText());
        }
        if (clicked_button.equals("sub_menu_btn_2")) {
            sub_category_meals = meals_interface.GetMealsFromSubMenuFilter(sub_menu_btn_2.getText());
        }
        if (clicked_button.equals("sub_menu_btn_3")) {
            sub_category_meals = meals_interface.GetMealsFromSubMenuFilter(sub_menu_btn_3.getText());
        }
        if (clicked_button.equals("sub_menu_btn_4")) {
            sub_category_meals = meals_interface.GetMealsFromSubMenuFilter(sub_menu_btn_4.getText());
        }

        if (sub_category_meals.size() > 1) {

            //List whitch contains the three meals to show
            List<Menu> three_meals = new ArrayList<>();
            three_meals = ThreeMealsToShow(sub_category_meals, true, central_meal_position);

            first_sub_meal_label.setText(three_meals.get(0).getLibelle());
            first_sub_meal_price.setText(String.valueOf(three_meals.get(0).getPrix()) + " DT");
            sub_menu_img1.setVisible(true);
            sub_menu_img1.setImage(new Image("http://localhost:90//www/Esprit4All/uploads/" + String.valueOf(three_meals.get(0).getPath_img())));

            snd_sub_meal_label.setText(three_meals.get(1).getLibelle());
            snd_sub_meal_price.setText(String.valueOf(three_meals.get(1).getPrix()) + " DT");
            sub_menu_img2.setVisible(true);
            sub_menu_img2.setImage(new Image("http://localhost:90//www/Esprit4All/uploads/" + String.valueOf(three_meals.get(1).getPath_img())));

            third_sub_meal_label.setText(three_meals.get(2).getLibelle());
            third_sub_meal_price.setText(String.valueOf(three_meals.get(2).getPrix()) + " DT");
            sub_menu_img3.setVisible(true);
            sub_menu_img3.setImage(new Image("http://localhost:90//www/Esprit4All/uploads/" + String.valueOf(three_meals.get(2).getPath_img())));

            meal_ready_for_command = three_meals.get(1);
            three_meals.clear();
            if (central_meal_position == sub_category_meals.size()) {
                central_meal_position = 0;
            } else {
                central_meal_position++;
            }
            the_other_butten_was_clicked = 1;
        }

    }

    //this method returns the three meals t show in the main page in case "previous" arrow is clicked 
    @FXML
    private void prev_part_sub_menu(ActionEvent event) {

        if (the_other_butten_was_clicked == 1) {

            central_meal_position = central_meal_position - 2;
        }
        the_other_butten_was_clicked = 0;
        if (central_meal_position == -2) {
            central_meal_position = -1;
        }

        IMenuService meals_interface = new MenuService();

        //list containing all the sub_category selected meals
        List<Menu> sub_category_meals = new ArrayList<>();

        //getting the meals of the sub_menu button clicked
        if (clicked_button.equals("sub_menu_btn_1")) {
            sub_category_meals = meals_interface.GetMealsFromSubMenuFilter(sub_menu_btn_1.getText());
        }
        if (clicked_button.equals("sub_menu_btn_2")) {
            sub_category_meals = meals_interface.GetMealsFromSubMenuFilter(sub_menu_btn_2.getText());
        }
        if (clicked_button.equals("sub_menu_btn_3")) {
            sub_category_meals = meals_interface.GetMealsFromSubMenuFilter(sub_menu_btn_3.getText());
        }
        if (clicked_button.equals("sub_menu_btn_4")) {
            sub_category_meals = meals_interface.GetMealsFromSubMenuFilter(sub_menu_btn_4.getText());
        }

        if (sub_category_meals.size() > 1) {

            //List whitch contains the three meals to show
            List<Menu> three_meals = new ArrayList<>();
            three_meals = ThreeMealsToShow(sub_category_meals, false, central_meal_position);

            first_sub_meal_label.setText(three_meals.get(0).getLibelle());
            first_sub_meal_price.setText(String.valueOf(three_meals.get(0).getPrix()) + " DT");
            sub_menu_img1.setImage(new Image("http://localhost:90//www/Esprit4All/uploads/" + String.valueOf(three_meals.get(0).getPath_img())));

            snd_sub_meal_label.setText(three_meals.get(1).getLibelle());
            snd_sub_meal_price.setText(String.valueOf(three_meals.get(1).getPrix()) + " DT");
            sub_menu_img2.setImage(new Image("http://localhost:90//www/Esprit4All/uploads/" + String.valueOf(three_meals.get(1).getPath_img())));

            third_sub_meal_label.setText(three_meals.get(2).getLibelle());
            third_sub_meal_price.setText(String.valueOf(three_meals.get(2).getPrix()) + " DT");
            sub_menu_img3.setImage(new Image("http://localhost:90//www/Esprit4All/uploads/" + String.valueOf(three_meals.get(2).getPath_img())));
            meal_ready_for_command = three_meals.get(1);

            three_meals.clear();
            if (central_meal_position == -1) {
                central_meal_position = sub_category_meals.size() - 2;

            } else {
                central_meal_position--;
            }

        }
    }

    private List<Menu> ThreeMealsToShow(List<Menu> meals, boolean action, Integer position) {
//        if(meals.size()<position)
//        {}

        List<Menu> meals_to_show = new ArrayList<>();

        //stepping forward in the meals list
        if (action) {
            if ((position > 0) && (position < meals.size() - 1)) {
                meals_to_show.add(meals.get(position - 1));
                meals_to_show.add(meals.get(position));
                meals_to_show.add(meals.get(position + 1));
                return meals_to_show;
            } else if (position == meals.size() - 1) {
                meals_to_show.add(meals.get(position - 1));
                meals_to_show.add(meals.get(position));
                meals_to_show.add(meals.get(0));
                return meals_to_show;

            } else if (position == meals.size()) {

                meals_to_show.add(meals.get(position - 1));
                meals_to_show.add(meals.get(0));
                meals_to_show.add(meals.get(1));
                return meals_to_show;

            } else if (position == meals.size() - 1) {
                meals_to_show.add(meals.get(position));
                meals_to_show.add(meals.get(0));
                meals_to_show.add(meals.get(1));
                return meals_to_show;
            } else if (position == 0) {
                meals_to_show.add(meals.get(meals.size() - 1));
                meals_to_show.add(meals.get(0));
                meals_to_show.add(meals.get(1));
                return meals_to_show;

            }

        }
        if (action == false) {

            if (position > 0) {
                meals_to_show.add(meals.get(position - 1));
                meals_to_show.add(meals.get(position));
                meals_to_show.add(meals.get(position + 1));
                return meals_to_show;
            } else if (position == 0) {
                meals_to_show.add(meals.get(meals.size() - 1));
                meals_to_show.add(meals.get(0));
                meals_to_show.add(meals.get(1));
                return meals_to_show;
            } else if (position == -1) {
                meals_to_show.add(meals.get(meals.size() - 2));
                meals_to_show.add(meals.get(meals.size() - 1));
                meals_to_show.add(meals.get(0));
                return meals_to_show;

            }
        }

        return null;

    }

    @FXML
    private void passer_commande(ActionEvent event) {

        add_to_virtual_commande(meal_ready_for_command);
    }

    private void add_to_virtual_commande(Menu m) {

        ILigneCommandeService Ligne_repas = new LigneCommandeService();
        LigneCommande l_test = new LigneCommande(CommandeId, m.getId(), 1);
        if ((Ligne_repas.TestExist(l_test)) == 0) {
            LigneCommande l_com = new LigneCommande(CommandeId, m.getId(), 1);
            Ligne_repas.add(l_com);
            //updating the price
            ICommandeService comm_tool = new CommandeService();
            Commande order = comm_tool.ReturnLastOrderByUser(User_id);
            Commande_Price = comm_tool.UpdateCommandePricce(order);

            //updating commande price in datbase
            order.setPrix(Commande_Price);
            comm_tool.update(order);
            //updating price label
            price_commande.setText(String.valueOf(Commande_Price) + " DT");

            System.out.println("-------------------------------------COMMANDE PRICE Add = " + Commande_Price);
            ligne_commande = FXCollections.observableArrayList(Ligne_repas.getByCommande(CommandeId));
            listView_commandes.setItems(ligne_commande);
            listView_commandes.setCellFactory(LigneCommandesListVIrs -> new FoodMyOrderRowListController());
        }
    }

    public void delete_row_list(LigneCommande l) {
        ILigneCommandeService Ligne_repas = new LigneCommandeService();
        Ligne_repas.delete(l);
        //updating the price
        //updating the price
        ICommandeService comm_tool = new CommandeService();
        Commande order = comm_tool.ReturnLastOrderByUser(User_id);
        Commande_Price = comm_tool.UpdateCommandePricce(order);
        //updating commande price in datbase
        order.setPrix(Commande_Price);
        comm_tool.update(order);
        //updating price label
        price_commande.setText(String.valueOf(Commande_Price) + " DT");

        ligne_commande = FXCollections.observableArrayList(Ligne_repas.getByCommande(CommandeId));
        listView_commandes.setItems(ligne_commande);
        listView_commandes.setCellFactory(LigneCommandesListVIrs -> new FoodMyOrderRowListController());

    }

    public void InitiateListView() {

    }

    @FXML
    private void delete_commande(ActionEvent event) {
        //deleting from database
        System.out.println("aaaaaaamaaa");
        ILigneCommandeService lign = new LigneCommandeService();
        lign.delete_by_commandeId(CommandeId);

        //calculating new price and refreshing order
        ICommandeService comm_tool = new CommandeService();
        //finding the last order by this user
        Commande order = comm_tool.ReturnLastOrderByUser(User_id);
        Commande_Price = comm_tool.UpdateCommandePricce(order);
        order.setPrix(0.0);
        comm_tool.update(order);

        //refresh price label
        price_commande.setText("0 DT");

        //Refresh_listview
        ILigneCommandeService Ligne_repas = new LigneCommandeService();
        ligne_commande = FXCollections.observableArrayList(Ligne_repas.getByCommande(CommandeId));
        listView_commandes.setItems(ligne_commande);
        listView_commandes.setCellFactory(LigneCommandesListVIrs -> new FoodMyOrderRowListController());

    }

    public int getUserId() {

        return User_id;
    }

    public void substructQuantity() {
        ICommandeService comm_tool = new CommandeService();
        Commande order = comm_tool.ReturnLastOrderByUser(User_id);
        Commande_Price = comm_tool.UpdateCommandePricce(order);

        //updating commande price in datbase
        order.setPrix(Commande_Price);
        comm_tool.update(order);

    }

    public void AddQuantity() {
        ICommandeService comm_tool = new CommandeService();
        Commande order = comm_tool.ReturnLastOrderByUser(User_id);
        Commande_Price = comm_tool.UpdateCommandePricce(order);
        //updating commande price in datbase
        order.setPrix(Commande_Price);
        comm_tool.update(order);

        System.out.println(".....................SETTING NEW TOTAL PRICE");
        SetTotaPriceLabel(Commande_Price);
        System.out.println(".....................NEW COMMANDE TOTAL PRICE " + Commande_Price);
        System.out.println(".....................NEW TOTAL PRICE SETTED");

        //price_commande.setText(String.valueOf(Commande_Price) + " DT");
    }

    public void SetTotaPriceLabel(double i) {

        price_commande.setText(String.valueOf(i) + " DT");

    }

}
