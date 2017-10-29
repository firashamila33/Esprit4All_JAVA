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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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

    public FXMLAnnonceColocationMenuController() {
        annonceWidgetList = new ArrayList<>();
    }

    public void setMarkerPosition(double lat, double lng) {
        String script = "setMarkerPosition(" + lat + "," + lng + ");";
        webViewMap.getEngine().executeScript(script);

    }

    public void onAnnonceClick(FXMLAnnonceColocationController c) {

        focusedElement = c;

        setMarkerPosition(c.getAnnonce().getAddress().getLat(), c.getAnnonce().getAddress().getLng());

    }

    public void onDetailedMenuOkClick() {
        mainPlace.getChildren().clear();
        mainPlace.getChildren().add(Menu);
        refresh();
    }

    private void refresh() {
        System.out.println("i am alive");
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
            //System.out.println(" Dclick" + trigger.getAnnonce());
            controller.initUpdateMode(trigger.getAnnonce(), this);
            //System.out.println(Menu);
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

}
