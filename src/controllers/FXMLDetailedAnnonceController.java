/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Address;
import models.AnnonceCoLocation;
import models.User;
import services.AddressService;
import services.AnnonceCoLocationService;

/**
 * FXML Controller class
 *
 * @author kadhem
 */
public class FXMLDetailedAnnonceController implements Initializable {

    @FXML
    private Label ajouteLeValue;
    @FXML
    private TextArea locatairesValue;
    @FXML
    private TextArea descriptionValue;
    @FXML
    private TextField loyerValue;
    @FXML
    private TextField dimensionsValue;
    private String mode = "view";
    private AnnonceCoLocation annonce;
    private FXMLAnnonceColocationMenuController menu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initViewMode(AnnonceCoLocation a, FXMLAnnonceColocationMenuController menu) {
        this.menu = menu;
        mode = "view";
        descriptionValue.setText(a.getDescription());
        loyerValue.setText(((Float) a.getLoyer()).toString());
        dimensionsValue.setText(a.getDimensions());
        ajouteLeValue.setText(a.getCreationDate().toString());

        descriptionValue.setEditable(false);
        loyerValue.setEditable(false);
        dimensionsValue.setEditable(false);
        this.annonce = a;
    }

    public void initAddMode(FXMLAnnonceColocationMenuController menu) {
        this.menu = menu;
        mode = "add";

    }

    public void initUpdateMode(AnnonceCoLocation a, FXMLAnnonceColocationMenuController menu) {
        this.menu = menu;
        mode = "update";
        descriptionValue.setText(a.getDescription());
        loyerValue.setText(((Float) a.getLoyer()).toString());
        dimensionsValue.setText(a.getDimensions());
        ajouteLeValue.setText(a.getCreationDate().toString());
        System.out.println("##" + a.getAddress());
        this.menu.setMarkerPosition(a.getAddress().getLat(), a.getAddress().getLng());

        this.annonce = a;
    }

    @FXML
    private void onOkAction(ActionEvent event) {
        if (mode.equals("view")) {
            onRetourAction(null);
        } else if (mode.equals("add")) {
            Boolean isMarkerSet = (Boolean) menu.webViewMap.getEngine().executeScript("isMarkerSet();");
            if (isMarkerSet) {
                Double lat = (Double) menu.webViewMap.getEngine().executeScript("markerLocationLat();");
                Double lng = (Double) menu.webViewMap.getEngine().executeScript("markerLocationLng();");
                AnnonceCoLocationService service = new AnnonceCoLocationService();
                AnnonceCoLocation a = new AnnonceCoLocation(
                        new Address(lat, lng), dimensionsValue.getText(),
                        new ArrayList<User>(),
                        10, Float.parseFloat(loyerValue.getText()),
                        new ArrayList<>(),
                        "",
                        descriptionValue.getText(),
                        new User(7), new Date(new java.util.Date().getTime()),
                        new Date(1514764800));
                service.add(a);
                annonce = a;

            } else {
                return;
            }

            onRetourAction(null);
        } else if (mode.equals("update")) {

            //update of address
            Double lat = (Double) menu.webViewMap.getEngine().executeScript("markerLocationLat();");
            Double lng = (Double) menu.webViewMap.getEngine().executeScript("markerLocationLng();");
            
            
            
            Address address = new Address(lat,lng);
            address.setId(annonce.getAddress().getId());
          
            
            AnnonceCoLocationService service = new AnnonceCoLocationService();
            
            
            AnnonceCoLocation a = new AnnonceCoLocation(
                    address, dimensionsValue.getText(),
                    new ArrayList<User>(),
                    10, Float.parseFloat(loyerValue.getText()),
                    new ArrayList<>(),
                    "",
                    descriptionValue.getText(),
                    new User(7), new Date(new java.util.Date().getTime()),
                    new Date(1514764800));
            a.setId(annonce.getId());
            service.update(a);
            onRetourAction(null);

        }
    }





    @FXML
        private void onRetourAction(ActionEvent event) {
        menu.onDetailedMenuOkClick();
    }

}
