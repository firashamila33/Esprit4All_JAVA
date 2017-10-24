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
public class FoodMaineFXMLController implements Initializable {

    @FXML
    private JFXButton menu_btn;
    @FXML
    private JFXButton current_order_btn;
    @FXML
    private JFXButton my_favorites_btn;
    @FXML
    private AnchorPane container;
    
    AnchorPane menu,myorder,myfavorits;
    @FXML
    private AnchorPane container1;
    @FXML
    private AnchorPane container3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            menu = FXMLLoader.load(getClass().getResource("/gui/FoodMenuFXML.fxml"));
            myorder = FXMLLoader.load(getClass().getResource("/gui/FoodMyOrderFXML.fxml"));
            myfavorits = FXMLLoader.load(getClass().getResource("/gui/FoodFavoritsFXML.fxml"));
            setNode1(menu);

        } catch (IOException ex) {
            Logger.getLogger(FoodMaineFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void goToMenu(ActionEvent event) throws IOException {
         menu = FXMLLoader.load(getClass().getResource("/gui/FoodMenuFXML.fxml"));
        setNode1(menu);
    }


    @FXML
    private void goToCurrentOrder(ActionEvent event) {
        setNode2(myorder);
    }

    @FXML
    private void goToFavorites(ActionEvent event) {
        setNode3(myfavorits);
        
    }
    
    
    private void setNode1(AnchorPane node){
        container1.getChildren().clear();
        container3.getChildren().clear();
        
        container.getChildren().clear();
        container.getChildren().add((Node) node);
    }
    private void setNode2(AnchorPane node){
        container.getChildren().clear();
        container3.getChildren().clear();
        
        container.getChildren().add((Node) container1);
        container1.getChildren().clear();
        container1.getChildren().add((Node) node);
    }
    
    private void setNode3(AnchorPane node){
        container.getChildren().clear();
        container1.getChildren().clear();
        
        container3.getChildren().add((Node) node);
        
    }
    
}
