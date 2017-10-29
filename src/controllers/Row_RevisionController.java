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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.E;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import models.Revision;
import models.User;
import models.utilisateur_has_revision;
import services.RevisionService;
import services.Sutilisateur_has_revision;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Row_RevisionController extends ListCell<Revision> {

    @FXML
    private ImageView photo_mentor2;
    
   
    private AnchorPane revision_fenetre;
    @FXML
    private Button rejoindre_grp;
    @FXML
    private Label LabelMatiere;
    @FXML
    private Label LabelDescription;
    @FXML
    private Label LabelNbrPersonne;
    @FXML
    private Label LabelNomMentor2;
JFXDialog dialog;
    private FXMLLoader mLLoader;
    JFXButton currentButton;
    @FXML
    private AnchorPane row_revision;
    @FXML
    private StackPane stack_revi;

    @Override
    protected void updateItem(Revision revision, boolean empty) {
        super.updateItem(revision, empty);

        if (empty || revision == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/gui/Row_Revision.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
               
                LabelNbrPersonne.setText(String.valueOf(revision.getNbrmax()));
                LabelMatiere.setText(revision.getMatiere());
                LabelDescription.setText(String.valueOf(revision.getId()));
                setText(null);
                setGraphic(row_revision);
            }

        }

    }

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void rejoindre_grp_revision(ActionEvent event) {
        try {
            int x = Integer.parseInt(LabelNbrPersonne.getText());
            if (x != 0) {
                x--;
                RevisionService rs = new RevisionService();
                Revision r = null;
                int f;
                f = Integer.parseInt(LabelDescription.getText());
                r = rs.search2(f);

                r.setNbrmax(x);
                rs.update(r);

                FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/gui/fenetre_groupe_revision.fxml"));
                Parent root = (Parent) fXMLLoader.load();

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
        User u = new User(1);
        Revision revision = rs.getById(u.getId());
         utilisateur_has_revision ur = new utilisateur_has_revision(revision, u);
        Sutilisateur_has_revision sur = new Sutilisateur_has_revision();
        sur.add(ur);
        LabelNbrPersonne.setText(String.valueOf(x));
        

            } else {
                rejoindre_grp.setVisible(false);
                JFXDialogLayout dialogLayout = new JFXDialogLayout();
                dialogLayout.setStyle("-fx-padding: 5px 10px 10px 5px;\n ");
                Label a = new Label("Le groupe est saturé");
                dialogLayout.getChildren().add(a);
                dialog = new JFXDialog(stack_revi, dialogLayout, JFXDialog.DialogTransition.TOP);
                dialog.show();
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        

    }

}
