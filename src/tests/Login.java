/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author YACINE
 */
public class Login extends Application {
    private double xOffset=0;
    private double yOffset=0;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));
        stage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
//        root.setOnMousePressed((MouseEvent event) -> {
//            xOffset=event.getSceneX();
//            yOffset=event.getSceneY();
//        });
//        root.setOnMouseDragged((MouseEvent event) -> {
//            stage.setX(event.getSceneX()-xOffset);
//            stage.setY(event.getSceneY()-xOffset);
//        });
        
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
