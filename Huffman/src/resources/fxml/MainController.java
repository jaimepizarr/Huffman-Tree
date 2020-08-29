/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.fxml;


import java.io.BufferedWriter;
import tda.HuffmanTree;
import tda.TDAUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import resources.alerts.ErrorAlert;
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
        //initialize controller
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
   private LinkedList<String> showMultiFileChooser(){
       LinkedList<String> rutas = new LinkedList<>();
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("TXT files (.txt)", "*.txt"));
        List<File> f= fc.showOpenMultipleDialog(null);
        for (File fil : f){
            rutas.add(fil.getAbsolutePath());
            
        }
       return rutas;
      }

    @FXML
    private void descomprimir(javafx.event.ActionEvent event) {
        LinkedList<String>  rutas =showMultiFileChooser();
        Map<String,String> mapDecode=reverse(obtenerMapa(rutas.get(1)));
        String texto= TDAUtil.leerTexto(rutas.get(0));
        String decode=HuffmanTree.decodificar(texto, mapDecode);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutas.get(0)))){
            bw.write(decode);      
        } catch (IOException ex) {
            ErrorAlert.alertError(ex.getMessage());
        }
    }
        
        
        
    

    @FXML
    private void comprimir(javafx.event.ActionEvent event) {
        String ruta =showFileChooser();
        String archivo =TDAUtil.leerTexto(ruta);
        Map<String,Integer> frecuencias =(HashMap<String,Integer>)TDAUtil.calcularFrecuencias(archivo);
        HuffmanTree arbol = new HuffmanTree();
        arbol.calcularArbol(frecuencias);
        HashMap<String,String> mapaHuffman=(HashMap<String,String>) arbol.calcularCodigos();
        String binario=HuffmanTree.codificar(archivo, mapaHuffman);
        String compreser =TDAUtil.binarioHexadecimal(binario);
        
        TDAUtil.guardarTexto(ruta, compreser, mapaHuffman);
        
    }
    
    private Map<String,String> obtenerMapa(String ruta){
        HashMap<String,String> map = new HashMap<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            map= (HashMap<String,String>) ois.readObject();
        }
        catch (FileNotFoundException ex) {
            ErrorAlert.alertError(ex.getMessage());
        }
        catch (IOException | ClassNotFoundException ex) {
            ErrorAlert.alertError(ex.getMessage());
        }
        return map;
    }
    private <K,V>Map<V,K> reverse(Map<K,V> map) {
        HashMap<V,K> rev = new HashMap<>();
        for(Map.Entry<K,V> entry : map.entrySet())
            rev.put(entry.getValue(), entry.getKey());
        return rev;
    }
    
    
}
