/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import models.Covoiturage;

import models.Profil;
import services.CovoiturageService;
import services.HasCovoiturageService;
import services.ProfilService;

/**
 * FXML Controller class
 *
 * @author YACINE
 */
public class RowMesCovoiturageController extends ListCell<Covoiturage> {

    @FXML
    private AnchorPane row;
    private FXMLLoader mLLoader;
    @FXML
    private ImageView owner_img;
    @FXML
    private Label owner_name_lbl;
    @FXML
    private Label phone_lbl;
    @FXML
    private Label marqueV_lbl;
    @FXML
    private Label dateDepart_lbl;
    @FXML
    private Label ville_depart_lbl;
    @FXML
    private Label ville_arrive_lbl;
    @FXML
    private Label prix_lbl;
    @FXML
    private ImageView img_occuped_place;
    @FXML
    private JFXButton supprime;
    @FXML
    private JFXButton modifier;
    @FXML
    private Text description;
    public StackPane a;
    JFXDialog dialog;
    HasCovoiturageService hasCovoiturageService = new HasCovoiturageService();

    public RowMesCovoiturageController(StackPane anchorPane) {
        a = anchorPane;
    }
    @Override
    protected void updateItem(Covoiturage covoiturage, boolean empty) {
        super.updateItem(covoiturage, empty);
        if (empty || covoiturage == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/gui/RowMesCovoiturage.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            Profil profil= new ProfilService().getByUserId(covoiturage.getUserId().getId());
            marqueV_lbl.setText(covoiturage.getVoiture());
            prix_lbl.setText(String.valueOf(covoiturage.getPrix() + " DT"));
            ville_depart_lbl.setText(covoiturage.getArrivé());
            ville_arrive_lbl.setText(covoiturage.getDepart());
            description.setText(covoiturage.getDescription());
            
            owner_name_lbl.setText(covoiturage.getUserId().getPrenom()+" "+covoiturage.getUserId().getNom());
            if (profil == null) {
                phone_lbl.setText("Pas de numéro");
            } else {
                phone_lbl.setText(profil.getTel() + "");
            }
            if (covoiturage.getHeureDépart() == null) {
                dateDepart_lbl.setText("Pas de date");
            } else {
                dateDepart_lbl.setText(covoiturage.getHeureDépart().toString());
            }
            supprime.setOnAction(event -> {
                CovoiturageService covoiturageService= new CovoiturageService();
                covoiturageService.delete(covoiturage.getId());
                getListView().getItems().remove(covoiturage);
                getListView().refresh();
            });
            setText(null);
            setGraphic(row);     
        }
    }
}
