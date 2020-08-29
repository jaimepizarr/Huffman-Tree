/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author soyjosephavila
 */
public class Main extends Application {

    public void start(Stage primaryStage) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/main.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene (root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        
    public static void main(String[] args) {
        Application.launch(args);  
    }
    
}
