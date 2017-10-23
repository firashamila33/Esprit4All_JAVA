/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import application.Button;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * FXML Controller class sss
 *
 * @author majdi
 */
public class AcceuilFXMLController implements Initializable {
    
    @FXML
    private ImageView logoesprit;
    
    private List<String> list = new ArrayList<String>();
    int j = 0;
    double orgCliskSceneX, orgReleaseSceneX;
    Button lbutton, rButton;
    ImageView imageView;
    
    Timer timer = new Timer();
    @FXML
    private Pane imageSlider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        slideImages();
       
    }
    
    private void slideImages() {
        try {
            list.add("ressources/images.jpg");
            list.add("ressources/user-3.png");
            list.add("ressources/LOGO1.png");
            Image images[] = new Image[list.size()];
            for (int i = 0; i < list.size(); i++) {
                images[i] = new Image(list.get(i));
            }
            
            imageView = new ImageView(images[j]);
            imageView.setCursor(Cursor.OPEN_HAND);
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (j == list.size()) {
                        j = 0;
                    }
                    FadeTransition ft_out = new FadeTransition(Duration.millis(1500));
                    ft_out.setNode(imageView);
                    ft_out.setFromValue(1);
                    ft_out.setToValue(0.5);
                    ft_out.setCycleCount(1);
                    ft_out.setAutoReverse(true);
                    ft_out.play();
                    imageView.setImage(images[j]);
                    FadeTransition ft_in = new FadeTransition(Duration.millis(1500));
                    ft_in.setNode(imageView);
                    ft_in.setFromValue(0.5);
                    ft_in.setToValue(1);
                    ft_in.setCycleCount(1);
                    ft_in.setAutoReverse(true);
                    ft_in.play();
                    j++;
                }
            }, 5000, 5000);
            
            imageView.setFitHeight(560);
            imageView.setFitWidth(1360);
            
            HBox hBox = new HBox();
            hBox.setSpacing(15);
            hBox.setAlignment(Pos.CENTER);
            
            hBox.getChildren().addAll(imageView);
            
            imageSlider.getChildren().add(hBox);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    EventHandler<MouseEvent> circleOnMousePressedEventHandler = new EventHandler<MouseEvent>() {
        
        @Override
        public void handle(MouseEvent t) {
            orgCliskSceneX = t.getSceneX();
        }
    };
}
