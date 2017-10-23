/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author YACINE
 */
public class LoginController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane window1;
    @FXML
    private AnchorPane window2;
    @FXML
    private AnchorPane winodw3;
    @FXML
    private JFXButton button1;
    @FXML
    private JFXButton button2;
    @FXML
    private AnchorPane winodw4;
    @FXML
    private JFXTextField text1;
    @FXML
    private JFXTextField text2;
    @FXML
    private JFXTextField text3;
    @FXML
    private JFXTextField text4;
    @FXML
    private JFXTextField text5;
    @FXML
    private DatePicker date;
    @FXML
    private JFXTextField text6;
    @FXML
    private JFXTextField text7;
    @FXML
    private JFXButton button3;
    @FXML
    private AnchorPane window5;
    @FXML
    private JFXTextField text8;
    @FXML
    private JFXTextField text9;
    @FXML
    private JFXButton button4;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()==button1){
            window5.setVisible(true);
            winodw4.setVisible(false);
        }else if(event.getSource()==button2){
            winodw4.setVisible(true);
            window5.setVisible(false);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
