/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.IOException;
import java.util.Optional;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import resources.fxml.MainController;

/**
 *
 * @author USUARIO
 */
public class NewMain extends Application{
     /**
     * Comienzo del Sistema de principal
     * @param primaryStage
     * @throws IOException
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        Stage anotherStage = new Stage();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/main.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene (root);
        primaryStage.setScene(scene);
        primaryStage.show();
        MainController pController = loader.getController();
        
        
      
    }
    
    
    
    /**
     * Argumentos
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
