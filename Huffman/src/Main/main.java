/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import java.io.IOException;
import java.util.HashMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tda.HuffmanTree;

/**
 *
 * @author soyjosephavila
 */
public class main extends Application {

    public void start(Stage primaryStage) throws IOException {
        Stage anotherStage = new Stage();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/main.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene (root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        
    public static void main(String[] args) {
        //Application.launch(args);
        
        HashMap<String, Integer> mapa = new HashMap<>();
        mapa.put("E", 6);
        mapa.put("B", 8);
        mapa.put("C", 5);
        mapa.put("D", 7);
        mapa.put("A", 6);
        mapa.put("F", 8);
        mapa.put("G", 11);
        
        HuffmanTree arbol = new HuffmanTree();
        arbol.calcularArbol(mapa);
        System.out.println(arbol.calcularCodigos());
        
       
        
        
        
        
        
        
        
        
        
    }
    
}
