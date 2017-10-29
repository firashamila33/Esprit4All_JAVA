/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import controllers.FXMLAnnonceColocationController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import models.AnnonceObjetPerdu;
import models.User;
import services.AnnonceObjetPerduService;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author kadhem
 */
public class FXMLAnnonceObjetPerduMenuController implements Initializable {

    @FXML
    public VBox myVBox;
    public String mode = "listMode";
    public ArrayList<AnnonceObjetPerdu> annonceList;
    public ArrayList<FXMLAnnonceObjetPerduController> annonceWidgetList;
    private FXMLAnnonceObjetPerduController focusedElement;
    @FXML
    public AnchorPane mainPlace;
    @FXML
    public AnchorPane Menu;

    @FXML
    private Button supprimerButton;
    private User currentUser;
    private boolean isAdmin;

    public User getCurrentUser() {
        return currentUser;
    }
    

    public FXMLAnnonceObjetPerduMenuController() {
        annonceWidgetList = new ArrayList<>();
        UserService service = new UserService();
        currentUser = service.userStatic;
        isAdmin = currentUser.getRole() == "ROLE_ADMIN";

    }

    public void onAnnonceClick(FXMLAnnonceObjetPerduController c) {

        focusedElement = c;

        if (currentUser.equals(focusedElement.getAnnonce().getOwner()) || isAdmin) {
            supprimerButton.setVisible(true);
        } else {
            supprimerButton.setVisible(false);
        }

    }

    public void onDetailedMenuOkClick() {
        mainPlace.getChildren().clear();
        mainPlace.getChildren().add(Menu);
        refresh();
    }

    private void refresh() {
        AnnonceObjetPerduService service = new AnnonceObjetPerduService();
        annonceWidgetList.clear();
        myVBox.getChildren().clear();
        annonceList = (ArrayList<AnnonceObjetPerdu>) service.getAll();

        annonceList.forEach(a -> {
            try {
                FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/gui/FXMLAnnonceObjetPerdu.fxml"));

                Node widget = fXMLLoader.<Node>load();
                FXMLAnnonceObjetPerduController controller = fXMLLoader.<FXMLAnnonceObjetPerduController>getController();
                controller.init(a, this);
                annonceWidgetList.add(controller);
                myVBox.getChildren().add(widget);

            } catch (IOException ex) {
                Logger.getLogger(FXMLAnnonceColocationMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        refresh();

    }

    public void onAnnonceDoubleClick(FXMLAnnonceObjetPerduController trigger) {
        try {
            mode = "detailedViewMode";
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/gui/FXMLDetailedAnnonceObjetPerdu.fxml"));
            Node widget = fXMLLoader.<Node>load();
            FXMLDetailedAnnonceObjetPerduController controller = fXMLLoader.<FXMLDetailedAnnonceObjetPerduController>getController();
            if (currentUser.equals(trigger.getAnnonce().getOwner())) {
                controller.initUpdateMode(trigger.getAnnonce(), this);
            } else {
                controller.initViewMode(trigger.getAnnonce(), this);
            }
            mainPlace.getChildren().remove(Menu);
            mainPlace.getChildren().add(widget);

        } catch (IOException ex) {
            Logger.getLogger(FXMLAnnonceColocationMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void onNouvelleAnnonceAction(ActionEvent event) {
        try {
            mode = "detailedViewMode";
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/gui/FXMLDetailedAnnonceObjetPerdu.fxml"));
            Node widget = fXMLLoader.<Node>load();
            FXMLDetailedAnnonceObjetPerduController controller = fXMLLoader.<FXMLDetailedAnnonceObjetPerduController>getController();
            controller.initAddMode(this);
            mainPlace.getChildren().remove(Menu);
            mainPlace.getChildren().add(widget);
        } catch (IOException ex) {
            Logger.getLogger(FXMLAnnonceColocationMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    @FXML
    private void onSupprimerAction(ActionEvent event) {
        AnnonceObjetPerduService service = new AnnonceObjetPerduService();
        service.delete(focusedElement.getAnnonce().getId());
        focusedElement = null;
        refresh();
    }

    

}
