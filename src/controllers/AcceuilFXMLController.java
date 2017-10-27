
package controllers;


import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 * FXML Controller class sss
 *
 * @author majdi
 */
public class AcceuilFXMLController implements Initializable {

    @FXML
    private AnchorPane slideImage;
    @FXML
    private AnchorPane Club_event;
    @FXML
    private AnchorPane Revision;
    @FXML
    private AnchorPane Document;
    @FXML
    private AnchorPane Couvoiturage;
    @FXML
    private AnchorPane Restauration;
    
    
    
    
    AnchorPane club,covoiturage,restauration,revision,document;
    
    List<String> images= new ArrayList<>();
    
    private ImageView slide;
    
    Timer timer= new Timer();
    int j=0;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       slideImages();
    }
    
    private void slideImages() {
        try {
            images.add("/ressources/food_pattern_background_wallpaper_free_hd.jpg");
            images.add("/ressources/hand-drawn-food-elements_1411-48.jpg");
            images.add("/ressources/salads-1-310x260.png");
            Image imagest[] = new Image[images.size()];
            for (int i = 0; i < images.size(); i++) {
                imagest[i] = new Image(images.get(i));
            }
            
            slide = new ImageView(imagest[j]);
            slide.setCursor(Cursor.OPEN_HAND);
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (j == images.size()) {
                        j = 0;
                    }
                    FadeTransition ft_out = new FadeTransition(Duration.millis(1500));
                    ft_out.setNode(slide);
                    ft_out.setFromValue(1);
                    ft_out.setToValue(0.5);
                    ft_out.setCycleCount(1);
                    ft_out.setAutoReverse(true);
                    ft_out.play();
                    slide.setImage(imagest[j]);
                    FadeTransition ft_in = new FadeTransition(Duration.millis(1500));
                    ft_in.setNode(slide);
                    ft_in.setFromValue(0.5);
                    ft_in.setToValue(1);
                    ft_in.setCycleCount(1);
                    ft_in.setAutoReverse(true);
                    ft_in.play();
                    j++;
                }
            }, 5000, 5000);
            
            slide.setFitHeight(560);
            slide.setFitWidth(1320);
            
            HBox hBox = new HBox();
            hBox.setSpacing(15);
            hBox.setAlignment(Pos.CENTER);
            
            hBox.getChildren().addAll(slide);
            
            slideImage.getChildren().add(hBox);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
}
