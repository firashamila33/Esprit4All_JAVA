/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import models.Club;
import models.Evenement;

/**
 * FXML Controller class
 *
 * @author majdi
 */
public class RowEventFXMLController extends ListCell<Evenement> {

    @FXML
    private ImageView img_evnt_id;
    @FXML
    private Label lib_event_id;
    @FXML
    private Label date_event_id;
    @FXML
    private Label type_event_id;
    @FXML
    private ImageView img_club_id;
    @FXML
    private Label desc_event_id;
    @FXML
    private AnchorPane row;
    
    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(Evenement evenements, boolean empty) {
        super.updateItem(evenements, empty);

        if (empty || evenements == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/gui/RowEventFXML.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            lib_event_id.setText(String.valueOf(evenements.getLiblle()));
           
            date_event_id.setText(String.valueOf(evenements.getDate()));
            desc_event_id.setText("qdhkjqhsjkdhqksjdhqkjsdhqkjsdhqkjsdhqkjsdhkjqsdhkjqshdk"
                    + "qjsdgkhqgfdhgfkjsqhdjkqhsdljqhsdljqhdsjl"
                    + "qshdjkshdlqjskhdqjkshdqjksdhjqksdhjqkshdjkqhsdjqhsdjkhqsdjkh");

            setText(null);
            setGraphic(row);
        }

    }

}
