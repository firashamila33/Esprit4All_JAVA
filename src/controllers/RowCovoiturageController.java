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
import models.HasCovoiturage;
import models.Profil;
import services.HasCovoiturageService;
import services.ProfilService;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author YACINE
 */
public class RowCovoiturageController extends ListCell<Covoiturage> {

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
    private JFXButton participer;
    @FXML
    private Text description;

    public StackPane a;
    JFXDialog dialog;
    HasCovoiturageService hasCovoiturageService = new HasCovoiturageService();

    public RowCovoiturageController(StackPane anchorPane) {
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
                mLLoader = new FXMLLoader(getClass().getResource("/gui/RowCovoiturage.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            
          
            Profil profil= new ProfilService().getByUserId(covoiturage.getUserId().getId());
            int count = hasCovoiturageService.getCouvoiturageCount(covoiturage);
            marqueV_lbl.setText(covoiturage.getVoiture());
            prix_lbl.setText(String.valueOf(covoiturage.getPrix() + " DT"));
            ville_depart_lbl.setText(covoiturage.getArrivé());
            ville_arrive_lbl.setText(covoiturage.getDepart());
            description.setText(covoiturage.getDescription());
            owner_name_lbl.setText(covoiturage.getUserId().getPrenom()+""+covoiturage.getUserId().getNom());
            phone_lbl.setText(profil.getTel()+"");
            dateDepart_lbl.setText(covoiturage.getHeureDépart().toString());
            participer.setOnAction(event -> {
                if (hasCovoiturageService.getUserCouvoiturage(covoiturage, UserService.userStatic)) {
                    showFullDialog("Vous etes deja Participant ", true, covoiturage);
                } else {
                    if (count == covoiturage.getNbrePlace()) {
                        showFullDialog("Nombre de place saturé", false, null);
                    } else {
                        hasCovoiturageService.add(new HasCovoiturage(covoiturage, UserService.userStatic));
                    }
                }
            });

            setText(null);
            setGraphic(row);
//            afficheCov.setOnAction(event -> {
//                try{
//                    FXMLLoader fXMLLoader=new FXMLLoader(getClass().getResource("/gui/DialogueLayout.fxml"));
//                    Parent root=(Parent) fXMLLoader.load();
//                    DialogueLayoutController dialogueLayoutController=fXMLLoader.<DialogueLayoutController>getController();
//                    dialogueLayoutController.setId(covoiturage.getUserId().getId());
//                    dialogueLayoutController.afficherDialogue(dialogueLayoutController.getId());
//                    Stage stage=new Stage();
//                    stage.setScene(new Scene(root));
//                    stage.show();
//                }catch(IOException e){
//                    e.printStackTrace();
//                }
//            });

        }
    }

    public void showFullDialog(String Message, Boolean b, Covoiturage covoiturage) {

        JFXDialogLayout dialogLayout = new JFXDialogLayout();

        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPrefSize(100, 100);
        VBox box = new VBox();
        Text text = new Text(Message);

        JFXButton b1 = new JFXButton("Supprime ma participation");
        box.getChildren().add(text);
        if (b == true) {
            box.getChildren().add(b1);
            b1.setOnAction(event -> {
                hasCovoiturageService.delete(covoiturage.getId());
                dialog.close();
            });
        }
        pane.getChildren().add(box);
        dialogLayout.getChildren().add(pane);
        dialog = new JFXDialog(a, dialogLayout, JFXDialog.DialogTransition.CENTER);
        dialog.show();

    }
}
