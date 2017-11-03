/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import interfaces.ICommandeService;
import interfaces.ILigneCommandeService;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import models.Commande;
import models.LigneCommande;
import services.CommandeService;
import services.LigneCommandeService;
import services.MenuService;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class BackOfficeMenuOrderFXMLController implements Initializable {

    @FXML
    private TableColumn<?, ?> col_ref;

    @FXML
    private TableColumn<?, ?> col_prix;
    @FXML
    private TableColumn<?, ?> col_confirmation;
    @FXML
    private TableView<Commande> membre_table;

    @FXML
    public JFXListView<LigneCommande> ligneCommande_lv;
    @FXML
    private AnchorPane responsable_label;
    @FXML
    private Label prix_lb;

    CommandeService commande_service;
    List<Commande> listCommande = new ArrayList<>();
    private ObservableList<LigneCommande> ligne_commande;
    @FXML
    private Label User;
    @FXML
    private JFXButton deconnexion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DisplayAll();

        //initialising orders interface to work on and getting the order of the user
//        ICommandeService ICommande = new CommandeService();
//        Commande commande = ICommande.getById(CommandeId);
        //Refresh_listview
    }

    public void DisplayAll() {
        commande_service = new CommandeService();
        listCommande = commande_service.getAll();
        ObservableList list = FXCollections.observableArrayList();
        listCommande.stream().forEach((Commande) -> {
            list.add(Commande);
        });
        col_ref.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));

        membre_table.setItems(list);

        membre_table.setRowFactory(tv -> {
            TableRow<Commande> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY
                        && event.getClickCount() == 2) {

                    Commande clickedRow = row.getItem();
                    System.out.println(clickedRow.toString());
                    prix_lb.setText(String.valueOf(clickedRow.getPrix()));
                    int Commande_id = (int)(clickedRow.getId());
                    ShowCommandeClicked(Commande_id);
                    
                }
            });
            return row;
        });
    }

    @FXML
    private void Deconnexion(ActionEvent event) {
    }

    public void ShowCommandeClicked(Integer r) {
        ILigneCommandeService Ligne_repas = new LigneCommandeService();
        int commandeId=0;
        commandeId=r;
        List<LigneCommande> list_com = new ArrayList<>();
        list_com=Ligne_repas.getByCommande(commandeId);
        ligne_commande = FXCollections.observableArrayList(list_com);
        ligneCommande_lv.setItems(ligne_commande);
        ligneCommande_lv.setCellFactory(LigneCommandesListVIrs -> new BackOfficeMenusRowFXMLController());
    }

}
