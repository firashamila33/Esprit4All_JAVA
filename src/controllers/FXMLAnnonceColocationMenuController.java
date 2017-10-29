/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import models.AnnonceCoLocation;
import services.AnnonceCoLocationService;
import controllers.FXMLAnnonceColocationController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import models.User;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author kadhem
 */
public class FXMLAnnonceColocationMenuController implements Initializable {

    @FXML
    public WebView webViewMap;
    @FXML
    public VBox myVBox;
    public String mode = "listMode";
    public ArrayList<AnnonceCoLocation> annonceList;
    public ArrayList<FXMLAnnonceColocationController> annonceWidgetList;
    private FXMLAnnonceColocationController focusedElement;
    @FXML
    public AnchorPane mainPlace;
    @FXML
    public AnchorPane Menu;
    @FXML
    private TextField minLoyer;
    @FXML
    private TextField maxLoyer;
    @FXML
    private TextField minCoLocataires;
    @FXML
    private TextField maxCoLocataires;
    @FXML
    private Button supprimerButton;
    private User currentUser;
    private boolean isAdmin;

    public FXMLAnnonceColocationMenuController() {
        annonceWidgetList = new ArrayList<>();
        UserService service = new UserService();
        currentUser = service.getUserById(7);
        isAdmin = false;
         
    }

    public void setMarkerPosition(double lat, double lng) {
        String script = "setMarkerPosition(" + lat + "," + lng + ");";
        webViewMap.getEngine().executeScript(script);

    }

    public void onAnnonceClick(FXMLAnnonceColocationController c) {

        focusedElement = c;

        setMarkerPosition(c.getAnnonce().getAddress().getLat(), c.getAnnonce().getAddress().getLng());
        System.out.println(focusedElement.getAnnonce().getOwner());
        if(currentUser.equals(focusedElement.getAnnonce().getOwner()) || isAdmin)
            supprimerButton.setVisible(true);
        else
            supprimerButton.setVisible(false);
        

    }

    public void onDetailedMenuOkClick() {
        mainPlace.getChildren().clear();
        mainPlace.getChildren().add(Menu);
        refresh();
    }

    private void refresh() {
        AnnonceCoLocationService service = new AnnonceCoLocationService();
        annonceWidgetList.clear();
        myVBox.getChildren().clear();
        annonceList = (ArrayList<AnnonceCoLocation>) service.getAll();

        annonceList.forEach(a -> {
            try {
                FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/gui/FXMLAnnonceColocation.fxml"));

                Node widget = fXMLLoader.<Node>load();
                FXMLAnnonceColocationController controller = fXMLLoader.<FXMLAnnonceColocationController>getController();
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

        //URL url1 = new URL("file:///home/kadhem/esprit/gmap.html");
        URL url1 = getClass().getResource("/gui/gmap.html");

        webViewMap.getEngine().load(url1.toString());

        refresh();

    }

    public void onAnnonceDoubleClick(FXMLAnnonceColocationController trigger) {
        try {
            mode = "detailedViewMode";
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/gui/FXMLDetailedAnnonce.fxml"));
            Node widget = fXMLLoader.<Node>load();
            FXMLDetailedAnnonceController controller = fXMLLoader.<FXMLDetailedAnnonceController>getController();
            if(currentUser.equals(trigger.getAnnonce().getOwner()))
                controller.initUpdateMode(trigger.getAnnonce(), this);
            else
               controller.initViewMode(trigger.getAnnonce(), this); 
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
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/gui/FXMLDetailedAnnonce.fxml"));
            Node widget = fXMLLoader.<Node>load();
            FXMLDetailedAnnonceController controller = fXMLLoader.<FXMLDetailedAnnonceController>getController();
            controller.initAddMode(this);
            mainPlace.getChildren().remove(Menu);
            mainPlace.getChildren().add(widget);
        } catch (IOException ex) {
            Logger.getLogger(FXMLAnnonceColocationMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void onFiltrerAction(ActionEvent event) {
        myVBox.getChildren().clear();
        ArrayList<FXMLAnnonceColocationController> newAnnonceWidgetList = new ArrayList<>();
        annonceList.stream()
                .filter(annonce -> {

                    float loyerMax = maxLoyer.getText().equals("") ? 99999 : Float.parseFloat(maxLoyer.getText());
                    float loyerMin = minLoyer.getText().equals("") ? 0 : Float.parseFloat(minLoyer.getText());
                    int maxCMax = maxCoLocataires.getText().equals("") ? 99999 : Integer.parseInt(maxCoLocataires.getText());
                    int maxCMin = minCoLocataires.getText().equals("") ? 0 : Integer.parseInt(minCoLocataires.getText());

                    System.out.println(loyerMax + " " + loyerMin + " "+maxCMax + " "+ maxCMin);
                    return annonce.getMaxCoLocataire() < maxCMax
                            && annonce.getMaxCoLocataire() > maxCMin
                            && annonce.getLoyer() < loyerMax
                            && annonce.getLoyer() > loyerMin;
                })
                .forEach(annonce -> {
                    try {
                        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/gui/FXMLAnnonceColocation.fxml"));

                        Node widget = fXMLLoader.<Node>load();
                        FXMLAnnonceColocationController controller = fXMLLoader.<FXMLAnnonceColocationController>getController();
                        controller.init(annonce, this);
                        newAnnonceWidgetList.add(controller);
                        myVBox.getChildren().add(widget);

                    } catch (IOException ex) {
                        Logger.getLogger(FXMLAnnonceColocationMenuController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                });
        annonceWidgetList = newAnnonceWidgetList;
    }

    @FXML
    private void onSupprimerAction(ActionEvent event) {
        AnnonceCoLocationService service = new AnnonceCoLocationService();
        service.delete(focusedElement.getAnnonce().getId());
        refresh();
    }

}
