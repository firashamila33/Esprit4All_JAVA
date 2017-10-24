/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class TestfxController implements Initializable {

    @FXML
    private TableView<?> tab;
    @FXML
    private TableColumn<?, ?> idcol1;
    @FXML
    private TableColumn<?, ?> usridcol2;
    @FXML
    private TableColumn<?, ?> typecol3;
    @FXML
    private TableColumn<?, ?> quantitecol4;
    @FXML
    private TableColumn<?, ?> confirmcol5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
