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
public class FoodMenuFXMLController implements Initializable {

    @FXML
    private AnchorPane menu_layout;
    @FXML
    private AnchorPane sub_menu_layout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("test");
        
    }    

    

    @FXML
    private void GoToFastFood(MouseEvent event) {
        menu_layout.setVisible(false);
        sub_menu_layout.setVisible(true);
        System.out.println("tesssssssst");
    }

     
    
    
}
