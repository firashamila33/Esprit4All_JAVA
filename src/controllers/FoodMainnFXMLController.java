/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
