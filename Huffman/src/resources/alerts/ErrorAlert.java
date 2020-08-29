/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.alerts;

import javafx.scene.control.Alert;

/**
 *
 * @author PC
 */
public class ErrorAlert {
    public static void alertError(String msj){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Alert");
        alert.setHeaderText("The following error has ocurred");
        alert.setContentText(msj);
        alert.show();
    }
    
    private ErrorAlert(){
        throw new IllegalStateException("Utility class");
    }
}
