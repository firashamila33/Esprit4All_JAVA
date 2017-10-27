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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Covoiturage;

/**
 * FXML Controller class
 *
 * @author YACINE
 */
public class RowCovoiturageController extends ListCell<Covoiturage> {

    @FXML
    private AnchorPane row;
    @FXML
    private JFXButton afficheCov;
    @FXML
    private Text marqueV;
    @FXML
    private Text departV;
    @FXML
    private Text arriveV;
    @FXML
    private Text prixV;
    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(Covoiturage covoiturage, boolean empty) {
        super.updateItem(covoiturage, empty);
        if (empty || covoiturage == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/gui/RowCovoiturage.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            marqueV.setText(covoiturage.getType());
            prixV.setText(String.valueOf(covoiturage.getPrix() + " DT"));
            arriveV.setText(covoiturage.getArrivé());
            departV.setText(covoiturage.getDepart());
            setText(null);
            setGraphic(row);
            afficheCov.setOnAction(event -> {
                try{
                    FXMLLoader fXMLLoader=new FXMLLoader(getClass().getResource("/gui/DialogueLayout.fxml"));
                    Parent root=(Parent) fXMLLoader.load();
                    DialogueLayoutController dialogueLayoutController=fXMLLoader.<DialogueLayoutController>getController();
                    dialogueLayoutController.setId(covoiturage.getUserId().getId());
                    dialogueLayoutController.afficherDialogue(dialogueLayoutController.getId());
                    Stage stage=new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                }catch(IOException e){
                    e.printStackTrace();
                }
            });
        }
    }

    @FXML
    private void afficherCovoiturage(ActionEvent event) throws IOException {

    }

   /* private void afficheDialogue(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

}
