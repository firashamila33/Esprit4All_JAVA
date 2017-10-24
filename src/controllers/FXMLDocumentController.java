/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author YACINE
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane window1;
    @FXML
    private AnchorPane window2;
    @FXML
    private AnchorPane window3;
    @FXML
    private AnchorPane window4;
    @FXML
    private AnchorPane window5;
    @FXML
    private AnchorPane window6;
    @FXML
    private AnchorPane window7;
    @FXML
    private AnchorPane window8;
    @FXML
    private AnchorPane window9;
    @FXML
    private AnchorPane window10;
    @FXML
    private JFXButton button1;
    @FXML
    private JFXButton button2;
    @FXML
    private JFXButton button3;
    @FXML
    private JFXTextField text1;
    @FXML
    private JFXTextField text2;
    @FXML
    private JFXTextField text3;
    @FXML
    private JFXTextField text4;
    @FXML
    private JFXRadioButton radio1;
    @FXML
    private JFXRadioButton radio2;
    @FXML
    private JFXRadioButton radio3;
    @FXML
    private JFXRadioButton radio4;
    @FXML
    private JFXTextField text5;
    @FXML
    private JFXTextArea text6;
    @FXML
    private JFXButton button4;
    @FXML
    private JFXButton button5;
    @FXML
    private JFXButton button6;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()==button1){
            window2.setVisible(false);
            window5.setVisible(true);
        }else if(event.getSource()==button2){
            window2.setVisible(false);
            window8.setVisible(true);
        }else if(event.getSource()==button3){
            window2.setVisible(true);
            window5.setVisible(false);
        }else if(event.getSource()==button5){
            window8.setVisible(false);
            window2.setVisible(true);
        }else if(event.getSource()==button6){
            window8.setVisible(false);
            window5.setVisible(true);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
