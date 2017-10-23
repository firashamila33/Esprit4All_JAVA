/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author majdi
 */
public class Esprit4All extends Application {

    @Override
    public void start(Stage stage) throws Exception {

         //Parent root = FXMLLoader.load(getClass().getResource("/gui/AcceuilFXML.fxml"));
       Parent root = FXMLLoader.load(getClass().getResource("/gui/RevisionMainFXML.fxml"));


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(true);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
