/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author plazma33
 */
public class FoodMainFXMLController implements Initializable {

    @FXML
    private AnchorPane container;
    @FXML
    private JFXButton menu_btn;
    @FXML
    private JFXButton myorders_btn;
    @FXML
    private JFXButton current_order_btn;
    @FXML
    private JFXButton my_favorites_btn;

    AnchorPane menu, myorder, currentOrder, myfavorites;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            menu = FXMLLoader.load(getClass().getResource("/gui/FoodHomeFXML.fxml"));
            myorder = FXMLLoader.load(getClass().getResource("/gui/FoodMyOrderFXML.fxml"));
            //currentOrder = FXMLLoader.load(getClass().getResource("/gui/FoodCurrentOrderListContainer.fxml"));
           //myfavorites = FXMLLoader.load(getClass().getResource("/gui/FoodHomeContainer.fxml"));
            setNode(menu);
        } catch (IOException ex) {
            Logger.getLogger(FoodMainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void goToMenu(ActionEvent event) {
        setNode(menu);
    }

    @FXML
    private void goToMyOrder(ActionEvent event) {
        setNode(myorder);
    }

    @FXML
    private void goToCurrentOrder(ActionEvent event) {
    }

    @FXML
    private void goToFavorites(ActionEvent event) {
    }
    
    
    private void setNode(Node node){
    container.getChildren().clear();
    container.getChildren().add((Node)node);
    }

}
