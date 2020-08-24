/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.fxml;

import TDA.HuffmanTree;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
/**
 * FXML Controller class
 *
 * @author soyjosephavila
 */
public class MainController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnDescomprimir;
    @FXML
    private Button btnComprimir;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

          
    
    private String showFileChooser(){
    FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("TXT files (.txt)", "*.txt"));
        File f= fc.showOpenDialog(null);
        if(f!=null){
          return f.getAbsolutePath();
        
        }
        return null;
      }

    @FXML
    private void descomprimir(javafx.event.ActionEvent event) {
        String ruta =showFileChooser();
        
    }

    @FXML
    private void comprimir(javafx.event.ActionEvent event) {
        String ruta =showFileChooser();
        String archivo =TDA.TDAUtil.leerTexto(ruta);
        HashMap<String,Integer> frecuencias =TDA.TDAUtil.calcularFrecuencias(archivo);
        HuffmanTree arbol = new HuffmanTree();
        arbol.calcularArbol(frecuencias);
        HashMap<String,String> mapaHuffman=arbol.calcularCodigos();
        String binario=TDA.HuffmanTree.codificar(archivo, mapaHuffman);
        String compreser =TDA.TDAUtil.binarioHexadecimal(binario);
        
        TDA.TDAUtil.guardarTexto(ruta, compreser, mapaHuffman);
        
    }
}
