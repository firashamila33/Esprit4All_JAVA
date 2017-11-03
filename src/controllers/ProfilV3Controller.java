/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import com.google.common.io.Files;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import models.Club;
import models.Profil;
import models.User;
import services.ClubService;
import services.ProfilService;
import services.UserService;
import tray.animations.AnimationType;
import tray.notification.NotificationType;

/**
 * FXML Controller class
 *
 * @author YACINE
 */
public class ProfilV3Controller implements Initializable {

    @FXML
    private ScrollPane profilAffiche;
    @FXML
    private ImageView photoDeCouverture;
    @FXML
    private JFXButton edit;
    @FXML
    private ImageView photoDeProfil;
    @FXML
    private Text name;
    @FXML
    private Text prenom;
    @FXML
    private Text nom;
    @FXML
    private Text age;
    @FXML
    private Text adresseMail;
    @FXML
    private Text classe;
    @FXML
    private Text telephone;
    @FXML
    private Label description;
    @FXML
    private JFXButton facebook;
    @FXML
    private JFXButton linkedin;
    @FXML
    private JFXButton googlePlus;
    @FXML
    private JFXButton cv;
    @FXML
    private ScrollPane profilEdit;
    @FXML
    private ImageView photoDeCouverture1;
    @FXML
    private ImageView photoDeProfil1;
    @FXML
    private Text name1;
    @FXML
    private JFXTextField prenomEdit;
    @FXML
    private JFXTextField nomEdit;
    @FXML
    private JFXTextField ageEdit;
    @FXML
    private JFXTextField mailEdit;
    @FXML
    private JFXTextField classeEdit;
    @FXML
    private JFXTextField telEdit;
    @FXML
    private JFXTextField descriptionEdit;
    @FXML
    private AnchorPane facebookPane;
    @FXML
    private JFXTextField textFacebook;
    @FXML
    private JFXButton btnFacebook;
    @FXML
    private AnchorPane linekdinPane;
    @FXML
    private JFXTextField textLinkedin;
    @FXML
    private JFXButton btnLinkedin;
    @FXML
    private AnchorPane googlePlusPane;
    @FXML
    private JFXTextField textGooglePlus;
    @FXML
    private JFXButton btnGooglePlus;
    @FXML
    private AnchorPane cvPane;
    @FXML
    private JFXTextField textCv;
    @FXML
    private JFXButton btnCv;
    @FXML
    private JFXButton facebookEdit;
    @FXML
    private JFXButton linkedinEdit;
    @FXML
    private JFXButton googlePlusEdit;
    @FXML
    private JFXButton cvEdit;
    @FXML
    private JFXButton valide;
    @FXML
    private JFXButton btnPhotoDeProfil;
    ClubService clubService = new ClubService();
    public ObservableList<Club> clubs;
    List<Club> listClub = new ArrayList<>();
    ProfilService profilService = new ProfilService();
    Profil profil = profilService.getByUserId(UserService.userStatic.getId());
    String lienFacebook = profil.getLinkFb();
    String lienLinkedin = profil.getLinkId();
    String lienGooglePlus = profil.getLinkG();
    String lienCV = profil.getLinkWeb();
    @FXML
    private AnchorPane profilVoir;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setText(capitalizeFirstLetter(profil.getU().getPrenom()) + " " + capitalizeFirstLetter(profil.getU().getNom()));
        name1.setText(capitalizeFirstLetter(profil.getU().getPrenom()) + " " + capitalizeFirstLetter(profil.getU().getNom()));
        prenom.setText(capitalizeFirstLetter(profil.getU().getPrenom()));
        nom.setText(capitalizeFirstLetter(profil.getU().getNom()));
        LocalDate now = (profil.getU().getDateNaissance()).toLocalDate();
        LocalDate otherDate = LocalDate.now();
        int ageDate = (int) Math.abs(ChronoUnit.YEARS.between(otherDate, now));
        age.setText(Integer.toString(ageDate));
        adresseMail.setText(profil.getU().getEmail());
        classe.setText(profil.getClasse());
        telephone.setText(profil.getTel());
        description.setText(profil.getDescription());
        prenomEdit.setText(capitalizeFirstLetter(profil.getU().getPrenom()));
        nomEdit.setText(capitalizeFirstLetter(profil.getU().getNom()));
        ageEdit.setText(Integer.toString(ageDate));
        mailEdit.setText(profil.getU().getEmail());
        classeEdit.setText(profil.getClasse());
        telEdit.setText(profil.getTel());
        descriptionEdit.setText(profil.getDescription());
        photoDeProfil.setImage(new Image("file:C:\\wamp\\www\\Photo\\" + profil.getU().getUsername() + ".png"));
        photoDeProfil1.setImage(new Image("file:C:\\wamp\\www\\Photo\\" + profil.getU().getUsername() + ".png"));
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == facebookEdit) {
            facebookPane.setVisible(true);
            facebookEdit.setVisible(false);
        } else if (event.getSource() == linkedinEdit) {
            linekdinPane.setVisible(true);
            linkedinEdit.setVisible(false);
        } else if (event.getSource() == googlePlusEdit) {
            googlePlusPane.setVisible(true);
            googlePlusEdit.setVisible(false);
        } else if (event.getSource() == cvEdit) {
            cvPane.setVisible(true);
            cvEdit.setVisible(false);
        } else if (event.getSource() == btnFacebook) {
            facebookPane.setVisible(false);
            facebookEdit.setVisible(true);
            if (!"".equals(textFacebook.getText())) {
                lienFacebook = textFacebook.getText();
            }
        } else if (event.getSource() == btnLinkedin) {
            linekdinPane.setVisible(false);
            linkedinEdit.setVisible(true);
            if (!"".equals(textFacebook.getText())) {
                lienLinkedin = textLinkedin.getText();
            }
        } else if (event.getSource() == btnGooglePlus) {
            googlePlusPane.setVisible(false);
            googlePlusEdit.setVisible(true);
            if (!"".equals(textFacebook.getText())) {
                lienGooglePlus = textGooglePlus.getText();
            }
        } else if (event.getSource() == btnCv) {
            cvPane.setVisible(false);
            cvEdit.setVisible(true);
            if (!"".equals(textFacebook.getText())) {
                lienCV = textCv.getText();
            }
        } else if (event.getSource() == valide) {
            profilEdit.setVisible(false);
            profilAffiche.setVisible(true);
        } else if (event.getSource() == edit) {
            profilEdit.setVisible(true);
            profilAffiche.setVisible(false);
        }
        if (event.getSource() == facebook) {
            System.out.println(profil);
            //String url_open = profil.getLinkFb();
            System.out.println("Lien facebook: " + profil.getLinkFb());
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(profil.getLinkFb()));
        } else if (event.getSource() == linkedin) {
            String url_open = "https://www.linkedin.com/in/yacine-farhat-a32997151/?trk=uno-choose-ge-no-intent&dl=no";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
        } else if (event.getSource() == googlePlus) {
            String url_open = "https://plus.google.com/discover?hl=fr";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
        } else if (event.getSource() == cv) {
            String cmds[] = new String[]{"cmd", "/c", "C:/Users/YACINE/Desktop/Liste-des-tâches-pour-lannivarsaire.pdf"};
            try {
                Runtime.getRuntime().exec(cmds);
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        if (event.getSource() == valide) {
            profil = new Profil(profilService.getByUserId(UserService.userStatic.getId()).getId(), UserService.userStatic, profilService.getByUserId(UserService.userStatic.getId()).getMatiereC(), descriptionEdit.getText(), classeEdit.getText(), profilService.getByUserId(UserService.userStatic.getId()).getPathImg(), profilService.getByUserId(UserService.userStatic.getId()).getPathCv(), lienFacebook, lienLinkedin, lienGooglePlus, lienCV, telEdit.getText());
            profilService.update(profil);
            name.setText(capitalizeFirstLetter(profil.getU().getPrenom()) + " " + capitalizeFirstLetter(profil.getU().getNom()));
            prenom.setText(capitalizeFirstLetter(profil.getU().getPrenom()));
            nom.setText(capitalizeFirstLetter(profil.getU().getNom()));
            LocalDate now = (profil.getU().getDateNaissance()).toLocalDate();
            LocalDate otherDate = LocalDate.now();
            int ageDate = (int) Math.abs(ChronoUnit.YEARS.between(otherDate, now));
            age.setText(Integer.toString(ageDate));
            adresseMail.setText(profil.getU().getEmail());
            classe.setText(profil.getClasse());
            telephone.setText(profil.getTel());
            description.setText(profil.getDescription());
        }
    }

    @FXML
    private void UploadPhotoDeCouverture(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            File file2 = new File("C:\\wamp\\www\\Photo\\" + profil.getU().getUsername() + "PhotoDeCouverture.png");
            Files.copy(file, file2);
            profil.setPathCv(file2.getPath());
            profilService.update(profil);
            photoDeCouverture.setImage(new Image("file:C:\\wamp\\www\\Photo\\" + profil.getU().getUsername() + "PhotoDeCouverture.png"));
            photoDeCouverture1.setImage(new Image("file:C:\\wamp\\www\\Photo\\" + profil.getU().getUsername() + "PhotoDeCouverture.png"));
            initialize(null, null);
        }
        tray.notification.TrayNotification tr = new tray.notification.TrayNotification();
        tr.setTitle("Terminé");
        tr.setMessage("Photo de couverture mise à jour");
        tr.setNotificationType(NotificationType.SUCCESS);
        tr.setAnimationType(AnimationType.POPUP);
        tr.showAndDismiss(Duration.seconds(2));
    }

    public String capitalizeFirstLetter(String original) {
        if (original == null || original.length() == 0) {
            return original;
        }
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }

    @FXML
    private void UploadPhotoDeProfil(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            System.out.println(profil);
            System.out.println(profil.getU());
            File file2 = new File("C:\\wamp\\www\\Photo\\" + profil.getU().getUsername() + ".png");
            Files.copy(file, file2);
            profil.setPathImg(file2.getPath());
            profilService.update(profil);
            photoDeProfil1.setImage(new Image("file:C:\\wamp\\www\\Photo\\" + profil.getU().getUsername() + ".png"));
            photoDeProfil.setImage(new Image("file:C:\\wamp\\www\\Photo\\" + profil.getU().getUsername() + ".png"));
            initialize(null, null);
        }
        tray.notification.TrayNotification tr = new tray.notification.TrayNotification();
        tr.setTitle("Terminé");
        tr.setMessage("Photo de profile mise à jour");
        tr.setNotificationType(NotificationType.SUCCESS);
        tr.setAnimationType(AnimationType.POPUP);
        tr.showAndDismiss(Duration.seconds(2));
    }
}
