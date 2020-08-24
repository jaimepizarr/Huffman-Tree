/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.fxml;

import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
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

    @FXML
    private void singleFileChooser(javafx.event.ActionEvent event) {
            FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("TXT files (.txt)", ".txt"));
        File f= fc.showOpenDialog(null);
        if(f!=null){
        System.out.println(f.getAbsolutePath());}
    }
    
}
