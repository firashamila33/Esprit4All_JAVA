/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.net.URI;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.UserService;

/**
 *
 * @author kadhem
 */
public class MainAnnonceTest extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        
       // System.out.println(url);
        try {
            UserService s = new UserService();
            UserService.userStatic = s.getUserById(3);
            System.out.println(UserService.userStatic);
            URL url = getClass().getResource("/gui/FXMLAnnonceColocationMenu.fxml");
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    static { // use system proxy settings when standalone application
        System.setProperty("java.net.useSystemProxies", "true");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
